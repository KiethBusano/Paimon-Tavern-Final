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

public class mondstadtmenu extends AppCompatActivity {

    private List<String> orderedItems = new ArrayList<>();
    private List<Integer> orderedQuantities = new ArrayList<>();

    private MediaPlayer mediaPlayer4;
    private MediaPlayer mediaPlayer5;
    private MediaPlayer mediaPlayer6;
    private MediaPlayer mediaPlayer7;
    private MediaPlayer mediaPlayer8;
    private MediaPlayer mediaPlayer9;
    private Switch mondstadt_ost;

    private TextView quantityTextView;
    private TextView quantityTextView2;
    private TextView quantityTextView3;
    private TextView quantityTextView4;
    private TextView quantityTextView5;
    private TextView quantityTextView6;
    private int quantity = 0;
    private int quantity2 = 0;
    private int quantity3 = 0;
    private int quantity4 = 0;
    private int quantity5 = 0;
    private int quantity6 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mondstadtmenu);

        // Initialize the quantity TextView
        quantityTextView = findViewById(R.id.quantity1);
        quantityTextView2 = findViewById(R.id.quantity2);
        quantityTextView3 = findViewById(R.id.quantity3);
        quantityTextView4 = findViewById(R.id.quantity4);
        quantityTextView5 = findViewById(R.id.quantity5);
        quantityTextView6 = findViewById(R.id.quantity6);

        // Set click listeners for Plus, Minus, Quantity, Order, Back, and Proceed TextViews
        setClickListeners(R.id.plus_button1);
        setClickListeners(R.id.minus_button1);
        setClickListeners(R.id.order1);
        setClickListeners(R.id.back_button1);
        setClickListeners(R.id.proceed_order1);
        setClickListeners(R.id.clear1);

        setClickListeners(R.id.plus_button2);
        setClickListeners(R.id.minus_button2);
        setClickListeners(R.id.order2);

        setClickListeners(R.id.plus_button3);
        setClickListeners(R.id.minus_button3);
        setClickListeners(R.id.order3);

        setClickListeners(R.id.plus_button4);
        setClickListeners(R.id.minus_button4);
        setClickListeners(R.id.order4);

        setClickListeners(R.id.plus_button5);
        setClickListeners(R.id.minus_button5);
        setClickListeners(R.id.order5);

        setClickListeners(R.id.plus_button6);
        setClickListeners(R.id.minus_button6);
        setClickListeners(R.id.order6);

        mediaPlayer4 = MediaPlayer.create(this, R.raw.mondstadt_ost);
        mediaPlayer5 = MediaPlayer.create(this, R.raw.back);
        mediaPlayer6 = MediaPlayer.create(this, R.raw.clear);
        mediaPlayer7 = MediaPlayer.create(this, R.raw.proceed);
        mediaPlayer8 = MediaPlayer.create(this, R.raw.plus_minus_button);
        mediaPlayer9 = MediaPlayer.create(this, R.raw.paimon_food_final);
        mondstadt_ost = findViewById(R.id.mondstadt_ost);

        mondstadt_ost.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    if(!mediaPlayer4.isPlaying()){
                        mediaPlayer4.start();
                    }
                }else{
                    if (mediaPlayer4.isPlaying()){
                        mediaPlayer4.pause();
                    }
                }
            }
        });
        mondstadt_ost.setChecked(true);

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
            case R.id.plus_button1:
                if (!mediaPlayer8.isPlaying()) {
                    mediaPlayer8.start();
                }

                if (quantity < 10) {
                    quantity++;
                    updateQuantityTextView();
                showToast("Added 1 Sticky Honey Roast");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }
                break;

            case R.id.minus_button1:
                if (!mediaPlayer8.isPlaying()) {
                    mediaPlayer8.start();
                }

                if (quantity > 1) {
                    quantity--;
                    updateQuantityTextView();
                } else if (quantity == 1) {
                    quantity = 0;
                    updateQuantityTextView();
                showToast("Removed 1 Sticky Honey Roast");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order1:
                if (!mediaPlayer9.isPlaying()){
                    mediaPlayer9.start();
                }
                if (quantity > 0) {
                    addOrderedItem("Sticky Honey Roast", quantity);
                    showToast("Successfully added " + quantity + "Sticky Honey Roast to the list");
                }

                // Handle order logic
                quantity = 0; // Clear the quantity
                updateQuantityTextView();
                break;

            case R.id.plus_button2:
                if (!mediaPlayer8.isPlaying()){
                    mediaPlayer8.start();
                }
                if (quantity2 < 10) {
                    quantity2++;
                    updateQuantityTextView2();
                showToast("Added 1 Mushroom Pizza");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button2:
                if (!mediaPlayer8.isPlaying()){
                    mediaPlayer8.start();
                }
                if (quantity2 > 1) {
                    quantity2--;
                    updateQuantityTextView2();
                } else if (quantity2 == 1) {
                    quantity2 = 0;
                    updateQuantityTextView2();
                showToast("Removed 1 Mushroom Pizza");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order2:
                if (!mediaPlayer9.isPlaying()){
                    mediaPlayer9.start();
                }
                if (quantity2 > 0) {
                    addOrderedItem("Mushroom Pizza", quantity2);
                    showToast("Successfully added " + quantity2 + "Mushroom Pizza to the list");
                }
                // Handle order logic
                quantity2 = 0; // Clear the quantity
                updateQuantityTextView2();

                break;

            case R.id.plus_button3:
                if (!mediaPlayer8.isPlaying()){
                    mediaPlayer8.start();
                }
                if (quantity3 < 10) {
                    quantity3++;
                    updateQuantityTextView3();
                showToast("Added 1 Flaming Red Bolognese");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button3:
                if (!mediaPlayer8.isPlaying()){
                    mediaPlayer8.start();
                }
                if (quantity3 > 1) {
                    quantity3--;
                    updateQuantityTextView3();
                } else if (quantity3 == 1) {
                    quantity3 = 0;
                    updateQuantityTextView3();
                showToast("Removed 1 Flaming Red Bolognese");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order3:
                if (!mediaPlayer9.isPlaying()){
                    mediaPlayer9.start();
                }
                if (quantity3 > 0) {
                    addOrderedItem("Flaming Red Bolognese", quantity3);
                    showToast("Successfully added " + quantity3 + "Flaming Red Bolognese to the list");

                }
                // Handle order logic
                quantity3 = 0; // Clear the quantity
                updateQuantityTextView3();
                break;

            case R.id.plus_button4:
                if (!mediaPlayer8.isPlaying()){
                    mediaPlayer8.start();
                }
                if (quantity4 < 10) {
                    quantity4++;
                    updateQuantityTextView4();
                showToast("Added 1 Venti\'s Bouyant Breeze");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button4:
                if (!mediaPlayer8.isPlaying()){
                    mediaPlayer8.start();
                }
                if (quantity4 > 1) {
                    quantity4--;
                    updateQuantityTextView4();
                } else if (quantity4 == 1) {
                    quantity4 = 0;
                    updateQuantityTextView4();
                showToast("Removed 1 Venti\'s Bouyant Breeze");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order4:
                if (!mediaPlayer9.isPlaying()){
                    mediaPlayer9.start();
                }
                if (quantity4 > 0) {
                    addOrderedItem("Venti\'s Bouyant Breeze", quantity4);
                    showToast("Successfully added " + quantity4 + "Venti\'s Bouyant Breeze to the list");
                }
                // Handle order logic
                quantity4 = 0; // Clear the quantity
                updateQuantityTextView4();
                break;

            case R.id.plus_button5:
                if (!mediaPlayer8.isPlaying()){
                    mediaPlayer8.start();
                }
                if (quantity5 < 10) {
                    quantity5++;
                    updateQuantityTextView5();
                showToast("Added 1 Apple Cider");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button5:
                if (!mediaPlayer8.isPlaying()){
                    mediaPlayer8.start();
                }
                if (quantity5 > 1) {
                    quantity5--;
                    updateQuantityTextView5();
                } else if (quantity5 == 1) {
                    quantity5 = 0;
                    updateQuantityTextView5();
                showToast("Removed 1 Apple Cider");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order5:
                if (!mediaPlayer9.isPlaying()){
                    mediaPlayer9.start();
                }
                if (quantity5 > 0) {
                    addOrderedItem("Apple Cider", quantity5);
                    showToast("Successfully added " + quantity5 + "Apple Cider to the list");
                }
                // Handle order logic
                quantity5 = 0; // Clear the quantity
                updateQuantityTextView5();
                break;

            case R.id.plus_button6:
                if (!mediaPlayer8.isPlaying()){
                    mediaPlayer8.start();
                }
                if (quantity6 < 10) {
                    quantity6++;
                    updateQuantityTextView6();
                showToast("Added 1 Fruits of the Festival");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button6:
                if (!mediaPlayer8.isPlaying()){
                    mediaPlayer8.start();
                }
                if (quantity6 > 1) {
                    quantity6--;
                    updateQuantityTextView6();
                } else if (quantity6 == 1) {
                    quantity6 = 0;
                    updateQuantityTextView6();
                showToast("Removed 1 Fruits of the Festival");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order6:
                if (!mediaPlayer9.isPlaying()){
                    mediaPlayer9.start();
                }
                if (quantity6 > 0) {
                    addOrderedItem("Fruits of the Festival", quantity6);
                    showToast("Successfully added " + quantity6 + "Fruits of the Festival to the list");
                }
                // Handle order logic
                quantity6 = 0; // Clear the quantity
                updateQuantityTextView6();
                break;

            case R.id.back_button1:

                if (!mediaPlayer5.isPlaying()){
                    mediaPlayer5.start();
                }
                showToast("Back to Tavern Menu Selection");

                backtavernmain();

                break;

            case R.id.proceed_order1:

                if (!mediaPlayer7.isPlaying()){
                    mediaPlayer7.start();
                }
                showToast("Thank you for Order! Please Proceed!");

                receiptavernproceed();

                break;

            case R.id.clear1:

                if (!mediaPlayer6.isPlaying()){
                    mediaPlayer6.start();
                }

                quantity = 0; // Reset the quantity
                updateQuantityTextView();
                quantity2 = 0;
                updateQuantityTextView2();
                quantity3 = 0;
                updateQuantityTextView3();
                quantity4 = 0;
                updateQuantityTextView4();
                quantity5 = 0;
                updateQuantityTextView5();
                quantity6 = 0;
                updateQuantityTextView6();

                clearOrderedItems();
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
        Intent intent = new Intent(mondstadtmenu.this, tavernreceipt.class);
        intent.putStringArrayListExtra("orderedItems", new ArrayList<>(orderedItems));
        intent.putIntegerArrayListExtra("orderedQuantities", new ArrayList<>(orderedQuantities));
        startActivity(intent);
    }

    private void backtavernmain() {

        // Create an intent to navigate back to tavernmain
        Intent intent = new Intent(mondstadtmenu.this, tavernmain.class);
        startActivity(intent);
    }

    public void backtavern(View view) {

        // Create an intent to navigate back to tavernmain
        Intent intent = new Intent(mondstadtmenu.this, tavernmain.class);
        startActivity(intent);
    }

    private void updateQuantityTextView() {
        if (quantity == 0) {
            quantityTextView.setText("  Qnt  ");
        } else {
            quantityTextView.setText(String.valueOf(quantity));
        }
    }

    private void updateQuantityTextView2() {
        if (quantity2 == 0) {
            quantityTextView2.setText("  Qnt  ");
        } else {
            quantityTextView2.setText(String.valueOf(quantity2));
        }
    }

    private void updateQuantityTextView3() {
        if (quantity3 == 0) {
            quantityTextView3.setText("  Qnt  ");
        } else {
            quantityTextView3.setText(String.valueOf(quantity3));
        }
    }

    private void updateQuantityTextView4() {
        if (quantity4 == 0) {
            quantityTextView4.setText("  Qnt  ");
        } else {
            quantityTextView4.setText(String.valueOf(quantity4));
        }
    }

    private void updateQuantityTextView5() {
        if (quantity5 == 0) {
            quantityTextView5.setText("  Qnt  ");
        } else {
            quantityTextView5.setText(String.valueOf(quantity5));
        }
    }

    private void updateQuantityTextView6() {
        if (quantity6 == 0) {
        quantityTextView6.setText("  Qnt  ");
        } else {
        quantityTextView6.setText(String.valueOf(quantity6));
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        if (mondstadt_ost.isChecked() && !mediaPlayer4.isPlaying()){
            mediaPlayer4.start();
        }
    }
    @Override
    protected void onPause(){
        super.onPause();
        if (mediaPlayer4.isPlaying()){
            mediaPlayer4.pause();
        }
        if (mediaPlayer5.isPlaying()){
            mediaPlayer4.pause();
        }
        if (mediaPlayer6.isPlaying()){
            mediaPlayer4.pause();
        }
        if (mediaPlayer7.isPlaying()){
            mediaPlayer4.pause();
        }
        if (mediaPlayer8.isPlaying()){
            mediaPlayer4.pause();
        }
        if (mediaPlayer9.isPlaying()){
            mediaPlayer4.pause();
        }

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mediaPlayer4.release();
        mediaPlayer5.release();
        mediaPlayer6.release();
        mediaPlayer7.release();
        mediaPlayer8.release();
        mediaPlayer9.release();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}



