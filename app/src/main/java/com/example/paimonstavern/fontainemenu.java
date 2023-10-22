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

public class fontainemenu extends AppCompatActivity {

    private List<String> orderedItems = new ArrayList<>();
    private List<Integer> orderedQuantities = new ArrayList<>();

    private MediaPlayer mediaPlayer28;
    private MediaPlayer mediaPlayer29;
    private MediaPlayer mediaPlayer30;
    private MediaPlayer mediaPlayer31;
    private MediaPlayer mediaPlayer32;
    private MediaPlayer mediaPlayer33;

    private Switch fontaine_ost;
    private TextView quantityTextView25;
    private TextView quantityTextView26;
    private TextView quantityTextView27;
    private TextView quantityTextView28;
    private TextView quantityTextView29;
    private TextView quantityTextView30;
    private int quantity25 = 0;
    private int quantity26 = 0;
    private int quantity27 = 0;
    private int quantity28 = 0;
    private int quantity29 = 0;
    private int quantity30 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fontainemenu);

        // Initialize the quantity TextView
        quantityTextView25 = findViewById(R.id.quantity25);
        quantityTextView26 = findViewById(R.id.quantity26);
        quantityTextView27 = findViewById(R.id.quantity27);
        quantityTextView28 = findViewById(R.id.quantity28);
        quantityTextView29 = findViewById(R.id.quantity29);
        quantityTextView30 = findViewById(R.id.quantity30);

        // Set click listeners for Plus, Minus, Quantity, Order, Back, and Proceed TextViews
        setClickListeners(R.id.plus_button25);
        setClickListeners(R.id.minus_button25);
        setClickListeners(R.id.order25);
        setClickListeners(R.id.back_button5);
        setClickListeners(R.id.proceed_order5);
        setClickListeners(R.id.clear5);

        setClickListeners(R.id.plus_button26);
        setClickListeners(R.id.minus_button26);
        setClickListeners(R.id.order26);

        setClickListeners(R.id.plus_button27);
        setClickListeners(R.id.minus_button27);
        setClickListeners(R.id.order27);

        setClickListeners(R.id.plus_button28);
        setClickListeners(R.id.minus_button28);
        setClickListeners(R.id.order28);

        setClickListeners(R.id.plus_button29);
        setClickListeners(R.id.minus_button29);
        setClickListeners(R.id.order29);

        setClickListeners(R.id.plus_button30);
        setClickListeners(R.id.minus_button30);
        setClickListeners(R.id.order30);

        mediaPlayer28 = MediaPlayer.create(this, R.raw.fontaine_ost);
        mediaPlayer29 = MediaPlayer.create(this, R.raw.back);
        mediaPlayer30 = MediaPlayer.create(this, R.raw.clear);
        mediaPlayer31 = MediaPlayer.create(this, R.raw.proceed);
        mediaPlayer32 = MediaPlayer.create(this, R.raw.plus_minus_button);
        mediaPlayer33 = MediaPlayer.create(this, R.raw.paimon_food_final);
        fontaine_ost = findViewById(R.id.fontaine_ost);

        fontaine_ost.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    if(!mediaPlayer28.isPlaying()){
                        mediaPlayer28.start();
                    }
                }else{
                    if (mediaPlayer28.isPlaying()){
                        mediaPlayer28.pause();
                    }
                }
            }
        });
        fontaine_ost.setChecked(true);
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
            case R.id.plus_button25:
                if (!mediaPlayer32.isPlaying()){
                    mediaPlayer32.start();
                }
                if (quantity25 < 10) {
                    quantity25++;
                    updateQuantityTextView();
                showToast("Added 1 Neuvillete\'s Consomme Purete");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }
                break;

            case R.id.minus_button25:
                if (!mediaPlayer32.isPlaying()){
                    mediaPlayer32.start();
                }
                if (quantity25 > 1) {
                    quantity25--;
                    updateQuantityTextView();
                } else if (quantity25 == 1) {
                    quantity25 = 0;
                    updateQuantityTextView();
                showToast("Removed 1 Neuvillete\'s Consomme Purete");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order25:
                if (!mediaPlayer33.isPlaying()){
                    mediaPlayer33.start();
                }
                if (quantity25 > 0) {
                    addOrderedItem("Neuvillete\'s Consomme Purete", quantity25);

                    showToast("Successfully added " + quantity25 + " Neuvillete\'s Consomme Purete");
                }
                // Handle order logic
                quantity25 = 0; // Clear the quantity
                updateQuantityTextView();
                break;

            case R.id.plus_button26:
                if (!mediaPlayer32.isPlaying()){
                    mediaPlayer32.start();
                }
                if (quantity26 < 10) {
                    quantity26++;
                    updateQuantityTextView2();
                showToast("Added 1 Poissonchant Pie");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button26:
                if (!mediaPlayer32.isPlaying()){
                    mediaPlayer32.start();
                }
                if (quantity26 > 1) {
                    quantity26--;
                    updateQuantityTextView2();
                } else if (quantity26 == 1) {
                    quantity26 = 0;
                    updateQuantityTextView2();
                showToast("Removed 1 Poissonchant Pie");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order26:
                if (!mediaPlayer33.isPlaying()){
                    mediaPlayer33.start();
                }
                if (quantity26 > 0) {
                    addOrderedItem("Poissonchant Pie", quantity26);

                    showToast("Successfully added " + quantity26 + " Poissonchant Pie");
                }
                // Handle order logic
                quantity26 = 0; // Clear the quantity
                updateQuantityTextView2();

                break;

            case R.id.plus_button27:
                if (!mediaPlayer32.isPlaying()){
                    mediaPlayer32.start();
                }
                if (quantity27 < 10) {
                    quantity27++;
                    updateQuantityTextView3();
                showToast("Added 1 Lasagna");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button27:
                if (!mediaPlayer32.isPlaying()){
                    mediaPlayer32.start();
                }
                if (quantity27 > 1) {
                    quantity27--;
                    updateQuantityTextView3();
                } else if (quantity27 == 1) {
                    quantity27 = 0;
                    updateQuantityTextView3();
                showToast("Removed 1 Lasagna");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order27:
                if (!mediaPlayer33.isPlaying()){
                    mediaPlayer33.start();
                }
                if (quantity27 > 0) {
                    addOrderedItem("Lasagna", quantity27);

                    showToast("Successfully added " + quantity27 + " Lasagna");
                }
                // Handle order logic
                quantity27 = 0; // Clear the quantity
                updateQuantityTextView3();
                break;

            case R.id.plus_button28:
                if (!mediaPlayer32.isPlaying()){
                    mediaPlayer32.start();
                }
                if (quantity28 < 10) {
                    quantity28++;
                    updateQuantityTextView4();
                showToast("Added 1 Vessie Chicken");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }
                break;

            case R.id.minus_button28:
                if (!mediaPlayer32.isPlaying()){
                    mediaPlayer32.start();
                }
                if (quantity28 > 1) {
                    quantity28--;
                    updateQuantityTextView4();
                } else if (quantity28 == 1) {
                    quantity28 = 0;
                    updateQuantityTextView4();
                showToast("Removed 1 Vessie Chicken");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order28:
                if (!mediaPlayer33.isPlaying()){
                    mediaPlayer33.start();
                }
                if (quantity28 > 0) {
                    addOrderedItem("Vessie Chicken", quantity28);

                    showToast("Successfully added " + quantity28 + " Vessie Chicken");
                }
                // Handle order logic
                quantity28 = 0; // Clear the quantity
                updateQuantityTextView4();
                break;

            case R.id.plus_button29:
                if (!mediaPlayer32.isPlaying()){
                    mediaPlayer32.start();
                }
                if (quantity29 < 10) {
                    quantity29++;
                    updateQuantityTextView5();
                showToast("Added 1 Coffee Bavarois");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button29:
                if (!mediaPlayer32.isPlaying()){
                    mediaPlayer32.start();
                }
                if (quantity29 > 1) {
                    quantity29--;
                    updateQuantityTextView5();
                } else if (quantity29 == 1) {
                    quantity29 = 0;
                    updateQuantityTextView5();
                showToast("Removed 1 Coffee Bavarois");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order29:
                if (!mediaPlayer33.isPlaying()){
                    mediaPlayer33.start();
                }
                if (quantity29 > 0) {
                    addOrderedItem("Tricolor Dango", quantity29);

                    showToast("Successfully added " + quantity29 + " Coffee Bavarois");
                }
                // Handle order logic
                quantity29 = 0; // Clear the quantity
                updateQuantityTextView5();
                break;

            case R.id.plus_button30:
                if (!mediaPlayer32.isPlaying()){
                    mediaPlayer32.start();
                }
                if (quantity30 < 10) {
                    quantity30++;
                    updateQuantityTextView6();
                showToast("Added 1 Fruity Trio");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button30:
                if (!mediaPlayer32.isPlaying()){
                    mediaPlayer32.start();
                }
                if (quantity30 > 1) {
                    quantity30--;
                    updateQuantityTextView6();
                } else if (quantity30 == 1) {
                    quantity30 = 0;
                    updateQuantityTextView6();
                showToast("Removed 1 Fruity Trio");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order30:
                if (!mediaPlayer33.isPlaying()){
                    mediaPlayer33.start();
                }
                if (quantity30 > 0) {
                    addOrderedItem("Fruity Trio", quantity30);

                    showToast("Successfully added " + quantity30 + " Fruity Trio");
                }
                // Handle order logic
                quantity30 = 0; // Clear the quantity
                updateQuantityTextView6();
                break;

            case R.id.back_button5:
                if (!mediaPlayer29.isPlaying()){
                    mediaPlayer29.start();
                }
                showToast("Back to Tavern Menu Selection");

                backtavernmain();

                break;

            case R.id.proceed_order5:
                if (!mediaPlayer31.isPlaying()){
                    mediaPlayer31.start();
                }
                showToast("Thank you for Order! Please Proceed!");

                receiptavernproceed();

                break;

            case R.id.clear5:
                if (!mediaPlayer30.isPlaying()){
                    mediaPlayer30.start();
                }

                clearOrderedItems();
                // Handle the "Back" logic to reset changes
                quantity25 = 0; // Reset the quantity
                updateQuantityTextView();
                quantity26 = 0;
                updateQuantityTextView2();
                quantity27 = 0;
                updateQuantityTextView3();
                quantity28 = 0;
                updateQuantityTextView4();
                quantity29 = 0;
                updateQuantityTextView5();
                quantity30 = 0;
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
        Intent intent = new Intent(fontainemenu.this, tavernreceipt.class);
        intent.putStringArrayListExtra("orderedItems", new ArrayList<>(orderedItems));
        intent.putIntegerArrayListExtra("orderedQuantities", new ArrayList<>(orderedQuantities));
        startActivity(intent);
    }

    private void updateQuantityTextView() {
        if (quantity25 == 0) {
            quantityTextView25.setText("  Qnt  ");
        } else {
            quantityTextView25.setText(String.valueOf(quantity25));
        }
    }

    private void updateQuantityTextView2() {
        if (quantity26 == 0) {
            quantityTextView26.setText("  Qnt  ");
        } else {
            quantityTextView26.setText(String.valueOf(quantity26));
        }
    }

    private void updateQuantityTextView3() {
        if (quantity27 == 0) {
            quantityTextView27.setText("  Qnt  ");
        } else {
            quantityTextView27.setText(String.valueOf(quantity27));
        }
    }

    private void updateQuantityTextView4() {
        if (quantity28 == 0) {
            quantityTextView28.setText("  Qnt  ");
        } else {
            quantityTextView28.setText(String.valueOf(quantity28));
        }
    }

    private void updateQuantityTextView5() {
        if (quantity29 == 0) {
            quantityTextView29.setText("  Qnt  ");
        } else {
            quantityTextView29.setText(String.valueOf(quantity29));
        }
    }

    private void updateQuantityTextView6() {
        if (quantity30 == 0) {
            quantityTextView30.setText("  Qnt  ");
        } else {
            quantityTextView30.setText(String.valueOf(quantity30));
        }
    }

    private void backtavernmain() {

        // Create an intent to navigate back to tavernmain
        Intent intent = new Intent(fontainemenu.this, tavernmain.class);
        startActivity(intent);

    }
    @Override
    protected void onResume(){
        super.onResume();
        if (fontaine_ost.isChecked() && !mediaPlayer28.isPlaying()){
            mediaPlayer28.start();
        }
    }
    @Override
    protected void onPause(){
        super.onPause();
        if (mediaPlayer28.isPlaying()){
            mediaPlayer28.pause();
        }
        if (mediaPlayer29.isPlaying()){
            mediaPlayer28.pause();
        }
        if (mediaPlayer30.isPlaying()){
            mediaPlayer28.pause();
        }
        if (mediaPlayer31.isPlaying()){
            mediaPlayer28.pause();
        }
        if (mediaPlayer32.isPlaying()){
            mediaPlayer28.pause();
        }
        if (mediaPlayer33.isPlaying()){
            mediaPlayer28.pause();
        }

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mediaPlayer28.release();
        mediaPlayer29.release();
        mediaPlayer30.release();
        mediaPlayer31.release();
        mediaPlayer32.release();
        mediaPlayer33.release();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}