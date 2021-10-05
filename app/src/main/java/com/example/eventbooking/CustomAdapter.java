package com.example.eventbooking;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList event_id, event_category, event_guests, event_date, event_time, event_venue;



    CustomAdapter(Activity activity, Context context,
                  ArrayList event_id,
                  ArrayList event_category,
                  ArrayList event_guests,
                  ArrayList event_date,
                  ArrayList event_time,
                  ArrayList event_venue) {
        this.activity = activity;
        this.context = context;
        this.event_id = event_id;
        this.event_category = event_category;
        this.event_guests = event_guests;
        this.event_date = event_date;
        this.event_time = event_time;
        this.event_venue = event_venue;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.event_id_txt.setText(String.valueOf(event_id.get(position)));
        holder.event_category_txt.setText(String.valueOf(event_category.get(position)));
        holder.event_guests_txt.setText(String.valueOf(event_guests.get(position)));
        holder.event_date_txt.setText(String.valueOf(event_date.get(position)));
        holder.event_time_txt.setText(String.valueOf(event_time.get(position)));
        holder.event_venue_txt.setText(String.valueOf(event_venue.get(position)));
        holder.mainLayout.setOnClickListener(view -> {
            Intent intent = new Intent(context, UpdateActivity.class);
            intent.putExtra("id", String.valueOf(event_id.get(position)));
            intent.putExtra("category", String.valueOf(event_category.get(position)));
            intent.putExtra("guests", String.valueOf(event_guests.get(position)));
            intent.putExtra("date", String.valueOf(event_date.get(position)));
            intent.putExtra("time", String.valueOf(event_time.get(position)));
            intent.putExtra("venue", String.valueOf(event_venue.get(position)));
            activity.startActivityForResult(intent, 1);

        });

    }

    @Override
    public int getItemCount() {
        return event_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView event_id_txt, event_category_txt, event_guests_txt, event_date_txt, event_time_txt, event_venue_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            event_id_txt = itemView.findViewById(R.id.event_id_txt);
            event_category_txt = itemView.findViewById(R.id.event_category_txt);
            event_guests_txt = itemView.findViewById(R.id.event_guests_txt);
            event_date_txt = itemView.findViewById(R.id.event_date_txt);
            event_time_txt = itemView.findViewById(R.id.event_time_txt);
            event_venue_txt = itemView.findViewById(R.id.event_venue_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
