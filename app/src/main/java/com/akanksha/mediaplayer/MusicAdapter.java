package com.akanksha.mediaplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Music> musicList;
    private MediaPlayer mediaPlayer;
    private boolean flag=true;

    public MusicAdapter(Context context, int layout, ArrayList<Music> musicList) {
        this.context = context;
        this.layout = layout;
        this.musicList = musicList;
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int position) {
        return musicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder{
        TextView textView_songname,textView_artist;
        ImageView imageView_stop,imageView_play,imageView_pause;
        private View convertView;
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        public ViewHolder(){
            convertView=layoutInflater.inflate(layout,null);
            textView_songname=convertView.findViewById(R.id.textview_songs);
            textView_artist=convertView.findViewById(R.id.textview_artist);
            imageView_play=convertView.findViewById(R.id.imageview_play);
            imageView_stop=convertView.findViewById(R.id.imageview_stop);
            imageView_pause=convertView.findViewById(R.id.imageview_pause);

        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder=new ViewHolder();
        if(convertView==null){
            convertView=viewHolder.convertView;
        }else{

        }
        final Music music=musicList.get(position);
        viewHolder.textView_songname.setText(music.getSong_name());
        viewHolder.textView_artist.setText(music.getArtist());
        viewHolder.imageView_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    mediaPlayer=MediaPlayer.create(context,music.getSongs());
                    flag=false;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    viewHolder.imageView_play.setImageResource(R.drawable.play);
                }else{
                    mediaPlayer.start();
                    viewHolder.imageView_play.setImageResource(R.drawable.pause);
                }

                mediaPlayer.start();
            }
        });
        viewHolder.imageView_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag=true;
                }
                viewHolder.imageView_stop.setImageResource(R.drawable.stop);
                viewHolder.imageView_play.setImageResource(R.drawable.pause);
            }
        });
        viewHolder.imageView_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag){
                    mediaPlayer.pause();
                    flag=true;
                }
                viewHolder.imageView_play.setImageResource(R.drawable.play);
            }
        });

        return convertView;
    }
}
