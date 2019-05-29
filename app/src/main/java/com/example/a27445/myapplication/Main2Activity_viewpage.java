package com.example.a27445.myapplication;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import Bean.Data;
import adapter.Viewpages;

public class Main2Activity_viewpage extends AppCompatActivity {

    private ViewPager mVp;
    private ArrayList<Data.ResultsEntity> list;
    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_viewpage);
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView() {
        List<View> views = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            View inflate = LayoutInflater.from(Main2Activity_viewpage.this).inflate(R.layout.layout_image, null);
            ImageView iv = inflate.findViewById(R.id.image);
            tv1 = inflate.findViewById(R.id.tv1);
            tv1.setText("第"+i+"张图片");
            Glide.with(Main2Activity_viewpage.this).load(list.get(i).getUrl()).into(iv);
            views.add(inflate);
        }


        mVp = (ViewPager) findViewById(R.id.vp);

        Viewpages viewpages = new Viewpages((ArrayList<View>) views);
        mVp.setAdapter(viewpages);

    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void A(Mass mass) {
        list = mass.getList(mass);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
