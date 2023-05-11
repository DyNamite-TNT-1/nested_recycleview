package com.example.set;

import java.util.List;

public class Set {
    private String id;
    private String title;
    private List<Mission> missions;

    public Set(String id, String title, List<Mission> missions) {
        this.id = id;
        this.title = title;
        this.missions = missions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }
}
