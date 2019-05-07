package com.oussema.eventregistration;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oussema.eventregistration.model.Member;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Member> members;

    public MyAdapter(List<Member> members) {
        this.members = members;
    }

    public List<Member> getMembers(){
        return members;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        String name = members.get(i).getName();
        String mail = members.get(i).getEmail();
        myViewHolder.setData(name,mail);
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtMail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_name);
            txtMail = itemView.findViewById(R.id.txt_mail);
        }

        private void setData(String name, String mail){
                txtName.setText(name);
                txtMail.setText(mail);
        }

    }

}
