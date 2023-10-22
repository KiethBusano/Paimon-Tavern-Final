package com.example.paimonstavern;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class tavernmain extends AppCompatActivity {

    private MediaPlayer mediaPlayer2;
    private MediaPlayer mediaPlayer3;

    TextView back_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tavernmain);

        back_main = findViewById(R.id.back_main);

        mediaPlayer2 = MediaPlayer.create(this,R.raw.back);
        mediaPlayer3 = MediaPlayer.create(this,R.raw.plus_minus_button);

        back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!mediaPlayer2.isPlaying()){
                    mediaPlayer2.start();
                }
                Intent intent = new Intent(tavernmain.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }

    public void showhandbook(View view) {

        if (!mediaPlayer3.isPlaying()){
            mediaPlayer3.start();
        }

        Intent intent = new Intent(tavernmain.this, handbook.class);
        startActivity(intent);
    }

    public void showmonstadtmenu(View view) {

        if (!mediaPlayer3.isPlaying()){
            mediaPlayer3.start();
        }

        Intent intent = new Intent(tavernmain.this, mondstadtmenu.class);
        startActivity(intent);
    }

    public void showliyuemenu(View view) {

        if (!mediaPlayer3.isPlaying()){
            mediaPlayer3.start();
        }

        Intent intent = new Intent(tavernmain.this, liyuemenu.class);
        startActivity(intent);
    }

    public void showinazumamenu(View view) {

        if (!mediaPlayer3.isPlaying()){
            mediaPlayer3.start();
        }

        Intent intent = new Intent(tavernmain.this, inazumamenu.class);
        startActivity(intent);
    }

    public void showsumerumenu(View view) {

        if (!mediaPlayer3.isPlaying()){
            mediaPlayer3.start();
        }

        Intent intent = new Intent(tavernmain.this, sumerumenu.class);
        startActivity(intent);
    }

    public void showfontainemenu(View view) {

        if (!mediaPlayer3.isPlaying()){
            mediaPlayer3.start();
        }

        Intent intent = new Intent(tavernmain.this, fontainemenu.class);
        startActivity(intent);
    }

    @Override
    protected void onResume(){
        super.onResume();
    }
    @Override
    protected void onPause(){
        super.onPause();

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mediaPlayer2.release();
        mediaPlayer3.release();
    }
}
