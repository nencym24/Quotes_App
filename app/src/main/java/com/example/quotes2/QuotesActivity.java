package com.example.quotes2;

import static com.example.quotes2.R.drawable.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.quotes2.Adapters.ImgListAdapter;
import com.example.quotes2.Clicks.ImgClick;

import java.util.ArrayList;

public class QuotesActivity extends AppCompatActivity {

    int imgArray[] = {img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16,img17,img18,img19,img20};
    ArrayList<Integer> imgArrayList = new ArrayList<>();
    private static final String TAG= "QuotesActivity";

    ImageView backImage;
    TextView txtQuote;
    NestedScrollView NestedScroll;
    RecyclerView imgList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        txtQuote = findViewById(R.id.txtQuote);
        imgList = findViewById(R.id.imgList);
        backImage = findViewById(R.id.backImage);
        NestedScroll = findViewById(R.id.NestedScroll);

        for (int i = 0; i < imgArray.length; i++) {
            imgArrayList.add(imgArray[i]);
        }

        String quote = getIntent().getStringExtra("quote");
        txtQuote.setText(quote);

        loadData();
    }
    private void loadData() {

        ImgClick click = new ImgClick() {
            @Override
            public void getImg(int pos) {
                Glide.with(QuotesActivity.this).load(imgArray[pos]).into(backImage);
            }
        };

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        ImgListAdapter adapter =new ImgListAdapter(imgArrayList,click);
        imgList.setLayoutManager(manager);
        imgList.setAdapter(adapter);
    }
}
