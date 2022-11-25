package com.example.tugas3_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerNews;
    private List<ListNews> newsList;
    private final String country = "us";
    private final String category = "sports";
    private final String API_KEY = "9c0e3baa423d43f3be830ef7c6a700d5";
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inject_data(country, category, API_KEY);
    }

    private void inject_data(String country, String category, String API_key) {

        newsList = new ArrayList<>();

        Call<DefaultResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .getAllNews(country, category, API_key);

        call.enqueue(new Callback<DefaultResponse>(){


            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                List<ListNews> listOfNews =
                        response.body().getArticles();
                for (int i = 0; i < listOfNews.size(); i++){
                    newsList.add(new ListNews(listOfNews.get(i).getAuthor(), listOfNews.get(i).getTitle(), listOfNews.get(i).getDescription(), listOfNews.get(i).getUrl()));
                }
                hookingAdapter(newsList);

            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });
    }

    private void hookingAdapter(List<ListNews> listBerita){
        recyclerNews = (RecyclerView) findViewById(R.id.recyclerNews);
        adapter = new MainAdapter(listBerita);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerNews.setLayoutManager(layoutManager);
        recyclerNews.setAdapter(adapter);
    }
}

