package com.example.onlineshopappecommerce.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.onlineshopappecommerce.Adapter.PopularListAdapter;
import com.example.onlineshopappecommerce.Domain.PopularDomain;
import com.example.onlineshopappecommerce.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPopular;
    private RecyclerView recyclerViewPopular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        bottom_navigation();

    }

    private void bottom_navigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, MainActivity.class)));
        cartBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
    }

    private void initRecyclerview() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Macbook Pro 13 M2 chip",
                "A laptop, sometimes called a notebook computer by manufacturers, is a battery- or AC-powered personal computer (PC) smaller than a briefcase. A laptop can be easily transported and used in temporary spaces such as on airplanes, in libraries, temporary offices and at meetings.","maytinh",15,4,500));
        items.add(new PopularDomain("Ps-5 Digital",
                "A laptop, sometimes called a notebook computer by manufacturers, is a battery- or AC-powered personal computer (PC) smaller than a briefcase. A laptop can be easily transported and used in temporary spaces such as on airplanes, in libraries, temporary offices and at meetings.","maytinh",10,4.5,450));
        items.add(new PopularDomain("Iphone 14",
                "A laptop, sometimes called a notebook computer by manufacturers, is a battery- or AC-powered personal computer (PC) smaller than a briefcase. A laptop can be easily transported and used in temporary spaces such as on airplanes, in libraries, temporary offices and at meetings.","maytinh",13,4.2,800));

        recyclerViewPopular = findViewById(R.id.view1);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterPopular = new PopularListAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);
    }
}