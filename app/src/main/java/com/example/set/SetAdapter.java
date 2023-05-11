package com.example.set;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SetAdapter extends RecyclerView.Adapter<SetAdapter.ViewHolder> {
    private List<Set> sets;

    private Context context;

    public void setData(List<Set> sets) {
        this.sets = sets;
        notifyDataSetChanged();
    }

    public SetAdapter(List<Set> sets, Context context) {
        this.sets = sets;
        this.context = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle;
        private final RecyclerView rvMission;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.tvTitle = view.findViewById(R.id.tvTitleSet);
            this.rvMission = view.findViewById(R.id.rvMission);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_set, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Set set = sets.get(position);
        if (set == null) {
            return;
        }
        holder.tvTitle.setText(set.getTitle());
        MissionAdapter missionAdapter = new MissionAdapter(set.getMissions(), context, new IClickMissionListener() {
            @Override
            public void onClickNext(Mission mission) {
                System.out.println(mission.title);
            }
        });
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.rvMission.setLayoutManager(layoutManager);
        holder.rvMission.setAdapter(missionAdapter);
    }

    @Override
    public int getItemCount() {
        if (sets != null) {
            return sets.size();
        }
        return 0;
    }
}
