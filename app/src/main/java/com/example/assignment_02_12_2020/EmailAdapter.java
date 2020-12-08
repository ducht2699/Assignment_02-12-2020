package com.example.assignment_02_12_2020;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class EmailAdapter extends BaseAdapter {
    List<Email> emailList = new ArrayList<Email>();
    Context context;
    List<Integer> colorList = new ArrayList<Integer>();

    public EmailAdapter(List<Email> emailList, Context context, List<Integer> colorList) {
        this.emailList = emailList;
        this.context = context;
        this.colorList = colorList;
    }

    @Override
    public int getCount() {
        return emailList.size();
    }

    @Override
    public Object getItem(int position) {
        return emailList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_email, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.title = convertView.findViewById(R.id.tv_title);
            viewHolder.details = convertView.findViewById(R.id.tv_details);
            viewHolder.star = convertView.findViewById(R.id.cb_star);
            viewHolder.avatar = convertView.findViewById(R.id.tv_avatar);
            viewHolder.avatar_background = convertView.findViewById(R.id.profile_image);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();

        Email email = emailList.get(position);

        viewHolder.title.setText(email.getTitle());
        viewHolder.details.setText(email.getDetails());
        viewHolder.star.setChecked(email.isStared());
        viewHolder.avatar.setText(email.getAvatar());
        viewHolder.avatar_background.setCircleBackgroundColor(R.color.red);

        viewHolder.star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email.setStared(viewHolder.star.isChecked());
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    class ViewHolder {
        private TextView title;
        private TextView details;
        private CheckBox star;
        private TextView avatar;
        private CircleImageView avatar_background;
    }
}
