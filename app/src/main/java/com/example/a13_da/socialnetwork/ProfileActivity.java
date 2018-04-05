package com.example.a13_da.socialnetwork;

import android.content.Intent;
import android.net.MailTo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ImageView image = findViewById(R.id.profile_image);
        image.setClipToOutline(true);

        if (getIntent().hasExtra("user")){
            String userStr = getIntent().getExtras().getString("user");
            String[] parts = (userStr + '\n').split("\n");
            user = User.getInstance();
            user.setUser(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
        }

        TextView name = findViewById(R.id.profile_name);
        TextView mail = findViewById(R.id.profile_mail);
        TextView phone = findViewById(R.id.profile_phone);
        TextView gender = findViewById(R.id.profile_gender);
        TextView login = findViewById(R.id.profile_login);
        TextView password = findViewById(R.id.profile_password);

        name.setText(user.getSurname() + " " + user.getName() + " " + user.getPatronymic());
        mail.setText(user.getMail());
        phone.setText(user.getPhone());
        gender.setText(user.getGender());
        login.setText(user.getLogin());
        password.setText(user.getPassword());

        Button friendsButton = findViewById(R.id.profile_buttonFriends);
        friendsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, FriendsActivity.class);
                startActivity(intent);
            }
        });

        Button exitButton = findViewById(R.id.profile_buttonExit);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
