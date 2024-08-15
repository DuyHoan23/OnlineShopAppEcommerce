package com.example.onlineshopappecommerce.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.onlineshopappecommerce.Domain.PopularDomain;
import com.example.onlineshopappecommerce.Helper.ManagmentCart;
import com.example.onlineshopappecommerce.R;

public class DetailActivity extends AppCompatActivity {
    private Button addToCartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, reviewTxt, scoreTxt;
    private ImageView picFood, backBtn;
    private PopularDomain object;
    private int numberOrder = 1;
    private ManagmentCart managmentCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        managmentCart = new ManagmentCart(this);
        initView();
        getBundle();


    }
    private void getBundle(){
        object = (PopularDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(object.getPicUrl(),"drawable",this.getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getPrice());
        descriptionTxt.setText(object.getDescription());
        reviewTxt.setText(object.getReview()+"");
        scoreTxt.setText(object.getScore()+"");

        addToCartBtn.setOnClickListener(view -> {
            object.setNumberinCart(numberOrder);
            managmentCart.insertFood(object);
        });

        backBtn.setOnClickListener(view -> {
           finish();
        });
    }

    private void initView() {
        addToCartBtn = findViewById(R.id.addInCartBtn);
        feeTxt = findViewById(R.id.pricetxt);
        titleTxt = findViewById(R.id.titletxt);
        descriptionTxt = findViewById(R.id.descripsiontxt);
        picFood = findViewById(R.id.foodpic);
        reviewTxt = findViewById(R.id.reviewstxt);
        scoreTxt = findViewById(R.id.scoreTxt);
        backBtn = findViewById(R.id.backBtn);
    }
}