package com.example.moon.mvvmdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moon.mvvmdemo.R;
import com.example.moon.mvvmdemo.models.NicePlaceInfo;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class Recycler_view_adapter extends RecyclerView.Adapter<Recycler_view_adapter.Recycler_view_holder> {

    private List<NicePlaceInfo> nicePlaceInfoArrayList;
    private Context mContext;

    public Recycler_view_adapter(List<NicePlaceInfo> nicePlaceInfoArrayList, Context mContext) {
        this.nicePlaceInfoArrayList = nicePlaceInfoArrayList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Recycler_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.custom_adapter_layout, null,false);
        Recycler_view_holder recycler_view_holder = new Recycler_view_holder(view);
        return recycler_view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_view_holder holder, int position) {
        holder.textView.setText(nicePlaceInfoArrayList.get(position).getPlaceName());
        //GLIDE
        Glide.with(mContext)
                .load(nicePlaceInfoArrayList.get(position).getPlaceImageUrl())
                .into(holder.circleImageView);


    }

    @Override
    public int getItemCount() {
        return nicePlaceInfoArrayList.size();
    }

    class Recycler_view_holder extends RecyclerView.ViewHolder{

        TextView textView;
        CircleImageView circleImageView;
        public Recycler_view_holder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.nice_place_name);
            circleImageView = (CircleImageView)itemView.findViewById(R.id.nice_place_image);
        }
    }
}
