package com.example.fragmentsandrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>
{
    private ArrayList<Person> people;
    ItemClicked activity;

    public interface ItemClicked
    {
       void onItemClicked(int index);
    }


    public PersonAdapter (Context context, ArrayList<Person> list)
    {
        people = list;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvNameC;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNameC = itemView.findViewById(R.id.tvNameC);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {

                    activity.onItemClicked(people.indexOf((Person)view.getTag()));

                }
            });

        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder viewHolder, int i) {

        viewHolder.itemView.setTag(people.get(i));
        viewHolder.tvNameC.setText(people.get(i).getName());

    }

    @Override
    public int getItemCount()
    {
        return people.size();
    }
}
