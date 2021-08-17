package com.example.spacexcrew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Show extends AppCompatActivity {

    RecyclerView recyclerView2;
    Intent intent;
    LinearLayoutManager linearLayoutManager;
    List<RoomDBDataModel> roomDataList = new ArrayList<>();
    RoomDB dataBase;
    RoomDBAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
         FloatingActionButton floating_deleteAll = findViewById(R.id.floating_deleteAll);
         FloatingActionButton floating_add = findViewById(R.id.floating_add);
        recyclerView2 = findViewById(R.id.recyclerView2);

        dataBase = RoomDB.getInstance(this);
        roomDataList = dataBase.mainDao().getAll();

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(linearLayoutManager);

        adapter = new RoomDBAdapter(roomDataList, Show.this);
        recyclerView2.setAdapter(adapter);

            intent = getIntent();
            RoomDBDataModel roomDBDataModel = new RoomDBDataModel();
            roomDBDataModel.setName(intent.getStringExtra("t1"));
            roomDBDataModel.setAgency(intent.getStringExtra("t2"));
            roomDBDataModel.setStatus(intent.getStringExtra("t3"));

            dataBase.mainDao().insert(roomDBDataModel);
            roomDataList.clear();
            roomDataList.addAll(dataBase.mainDao().getAll());
            adapter.notifyDataSetChanged();


            floating_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
            });

        floating_deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              dataBase.mainDao().deleteAll(roomDataList);
              roomDataList.clear();
              roomDataList.addAll(dataBase.mainDao().getAll());
              adapter.notifyDataSetChanged();
              Toast.makeText(getApplicationContext(), "All Saved Data Cleared!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}