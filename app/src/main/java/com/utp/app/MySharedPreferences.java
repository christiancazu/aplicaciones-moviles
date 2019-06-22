package com.utp.app;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {

    private static String PREF_NAME = "prefs";

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static String getData(Context context) {
        return getPrefs(context).getString("data", "");
    }

    public static void setData(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("data", input);
        editor.commit();
    }

}
