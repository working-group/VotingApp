package com.working_group.votingapp.listeners;

import android.view.View;
import android.widget.ListView;

import com.working_group.votingapp.R;

public class ResultButton implements View.OnClickListener {
    private int id;
    private int position;
    private ListView listView;

    public ResultButton(int id, int position, ListView listView) {
        this.id = id;
        this.position = position;
        this.listView = listView;

    }
    public void onClick(View view) {
        this.listView.performItemClick(view, this.position, R.id.result_button);
    }
}