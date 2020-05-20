package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    ArrayList<News_> newsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<News> call = service.getAllNews();

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                System.out.println("Response From URL :" + response.body());

                try {
                    News number = response.body();

                    newsList = new ArrayList<>(number.getNews());

                    generateView(newsList);

                }catch (NullPointerException e)
                {
                    System.out.println("Nullpointer Exception :"+e.getMessage());
                }



            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

                System.out.println("In Failure :" + t.getMessage());

            }
        });
    }
    public void generateView(ArrayList<News_> numberS)
    {
        recyclerAdapter = new RecyclerAdapter(numberS, getApplicationContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView = findViewById(R.id.main_recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.setOnClickListner(onClickListener);
    }


    public final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();

            Toast.makeText(getApplicationContext(), newsList.get(position).getTitle(), Toast.LENGTH_SHORT).show();

            Intent i = new Intent(MainActivity.this, Newsdetail.class);
            i.putExtra("key", newsList.get(position));
            startActivity(i);
         /*   Intent i = new Intent(MainActivity.this,Newsdetail.class);
           i.putExtra("news",newsList.get(position));
            startActivity(i);
*/

        }
    };
}
