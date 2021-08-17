package com.example.spacexcrew;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Locale;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private Context context;
    private List<DataModel> crewList;

    public Adapter(Context context, List<DataModel> crewList) {
        this.context = context;
        this.crewList = crewList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.each_crew_member_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        DataModel dataModel = crewList.get(position);

        Glide.with(context).load(dataModel.getCrewMemberImage()).into(holder.crewMemberImage);
        holder.crewMemberName.setText(dataModel.getCrewMemberName());
        holder.crewMemberAgency.setText(dataModel.getCrewMemberAgency());
        holder.CrewMemberStatus.setText(dataModel.getCrewMemberStatus().toUpperCase(Locale.ROOT));
        holder.wiki_link.setText(dataModel.getWiki_link());

        holder.wiki_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(dataModel.getWiki_link().toString()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String text1 = holder.crewMemberName.getText().toString();
                 String text2 = holder.crewMemberAgency.getText().toString();
                 String text3 = holder.CrewMemberStatus.getText().toString();

                 Intent intent = new Intent(context,Show.class);
                 intent.putExtra("t1",text1);
                 intent.putExtra("t2",text2);
                 intent.putExtra("t3",text3);

                 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 context.startActivity(intent);
                 Toast.makeText(context, "Data Saved Successfully!", Toast.LENGTH_SHORT).show();
             }
         });
    }

    @Override
    public int getItemCount() {
        return crewList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView crewMemberImage;
        TextView crewMemberName,crewMemberAgency,CrewMemberStatus,wiki_link ;

        public ViewHolder(View itemView) {
            super(itemView);
            crewMemberImage = itemView.findViewById(R.id.crewMemberImage);
            crewMemberName = itemView.findViewById(R.id.crewMemberName);
            crewMemberAgency = itemView.findViewById(R.id.crewMemberAgency);
            CrewMemberStatus = itemView.findViewById(R.id.crewMemberStatus);
            wiki_link = itemView.findViewById(R.id.wiki_link);
            wiki_link.setMovementMethod(LinkMovementMethod.getInstance());

        }
    }
}
