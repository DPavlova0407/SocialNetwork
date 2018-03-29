package com.example.a13_da.socialnetwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        EditText phone = findViewById(R.id.registration_phone);

        Button buttonregistration = findViewById(R.id.registration_buttonregistration);
        buttonregistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = findViewById(R.id.registration_name);
                EditText surname = findViewById(R.id.registration_surname);
                EditText mail = findViewById(R.id.registration_mail);
                EditText phone = findViewById(R.id.registration_phone);

                String nameStr = name.getText().toString();
                String surnameStr = surname.getText().toString();
                String mailStr = mail.getText().toString();
                String phoneStr = phone.getText().toString();

                TextView log = findViewById(R.id.registration_message);


                if (nameStr.length() == 0 || surnameStr.length() == 0 || mailStr.length() == 0 || phoneStr.length() == 0){
                    log.setText("заполните пустые поля");
                } else {
                    User user = new User(nameStr, surnameStr, mailStr, phoneStr);
                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                    intent.putExtra("user", user.toString());
                    startActivity(intent);
                }

            }
        });
    }
}
