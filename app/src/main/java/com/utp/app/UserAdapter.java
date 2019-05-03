package com.utp.app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // return null;
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_user, viewGroup, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        User user = users.get(i);
        userViewHolder.txvName.setText(user.getName());
        userViewHolder.txvSurname.setText(user.getSurname());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class UserViewHolder extends ViewHolder {

        private TextView txvName, txvSurname;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            txvName = itemView.findViewById(R.id.txv_name);
            txvSurname = itemView.findViewById(R.id.txv_surname);
        }
    }
}
