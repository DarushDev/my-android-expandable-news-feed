package com.example.myandroidexpandablenewsfeed;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.ChildPosition;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;

/**
 * Created by Darush on 1/7/2018.
 */

@Layout(R.layout.feed_item)
public class InfoView {

    @ParentPosition
    private int mParentPosition;

    @ChildPosition
    private int mChildPosition;

    @View(R.id.tv_feeditem_title)
    private TextView textTitle;

    @View(R.id.tv_feeditem_caption)
    private TextView textCaption;

    @View(R.id.tv_feeditem_time)
    private TextView textTime;

    @View(R.id.iv_feeditem_image)
    private ImageView image;

    private Info mInfo;
    private Context mContext;

    public InfoView(Context context, Info info) {
        mContext = context;
        mInfo = info;
    }

    @Resolve
    private void onResolved() {
        textTitle.setText(mInfo.getTitle());
        textCaption.setText(mInfo.getCaption());
        textTime.setText(mInfo.getTime());
        Glide.with(mContext).load(mInfo.getImageUrl()).into(image);
    }

}
