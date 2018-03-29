package com.example.a13_da.socialnetwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().hasExtra("user")){
            String userStr = getIntent().getExtras().getString("user");
            String[] parts = (userStr + '\n').split("\n");
            user = new User(parts[0], parts[1], parts[2], parts[3]);
        } else {
            user = new User("Вася", "Иванов", "mail@gmail.com", "89034569856");
        }

        Button loginbutton = findViewById(R.id.login_buttonlogin);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText log = findViewById(R.id.login_login);
                EditText pas = findViewById(R.id.login_password);
                String login = log.getText().toString();
                String password = pas.getText().toString();
                if (!login.equals("admin") || !password.equals("admin") || login.length() == 0 || password.length() == 0) {
                    log.setText("неверный логин или пароль, используйте 'admin' для входа");
                }
                else {
                    user.setLogin(login);
                    user.setPassword(password);

                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.putExtra("user", user.toString());
                    startActivity(intent);
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
}
