package com.utp.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    private final String
            BASE_URL = "http://10.0.2.2:80/backend/",
            SIGN_IN_API = "authenticate",
            USER_API = "user";

    private Toast toast;
    private EditText etCode, etPwd;
    private CheckBox cbxRememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkSession();

        initBindingWidgets();
    }

    private void checkSession() {
        String token = MySharedPreferences.getToken(this);

        if (token.isEmpty()) return;

        String url =
                BASE_URL + USER_API +
                "?token=" + token;

        fetchAPI(url);
    }

    public void signInOnClick(View v) {
        String url =
                BASE_URL + SIGN_IN_API +
                "?login=" + etCode.getText() +
                "&password=" + etPwd.getText();

        fetchAPI(url);
    }

    public void fetchAPI(String url) {
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            handleResponseSuccess(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        try {
                            handleResponseError(error);
                        } catch (Exception e) {
                            e.printStackTrace();
                            toastMessage("Error: failed request to API");
                        }
                        error.printStackTrace();
                    }
                }
        );
        queue.add(stringRequest);
    }

    private void handleResponseSuccess(String response) throws JSONException {
        JSONObject jo = new JSONObject(response);

        if (jo.has("token")) {
            MySharedPreferences.setToken(this, jo.getString("token"));
            checkSession();
        } else {
            User user = mapJsonToUser(jo);

            saveUserAsGlobalContext(user);

            toastMessage("The session has been initialize!");

            redirectToProfile();
        }
    }

    private void saveUserAsGlobalContext(User user) {
        ((GlobalContext) this.getApplication()).setUser(user);
    }

    private User mapJsonToUser(JSONObject jo) throws JSONException {
        User user = new User();
        user.setId(jo.getInt("id"));
        user.setName(jo.getString("name"));
        user.setSurname(jo.getString("surname"));
        user.setBirthdate(jo.getString("birthdate"));
        user.setLogin(jo.getString("login"));
        user.setPassword(jo.getString("password"));

        return user;
    }

    private void redirectToProfile() {
        if (!cbxRememberMe.isChecked()) MySharedPreferences.purgeToken(this);

        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void tvRememberMeOnClick(View v) {
        cbxRememberMe.setChecked(!cbxRememberMe.isChecked());
    }

    private void initBindingWidgets() {
        etCode = findViewById(R.id.et_code);
        etPwd = findViewById(R.id.et_pwd);

        cbxRememberMe = findViewById(R.id.cbx_remember_me);
    }

    private void handleResponseError(VolleyError error) throws UnsupportedEncodingException, JSONException {
        String responseBody = new String(error.networkResponse.data, "utf-8");
        JSONObject data = new JSONObject(responseBody);
        String message = data.optString("error");
        toastMessage(message);
    }

    private void toastMessage(String msg) {
        if (toast == null) {
            toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        toast.show();
    }

}
