package themovies.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.moviesapp.R;

import themovies.moviefragments.DetailFragment;

/**
 * Created by Aya Ezz on 25/13/16.
 */
public class activity_details extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;


        Bundle arguments = new Bundle();
        arguments.putParcelable(DetailFragment.MOVIE_DATA,
                getIntent().getParcelableExtra(DetailFragment.MOVIE_DATA));
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(arguments);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.replace(R.id.movie_detail_container, detailFragment);
        fragmentTransaction.commit();
    }
}