package com.working_group.votingapp.entities;

public class Enquete {
    private int id;
    private String title;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId(){
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }
}
