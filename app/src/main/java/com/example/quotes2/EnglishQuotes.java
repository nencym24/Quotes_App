package com.example.quotes2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.quotes2.Adapters.EngQuotesAdapter;
import com.example.quotes2.Clicks.QuotesClick;
import com.example.quotes2.Utils.Utils1;

import java.util.ArrayList;

public class EnglishQuotes extends AppCompatActivity {

    RecyclerView RcvList;
    NestedScrollView nestedScroll;

    ArrayList<String> arrayList = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_quotes);

        RcvList = findViewById(R.id.RcvList);
        nestedScroll = findViewById(R.id.nestedScroll);

        for (int i = 0; i < Utils1.Quotes1.length; i++) {
                arrayList.add(Utils1.Quotes1[i]);
        }

        loadData();
    }

    private void loadData() {

        QuotesClick click = new QuotesClick() {
            @Override
            public void getQuote(String quote) {

                Intent intent = new Intent(EnglishQuotes.this, QuotesActivity.class);
                intent.putExtra("quote",quote);
                startActivity(intent);
            }
        };

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        EngQuotesAdapter adapter = new EngQuotesAdapter(arrayList,click);
        RcvList.setLayoutManager(manager);
        RcvList.setAdapter(adapter);
    }
}