package com.example.onlinediary.AccountActivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.onlinediary.Model.Listdata;
import com.example.fishermen.R;

import java.util.List;


public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyHolder>{

    List<Listdata> listdata;

    public RecyclerviewAdapter(List<Listdata> listdata) {
        this.listdata = listdata;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myview,parent,false);

        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }


    public void onBindViewHolder(MyHolder holder, int position) {
     Listdata data = listdata.get(position);
        holder.name.setText(data.getName());
        holder.details.setText(data.getDetails());
        holder.date.setText(data.getDate());
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{
               TextView name , details,date;

        public MyHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.noteName);
            details = (TextView) itemView.findViewById(R.id.noteDetails);
            date = (TextView) itemView.findViewById(R.id.noteDate);

        }
    }


}
