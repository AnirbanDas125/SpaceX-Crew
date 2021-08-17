package com.example.spacexcrew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RequestQueue requestQueue;
    List<DataModel> crewDataList;
    public static String apiUrl = "https://api.spacexdata.com/v4/crew";
    FloatingActionButton refresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        refresh = findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchData();
            }
        });

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getInstance(this).getRequestQueue();

        crewDataList = new ArrayList<>();
        fetchData();
    }
    public void fetchData(){

        JsonArrayRequest jsonArrayRequest =  new JsonArrayRequest(Request.Method.GET, apiUrl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i< response.length();i++){
                    try{
                        JSONObject jsonObject = response.getJSONObject(i);

                       String imageURL = jsonObject.getString("image");
                       String cName ="Name:"+jsonObject.getString("name");
                       String cAgency ="Agency:"+jsonObject.getString("agency");
                       String cStatus =jsonObject.getString("status");
                       String link = jsonObject.getString("wikipedia");


                       DataModel dataModel = new DataModel(cName,cAgency,imageURL,cStatus,link);
                       crewDataList.add(dataModel);
                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                   Adapter adapter = new Adapter(getApplicationContext(),crewDataList);
                   recyclerView.setAdapter(adapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
          requestQueue.add(jsonArrayRequest);
    }
}