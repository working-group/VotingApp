package com.working_group.votingapp.libs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.working_group.votingapp.R;
import com.working_group.votingapp.entities.Enquete;
import com.working_group.votingapp.entities.Result;
import com.working_group.votingapp.listeners.AnswerButton;
import com.working_group.votingapp.listeners.ResultButton;

public class ResultListAdapter extends ArrayAdapter<Result> {
    private LayoutInflater inflater;
    private Result result;

    public ResultListAdapter(Context context) {
        super(context, R.layout.result_list);

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //実質的な処理はここに
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            //ListViewの各行のレイアウトを設定
            convertView = inflater.inflate(R.layout.result_list, null);
        }

        //リストのアイテムデータの取得
        result = this.getItem(position);

        TextView itemId = (TextView) convertView.findViewById(R.id.itemId);
        if (itemId != null) {
            //アイテムデータに設定された回答IDを表示
            itemId.setText(result.getItemId());
        }
        TextView comment = (TextView) convertView.findViewById(R.id.comment);
        if (comment != null) {
            //アイテムデータに設定されたコメントを表示
            comment.setText(result.getComment());
        }

        return convertView;
    }
}
