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
    private User curUser = Session.getINSTANCE().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView image = findViewById(R.id.profile_image);
        image.setClipToOutline(true);

        TextView name = findViewById(R.id.profile_name);
        TextView mail = findViewById(R.id.profile_mail);
        TextView phone = findViewById(R.id.profile_phone);
        TextView gender = findViewById(R.id.profile_gender);
        TextView login = findViewById(R.id.profile_login);
        TextView password = findViewById(R.id.profile_password);

        name.setText(curUser.getSurname() + " " + curUser.getName() + " " + curUser.getPatronymic());
        mail.setText(curUser.getMail());
        phone.setText(curUser.getPhone());
        gender.setText(curUser.getGender());
        login.setText(curUser.getLogin());
        password.setText(curUser.getPassword());

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
