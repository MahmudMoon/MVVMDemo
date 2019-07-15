package com.example.moon.mvvmdemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.moon.mvvmdemo.R;
import com.example.moon.mvvmdemo.adapter.Recycler_view_adapter;
import com.example.moon.mvvmdemo.models.NicePlaceInfo;
import com.example.moon.mvvmdemo.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Recycler_view_adapter recycler_view_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view_);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //////////////////////////////////////////////
          ///Fetch Data/////////////
        MainActivityViewModel mainActivityViewModel = new MainActivityViewModel();
        MutableLiveData<List<NicePlaceInfo>> placeData =  mainActivityViewModel.getPlaceData();
        placeData.observe(this, new Observer<List<NicePlaceInfo>>() {
            @Override
            public void onChanged(List<NicePlaceInfo> nicePlaceInfos) {
                recycler_view_adapter.notifyDataSetChanged();

            }
        });

        ///////////////////////////////////////
        recycler_view_adapter = new Recycler_view_adapter(mainActivityViewModel.getPlaceData().getValue(),getApplicationContext());
        recyclerView.setAdapter(recycler_view_adapter);




    }
}
