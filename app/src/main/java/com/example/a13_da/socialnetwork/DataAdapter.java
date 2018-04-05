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

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<UserPublic> users;

    DataAdapter(Context context, List<UserPublic> users) {
        this.users = users;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        UserPublic user = users.get(position);
       // holder.imageView.setImageResource(user.getPhoto());
        holder.nameView.setText(user.getName() + " " + user.getSurname());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //final ImageView imageView;
        final TextView nameView;
        ViewHolder(View view){
            super(view);
           // imageView = view.findViewById(R.id.image);
            nameView = view.findViewById(R.id.name);
        }
    }
}
