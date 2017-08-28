package com.jiyun.qcloud.dashixummoban.view;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import com.jiyun.qcloud.dashixummoban.R;

import java.util.List;

/**
 * Created by liuwangping on 2017-8-23.
 */

public class MyGridLayout extends GridLayout {
    private View mDragedView;//被拖拽的view
    private int mMargin =10;
    private boolean mDragAble;
    private int count;
    /**
     * 在代码中new对象是会调用；
     * @param context
     */
    public MyGridLayout(Context context) {
        this(context, null);
    }

    /**
     * 在XML里面声明该控件的时候会调用；
     *
     * @param context
     * @param attrs
     */
    public MyGridLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 在XML里面声明时的style属性时调用；
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MyGridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setColumnCount(3);//初始化当前Gridlayout的条目个数
        setLayoutTransition(new LayoutTransition());   // 设置 GridLayout 中的条目增加过渡动画

    }

    /**
     * 向外界提供的设置添加Gridlayout条目的方法；
     *
     * @param list
     */
    public void setAddList(List<String> list) {
        for (String strItem : list) {
            addTvItem(strItem);
        }
    }
    //定义接口回调
    public interface OnItemClickListener {
        void onItemClick(TextView tv);
    }
    OnItemClickListener itemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }
    /**
     * 向Gridlayout里面添加条目；
     *
     * @param strItem
     */
    public void addTvItem(String strItem) {
        TextView tv = new TextView(getContext());
        GridLayout.LayoutParams lp = new GridLayout.LayoutParams();
        lp.width = getResources().getDisplayMetrics().widthPixels /3 - mMargin * 2;
        lp.height = GridLayout.LayoutParams.WRAP_CONTENT;
        lp.setMargins(mMargin,8,mMargin, 8);
        tv.setLayoutParams(lp);
        tv.setGravity(Gravity.CENTER);
        tv.setPadding(mMargin,8,mMargin, 8);
        tv.setText(strItem);
        tv.setBackgroundResource(R.drawable.tv_popup_item);
        MyGridLayout.this.addView(tv);
        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick((TextView) v);
                }
            }
        });
        count++;
        // 可以拖拽
        if (mDragAble) {
            tv.setOnLongClickListener(ocl);

        } else {// 不能拖拽
            tv.setOnLongClickListener(null);

        }

    }

    // TextView(MyGridLayout的条目)的长按事件
    private OnLongClickListener ocl = new OnLongClickListener() {

        @Override
        public boolean onLongClick(View v) {
            mDragedView= v;
            // 设置控件开始拖拽
            // 参数 1 ：拖拽要显示的数据，一般 null
            // 参数 2 ：拖拽显示的阴影样式 ,DragShadowBuilder(v): 根据拖拽的控件，设置拖拽阴影的样式效果
            // 参数 3 ：拖拽的控件的状态，一般 null
            // 参数 4 ：拖拽的其他设置的标示，一般 0
            v.startDrag(null, new DragShadowBuilder(v), null, 0);
            v.setEnabled(false);
            return false;
        }
    };

    // 向外界提供是否能拖拽的方法
    public void setDragAble(boolean isDrage) {
        this.mDragAble = isDrage;
        if (mDragAble) {
            // 监听拖拽事件
            this.setOnDragListener(odl);
        } else {
            // 不监听拖拽事件
            this.setOnDragListener(null);
        }
    }

    // 拖拽监听器
    private OnDragListener odl = new OnDragListener() {

        @Override
        public boolean onDrag(View arg0, DragEvent event) {

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    //当拖拽事件产生时，给每个子控件创建出对应的矩形
                    initRect();
                    break;
                // 实时监听拖拽事件// 开始拖拽控件后，移动控件或者是拖拽控件执行的操作
                case DragEvent.ACTION_DRAG_LOCATION:
                    //当手指移动时，判断当前进入了哪一个子控件范围内，并返回对应子控件的索引
                    int index = getIntouchIndex(event);
                    if (index > -1 && mDragedView != null
                            && mDragedView != getChildAt(index)) {
                        //先把拖拽的view从当前位置删除，再添加到touchIndex上
                        removeView(mDragedView);
                        addView(mDragedView, index);
                    }
                    break;
                // 停止拖拽
                case DragEvent.ACTION_DRAG_ENDED:
                    if (mDragedView != null) {
                        mDragedView.setEnabled(true);
                    }

                    break;
            }
            return true;
        }

    };

    private Rect[] mRectArr;
    // 将所有的条目都封装成矩形然后存入数组
    private void initRect() {
        //getChildCount() : 获取 Gridlayout 的子控件的个数
        int childViewCount = getChildCount();
        mRectArr = new Rect[childViewCount];
        // 根据孩子的个数，创建相应个数的矩形
        for (int i = 0; i < childViewCount; i++) {
            View childView = getChildAt(i);    // 根据子控件的索引，获取子控件的 view 对象

            // 创建一个矩形
            // 参数 1,2 ：左上角的 x 和 y 的坐标
            // 参数 3,4 ：右下角的 x 和 y 的坐标
            Rect rect = new Rect(childView.getLeft(), childView.getTop(), childView.getRight(), childView.getBottom());
            // 保存到就行到数组中
            mRectArr[i] = rect;
        }

    }

    // 实时监听拖拽的点是否进入到了某一个子控件范围内
    private int getIntouchIndex(DragEvent event) {
        for (int i = 0; i < mRectArr.length; i++) {
            // 判断按下的坐标是否包含在矩形的坐标范围内容
            if (mRectArr[i].contains((int) event.getX(), (int) event.getY())) {
                return i;
            }
        }
        return -1;
    }
}

