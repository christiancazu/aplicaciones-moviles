package com.utp.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button btnFetch;
    TextView tvMessage, tvUserName, tvUserSurname, tvUserCode;
    String url = "http://10.225.42.50:8088/apirest/";
    User user;
    // String url = "http://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFetch = findViewById(R.id.btn_fetch);

        initBtnFetchListener();
    }

    public void initBtnFetchListener() {
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchAPI(url);
            }
        });
    }

    public void fetchAPI(String apiUrl) {
        tvMessage = findViewById(R.id.tv_message);
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                apiUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // tvMessage.setText(response);
                        setUserFromApi(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        toastMessage(error.toString());
                    }
                }
        );

        queue.add(stringRequest);
    }

    private void setUserFromApi(String response) {
        user = new User();

        try {
            JSONObject res = new JSONObject(response);
            user.setName(res.getString("name"));
            user.setSurname(res.getString("surname"));
            user.setCode(Integer.parseInt(res.getString("code")));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        tvUserName = findViewById(R.id.tv_user_name);
        tvUserSurname = findViewById(R.id.tv_user_surname);
        tvUserCode = findViewById(R.id.tv_user_code);

        tvUserName.setText(user.getName());
        tvUserSurname.setText(user.getSurname());
        tvUserCode.setText(Integer.toString(user.getCode()));
    }

    public void signIn(View v) {
        fetchAPI("http://10.225.42.50:8088/apirest/login.php");
    }

    private void toastMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
