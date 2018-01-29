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
import com.working_group.votingapp.listeners.AnswerButton;
import com.working_group.votingapp.listeners.ResultButton;

import java.util.List;

public class EnqueteListAdapter extends ArrayAdapter<Enquete> {
    private LayoutInflater inflater;
    private Enquete enquete;

    public EnqueteListAdapter(Context context) {
        super(context, R.layout.enquete_list);

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //実質的な処理はここに
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            //ListViewの各行のレイアウトを設定
            convertView = inflater.inflate(R.layout.enquete_list, null);
        }

        //リストのアイテムデータの取得
        enquete = this.getItem(position);

        //回答ボタンの設定
        Button answerButton = (Button)convertView.findViewById(R.id.answer_button);
        answerButton.setOnClickListener(new AnswerButton(enquete.getId(), position, (ListView)parent));

        //結果ボタンの設定
        Button resultButton = (Button)convertView.findViewById(R.id.result_button);
        resultButton.setOnClickListener(new ResultButton(enquete.getId(), position, (ListView)parent));

        TextView textView = (TextView) convertView.findViewById(R.id.title);
        if (textView != null) {
            //アイテムデータに設定されたテキストを表示
            textView.setText(enquete.getTitle());
        }

        return convertView;
    }
}
