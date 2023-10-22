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

public class liyuemenu extends AppCompatActivity {
    private List<String> orderedItems = new ArrayList<>();
    private List<Integer> orderedQuantities = new ArrayList<>();
    private MediaPlayer mediaPlayer10;
    private MediaPlayer mediaPlayer11;
    private MediaPlayer mediaPlayer12;
    private MediaPlayer mediaPlayer13;
    private MediaPlayer mediaPlayer14;
    private MediaPlayer mediaPlayer15;
    private Switch liyue_ost;

    private TextView quantityTextView7;
    private TextView quantityTextView8;
    private TextView quantityTextView9;
    private TextView quantityTextView10;
    private TextView quantityTextView11;
    private TextView quantityTextView12;
    private int quantity7 = 0;
    private int quantity8 = 0;
    private int quantity9 = 0;
    private int quantity10 = 0;
    private int quantity11 = 0;
    private int quantity12 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liyuemenu);

        // Initialize the quantity TextView
        quantityTextView7 = findViewById(R.id.quantity7);
        quantityTextView8 = findViewById(R.id.quantity8);
        quantityTextView9 = findViewById(R.id.quantity9);
        quantityTextView10 = findViewById(R.id.quantity10);
        quantityTextView11 = findViewById(R.id.quantity11);
        quantityTextView12 = findViewById(R.id.quantity12);

        // Set click listeners for Plus, Minus, Quantity, Order, Back, and Proceed TextViews
        setClickListeners(R.id.plus_button7);
        setClickListeners(R.id.minus_button7);
        setClickListeners(R.id.order7);
        setClickListeners(R.id.back_button2);
        setClickListeners(R.id.proceed_order2);
        setClickListeners(R.id.clear2);

        setClickListeners(R.id.plus_button8);
        setClickListeners(R.id.minus_button8);
        setClickListeners(R.id.order8);

        setClickListeners(R.id.plus_button9);
        setClickListeners(R.id.minus_button9);
        setClickListeners(R.id.order9);

        setClickListeners(R.id.plus_button10);
        setClickListeners(R.id.minus_button10);
        setClickListeners(R.id.order10);

        setClickListeners(R.id.plus_button11);
        setClickListeners(R.id.minus_button11);
        setClickListeners(R.id.order11);

        setClickListeners(R.id.plus_button12);
        setClickListeners(R.id.minus_button12);
        setClickListeners(R.id.order12);

        mediaPlayer10 = MediaPlayer.create(this, R.raw.liyue_ost);
        mediaPlayer11 = MediaPlayer.create(this, R.raw.back);
        mediaPlayer12 = MediaPlayer.create(this, R.raw.clear);
        mediaPlayer13 = MediaPlayer.create(this, R.raw.proceed);
        mediaPlayer14 = MediaPlayer.create(this, R.raw.plus_minus_button);
        mediaPlayer15 = MediaPlayer.create(this, R.raw.paimon_food_final);
        liyue_ost = findViewById(R.id.liyue_ost);

        liyue_ost.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    if(!mediaPlayer10.isPlaying()){
                        mediaPlayer10.start();
                    }
                }else{
                    if (mediaPlayer10.isPlaying()){
                        mediaPlayer10.pause();
                    }
                }
            }
        });
        liyue_ost.setChecked(true);
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
            case R.id.plus_button7:
                if (!mediaPlayer14.isPlaying()){
                    mediaPlayer14.start();
                }
                if (quantity7 < 10) {
                    quantity7++;
                    updateQuantityTextView();
                showToast("Add 1 Adeptus Temptation ");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button7:
                if (!mediaPlayer14.isPlaying()){
                    mediaPlayer14.start();
                }
                if (quantity7 > 1) {
                    quantity7--;
                    updateQuantityTextView();
                } else if (quantity7 == 1) {
                    quantity7 = 0;
                    updateQuantityTextView();
                showToast("Removed 1 Adeptus Temptation ");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order7:
                if (!mediaPlayer15.isPlaying()) {
                    mediaPlayer15.start();
                }
                if (quantity7 > 0) {
                    addOrderedItem("Adeptus Temptation", quantity7);
                    showToast("Successfully added " +  quantity7+ "Adeptus Temptation to the list");
                }
                // Handle order logic
                quantity7 = 0; // Clear the quantity
                updateQuantityTextView();
                break;

            case R.id.plus_button8:
                if (!mediaPlayer14.isPlaying()){
                    mediaPlayer14.start();
                }
                if (quantity8 < 10) {
                    quantity8++;
                    updateQuantityTextView2();
                showToast("Added 1 Almond Tofu ");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }
                break;

            case R.id.minus_button8:
                if (!mediaPlayer14.isPlaying()){
                    mediaPlayer14.start();
                }
                if (quantity8 > 1) {
                    quantity8--;
                    updateQuantityTextView2();
                } else if (quantity8 == 1) {
                    quantity8 = 0;
                    updateQuantityTextView2();
                showToast("Removed 1 Almond Tofu ");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order8:
                if (!mediaPlayer15.isPlaying()){
                    mediaPlayer15.start();
                }
                if (quantity8 > 0) {
                    addOrderedItem("Almond Tofu", quantity8);
                    showToast("Successfully added " + quantity8 + " Almond Tofu to the list");
                }
                // Handle order logic
                quantity8 = 0; // Clear the quantity
                updateQuantityTextView2();

                break;

            case R.id.plus_button9:
                if (!mediaPlayer14.isPlaying()){
                    mediaPlayer14.start();
                }
                if (quantity9 < 10) {
                    quantity9++;
                    updateQuantityTextView3();
                showToast("Added 1 Zhongli\'s Bamboo Shoot ");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }
                break;

            case R.id.minus_button9:
                if (!mediaPlayer14.isPlaying()){
                    mediaPlayer14.start();
                }
                if (quantity9 > 1) {
                    quantity9--;
                    updateQuantityTextView3();
                } else if (quantity9 == 1) {
                    quantity9 = 0;
                    updateQuantityTextView3();
                showToast("Removed 1 Zhongli\'s Bamboo Shoot ");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order9:
                if (!mediaPlayer15.isPlaying()){
                    mediaPlayer15.start();
                }
                if (quantity9 > 0) {
                    addOrderedItem("Zhongli\'s Bamboo Shoot", quantity9);
                    showToast("Successfully added " + quantity9 + " Zhongli\'s Bamboo Shoot");
                }
                // Handle order logic
                quantity9 = 0; // Clear the quantity
                updateQuantityTextView3();
                break;

            case R.id.plus_button10:
                if (!mediaPlayer14.isPlaying()){
                    mediaPlayer14.start();
                }
                if (quantity10 < 10) {
                    quantity10++;
                    updateQuantityTextView4();
                showToast("Added 1 Tianshu Meat ");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button10:
                if (!mediaPlayer14.isPlaying()){
                    mediaPlayer14.start();
                }
                if (quantity10 > 1) {
                    quantity10--;
                    updateQuantityTextView4();
                } else if (quantity10 == 1) {
                    quantity10 = 0;
                    updateQuantityTextView4();
                showToast("Removed 1 Tianshu Meat ");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order10:
                if (!mediaPlayer15.isPlaying()){
                    mediaPlayer15.start();
                }
                if (quantity10 > 0) {
                    addOrderedItem("Tianshu Meat", quantity10);

                    showToast("Successfully added " + quantity10 + "Tianshu Meat");
                }
                // Handle order logic
                quantity10 = 0; // Clear the quantity
                updateQuantityTextView4();
                break;

            case R.id.plus_button11:
                if (!mediaPlayer14.isPlaying()){
                    mediaPlayer14.start();
                }
                if (quantity11 < 10) {
                    quantity11++;
                    updateQuantityTextView5();
                showToast("Added 1 Pop Tea ");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button11:
                if (!mediaPlayer14.isPlaying()){
                    mediaPlayer14.start();
                }
                if (quantity11 > 1) {
                    quantity11--;
                    updateQuantityTextView5();
                } else if (quantity11 == 1) {
                    quantity11 = 0;
                    updateQuantityTextView5();
                showToast("Removed 1 Pop Tea ");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order11:
                if (!mediaPlayer15.isPlaying()){
                    mediaPlayer15.start();
                }
                if (quantity11 > 0) {
                    addOrderedItem("Pop Tea", quantity11);

                    showToast("Successfully added " + quantity11 + "Pop Tea");
                }
                // Handle order logic
                quantity11 = 0; // Clear the quantity
                updateQuantityTextView5();
                break;

            case R.id.plus_button12:
                if (!mediaPlayer14.isPlaying()){
                    mediaPlayer14.start();
                }
                if (quantity12 < 10) {
                    quantity12++;
                    updateQuantityTextView6();
                showToast("Added 1 Rice Pudding ");
                }else {
                    showToast("You Have Reached the Maximum of 10 per item");
                }

                break;

            case R.id.minus_button12:
                if (!mediaPlayer14.isPlaying()){
                    mediaPlayer14.start();
                }
                if (quantity12 > 1) {
                    quantity12--;
                    updateQuantityTextView6();
                } else if (quantity12 == 1) {
                    quantity12 = 0;
                    updateQuantityTextView6();
                showToast("Removed 1 Rice Pudding ");
                }else{
                    showToast("There\'s nothing to remove");
                }
                break;

            case R.id.order12:
                if (!mediaPlayer15.isPlaying()){
                    mediaPlayer15.start();
                }
                if (quantity12 > 0) {
                    addOrderedItem("Rice Pudding", quantity12);

                    showToast("Successfully added " + quantity12 + "Rice Pudding");
                }
                // Handle order logic
                quantity12 = 0; // Clear the quantity
                updateQuantityTextView6();
                break;

            case R.id.back_button2:
                if (!mediaPlayer11.isPlaying()){
                    mediaPlayer11.start();
                }
                showToast("Back to Tavern Menu Selection");

                backtavernmain();

                break;

            case R.id.proceed_order2:
                if (!mediaPlayer13.isPlaying()){
                    mediaPlayer13.start();
                }
                showToast("Thank you for Order! Please Proceed!");

                receiptavernproceed();

                break;

            case R.id.clear2:
                if (!mediaPlayer12.isPlaying()){
                    mediaPlayer12.start();
                }

                quantity7 = 0; // Reset the quantity
                updateQuantityTextView();
                quantity8 = 0;
                updateQuantityTextView2();
                quantity9 = 0;
                updateQuantityTextView3();
                quantity10 = 0;
                updateQuantityTextView4();
                quantity11 = 0;
                updateQuantityTextView5();
                quantity12 = 0;
                updateQuantityTextView6();
                showToast("The List has been Cleared!");

                clearOrderedItems();

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
        Intent intent = new Intent(liyuemenu.this, tavernreceipt.class);
        intent.putStringArrayListExtra("orderedItems", new ArrayList<>(orderedItems));
        intent.putIntegerArrayListExtra("orderedQuantities", new ArrayList<>(orderedQuantities));
        startActivity(intent);
    }

    private void backtavernmain() {

        Intent intent = new Intent(liyuemenu.this, tavernmain.class);
        startActivity(intent);
    }

    private void updateQuantityTextView() {
        if (quantity7 == 0) {
            quantityTextView7.setText("  Qnt  ");
        } else {
            quantityTextView7.setText(String.valueOf(quantity7));
        }
    }

    private void updateQuantityTextView2() {
        if (quantity8 == 0) {
            quantityTextView8.setText("  Qnt  ");
        } else {
            quantityTextView8.setText(String.valueOf(quantity8));
        }
    }

    private void updateQuantityTextView3() {
        if (quantity9 == 0) {
            quantityTextView9.setText("  Qnt  ");
        } else {
            quantityTextView9.setText(String.valueOf(quantity9));
        }
    }

    private void updateQuantityTextView4() {
        if (quantity10 == 0) {
            quantityTextView10.setText("  Qnt  ");
        } else {
            quantityTextView10.setText(String.valueOf(quantity10));
        }
    }

    private void updateQuantityTextView5() {
        if (quantity11 == 0) {
            quantityTextView11.setText("  Qnt  ");
        } else {
            quantityTextView11.setText(String.valueOf(quantity11));
        }
    }

    private void updateQuantityTextView6() {
        if (quantity12 == 0) {
            quantityTextView12.setText("  Qnt  ");
        } else {
            quantityTextView12.setText(String.valueOf(quantity12));
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        if (liyue_ost.isChecked() && !mediaPlayer10.isPlaying()){
            mediaPlayer10.start();
        }
    }
    @Override
    protected void onPause(){
        super.onPause();
        if (mediaPlayer10.isPlaying()){
            mediaPlayer10.pause();
        }
        if (mediaPlayer11.isPlaying()){
            mediaPlayer10.pause();
        }
        if (mediaPlayer12.isPlaying()){
            mediaPlayer10.pause();
        }
        if (mediaPlayer13.isPlaying()){
            mediaPlayer10.pause();
        }
        if (mediaPlayer14.isPlaying()){
            mediaPlayer10.pause();
        }
        if (mediaPlayer15.isPlaying()){
            mediaPlayer10.pause();
        }

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mediaPlayer10.release();
        mediaPlayer11.release();
        mediaPlayer12.release();
        mediaPlayer13.release();
        mediaPlayer14.release();
        mediaPlayer15.release();
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}