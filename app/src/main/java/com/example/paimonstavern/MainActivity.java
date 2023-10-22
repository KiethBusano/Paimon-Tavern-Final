package com.example.paimonstavern;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaplayer;
    private MediaPlayer mediaplayer37;
    private EditText traveler_name;
    private EditText traveler_confirm;
    private Button button_login;
    private TextView error_text;
    RelativeLayout layout1;
    private PopupWindow tavernPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        traveler_name = findViewById(R.id.traveler_name);
        traveler_confirm = findViewById(R.id.traveler_confirm);
        traveler_confirm.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        button_login = findViewById(R.id.button_login);
        error_text = findViewById(R.id.error_text);
        layout1 = findViewById(R.id.layout1);

        mediaplayer = MediaPlayer.create(this, R.raw.loginmusic_button);
        mediaplayer37 = MediaPlayer.create(this, R.raw.back);


        mediaplayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Log.e("MediaPlayer", "Error: " + what + ", " + extra);
                return false; // Handle the error
            }
        });


        CreateTavernPopup();
    }
    private void CreateTavernPopup() {
        Log.d("TavernPopup", "Creating the tavern popup");
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.tavernpopup, null);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        boolean focusable = true;

        tavernPopup = new PopupWindow(popUpView, width, height, focusable);

        // Adding a log statement to check if this code is being executed
        Log.d("TavernPopup", "Showing the tavern popup");

        layout1.post(new Runnable() {
            @Override
            public void run() {
                tavernPopup.showAtLocation(layout1, Gravity.BOTTOM, 0, 0);
            }
        });

        TextView Proceed;
        Proceed = popUpView.findViewById(R.id.proceed_button);
        Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaplayer37.isPlaying()) {
                    mediaplayer37.start();
                }

                tavernPopup.dismiss();
            }
        });



        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playMusic();

                String username = traveler_name.getText().toString();
                String confirmName = traveler_confirm.getText().toString();

                if (username.isEmpty() && confirmName.isEmpty()) {
                    error_text.setText("Input your name first");
                    Toast.makeText(MainActivity.this, "Nameless Traveler", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            error_text.setText("");
                        }
                    }, 3000);
                } else if (username.isEmpty()) {
                    error_text.setText("No name inputted");
                    Toast.makeText(MainActivity.this, "Enter name first", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            error_text.setText("");
                        }
                    }, 3000);
                } else if (confirmName.isEmpty()) {
                    error_text.setText("Input your name to proceed");
                    Toast.makeText(MainActivity.this, "Nameless Traveler", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            error_text.setText("");
                        }
                    }, 3000);
                } else if (!username.equals(confirmName)) {
                    error_text.setText("Name unmatched");
                    traveler_name.getText().clear();
                    traveler_confirm.getText().clear();
                    Toast.makeText(MainActivity.this, "Name unmatched", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            error_text.setText("");
                        }
                    }, 3000);
                } else {


                    error_text.setText("");
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, tavernmain.class);
                    startActivity(intent);

                }
            }
        });
    }
    @Override
    protected void onResume(){
      super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy(){
        super.onDestroy();
        mediaplayer.release();
        mediaplayer37.release();
    }

    public void playMusic() {
        if (!mediaplayer.isPlaying()) {
            mediaplayer.start();
        }

    }
}
