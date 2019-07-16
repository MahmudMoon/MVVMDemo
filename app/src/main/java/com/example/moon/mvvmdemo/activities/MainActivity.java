package com.example.moon.mvvmdemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.example.moon.mvvmdemo.R;
import com.example.moon.mvvmdemo.adapter.Recycler_view_adapter;
import com.example.moon.mvvmdemo.models.NicePlaceInfo;
import com.example.moon.mvvmdemo.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Recycler_view_adapter recycler_view_adapter;
    LottieAnimationView lottieAnimationView;
    MainActivityViewModel mainActivityViewModel;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view_);
        lottieAnimationView = (LottieAnimationView)findViewById(R.id.lottie_animation_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //////////////////////////////////////////////
          ///Fetch Data/////////////

        mainActivityViewModel = new MainActivityViewModel();
        mainActivityViewModel.getPlaceData().observe(this, new Observer<List<NicePlaceInfo>>() {
            @Override
            public void onChanged(List<NicePlaceInfo> nicePlaceInfos) {
                recycler_view_adapter.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition(mainActivityViewModel.getPlaceData().getValue().size()-1);
                Log.i(TAG, "onChanged: " + mainActivityViewModel.getPlaceData().getValue().size());
            }
        });

        ///////////////////////////////////////
        recycler_view_adapter = new Recycler_view_adapter(mainActivityViewModel.getPlaceData().getValue(),getApplicationContext());
        recyclerView.setAdapter(recycler_view_adapter);



        lottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: "+mainActivityViewModel.addNewData());
            }
        });






    }
}
