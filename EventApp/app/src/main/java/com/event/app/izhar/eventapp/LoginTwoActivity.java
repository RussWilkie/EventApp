package com.event.app.izhar.eventapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_two);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final Button btnRegister = (Button) findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View l) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                String username = jsonResponse.getString("username");
                                Intent loginIntent = new Intent(LoginTwoActivity.this, EventActivity.class);
                                loginIntent.putExtra("username", username);
                                LoginTwoActivity.this.startActivity(loginIntent);
                                Toast.makeText(getApplicationContext(), "Success",
                                        Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Login Failed",
                                        Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginTwoActivity.this);
                queue.add(loginRequest);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View r) {
                Intent registerIntent = new Intent(LoginTwoActivity.this, RegisterUserActivity.class);
                LoginTwoActivity.this.startActivity(registerIntent);
            }
        });
<<<<<<< HEAD
=======

    }

    @Override
    public void onClick(View v) {

        HashMap postData = new HashMap();
        postData.put("btnLogin", "Login");
        postData.put("mobile", "android");
        postData.put("txtUsername", username.getText().toString());
        postData.put("txtPassword", password.getText().toString());

        PostResponseAsyncTask loginTask = new PostResponseAsyncTask(this, postData,this);
        loginTask.execute("http://cq7243tk.000webhostapp.com/login.php");
    }


    @Override
    public void processFinish(String result) {

        if (result.equals("success")) {
            Toast.makeText(this, "Login Successfully!",
                    Toast.LENGTH_LONG).show();
            Intent next = new Intent(this, EventNavigationDrawer.class);
            startActivity(next);
        }
        else{
            Toast.makeText(this, "Login Failed!", Toast.LENGTH_LONG).show();
        }
>>>>>>> 15338ae6e053b045ebcc9bc43846c5271b485919
    }
}
