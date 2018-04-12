package com.example.a13_da.socialnetwork;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 13_da on 05.04.2018.
 */

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<User> female, male, not_defined, userList;
    private LayoutInflater inflater;
    private final int USER = 0, LABLE = 1;

    DataAdapter(Context context, List<User> female, List<User> male, List<User> not_defined, List<User> userList){
        this.female = female;
        this.male = male;
        this.not_defined = not_defined;
        this.userList = userList;

        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        inflater = LayoutInflater.from(viewGroup.getContext());
        switch (viewType) {
            case USER:
                View v1 = inflater.inflate(R.layout.item_list, viewGroup, false);
                viewHolder = new DataAdapter.ViewHolder(v1);
                break;
            case LABLE:
                View v2 = inflater.inflate(R.layout.lable_list, viewGroup, false);
                viewHolder = new DataAdapter.ViewHolderLable(v2);
                break;
        }
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position == female.size() + 1 || position == female.size() + male.size() + 2)
            return LABLE;
        else
            return USER;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //if (holder instanceof DataAdapter.ViewHolder)
        switch (holder.getItemViewType()) {
            case USER:
                DataAdapter.ViewHolder vh1 = (DataAdapter.ViewHolder) holder;
                configureViewHolder1(vh1, position);
                break;
            case LABLE:
                DataAdapter.ViewHolderLable vh2 = (DataAdapter.ViewHolderLable) holder;
                configureViewHolder2(vh2, position);
                break;
        }
    }

    private void configureViewHolder1(DataAdapter.ViewHolder vh1, int position) {
        User user = null;
        if (position <= female.size()) {
            System.out.println(position-1 + " / " + female.size());
            user = female.get(position - 1);
        }
        else {
            if (position <= female.size() + male.size() + 1) {
                System.out.println(position - female.size() - 2 + " / " + male.size());
                user = male.get(position - female.size() - 2);
            }
            else {
                System.out.println(position-female.size()-male.size()-3 + " / " + not_defined.size());
                user = not_defined.get(position-female.size()-male.size()-3);
            }
        }
        vh1.nameView.setText(user.getName() + " " + user.getSurname());
        vh1.phoneView.setText(user.getPhone());
    }
    private void configureViewHolder2(DataAdapter.ViewHolderLable vh2, int position) {
        if (position == 0)
            vh2.lable.setText("Женский пол");
        if (position == female.size() + 1)
            vh2.lable.setText("Мужской пол");
        if (position == female.size() + male.size() + 2)
            vh2.lable.setText("Пол не задан");
    }

    @Override
    public int getItemCount() {
        return male.size() + female.size() + not_defined.size() + 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        final TextView nameView, phoneView;
        final ImageView avaView, imgView;
        ViewHolder(View view){
            super(view);
            avaView = view.findViewById(R.id.item_ava);
            nameView = view.findViewById(R.id.item_name);
            phoneView = view.findViewById(R.id.item_phone);
            imgView = view.findViewById(R.id.item_img);
        }
    }
    public class ViewHolderLable extends RecyclerView.ViewHolder{
        final TextView lable;
        ViewHolderLable(View view){
            super(view);
            lable = view.findViewById(R.id.list_lable);
        }
    }
}
