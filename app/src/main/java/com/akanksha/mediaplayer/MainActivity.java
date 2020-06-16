package com.akanksha.mediaplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Music> my_main_ArrayList;
    private MusicAdapter my_musicadapter;
    private ListView listView_songs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView_songs=findViewById(R.id.listviewforsong);
        my_main_ArrayList=new ArrayList();
        my_main_ArrayList.add(new Music("Ee Kaattu","unknown",R.raw.ekaattu));
        my_main_ArrayList.add(new Music("Arikil Ini","unknown",R.raw.arikilini));
        MusicAdapter musicAdapter=new MusicAdapter(this,R.layout.songs_item_listview,my_main_ArrayList);
        listView_songs.setAdapter(musicAdapter);
    }
}
