package com.event.app.izhar.eventapp;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

/**
 * Created by Izhar on 10/9/2017.
 */

public class LoginRequest extends StringRequest {

    private static final String LOGIN_REQUEST_URL = "https://cq7243tk.000webhostapp.com/login.php";
    private Map<String, String> params;

    public LoginRequest( String username, String password,
                         Response.Listener<String> listener) {
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);

        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

        Log.d(TAG, "LoginRequest: "+username+" "+password);
    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }
}

