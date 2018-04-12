package com.example.a13_da.socialnetwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

import static android.text.TextUtils.isEmpty;

public class RegistrationActivity extends AppCompatActivity {
    private Session session = Session.getINSTANCE();

    private String genderStr = "Неопределен";
    private TextView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button buttonregistration = findViewById(R.id.registration_buttonregistration);
        buttonregistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = findViewById(R.id.registration_name);
                EditText surname = findViewById(R.id.registration_surname);
                EditText patronymic = findViewById(R.id.registration_patronymic);
                EditText mail = findViewById(R.id.registration_mail);
                EditText phone = findViewById(R.id.registration_phone);
                EditText gender = findViewById(R.id.registration_gender);
                EditText login = findViewById(R.id.registration_login);
                EditText password = findViewById(R.id.registration_password);


                String nameStr = name.getText().toString();
                String surnameStr = surname.getText().toString();
                String patronymicStr = patronymic.getText().toString();
                String mailStr = mail.getText().toString();
                String phoneStr = phone.getText().toString();
                //TODO
                // Для выбора пола вместо EditText Spinner ?
                if (!gender.getText().toString().isEmpty())
                    genderStr = gender.getText().toString();
                String loginStr = login.getText().toString();
                String passwordStr = password.getText().toString();


                log = findViewById(R.id.registration_message);
                //TODO
                //телефон в нужном формате
/*
                phone.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View view, int i, KeyEvent keyEvent) {
                        phone.set
                    }
                });
                phone.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        return false;
                    }
                });*/

                TextView passwordError = findViewById(R.id.registration_password_error);

                if (nameStr.length() == 0 || surnameStr.length() == 0 || mailStr.length() == 0 || phoneStr.length() == 0 || loginStr.length() == 0 || passwordStr.length() == 0){
                    log.setText("Фамилия, Имя, телефон, почта, логин и пароль являются обязательными для заполнения");
                } else {
                    if (!checkPassword(passwordStr))
                        passwordError.setText("Пароль не достаточно сложный");
                    else {
                        User user = new User(nameStr, surnameStr, patronymicStr, mailStr, phoneStr, genderStr, loginStr, passwordStr);
                        session.addUser(user);
                        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

        Button buttonback = findViewById(R.id.registration_buttonback);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    //TODO
    //переделать порверку пароля
    private boolean checkPassword(String password){
        if (password == null) {throw new IllegalArgumentException();}
        int passwordStrength = 0;
        if (password.length() > 5) {passwordStrength++;} // minimal pw length of 6
        if (password.toLowerCase()!= password) {passwordStrength++;} // lower and upper case
        if (password.length() > 8) {passwordStrength++;} // good pw length of 9+
        int numDigits = getNumberDigits(password);
        if (numDigits > 0 && numDigits != password.length()) {passwordStrength++;} // contains digits and non-digits
        return passwordStrength >= 3;
    }
    private int getNumberDigits(String inString){
        if (isEmpty(inString)) {
            return 0;
        }
        int numDigits= 0;
        int length= inString.length();
        for (int i = 0; i < length; i++) {
            if (Character.isDigit(inString.charAt(i))) {
                numDigits++;
            }
        }
        return numDigits;
    }
}
