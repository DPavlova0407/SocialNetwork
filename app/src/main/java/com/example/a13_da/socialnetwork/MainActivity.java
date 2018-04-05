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
    private Map<String, User> users = new HashMap<>();
    private TextView loginError;
    private TextView passwordError;
    private User currentUser = User.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User admin = User.getInstance();
        admin.setUser("Admin", "Adminov", "Adminovich", "admin@gmail.com", "+79045867658", "Неопределен", "admin", "000");
        users.put(admin.getLogin(), admin);

        if (getIntent().hasExtra("user")){
            String userStr = getIntent().getExtras().getString("user");
            String[] parts = (userStr + '\n').split("\n");
            User user = User.getInstance();
            user.setUser(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
            users.put(user.getLogin(), user);
        }
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
                    currentUser = users.get(login);
                    if (password.equals(currentUser.getPassword())) {
                        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                        intent.putExtra("user", currentUser.toString());
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
        return users.containsKey(login);
    }
}
