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

public class inazumamenu extends AppCompatActivity {

    private List<String> orderedItems = new ArrayList<>();
    private List<Integer> orderedQuantities = new ArrayList<>();

    private MediaPlayer mediaPlayer16;
    private MediaPlayer mediaPlayer17;
    private MediaPlayer mediaPlayer18;
    private MediaPlayer mediaPlayer19;
    private MediaPlayer mediaPlayer20;
    private MediaPlayer mediaPlayer21;
    private Switch inazuma_ost;

    private TextView quantityTextView13;
    private TextView quantityTextView14;
    private TextView quantityTextView15;
    private TextView quantityTextView16;
    private TextView quantityTextView17;
    private TextView quantityTextView18;
    private int quantity13 = 0;
    private int quantity14 = 0;
    private int quantity15 = 0;
    private int quantity16 = 0;
    private int quantity17 = 0;
    private int quantity18 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inazumamenu);

        // Initialize the quantity TextView
        quantityTextView13 = findViewById(R.id.quantity13);
        quantityTextView14 = findViewById(R.id.quantity14);
        quantityTextView15 = findViewById(R.id.quantity15);
        quantityTextView16 = findViewById(R.id.quantity16);
        quantityTextView17 = findViewById(R.id.quantity17);
        quantityTextView18 = findViewById(R.id.quantity18);

        // Set click listeners for Plus, Minus, Quantity, Order, Back, and Proceed TextViews
        setClickListeners(R.id.plus_button13);
        setClickListeners(R.id.minus_button13);
        setClickListeners(R.id.order13);
        setClickListeners(R.id.back_button3);
        setClickListeners(R.id.proceed_order3);
        setClickListeners(R.id.clear3);

        setClickListeners(R.id.plus_button14);
        setClickListeners(R.id.minus_button14);
        setClickListeners(R.id.order14);

        setClickListeners(R.id.plus_button15);
        setClickListeners(R.id.minus_button15);
        setClickListeners(R.id.order15);

        setClickListeners(R.id.plus_button16);
        setClickListeners(R.id.minus_button16);
        setClickListeners(R.id.order16);

        setClickListeners(R.id.plus_button17);
        setClickListeners(R.id.minus_button17);
        setClickListeners(R.id.order17);

        setClickListeners(R.id.plus_button18);
        setClickListeners(R.id.minus_button18);
        setClickListeners(R.id.order18);

        mediaPlayer16 = MediaPlayer.create(this, R.raw.inazuma_ost);
        mediaPlayer17 = MediaPlayer.create(this, R.raw.back);
        mediaPlayer18 = MediaPlayer.create(this, R.raw.clear);
        mediaPlayer19 = MediaPlayer.create(this, R.raw.proceed);
        mediaPlayer20 = MediaPlayer.create(this, R.raw.plus_minus_button);
        mediaPlayer21 = MediaPlayer.create(this, R.raw.paimon_food_final);
        inazuma_ost = findViewById(R.id.inazuma_ost);

        inazuma_ost.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    if(!mediaPlayer16.isPlaying()){
                        mediaPlayer16.start();
                    }
                }else{
                    if (mediaPlayer16.isPlaying()){
                        mediaPlayer16.pause();
                    }
                }
            }
        });
        inazuma_ost.setChecked(true);
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
            case R.id.plus_button13:
                if (!mediaPlayer20.isPlaying()){
                    mediaPlayer20.start();
                }
                if (quantity13 < 10) {
                    quantity13++;
                    updateQuantityTextView();
                showToast("Added 1 Tricolor Dango");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }
                break;

            case R.id.minus_button13:
                if (!mediaPlayer20.isPlaying()){
                    mediaPlayer20.start();
                }
                if (quantity13 > 1) {
                    quantity13--;
                    updateQuantityTextView();
                } else if (quantity13 == 1) {
                    quantity13 = 0;
                    updateQuantityTextView();
                showToast("Removed 1 Tricolor Dango");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order13:
                if (!mediaPlayer21.isPlaying()){
                    mediaPlayer21.start();
                }
                if (quantity13 > 0) {
                    addOrderedItem("Tricolor Dango", quantity13);
                    showToast("Successfully added " + quantity13 + " Tricolor Dango");
                }
                // Handle order logic
                quantity13 = 0; // Clear the quantity
                updateQuantityTextView();
                break;

            case R.id.plus_button14:
                if (!mediaPlayer20.isPlaying()){
                    mediaPlayer20.start();
                }
                if (quantity14 < 10) {
                    quantity14++;
                    updateQuantityTextView2();
                showToast("Added 1 Raiden\'s Boiled Fatui Ashes");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button14:
                if (!mediaPlayer20.isPlaying()){
                    mediaPlayer20.start();
                }
                if (quantity14 > 1) {
                    quantity14--;
                    updateQuantityTextView2();
                } else if (quantity14 == 1) {
                    quantity14 = 0;
                    updateQuantityTextView2();
                showToast("Removed 1 Raiden\'s Boiled Fatui Ashes");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order14:
                if (!mediaPlayer21.isPlaying()){
                    mediaPlayer21.start();
                }
                if (quantity14 > 0) {
                    addOrderedItem("Raiden\'s Boiled Fatui Ashes", quantity14);

                    showToast("Successfully added " + quantity14 + " Raiden\'s Boiled Fatui Ashes");
                }
                // Handle order logic
                quantity14 = 0; // Clear the quantity
                updateQuantityTextView2();

                break;

            case R.id.plus_button15:
                if (!mediaPlayer20.isPlaying()){
                    mediaPlayer20.start();
                }
                if (quantity15 < 10) {
                    quantity15++;
                    updateQuantityTextView3();
                showToast("Added 1 Omellete Rice");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }
                break;

            case R.id.minus_button15:
                if (!mediaPlayer20.isPlaying()){
                    mediaPlayer20.start();
                }
                if (quantity15 > 1) {
                    quantity15--;
                    updateQuantityTextView3();
                } else if (quantity15 == 1) {
                    quantity15 = 0;
                    updateQuantityTextView3();
                showToast("Removed 1 Omellete Rice");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order15:
                if (!mediaPlayer21.isPlaying()){
                    mediaPlayer21.start();
                }
                if (quantity15 > 0) {
                    addOrderedItem("Omellete Rice", quantity15);

                    showToast("Successfully added " + quantity15 + " Omellete Rice");
                }
                // Handle order logic
                quantity15 = 0; // Clear the quantity
                updateQuantityTextView3();
                break;

            case R.id.plus_button16:
                if (!mediaPlayer20.isPlaying()){
                    mediaPlayer20.start();
                }
                if (quantity16 < 10) {
                    quantity16++;
                    updateQuantityTextView4();
                showToast("Added 1 Udon Noodles");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button16:
                if (!mediaPlayer20.isPlaying()){
                    mediaPlayer20.start();
                }
                if (quantity16 > 1) {
                    quantity16--;
                    updateQuantityTextView4();
                } else if (quantity16 == 1) {
                    quantity16 = 0;
                    updateQuantityTextView4();
                showToast("Removed 1 Udon Noodles");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order16:
                if (!mediaPlayer21.isPlaying()){
                    mediaPlayer21.start();
                }
                if (quantity16 > 0) {
                    addOrderedItem("Udon Noodles", quantity16);

                    showToast("Successfully added " + quantity16 + "  Udon Noodles");
                }
                // Handle order logic
                quantity16 = 0; // Clear the quantity
                updateQuantityTextView4();
                break;

            case R.id.plus_button17:
                if (!mediaPlayer20.isPlaying()){
                    mediaPlayer20.start();
                }
                if (quantity17 < 10) {
                    quantity17++;
                    updateQuantityTextView5();
                showToast("Added 1 Rainbow Aster");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button17:
                if (!mediaPlayer20.isPlaying()){
                    mediaPlayer20.start();
                }
                if (quantity17 > 1) {
                    quantity17--;
                    updateQuantityTextView5();
                } else if (quantity17 == 1) {
                    quantity17 = 0;
                    updateQuantityTextView5();
                showToast("Removed 1 Rainbow Aster");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order17:
                if (!mediaPlayer21.isPlaying()){
                    mediaPlayer21.start();
                }
                if (quantity17 > 0) {
                    addOrderedItem("Rainbow Aster", quantity17);

                    showToast("Successfully added " + quantity17 + " Rainbow Aster");
                }
                // Handle order logic
                quantity17 = 0; // Clear the quantity
                updateQuantityTextView5();
                break;

            case R.id.plus_button18:
                if (!mediaPlayer20.isPlaying()){
                    mediaPlayer20.start();
                }
                if (quantity18 < 10) {
                    quantity18++;
                    updateQuantityTextView6();
                showToast("Added 1 Dango Milk");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button18:
                if (!mediaPlayer20.isPlaying()){
                    mediaPlayer20.start();
                }
                if (quantity18 > 1) {
                    quantity18--;
                    updateQuantityTextView6();
                } else if (quantity18 == 1) {
                    quantity18 = 0;
                    updateQuantityTextView6();
                showToast("Removed 1 Dango Milk");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order18:
                if (!mediaPlayer21.isPlaying()){
                    mediaPlayer21.start();
                }
                if (quantity18 > 0) {
                    addOrderedItem("Dango Milk", quantity18);

                    showToast("Successfully added " + quantity18 + " Dango Milk");
                }
                // Handle order logic
                quantity18 = 0; // Clear the quantity
                updateQuantityTextView6();
                break;

            case R.id.back_button3:
                if (!mediaPlayer17.isPlaying()){
                    mediaPlayer17.start();
                }
                // Handle the "Back" logic to reset changes
                quantity13 = 0; // Reset the quantity
                updateQuantityTextView();
                quantity14 = 0;
                updateQuantityTextView2();
                quantity15 = 0;
                updateQuantityTextView3();
                quantity16 = 0;
                updateQuantityTextView4();
                quantity17 = 0;
                updateQuantityTextView5();
                quantity18 = 0;
                updateQuantityTextView6();

                backtavernmain();
                showToast("Back to Tavern Menu Selection");

                break;

            case R.id.proceed_order3:
                if (!mediaPlayer19.isPlaying()){
                    mediaPlayer19.start();
                }
                showToast("Thank you for Order! Please Proceed!");

                receiptavernproceed();

                break;

            case R.id.clear3:
                if (!mediaPlayer18.isPlaying()){
                    mediaPlayer18.start();
                }
                clearOrderedItems();

                // Handle the "Back" logic to reset changes
                quantity13 = 0; // Reset the quantity
                updateQuantityTextView();
                quantity14 = 0;
                updateQuantityTextView2();
                quantity15 = 0;
                updateQuantityTextView3();
                quantity16 = 0;
                updateQuantityTextView4();
                quantity17 = 0;
                updateQuantityTextView5();
                quantity18 = 0;
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

    private void updateQuantityTextView() {
        if (quantity13 == 0) {
            quantityTextView13.setText("  Qnt  ");
        } else {
            quantityTextView13.setText(String.valueOf(quantity13));
        }
    }

    private void updateQuantityTextView2() {
        if (quantity14 == 0) {
            quantityTextView14.setText("  Qnt  ");
        } else {
            quantityTextView14.setText(String.valueOf(quantity14));
        }
    }

    private void updateQuantityTextView3() {
        if (quantity15 == 0) {
            quantityTextView15.setText("  Qnt  ");
        } else {
            quantityTextView15.setText(String.valueOf(quantity15));
        }
    }

    private void updateQuantityTextView4() {
        if (quantity16 == 0) {
            quantityTextView16.setText("  Qnt  ");
        } else {
            quantityTextView16.setText(String.valueOf(quantity16));
        }
    }

    private void updateQuantityTextView5() {
        if (quantity17 == 0) {
            quantityTextView17.setText("  Qnt  ");
        } else {
            quantityTextView17.setText(String.valueOf(quantity17));
        }
    }

    private void updateQuantityTextView6() {
        if (quantity18 == 0) {
            quantityTextView18.setText("  Qnt  ");
        } else {
            quantityTextView18.setText(String.valueOf(quantity18));
        }
    }

    private void backtavernmain() {

        Intent intent = new Intent(inazumamenu.this, tavernmain.class);
        startActivity(intent);
    }

    private void receiptavernproceed() {
        Intent intent = new Intent(inazumamenu.this, tavernreceipt.class);
        intent.putStringArrayListExtra("orderedItems", new ArrayList<>(orderedItems));
        intent.putIntegerArrayListExtra("orderedQuantities", new ArrayList<>(orderedQuantities));
        startActivity(intent);
    }
    @Override
    protected void onResume(){
        super.onResume();
        if (inazuma_ost.isChecked() && !mediaPlayer16.isPlaying()){
            mediaPlayer16.start();
        }
    }
    @Override
    protected void onPause(){
        super.onPause();

        if (mediaPlayer16.isPlaying()){
            mediaPlayer16.pause();
        }
        if (mediaPlayer17.isPlaying()){
            mediaPlayer16.pause();
        }
        if (mediaPlayer18.isPlaying()){
            mediaPlayer16.pause();
        }
        if (mediaPlayer19.isPlaying()){
            mediaPlayer16.pause();
        }
        if (mediaPlayer20.isPlaying()){
            mediaPlayer16.pause();
        }
        if (mediaPlayer21.isPlaying()){
            mediaPlayer16.pause();
        }

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mediaPlayer16.release();
        mediaPlayer17.release();
        mediaPlayer18.release();
        mediaPlayer19.release();
        mediaPlayer20.release();
        mediaPlayer21.release();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

