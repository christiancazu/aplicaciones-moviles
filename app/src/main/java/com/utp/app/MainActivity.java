package com.utp.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    final String BASE_URL = "http://10.0.2.2:80/backend/authenticate";

    Toast toast;
    EditText etCode, etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBindingEditText();
    }

    public void signIn(View v) {
        String url = BASE_URL +
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
                            setUser(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );

        queue.add(stringRequest);
    }

    private void setUser(String response) throws JSONException {

        JSONObject jo = new JSONObject(response);

        User user = new User();
        user.setId(jo.getInt("id"));
        user.setName(jo.getString("name"));
        user.setSurname(jo.getString("surname"));
        user.setBirthdate(jo.getString("birthdate"));
        user.setLogin(jo.getString("login"));
        user.setPassword(jo.getString("password"));

        redirectToHome(user);

    }

    private void redirectToHome(User user) {
    }

    private void initBindingEditText() {
        etCode = findViewById(R.id.et_code);
        etPwd = findViewById(R.id.et_pwd);
    }

    private void toastMessage(String msg) {
        if (toast == null) {
            toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        toast.show();
    }

}
