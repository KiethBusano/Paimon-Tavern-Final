package com.example.paimonstavern;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class sumerumenu extends AppCompatActivity {

    private List<String> orderedItems = new ArrayList<>();
    private List<Integer> orderedQuantities = new ArrayList<>();
    private MediaPlayer mediaPlayer22;
    private MediaPlayer mediaPlayer23;
    private MediaPlayer mediaPlayer24;
    private MediaPlayer mediaPlayer25;
    private MediaPlayer mediaPlayer26;
    private MediaPlayer mediaPlayer27;
    private Switch sumeru_ost;
    
    private TextView quantityTextView19;
    private TextView quantityTextView20;
    private TextView quantityTextView21;
    private TextView quantityTextView22;
    private TextView quantityTextView23;
    private TextView quantityTextView24;
    private int quantity19 = 0;
    private int quantity20 = 0;
    private int quantity21 = 0;
    private int quantity22 = 0;
    private int quantity23 = 0;
    private int quantity24 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumerumenu);

        // Initialize the quantity TextView
        quantityTextView19 = findViewById(R.id.quantity19);
        quantityTextView20 = findViewById(R.id.quantity20);
        quantityTextView21 = findViewById(R.id.quantity21);
        quantityTextView22 = findViewById(R.id.quantity22);
        quantityTextView23 = findViewById(R.id.quantity23);
        quantityTextView24 = findViewById(R.id.quantity24);

        // Set click listeners for Plus, Minus, Quantity, Order, Back, and Proceed TextViews
        setClickListeners(R.id.plus_button19);
        setClickListeners(R.id.minus_button19);
        setClickListeners(R.id.order19);
        setClickListeners(R.id.back_button4);
        setClickListeners(R.id.proceed_order4);
        setClickListeners(R.id.clear4);

        setClickListeners(R.id.plus_button20);
        setClickListeners(R.id.minus_button20);
        setClickListeners(R.id.order20);

        setClickListeners(R.id.plus_button21);
        setClickListeners(R.id.minus_button21);
        setClickListeners(R.id.order21);

        setClickListeners(R.id.plus_button22);
        setClickListeners(R.id.minus_button22);
        setClickListeners(R.id.order22);

        setClickListeners(R.id.plus_button23);
        setClickListeners(R.id.minus_button23);
        setClickListeners(R.id.order23);

        setClickListeners(R.id.plus_button24);
        setClickListeners(R.id.minus_button24);
        setClickListeners(R.id.order24);

        mediaPlayer22 = MediaPlayer.create(this, R.raw.sumeru_ost);
        mediaPlayer23 = MediaPlayer.create(this, R.raw.back);
        mediaPlayer24 = MediaPlayer.create(this, R.raw.clear);
        mediaPlayer25 = MediaPlayer.create(this, R.raw.proceed);
        mediaPlayer26 = MediaPlayer.create(this, R.raw.plus_minus_button);
        mediaPlayer27 = MediaPlayer.create(this, R.raw.paimon_food_final);
        sumeru_ost = findViewById(R.id.sumeru_ost);

        sumeru_ost.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    if(!mediaPlayer22.isPlaying()){
                        mediaPlayer22.start();
                    }
                }else{
                    if (mediaPlayer22.isPlaying()){
                        mediaPlayer22.pause();
                    }
                }
            }
        });
        sumeru_ost.setChecked(true);
    }

    private void setClickListeners(int viewId) {
        TextView textView = findViewById(viewId);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleTextViewClick(viewId);
            }
        });
    }

    private void handleTextViewClick(int viewId) {
        switch (viewId) {
            case R.id.plus_button19:
                if (!mediaPlayer26.isPlaying()){
                    mediaPlayer26.start();
                }
                if (quantity19 < 10) {
                    quantity19++;
                    updateQuantityTextView();
                showToast("Added 1 Padisarah Pudding");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }
                break;

            case R.id.minus_button19:
                if (!mediaPlayer26.isPlaying()){
                    mediaPlayer26.start();
                }
                if (quantity19 > 1) {
                    quantity19--;
                    updateQuantityTextView();
                } else if (quantity19 == 1) {
                    quantity19 = 0;
                    updateQuantityTextView();
                showToast("Removed 1 Padisarah Pudding");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order19:
                if (!mediaPlayer27.isPlaying()){
                    mediaPlayer27.start();
                }
                if (quantity19 > 0) {
                    addOrderedItem("Padisarah Pudding", quantity19);

                    showToast("Successfully added " + quantity19 + " Padisarah Pudding");
                }
                // Handle order logic
                quantity19 = 0; // Clear the quantity
                updateQuantityTextView();
                break;

            case R.id.plus_button20:
                if (!mediaPlayer26.isPlaying()){
                    mediaPlayer26.start();
                }
                if (quantity20 < 10) {
                    quantity20++;
                    updateQuantityTextView2();
                showToast("Added 1 Nahida\'s Halvamazd");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button20:
                if (!mediaPlayer26.isPlaying()){
                    mediaPlayer26.start();
                }
                if (quantity20 > 1) {
                    quantity20--;
                    updateQuantityTextView2();
                } else if (quantity20 == 1) {
                    quantity20 = 0;
                    updateQuantityTextView2();
                showToast("Removed 1 Nahida\'s Halvamazd");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order20:
                if (!mediaPlayer27.isPlaying()){
                    mediaPlayer27.start();
                }
                if (quantity20 > 0) {
                    addOrderedItem("Nahida\'s Halvamazd", quantity20);

                    showToast("Successfully added " + quantity20 + " Nahida\'s Halvamazd");
                }
                // Handle order logic
                quantity20 = 0; // Clear the quantity
                updateQuantityTextView2();

                break;

            case R.id.plus_button21:
                if (!mediaPlayer26.isPlaying()){
                    mediaPlayer26.start();
                }
                if (quantity21 < 10) {
                    quantity21++;
                    updateQuantityTextView3();
                showToast("Added 1 Tahchin");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button21:
                if (!mediaPlayer26.isPlaying()){
                    mediaPlayer26.start();
                }
                if (quantity21 > 1) {
                    quantity21--;
                    updateQuantityTextView3();
                } else if (quantity21 == 1) {
                    quantity21 = 0;
                    updateQuantityTextView3();
                showToast("Removed 1 Tahchin");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order21:
                if (!mediaPlayer27.isPlaying()){
                    mediaPlayer27.start();
                }
                if (quantity21 > 0) {
                    addOrderedItem("Tahchin", quantity21);

                    showToast("Successfully added " + quantity21 + " Tahchin");
                }
                // Handle order logic
                quantity21 = 0; // Clear the quantity
                updateQuantityTextView3();
                break;

            case R.id.plus_button22:
                if (!mediaPlayer26.isPlaying()){
                    mediaPlayer26.start();
                }
                if (quantity22 < 10) {
                    quantity22++;
                    updateQuantityTextView4();
                showToast("Added 1 Rose Custard");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button22:
                if (!mediaPlayer26.isPlaying()){
                    mediaPlayer26.start();
                }
                if (quantity22 > 1) {
                    quantity22--;
                    updateQuantityTextView4();
                } else if (quantity22 == 1) {
                    quantity22 = 0;
                    updateQuantityTextView4();
                showToast("Removed 1 Rose Custard");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order22:
                if (!mediaPlayer27.isPlaying()){
                    mediaPlayer27.start();
                }
                if (quantity22 > 0) {
                    addOrderedItem("Rose Custard", quantity22);

                    showToast("Successfully added " + quantity22 + " Rose Custard");
                }
                // Handle order logic
                quantity22 = 0; // Clear the quantity
                updateQuantityTextView4();
                break;

            case R.id.plus_button23:
                if (!mediaPlayer26.isPlaying()){
                    mediaPlayer26.start();
                }
                if (quantity23 < 10) {
                    quantity23++;
                    updateQuantityTextView5();
                showToast("Added 1 Baklava");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button23:
                if (!mediaPlayer26.isPlaying()){
                    mediaPlayer26.start();
                }
                if (quantity23 > 1) {
                    quantity23--;
                    updateQuantityTextView5();
                } else if (quantity23 == 1) {
                    quantity23 = 0;
                    updateQuantityTextView5();
                showToast("Removed 1 Baklava");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order23:
                if (!mediaPlayer27.isPlaying()){
                    mediaPlayer27.start();
                }
                if (quantity23 > 0) {
                    addOrderedItem("Baklava", quantity23);

                    showToast("Successfully added " + quantity23 + " Baklava");
                }
                // Handle order logic
                quantity23 = 0; // Clear the quantity
                updateQuantityTextView5();
                break;

            case R.id.plus_button24:
                if (!mediaPlayer26.isPlaying()){
                    mediaPlayer26.start();
                }
                if (quantity24 < 10) {
                    quantity24++;
                    updateQuantityTextView6();
                showToast("Added 1 Biryani");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button24:
                if (!mediaPlayer26.isPlaying()){
                    mediaPlayer26.start();
                }
                if (quantity24 > 1) {
                    quantity24--;
                    updateQuantityTextView6();
                } else if (quantity24 == 1) {
                    quantity24 = 0;
                    updateQuantityTextView6();
                showToast("Removed 1 Biryani");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order24:
                if (!mediaPlayer27.isPlaying()){
                    mediaPlayer27.start();
                }
                if (quantity24 > 0) {
                    addOrderedItem("Biryani", quantity24);

                    showToast("Successfully added " + quantity24 + " Biryani");
                }
                // Handle order logic
                quantity24 = 0; // Clear the quantity
                updateQuantityTextView6();
                break;

            case R.id.back_button4:
                if (!mediaPlayer23.isPlaying()){
                    mediaPlayer23.start();
                }
                showToast("Back to Tavern Menu Selection");

                backtavernmain();

                break;

            case R.id.proceed_order4:
                if (!mediaPlayer25.isPlaying()){
                    mediaPlayer25.start();
                }
                showToast("Thank you for Order! Please Proceed!");

                receiptavernproceed();

                break;

            case R.id.clear4:
                if (!mediaPlayer24.isPlaying()){
                    mediaPlayer24.start();
                }
                clearOrderedItems();

                quantity19 = 0; // Reset the quantity
                updateQuantityTextView();
                quantity20 = 0;
                updateQuantityTextView2();
                quantity21 = 0;
                updateQuantityTextView3();
                quantity22 = 0;
                updateQuantityTextView4();
                quantity23 = 0;
                updateQuantityTextView5();
                quantity24 = 0;
                updateQuantityTextView6();
                showToast("The List has been Cleared!");

                break;
        }
    }
    private void addOrderedItem(String itemName, int itemQuantity) {
        orderedItems.add(itemName);
        orderedQuantities.add(itemQuantity);
    }

    private void clearOrderedItems() {
        orderedItems.clear();
        orderedQuantities.clear();
    }
    private void receiptavernproceed() {
        Intent intent = new Intent(sumerumenu.this, tavernreceipt.class);
        intent.putStringArrayListExtra("orderedItems", new ArrayList<>(orderedItems));
        intent.putIntegerArrayListExtra("orderedQuantities", new ArrayList<>(orderedQuantities));
        startActivity(intent);
    }

    private void updateQuantityTextView() {
        if (quantity19 == 0) {
            quantityTextView19.setText("  Qnt  ");
        } else {
            quantityTextView19.setText(String.valueOf(quantity19));
        }
    }

    private void updateQuantityTextView2() {
        if (quantity20 == 0) {
            quantityTextView20.setText("  Qnt  ");
        } else {
            quantityTextView20.setText(String.valueOf(quantity20));
        }
    }

    private void updateQuantityTextView3() {
        if (quantity21 == 0) {
            quantityTextView21.setText("  Qnt  ");
        } else {
            quantityTextView21.setText(String.valueOf(quantity21));
        }
    }

    private void updateQuantityTextView4() {
        if (quantity22 == 0) {
            quantityTextView22.setText("  Qnt  ");
        } else {
            quantityTextView22.setText(String.valueOf(quantity22));
        }
    }

    private void updateQuantityTextView5() {
        if (quantity23 == 0) {
            quantityTextView23.setText("  Qnt  ");
        } else {
            quantityTextView23.setText(String.valueOf(quantity23));
        }
    }

    private void updateQuantityTextView6() {
        if (quantity24 == 0) {
            quantityTextView24.setText("  Qnt  ");
        } else {
            quantityTextView24.setText(String.valueOf(quantity24));
        }
    }

    private void backtavernmain() {

        // Create an intent to navigate back to tavernmain
        Intent intent = new Intent(sumerumenu.this, tavernmain.class);
        startActivity(intent);

    }
    @Override
    protected void onResume(){
        super.onResume();
        if (sumeru_ost.isChecked() && !mediaPlayer22.isPlaying()){
            mediaPlayer22.start();
        }
    }
    @Override
    protected void onPause(){
        super.onPause();
        if (mediaPlayer23.isPlaying()){
            mediaPlayer22.pause();
        }
        if (mediaPlayer24.isPlaying()){
            mediaPlayer22.pause();
        }
        if (mediaPlayer25.isPlaying()){
            mediaPlayer22.pause();
        }
        if (mediaPlayer26.isPlaying()){
            mediaPlayer22.pause();
        }
        if (mediaPlayer27.isPlaying()){
            mediaPlayer22.pause();
        }
        if (mediaPlayer22.isPlaying()){
            mediaPlayer22.pause();
        }

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mediaPlayer22.release();
        mediaPlayer23.release();
        mediaPlayer24.release();
        mediaPlayer25.release();
        mediaPlayer26.release();
        mediaPlayer27.release();
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
