package com.example.tugas3_api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder>{
    private List<ListNews> newsList;

    public MainAdapter(List<ListNews> newsList){
        this.newsList = newsList;
    }

    @Override
    public MainViewHolder onCreateViewHolder(
            ViewGroup parent,
            int viewType
    ){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.news_card_view, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            MainViewHolder holder,
            int position) {
        String title = newsList.get(position).getTitle();
        String author = newsList.get(position).getAuthor();
        String description = newsList.get(position).getDescription();
        holder.tvNewsTitle.setText(title);
        holder.tvNewsAuthor.setText(author);
        holder.tvNewsDesc.setText(description);
    }

    @Override
    public int getItemCount() {
        return (newsList != null) ? newsList.size() : 0;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNewsDesc, tvNewsTitle, tvNewsAuthor;

        public MainViewHolder(View itemView){
            super(itemView);
            tvNewsTitle = (TextView) itemView
                    .findViewById(R.id.tv_news_title);
            tvNewsAuthor = (TextView) itemView
                    .findViewById(R.id.tv_news_author);
            tvNewsDesc = (TextView) itemView
                    .findViewById(R.id.tv_news_desc);
        }
    }
}
