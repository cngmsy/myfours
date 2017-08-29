package com.jiyun.qcloud.dashixummoban.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.modle.utils.GlideCacheUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by liuwangping on 2017/8/28.
 */
public class ClearActivity extends BaseActivity {

    @BindView(R.id.MySet_Return)
    ImageView MySetReturn;
    @BindView(R.id.MySet_CacheShu)
    TextView MySetCacheShu;
    @BindView(R.id.MySet_Cache)
    RelativeLayout MySetCache;
    private final int CLEAN_SUC = 1001;
    private final int CLEAN_FAIL = 1002;
    @Override
    protected void initData() {
        String cacheSize = GlideCacheUtil.getInstance().getCacheSize(ClearActivity.this);
        MySetCacheShu.setText(cacheSize);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_clearcache;
    }
    @OnClick(R.id.MySet_Cache)
    public void onViewClicked() {
        onClickCleanCache();
    }

    private void onClickCleanCache() {
        getConfirmDialog(this, "是否清空缓存?", new DialogInterface.OnClickListener
                () {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                GlideCacheUtil.getInstance().clearImageAllCache(ClearActivity.this);
                Toast.makeText(ClearActivity.this, "清除成功", Toast.LENGTH_SHORT).show();
                MySetCacheShu.setText("0KB");
            }
        }).show();
    }

    public static AlertDialog.Builder getConfirmDialog(Context context, String message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = getDialog(context);
        builder.setMessage(Html.fromHtml(message));
        builder.setPositiveButton("确定", onClickListener);
        builder.setNegativeButton("取消", null);
        return builder;
    }

    public static AlertDialog.Builder getDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        return builder;
    }
    

}
