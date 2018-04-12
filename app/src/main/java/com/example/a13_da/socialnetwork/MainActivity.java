package com.example.a13_da.socialnetwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private Session session = Session.getINSTANCE();

    private TextView loginError;
    private TextView passwordError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Admin 000
        session.addUser(session.getCurrentUser());

        loginError = findViewById(R.id.login_login_error);
        passwordError = findViewById(R.id.login_password_error);

        Button loginbutton = findViewById(R.id.login_buttonlogin);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText log = findViewById(R.id.login_login);
                EditText pas = findViewById(R.id.login_password);
                String login = log.getText().toString();
                String password = pas.getText().toString();
                if (!userFind(login)) {
                    loginError.setText("Логин не найден.");
                }
                else {
                    session.setCurrentUser(session.getUsersMap().get(login));
                    if (password.equals(session.getCurrentUser().getPassword())) {
                        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                        //intent.putExtra("user", session.getCurrentUser().toString());
                        startActivity(intent);
                    }
                    else {
                        passwordError.setText("Неверный пароль.");
                    }
                }
            }
        });

        Button registrationbutton = findViewById(R.id.login_buttonregistration);
        registrationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
    private boolean userFind(String login){
        return Session.getINSTANCE().getUsersMap().containsKey(login);
    }
}