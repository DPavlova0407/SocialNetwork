package com.example.a13_da.socialnetwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class FriendsActivity extends AppCompatActivity {
    private Session session = Session.getINSTANCE();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        initUsers();
        RecyclerView recyclerView = findViewById(R.id.friends_list);

        recyclerView.setAdapter(new DataAdapter(this, session.getFemale(), session.getMale(), session.getNot_defined(), session.getUsersList()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        Button buttonBack = findViewById(R.id.friends_buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FriendsActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initUsers(){
        session.addUser(new User("Саша", "Петруненко", "", "sa@mail.ru", "+78936758475", "", "log1", "pas1"));
        session.addUser(new User("Паша", "Иванов", "", "pi@mail.ru", "+78936758475", "Мужской", "log1", "pas1"));
        session.addUser(new User("Таня", "Иванова", "", "pi@mail.ru", "+78936758475", "Женский", "log1", "pas1"));
        session.addUser(new User("Олег", "Кузнецов", "", "pi@mail.ru", "+78936758475", "Мужской", "log1", "pas1"));
        session.addUser(new User("Игорь", "Мартынов", "", "pi@mail.ru", "+78936758475", "Мужской", "log1", "pas1"));
        session.addUser(new User("Егор", "Щукин", "", "pi@mail.ru", "+78936758475", "Мужской", "log1", "pas1"));
        session.addUser(new User("Маша", "Крапцова", "", "pi@mail.ru", "+78936758475", "Женский", "log1", "pas1"));
        session.addUser(new User("Валерия", "Кузнецова", "", "pi@mail.ru", "+78936758475", "Женский", "log1", "pas1"));
        session.addUser(new User("Нина", "Белова", "", "pi@mail.ru", "+78936758475", "Женский", "log1", "pas1"));
        session.addUser(new User("Женя", "Мартыненко", "", "pi@mail.ru", "+78936758475", "", "log1", "pas1"));
        session.addUser(new User("Ярослав", "Слуцкий", "", "pi@mail.ru", "+78936758475", "Мужской", "log1", "pas1"));
        session.addUser(new User("Катя", "Янина", "", "pi@mail.ru", "+78936758475", "Женский", "log1", "pas1"));
    }
}
