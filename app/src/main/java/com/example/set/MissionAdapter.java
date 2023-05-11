package com.example.set;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class MissionAdapter extends RecyclerView.Adapter<MissionAdapter.ViewHolder> {
    private List<Mission> missions;
    private Context context;
    private final IClickMissionListener iClickMissionListener;

    public void setData(List<Mission> missions) {
        this.missions = missions;
        notifyDataSetChanged();
    }

    public MissionAdapter(List<Mission> missions, Context context, IClickMissionListener listener) {
        this.missions = missions;
        this.context = context;
        this.iClickMissionListener = listener;
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle;
        private final TextView tvSubTitle;
        private final ImageView ivThumbnail;
        private final ImageButton btnNext;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.tvTitle = view.findViewById(R.id.tvTitleMission);
            this.tvSubTitle = view.findViewById(R.id.tvSubTitleMission);
            this.ivThumbnail = view.findViewById(R.id.ivMission);
            this.btnNext = view.findViewById(R.id.btnNext);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_mission, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mission mission = missions.get(position);
        if (mission == null) {
            return;
        }
        holder.tvTitle.setText(mission.getTitle());
        holder.tvSubTitle.setText(mission.getSubTitle());
        Glide.with(holder.ivThumbnail).load(mission.urlImage).override(80,80).fitCenter().apply(RequestOptions.bitmapTransform(new RoundedCorners(10))).into(holder.ivThumbnail);
        holder.btnNext.setOnClickListener(view -> iClickMissionListener.onClickNext(mission));
    }

    @Override
    public int getItemCount() {
        if (missions != null) {
            return missions.size();
        }
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
