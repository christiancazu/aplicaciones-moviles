package com.utp.app;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {

    private static String PREF_NAME = "prefs";

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static String getToken(Context context) {
        return getPrefs(context).getString("token", "");
    }

    public static void setToken(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("token", input);
        editor.commit();
    }

    public static void purgeToken(Context context) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.remove("token");
        editor.commit();
    }

}
