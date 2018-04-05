package com.example.a13_da.socialnetwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class FriendsActivity extends AppCompatActivity {
    private List<UserPublic> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        initUsers();
        //TODO
        // Исправить. Высота текстового поля одного пользователя равна высоте окна.
        RecyclerView recyclerView = findViewById(R.id.friends_list);

        DataAdapter adapter = new DataAdapter(this, users);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

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
        UserPublic user1 = new UserPublic();
        user1.setUser("Саша", "Петруненко", "", "sa@mail.ru", "+78936758475", "", "log1", "pas1");
        users.add(user1);

        UserPublic user2 = new UserPublic();
        user2.setUser("Паша", "Иванов", "", "pi@mail.ru", "+78936758475", "Мужской", "log1", "pas1");
        users.add(user2);

        UserPublic user3 = new UserPublic();
        user3.setUser("Таня", "Иванова", "", "pi@mail.ru", "+78936758475", "Женский", "log1", "pas1");
        users.add(user3);

        UserPublic user4 = new UserPublic();
        user4.setUser("Олег", "Кузнецов", "", "pi@mail.ru", "+78936758475", "Мужской", "log1", "pas1");
        users.add(user4);

        UserPublic user5 = new UserPublic();
        user5.setUser("Игорь", "Мартынов", "", "pi@mail.ru", "+78936758475", "Мужской", "log1", "pas1");
        users.add(user5);

        UserPublic user6 = new UserPublic();
        user6.setUser("Егор", "Щукин", "", "pi@mail.ru", "+78936758475", "Мужской", "log1", "pas1");
        users.add(user6);

        UserPublic user7 = new UserPublic();
        user7.setUser("Маша", "Крапцова", "", "pi@mail.ru", "+78936758475", "Женский", "log1", "pas1");
        users.add(user7);

        UserPublic user8 = new UserPublic();
        user8.setUser("Валерия", "Кузнецова", "", "pi@mail.ru", "+78936758475", "Женский", "log1", "pas1");
        users.add(user8);

        UserPublic user9 = new UserPublic();
        user9.setUser("Нина", "Белова", "", "pi@mail.ru", "+78936758475", "Женский", "log1", "pas1");
        users.add(user9);

        UserPublic user10 = new UserPublic();
        user10.setUser("Женя", "Мартыненко", "", "pi@mail.ru", "+78936758475", "", "log1", "pas1");
        users.add(user10);

        UserPublic user11 = new UserPublic();
        user11.setUser("Ярослав", "Слуцкий", "", "pi@mail.ru", "+78936758475", "Мужской", "log1", "pas1");
        users.add(user11);

        UserPublic user12 = new UserPublic();
        user12.setUser("Катя", "Янина", "", "pi@mail.ru", "+78936758475", "Женский", "log1", "pas1");
        users.add(user12);
    }
}
