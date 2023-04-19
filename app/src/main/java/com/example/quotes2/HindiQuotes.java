package com.example.quotes2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.quotes2.Adapters.HiQuotesAdapter;
import com.example.quotes2.Clicks.QuotesClick;
import com.example.quotes2.Utils.Utils;
import com.example.quotes2.Utils.Utils1;

import java.util.ArrayList;

public class HindiQuotes extends AppCompatActivity {

    NestedScrollView nestedScroll;
    RecyclerView rcvList;

    ArrayList<String> arrayList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindi_quotes);

        rcvList = findViewById(R.id.rcvList);
        nestedScroll = findViewById(R.id.nestedScroll);

        for (int i = 0; i < Utils.Quotes.length; i++) {
            arrayList.add(Utils.Quotes[i]);
        }

        loadData();
    }

    private void loadData() {

        QuotesClick click = new QuotesClick() {
            @Override
            public void getQuote(String quote) {

                Intent intent = new Intent(HindiQuotes.this, QuotesActivity.class);
                intent.putExtra("quote",quote);
                startActivity(intent);

            }
        };

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        HiQuotesAdapter adapter = new HiQuotesAdapter(arrayList,click);
        rcvList.setLayoutManager(manager);
        rcvList.setAdapter(adapter);
    }
}