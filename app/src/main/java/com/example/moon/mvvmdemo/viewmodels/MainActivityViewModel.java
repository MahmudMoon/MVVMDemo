package com.example.moon.mvvmdemo.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moon.mvvmdemo.models.NicePlaceInfo;
import com.example.moon.mvvmdemo.repository.NicePlaceRepo;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<NicePlaceInfo>> mutableLiveData_of_nice_places;

    public MutableLiveData<List<NicePlaceInfo>> getPlaceData(){
        if(mutableLiveData_of_nice_places==null){
            mutableLiveData_of_nice_places = NicePlaceRepo.getInstance().getNicePlaces();
        }
        return mutableLiveData_of_nice_places;
    }

    public int addNewData(){
        List<NicePlaceInfo> nicePlaceInfos = NicePlaceRepo.addNewData();
        mutableLiveData_of_nice_places.setValue(nicePlaceInfos);
        return mutableLiveData_of_nice_places.getValue().size();
    }

}
