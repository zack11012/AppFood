package com.app.foodorder.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.app.foodorder.Activity.Adaptor.DanhSachAdaptor;
import com.app.foodorder.Activity.Adaptor.PhoBienAdaptor;
import com.app.foodorder.Activity.Domain.DanhSachDomain;
import com.app.foodorder.Activity.Domain.FoodDomain;
import com.app.foodorder.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter, adapter2;
private RecyclerView recyclerViewDanhSach,recyclerViewPhoBien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycleDanhSach();
        recyclerViewPhoBien();
        bottomNavigation();
    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homebtn = findViewById(R.id.btnHome);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });
    }

    private void recycleDanhSach() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewDanhSach=findViewById(R.id.recyclerView);
        recyclerViewDanhSach.setLayoutManager(linearLayoutManager);

        ArrayList<DanhSachDomain> danhSach= new ArrayList<>();
        danhSach.add(new DanhSachDomain("Pizza","cat_1"));
        danhSach.add(new DanhSachDomain("Burger","cat_2"));
        danhSach.add(new DanhSachDomain("Hotdog","cat_3"));
        danhSach.add(new DanhSachDomain("Drink","cat_4"));
        danhSach.add(new DanhSachDomain("Donut","cat_5"));
        adapter = new DanhSachAdaptor(danhSach);
        recyclerViewDanhSach.setAdapter(adapter);
    }
    private void recyclerViewPhoBien(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPhoBien = findViewById(R.id.recyclerView2);
        recyclerViewPhoBien.setLayoutManager(linearLayoutManager);
        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Pepperoni pizza","pop_3","slices peperoni,mozzerella phô mai, tiêu đen, sốt pizza",5.99));
        foodlist.add(new FoodDomain("Burger Chicken","pop_2","bò, cà chua, phô mai, sốt burger",2.99));
        foodlist.add(new FoodDomain("Pizza chay","pizza","dầu oliu, dầu thực vật, cà chua bi, rau salad",4.99));

        adapter2 = new PhoBienAdaptor(foodlist);
        recyclerViewPhoBien.setAdapter(adapter2);
    }
}