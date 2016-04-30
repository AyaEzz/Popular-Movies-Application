package themovies.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.moviesapp.R;

import themovies.calling_back.ActionCallback;
import themovies.theentity.Movie;
import themovies.moviefragments.DetailFragment;


public class mainactivity extends AppCompatActivity implements ActionCallback {

    static final String TAG = "mainactivity";
    public static FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;


        frameLayout = (FrameLayout) findViewById(R.id.frame_container);
    }

    @Override
    public void actionCallback(Movie movie) {
        Log.d(TAG, "Callback with " + movie.getJsonObject());

        if (frameLayout == null) {
            Intent intent = new Intent(mainactivity.this, activity_details.class)
                    .putExtra(DetailFragment.MOVIE_DATA, movie);
            startActivity(intent);
        } else {
            Bundle arguments = new Bundle();

            arguments.putParcelable(DetailFragment.MOVIE_DATA,
                    movie);

            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setArguments(arguments);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager
                    .beginTransaction();
            fragmentTransaction.replace(R.id.frame_container, detailFragment);
            fragmentTransaction.commit();
        }
    }
}