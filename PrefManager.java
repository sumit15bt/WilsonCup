package Sumit.wilsoncricket;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by radhe-krishna on 9/1/18.
 */

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int Private_mode=0;
    private static final String prefName="Project1";
    private static final String ISFIRSTTIMELAUNCH="launch";

    public PrefManager(Context context) {

        this.context = context;

        pref=context.getSharedPreferences(prefName,Private_mode);
        editor=pref.edit();
    }
    public void setFirstTimelaunch(boolean isFirstTimeLaunch){

        editor.putBoolean(ISFIRSTTIMELAUNCH,isFirstTimeLaunch);
        editor.commit();
    }
    public  boolean isFirstTimeLaunch(){
        return pref.getBoolean(ISFIRSTTIMELAUNCH,true);
    }
}
