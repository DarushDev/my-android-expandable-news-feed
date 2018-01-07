package com.example.myandroidexpandablenewsfeed;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.Collapse;
import com.mindorks.placeholderview.annotations.expand.Expand;
import com.mindorks.placeholderview.annotations.expand.Parent;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;
import com.mindorks.placeholderview.annotations.expand.SingleTop;
import com.mindorks.placeholderview.annotations.expand.Toggle;

/**
 * Created by Darush on 1/7/2018.
 */

@Parent
@SingleTop
@Layout(R.layout.feed_heading)
public class HeadingView {

    @View(R.id.tv_feedheading_heading)
    private TextView textHeading;

    @View(R.id.iv_feedheading_toggle)
    private ImageView imageToggle;

    @Toggle(R.id.ll_feedheading_toggle)
    private LinearLayout layoutToggle;

    @ParentPosition
    private int mParentPosition;

    private Context mContext;
    private String mHeading;

    public HeadingView(Context context, String heading) {
        mContext = context;
        mHeading = heading;
    }

    @Resolve
    public void onResolved() {
        imageToggle.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_expand_less_white_24dp));
        textHeading.setText(mHeading);
    }

    @Expand
    private void onExpand() {
        imageToggle.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_expand_more_white_24dp));
    }

    @Collapse
    private void onCollapse() {
        imageToggle.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_expand_more_white_24dp));
    }


}
