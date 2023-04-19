package com.example.quotes2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quotes2.Clicks.QuotesClick;
import com.example.quotes2.R;

import java.util.ArrayList;

public class HiQuotesAdapter extends RecyclerView.Adapter<HiQuotesAdapter.HiQuotesHolder>{

    ArrayList<String> quotes;
    QuotesClick click;
    Context context;

    public HiQuotesAdapter(ArrayList<String> quotes, QuotesClick click) {
        this.quotes = quotes;
        this.click = click;
    }

    @NonNull
    @Override
    public HiQuotesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hiquotes,parent,false);
        return new HiQuotesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HiQuotesHolder holder, int position) {

        holder.hiQuotes.setText(quotes.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click.getQuote(quotes.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    class HiQuotesHolder extends RecyclerView.ViewHolder {

        TextView hiQuotes;
        public HiQuotesHolder(@NonNull View itemView) {
            super(itemView);

            hiQuotes = itemView.findViewById(R.id.hiQuotes);
        }
    }

}
