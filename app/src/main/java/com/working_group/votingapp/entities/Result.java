package com.working_group.votingapp.entities;

public class Result {
    private int id;
    private int itemId;
    private String comment;

    public void setId(int id) {
        this.id = id;
    }

    public void setItemId(int itemId) { this.itemId = itemId;}

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId(){
        return this.id;
    }

    public int getItemId() { return this.itemId;}

    public String getComment() {
        return this.comment;
    }

}
