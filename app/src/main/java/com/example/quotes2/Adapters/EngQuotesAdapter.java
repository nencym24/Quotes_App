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

public class EngQuotesAdapter extends RecyclerView.Adapter<EngQuotesAdapter.EngQuotesHolder> {

    ArrayList<String> quotes1;
    QuotesClick click;
    Context context;

    public EngQuotesAdapter(ArrayList<String> quotes1, QuotesClick click) {
        this.quotes1 = quotes1;
        this.click = click;
    }

    @NonNull
    @Override
    public EngQuotesAdapter.EngQuotesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.engquotes,parent,false);
        return new EngQuotesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EngQuotesAdapter.EngQuotesHolder holder, int position) {

        holder.EngQuotes.setText(quotes1.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    click.getQuote(quotes1.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return quotes1.size();
    }

    public class EngQuotesHolder extends RecyclerView.ViewHolder {

        TextView EngQuotes;

        public EngQuotesHolder(@NonNull View itemView) {
            super(itemView);

            EngQuotes = itemView.findViewById(R.id.EngQuotes);
        }
    }
}
