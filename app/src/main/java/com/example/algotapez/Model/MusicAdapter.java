package com.example.algotapez.Model;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.algotapez.R;
import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {

    private List<Song> musicList;
    private OnItemClickListener listener;

    public MusicAdapter(List<Song> musicList, OnItemClickListener listener) {
        this.musicList = musicList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = musicList.get(position);
        Log.d("Adapter", "Binding song: " + song.getSongTitle());
        holder.musicTitleTextView.setText(song.getSongTitle());
        holder.musicArtistTextView.setText(song.getArtistName());
        holder.musicYearTextView.setText(song.getYear());
        holder.musicComposerTextView.setText(song.getComposer());

        // Load the image using Glide library
        Glide.with(holder.itemView.getContext())
                .load(song.getImageUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView musicTitleTextView;
        public TextView musicArtistTextView;
        public TextView musicYearTextView;
        public TextView musicComposerTextView;
        public TextView musicRatingTextView;
        public ImageView imageView;

        private OnItemClickListener listener;

        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            musicTitleTextView = itemView.findViewById(R.id.musicTitleTextView);
            musicArtistTextView = itemView.findViewById(R.id.musicArtistTextView);
            musicYearTextView = itemView.findViewById(R.id.musicYearTextView);
            musicComposerTextView = itemView.findViewById(R.id.musicComposerTextView);
            musicRatingTextView = itemView.findViewById(R.id.musicRatingTextView);
            imageView = itemView.findViewById(R.id.imageView);

            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(getAdapterPosition());
        }
    }
}




