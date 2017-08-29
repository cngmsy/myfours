package com.jiyun.qcloud.dashixummoban.ui.home;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Administrator on 2017/8/26.
 */

public class CostumListView extends ListView{
    public CostumListView(Context context) {
        super(context);
    }

    public CostumListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CostumListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 5, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
