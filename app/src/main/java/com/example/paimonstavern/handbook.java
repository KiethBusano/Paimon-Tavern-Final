package com.example.paimonstavern;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class handbook extends AppCompatActivity {

    private TextView finish_button;

    private MediaPlayer mediaplayer36;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handbook);

        finish_button = findViewById(R.id.finish_button);

        Button share1 = findViewById(R.id.share1);
        Button share2 = findViewById(R.id.share2);

        mediaplayer36 = MediaPlayer.create(this, R.raw.back);

        share1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent shareIntent1 = new Intent(Intent.ACTION_SEND);
                shareIntent1.setType("text/plain");

                String title = "More about Genshin Impact";
                String link = "https://genshin.hoyoverse.com/en/home";
                String message = title + "\n" + link + "\n";

                shareIntent1.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(Intent.createChooser(shareIntent1, "References"));
            }
        });

        share2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent shareIntent2 = new Intent(Intent.ACTION_SEND);
                shareIntent2.setType("text/plain");

                String title = "Genshin Impact Foods";
                String link = "https://genshin-impact.fandom.com/wiki/Food";
                String message = title + "\n" + link + "\n";

                shareIntent2.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(Intent.createChooser(shareIntent2, "References"));
            }
        });

        finish_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaplayer36.isPlaying()) {
                    mediaplayer36.start();
                }
                // Handle the click event here
                navigateToTavernMain();
            }
        });
    }


    // Create a method to navigate back to tavernmain
    private void navigateToTavernMain() {
        Intent intent = new Intent(this, tavernmain.class);
        startActivity(intent);
    }

    protected void onDestroy(){
        super.onDestroy();
        mediaplayer36.release();
    }
}