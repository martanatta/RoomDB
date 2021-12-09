package com.example.roomdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdb.db.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {
    private Context context;
    private List<User> userList;

    public UserListAdapter(Context context) {
        this.context = context;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
//        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_person, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textName.setText(this.userList.get(position).name);
        holder.textSurname.setText(this.userList.get(position).surname);
        holder.textEmail.setText(this.userList.get(position).Email);
        holder.textPhone.setText(this.userList.get(position).phone);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textSurname, textEmail, textPhone;

        public MyViewHolder(View view) {
            super(view);
            textName = view.findViewById(R.id.textName);
            textSurname = view.findViewById(R.id.textSurname);
            textEmail = view.findViewById(R.id.textEmail);
            textPhone = view.findViewById(R.id.textPhone);
        }
    }
}
