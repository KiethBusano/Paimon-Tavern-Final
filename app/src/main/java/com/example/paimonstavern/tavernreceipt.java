package com.example.paimonstavern;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class tavernreceipt extends AppCompatActivity {
    private PopupWindow tavernPopup1;
    private MediaPlayer mediaPlayer34;
    private MediaPlayer mediaPlayer35;
    private Switch receipt_ost;


    RelativeLayout layoutreceipt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tavernreceipt);

        layoutreceipt = findViewById(R.id.layoutreceipt);
        mediaPlayer34 = MediaPlayer.create(this, R.raw.clear);
        mediaPlayer35 = MediaPlayer.create(this, R.raw.paimonial);
        receipt_ost = findViewById(R.id.receipt_ost);

        receipt_ost.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    if(!mediaPlayer35.isPlaying()){
                        mediaPlayer35.start();
                    }
                }else{
                    if (mediaPlayer35.isPlaying()){
                        mediaPlayer35.pause();
                    }
                }
            }
        });
        receipt_ost.setChecked(true);

        // Receive the ordered items and quantities from the intent
        Intent intent = getIntent();
        ArrayList<String> orderedItems = intent.getStringArrayListExtra("orderedItems");
        ArrayList<Integer> orderedQuantities = intent.getIntegerArrayListExtra("orderedQuantities");



        CreateTavernPopup();



        if (orderedItems != null && orderedQuantities != null) {
            StringBuilder receiptText = new StringBuilder("Ordered Items:\n\n");

            for (int i = 0; i < orderedItems.size(); i++) {
                String itemName = orderedItems.get(i);
                int quantity = orderedQuantities.get(i);

                receiptText.append("Item: ").append(itemName).append(", X ").append(quantity).append("\n");
            }

            // Find the TextViews for displaying ordered items and quantities
            TextView itemTextView = findViewById(R.id.get_allitem);
            TextView quantityTextView = findViewById(R.id.get_itemquantity);

            // Set the text of the TextViews
            itemTextView.setText(receiptText.toString());
            quantityTextView.setText(""); // You can set this to an empty string if you don't want to display quantities
        }
    }
    private void CreateTavernPopup() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popupthankyou, null);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        boolean focusable = true;

        tavernPopup1 = new PopupWindow(popUpView, width, height, focusable);

        // Adding a log statement to check if this code is being executed
        Log.d("TavernPopup", "Showing the tavern popup");

        layoutreceipt.post(new Runnable() {
            @Override
            public void run() {
                tavernPopup1.showAtLocation(layoutreceipt, Gravity.TOP, 0, 0);
            }
        });

        TextView check;
        check = popUpView.findViewById(R.id.checkorder);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer34.isPlaying()){
                    mediaPlayer34.start();
                }
                tavernPopup1.dismiss();
            }
        });
    }
    protected void onResume(){
        super.onResume();
        if (receipt_ost.isChecked() && !mediaPlayer35.isPlaying()){
            mediaPlayer35.start();
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer35 != null) {
            mediaPlayer35.stop();
            mediaPlayer35.release();
            mediaPlayer35 = null;
        }

        if (!mediaPlayer34.isPlaying()) {
            mediaPlayer34.start();
        }
    }
    public void backlogging(View view) {
        if (!mediaPlayer34.isPlaying()){
            mediaPlayer34.start();
        }
        if (!mediaPlayer35.isPlaying()){
            mediaPlayer35.stop();
        }
        Intent intent = new Intent(tavernreceipt.this, tavernmain.class);
        startActivity(intent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer34.release();
        mediaPlayer35.release();
    }
}
