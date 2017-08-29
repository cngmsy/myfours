package com.jiyun.qcloud.dashixummoban.ui.observation.bobaoxiang;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;

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
    }

    @Override
    protected void initView() {

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
}
