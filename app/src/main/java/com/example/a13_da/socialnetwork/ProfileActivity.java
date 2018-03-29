package com.example.a13_da.socialnetwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
            user = new User(parts[0], parts[1], parts[2], parts[3]);
        } else {
            user = new User("Вася", "Иванов", "mail@gmail.com", "89034569856");
        }

        TextView name = findViewById(R.id.profile_name);
        TextView mail = findViewById(R.id.profile_mail);
        TextView phone = findViewById(R.id.profile_phone);

        name.setText(user.getName() + " " + user.getSurname());
        mail.setText(user.getMail());
        phone.setText(user.getPhone());

    }
}
