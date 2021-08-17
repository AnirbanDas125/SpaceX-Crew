package com.example.spacexcrew;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RoomDBAdapter extends RecyclerView.Adapter<RoomDBAdapter.RoomDBViewHolder> {

    private List<RoomDBDataModel> roomDataList;
    private Activity context;
    private RoomDB database;

    public RoomDBAdapter(List<RoomDBDataModel> roomDataList, Activity context) {
        this.roomDataList = roomDataList;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RoomDBViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.room_db_each_crew_member,
                parent,false);

        return new RoomDBViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomDBViewHolder holder, int position) {
       RoomDBDataModel roomDBDataModel = roomDataList.get(position);

           holder.textView.setText(roomDBDataModel.getName());
           holder.textView2.setText(roomDBDataModel.getAgency());
           holder.textView3.setText(roomDBDataModel.getStatus());

    }

    @Override
    public int getItemCount() {
        return roomDataList.size();
    }

    public class RoomDBViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewRoomDB;
        TextView textView,textView2,textView3;

        public RoomDBViewHolder(@NonNull View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.textView);
            textView2= itemView.findViewById(R.id.textView2);
            textView3= itemView.findViewById(R.id.textView3);
        }
    }
}
