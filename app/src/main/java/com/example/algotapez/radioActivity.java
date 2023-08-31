package com.example.algotapez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import com.example.algotapez.Model.MusicAdapter;
import com.example.algotapez.Model.Song;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class radioActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MusicAdapter musicAdapter;

    private final List<Song> musicList = new ArrayList<>(); // Initialize the list
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        // Initialize RecyclerView and its adapter
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        musicAdapter = new MusicAdapter(musicList, position -> playAudio(musicList.get(position).getAudioUrl()));
        recyclerView.setAdapter(musicAdapter);

        // Fetch music data from Firebase
        fetchMusicData();
    }

    private void fetchMusicData() {
        try {
            // Get a reference to the Firebase database
            DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("audio");

            // Add a listener for data changes
            databaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Clear the list before adding new data
                    musicList.clear();

                    // Loop through the data and add it to the list
                    for (DataSnapshot songSnapshot : dataSnapshot.getChildren()) {
                        Song song = songSnapshot.getValue(Song.class);
                        musicList.add(song);
                    }

                    // Notify the adapter about data change
                    musicAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Handle error
                    Log.e("radioActivity", "Error fetching music data: " + databaseError.getMessage());
                }
            });
        } catch (Exception e) {
            // Handle exception
            Log.e("radioActivity", "Error fetching music data: " + e.getMessage());
        }
    }

    private void playAudio(String audioUrl) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }

        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(audioUrl);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}






