package Sumit.wilsoncricket;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by radhe-krishna on 21/3/18.
 */

public class FireApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
