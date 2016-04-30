package themovies.features;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Aya Ezz on 25/3/16.
 */

public class Connectivity {


    public static boolean isConnected(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager == null)
            return false;
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
        if (networkInfo == null)
            return false;
        if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            return true;
        }
        return false;
    }
}