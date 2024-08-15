package com.example.onlineshopappecommerce.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.onlineshopappecommerce.Adapter.CartListAdapter;
import com.example.onlineshopappecommerce.Helper.ChangeNumberItemsListener;
import com.example.onlineshopappecommerce.Helper.ManagmentCart;
import com.example.onlineshopappecommerce.R;

public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private ManagmentCart managmentCart;
    private TextView totalFeeTxt, taxTxt, deliveryTxt,totalTxt,emptyTxt;
    private double tax;
    private ScrollView scrollView;
    private ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        managmentCart = new ManagmentCart(this);

        initView();
        setVariable();
        initList();
        calculateCart();
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managmentCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void change() {
                calculateCart();
            }
        });

        recyclerView.setAdapter(adapter);
        if(managmentCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else{
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCart() {
        double percentTax = 0.02; //you can change this value for tax price
        double delivery = 10;
        tax = Math.round((managmentCart.getTotalFee()*percentTax*100.0))/100.0;

        double total = Math.round((managmentCart.getTotalFee() + tax + delivery) * 100) / 100;
        double itemTotal = Math.round(managmentCart.getTotalFee() * 100) / 100;

        totalFeeTxt.setText("$" + itemTotal);
        taxTxt.setText("$" + tax);
        deliveryTxt.setText("$" + delivery);
        totalTxt.setText("$" + total);
    }

    private void setVariable() {
        backBtn.setOnClickListener(view -> finish());
    }

    private void initView() {
        totalFeeTxt = findViewById(R.id.totalFeetxt);
        taxTxt = findViewById(R.id.taxtxt);
        deliveryTxt = findViewById(R.id.deliverytxt);
        totalTxt = findViewById(R.id.totaltxt);
        recyclerView = findViewById(R.id.view3);
        scrollView = findViewById(R.id.scrollView2);
        backBtn = findViewById(R.id.backbtn);
        emptyTxt = findViewById(R.id.emptytxt);

    }
}