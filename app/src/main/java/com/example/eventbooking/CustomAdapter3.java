package com.example.eventbooking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter3 extends RecyclerView.Adapter<CustomAdapter3.MyViewHolder> {

   private Context context;
   private ArrayList book_id, checkindate, checkoutdate, packg, noofrooms, preference;

    CustomAdapter3(Context context, ArrayList book_id,
                   ArrayList checkindate,
                   ArrayList checkoutdate,
                   ArrayList packg,
                   ArrayList noofrooms,
                   ArrayList preference){
        this.context = context;
        this.book_id = book_id;
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
        this.packg = packg;
        this.noofrooms = noofrooms;
        this.preference = preference;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row3, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.book_id_txt.setText(String.valueOf(book_id.get(position)));
        holder.checkindate_txt.setText(String.valueOf(checkindate.get(position)));
        holder.checkoutdate_txt.setText(String.valueOf(checkoutdate.get(position)));
        holder.packg_txt.setText(String.valueOf(packg.get(position)));
        holder.ntoofroom_txt.setText(String.valueOf(noofrooms.get(position)));
        holder.preference_txt.setText(String.valueOf(preference.get(position)));
    }

    @Override
    public int getItemCount() {
        return book_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView book_id_txt,checkindate_txt,checkoutdate_txt,packg_txt,ntoofroom_txt,preference_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id_txt = itemView.findViewById(R.id.book_id_txt);
            checkindate_txt = itemView.findViewById(R.id.checkindate_txt);
            checkoutdate_txt = itemView.findViewById(R.id.checkoutdate_txt);
            packg_txt = itemView.findViewById(R.id.packg_txt);
            ntoofroom_txt = itemView.findViewById(R.id.ntoofroom_txt);
            preference_txt = itemView.findViewById(R.id.preference_txt);

        }
    }
}
