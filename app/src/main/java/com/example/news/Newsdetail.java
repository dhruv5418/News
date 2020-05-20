package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Newsdetail extends AppCompatActivity {

    ImageView imageView;
    TextView txt_title,txt_desc,txt_author,txt_category,txt_date,txt_link;
    News_  news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetail);

        imageView=findViewById(R.id.detail_imgv);
        txt_title=findViewById(R.id.txt_detail_title);
        txt_desc=findViewById(R.id.txt_detail_description);
        txt_link=findViewById(R.id.txt_detail_link);
        txt_author=findViewById(R.id.txt_detail_author);
        txt_date=findViewById(R.id.txt_detail_date);
        //txt_category=findViewById(R.id.txt_detail_category);
        news=getIntent().getParcelableExtra("key");
        generateView();
        txt_desc.setMovementMethod(new ScrollingMovementMethod());
        txt_link.setMovementMethod(new ScrollingMovementMethod());
    }
    public void generateView()
    {
        Picasso.get().load(news.getImage()).into(imageView);
        txt_title.setText("Name :"+news.getTitle());
        txt_desc.setText("Type :"+news.getDescription());
        txt_link.setText("Link :"+news.getUrl());
        txt_author.setText("Ability :"+news.getAuthor());
      //  txt_category.setText("Height :"+news.getCategory());
        txt_date.setText("Weight :"+news.getPublished());
    }
}
