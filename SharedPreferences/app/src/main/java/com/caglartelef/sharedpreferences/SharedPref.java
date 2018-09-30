package com.caglartelef.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    /*
    * I used singleton design pattern.
    * */
    private static SharedPref myInstance = new SharedPref();
    private SharedPref() {
    }
    public static SharedPref getMyInstance() {
        return myInstance;
    }

    public static Context context;
    private static final String MYPREFERENCES = "MyPreferences";
    private SharedPreferences sharedPreferences;
    private boolean recordType = false;
    private String processType;

    /**
     *
     * You should not change above code.
     * */

    private String username, password;
    /**
     *
     * Hi, if you wanna add new property to this class.
     * Firstly, you should setter getter methods.
     * Secondly, you should add processType to setGetSharedpreferences method.
     * That's all.
     * Have nice day and coding.
     *
     * */

    public String getUsername() {
        processType = "username";
        recordType = false;
        setGetSharedpreferences();
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        processType = "username";
        recordType = true;
        setGetSharedpreferences();
    }

    public String getPassword() {
        processType = "password";
        recordType = false;
        setGetSharedpreferences();
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        processType = "password";
        recordType = true;
        setGetSharedpreferences();
    }

    private void setGetSharedpreferences() {
        sharedPreferences = context.getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (recordType) {
            /*
             * recordType=true
             * Data sets to shared preferences.
             * */
            switch (processType) {
                case "username":
                    editor.putString("username", username);
                    editor.apply();
                    break;
                case "password":
                    editor.putString("password", password);
                    editor.apply();
                    break;
            }
        } else {
            /*
             * recordType=false
             * Data gets to shared preferences.
             * */
            switch (processType) {
                case "username":
                    username = sharedPreferences.getString("username", username);
                    break;
                case "password":
                    password = sharedPreferences.getString("password", password);
                    break;
            }
        }
    }

}
