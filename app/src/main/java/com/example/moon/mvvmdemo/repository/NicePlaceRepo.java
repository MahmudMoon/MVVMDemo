package com.example.moon.mvvmdemo.repository;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moon.mvvmdemo.models.NicePlaceInfo;

import java.util.ArrayList;
import java.util.List;

//Single Tone Pattern
public class NicePlaceRepo {
    private static MutableLiveData<List<NicePlaceInfo>> mutableLiveData;
    public static NicePlaceRepo nicePlaceRepo =null;
    private static List<NicePlaceInfo> nicePlaceInfos;
    public static NicePlaceRepo getInstance(){
        if(nicePlaceRepo==null){
            nicePlaceRepo = new NicePlaceRepo();
            nicePlaceInfos = new ArrayList<>();
        }
        return nicePlaceRepo;
    }

    public MutableLiveData<List<NicePlaceInfo>> getNicePlaces(){
        mutableLiveData = new MutableLiveData<>();
        nicePlaceInfos.add(new NicePlaceInfo("Place One","https://firebasestorage.googleapis.com/v0/b/pushnotificationdemo-75b6d.appspot.com/o/64278687-close-up-of-a-hand-of-a-thief-stealing-a-painting-in-a-gallery-of-a-ship-at-sea.jpg?alt=media&token=91748c0b-ffa9-450c-9da2-d8597cd102b1"));
        nicePlaceInfos.add(new NicePlaceInfo("place Two","https://firebasestorage.googleapis.com/v0/b/pushnotificationdemo-75b6d.appspot.com/o/clipart354881.png?alt=media&token=0e20ad58-b668-4b59-bf13-a57701b8fa0f"));
        nicePlaceInfos.add(new NicePlaceInfo("Place Three","https://firebasestorage.googleapis.com/v0/b/pushnotificationdemo-75b6d.appspot.com/o/dp.jpg?alt=media&token=2a3fac6e-6a2c-466c-9e96-19e2c21bd33e"));
        nicePlaceInfos.add(new NicePlaceInfo("Place Four","https://firebasestorage.googleapis.com/v0/b/pushnotificationdemo-75b6d.appspot.com/o/image%20(3).png?alt=media&token=15fd9c30-756d-44e7-916c-9d2699fd1b91"));
        nicePlaceInfos.add(new NicePlaceInfo("Place Five","https://firebasestorage.googleapis.com/v0/b/pushnotificationdemo-75b6d.appspot.com/o/pzicon.png?alt=media&token=fa4af9f9-8bae-4429-bf8a-165c6d694365"));
        nicePlaceInfos.add(new NicePlaceInfo("Place Six","https://firebasestorage.googleapis.com/v0/b/pushnotificationdemo-75b6d.appspot.com/o/pzmag.jpg?alt=media&token=cb2319ea-cf73-4c24-8c40-271a90640eab"));
        nicePlaceInfos.add(new NicePlaceInfo("Place Seven","https://firebasestorage.googleapis.com/v0/b/pushnotificationdemo-75b6d.appspot.com/o/pzmal.jpg?alt=media&token=3b1017d7-d4d7-4ac1-8901-09b7582ff514"));
        nicePlaceInfos.add(new NicePlaceInfo("Place Eight","https://firebasestorage.googleapis.com/v0/b/pushnotificationdemo-75b6d.appspot.com/o/pzspy.jpg?alt=media&token=13886c24-bf80-4be3-ae0b-9f362f9964c1"));
        nicePlaceInfos.add(new NicePlaceInfo("Place Nine","https://firebasestorage.googleapis.com/v0/b/pushnotificationdemo-75b6d.appspot.com/o/tree-85-128%20(1).png?alt=media&token=5a095410-a738-40f9-ac80-528ddf428029"));
        nicePlaceInfos.add(new NicePlaceInfo("Place Ten","https://firebasestorage.googleapis.com/v0/b/pushnotificationdemo-75b6d.appspot.com/o/tree.jpg?alt=media&token=1c8135c3-bc56-4a38-8673-b5159e230aca"));
        mutableLiveData.setValue(nicePlaceInfos);
        return mutableLiveData;
    }

    public static List<NicePlaceInfo> addNewData(){
        nicePlaceInfos.add(new NicePlaceInfo("Place One","https://firebasestorage.googleapis.com/v0/b/pushnotificationdemo-75b6d.appspot.com/o/64278687-close-up-of-a-hand-of-a-thief-stealing-a-painting-in-a-gallery-of-a-ship-at-sea.jpg?alt=media&token=91748c0b-ffa9-450c-9da2-d8597cd102b1"));
       return nicePlaceInfos;
    }


}
