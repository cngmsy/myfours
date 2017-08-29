package com.jiyun.qcloud.dashixummoban.ui.observation.bobaoxiang;


import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.Bobao.BoBean;
import com.jiyun.qcloud.dashixummoban.ui.observation.bobaodetail.BoContract;
import com.jiyun.qcloud.dashixummoban.ui.observation.bobaodetail.BoPresenter;
import com.jiyun.qcloud.dashixummoban.ui.observation.imageloder.MyTagHandler;
import com.jiyun.qcloud.dashixummoban.ui.observation.imageloder.URLImageParser;

import java.util.HashMap;
import java.util.Map;


public class BoxiangActivity extends BaseActivity {



    /*private Element h1;
    private Node node;
    private Node node1;
    private Element p;
    private String resu;
    private String titles;
    private String ssk;*/


    @Override
    protected void initData() {
      /*  Intent intent = getIntent();
        final String url = intent.getStringExtra("url");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = Jsoup.connect(url).get();
                    Elements elements = doc.select("div.col_w920");
                    Element element = elements.get(0);
                    List<Node> nodes = element.childNodes().get(5).childNodes();
                    for (int i = 0; i < nodes.size(); i++) {
                        if (nodes.get(i).nodeName().equals("p")) {
                            ssk = nodes.get(i).childNode(0).outerHtml();
                            Logger.d("==========" + ssk);
                        }
                    }

                  *//*  Node node=elements.get(0).parentNode();
                    Node child=node.childNode(3);
                    for (int i = 0; i < child.childNodeSize(); i++) {

                            if (child.childNode(i).nodeName().equals("p")) {

                                String ssk  = child.childNode(i).outerHtml();
                            }
                    }*//*
                  *//*  for (Element element : elements) {
                        Elements title = element.select("span.info");
                        Log.e("title", title.get(0).text() + "8888888888888");
                        titles = title.get(0).text();
                       // botitle.setText(titles);
                        //h1 = element.select("h1").get(0);
                        //node = h1.parentNode();
                        //node1 = node.childNode(1);
//                        resu = node1.childNode(1).outerHtml();
                       // bodata.setText(resu);
                        //oc.select("meta[name=description]").get(0).attr("content")
                        p = element.select("p[style=\"text-align: center;\"]").get(0);
                        Element  p2 = element.select("p[style=\"text-align: left;\"]").get(0);
                        //String ss = element.select("img").attr("src");
                        //p = element.select("p").get(0);
                        //Element p2 = element.select("p style=\"text-align: center;\"").get(0);
                        //Node node2 = p.parentNode();
                        //Node node3 = node2.childNode(1);
                        //String resu1 = node3.childNode(1).outerHtml();
                 *//**//*
                    node1.childNode(1).toString();
                 node1.childNode(1).nodeName();

                //  node1
                   String sss= node1.attr(null);
                        String kk= BoxiangActivity.this.node1.toString();
                        String name2=h1.data();*//**//*

                        Logger.d("8888888888888" + resu);

                    }*//*
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }).start();
       runOnUiThread(new Runnable() {
           @Override
           public void run() {
               webview.setText(ssk);
           }
       });
=======
import butterknife.ButterKnife;

public class BoxiangActivity extends BaseActivity implements BoContract.BoView {


    private BoContract.BoPresenter boPresenter;
    private Map<String, String> map = new HashMap<>();
    private String id;
    private TextView tvBxcontent,title,soure,time;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
          boPresenter = new BoPresenter(this);
        map.put("id", id);
        map.put("serviceId", "panda");
        boPresenter.mapData(map);
>>>>>>> 8f9ef07eee498361b013049429ce693a316b724e
    }

    @Override
    protected void initView() {
        tvBxcontent = (TextView) findViewById(R.id.tv_bxcontent);
        title = (TextView) findViewById(R.id.tv_bxtitle);
        soure = (TextView) findViewById(R.id.tv_bxsource);
        time = (TextView) findViewById(R.id.tv_bxpubtime);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_boxiang;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }*/
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_boxiang;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(BoContract.BoPresenter boPresente) {
        this.boPresenter = boPresente;
    }

    @Override
    public void getData(BoBean boBean) {
        MyTagHandler myTagHandler = new MyTagHandler(this);
        tvBxcontent.setText(Html.fromHtml(boBean.getContent(), new URLImageParser(tvBxcontent, this), myTagHandler));
        tvBxcontent.setMovementMethod(ScrollingMovementMethod.getInstance());
        title.setText(boBean.getTitle());
        time.setText(boBean.getPubtime());
        soure.setText(boBean.getSource());
    }
}
