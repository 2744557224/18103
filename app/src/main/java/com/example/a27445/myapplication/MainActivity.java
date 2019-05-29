package com.example.a27445.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import Bean.Data;
import adapter.RlvAdapter;
import ivew.Ivew;
import presenter.Persenter;
//葛英杰   1810
public class MainActivity extends AppCompatActivity implements Ivew {

    private RecyclerView mRlv;
    private RlvAdapter rlvAdapter;
    private ArrayList<Data.ResultsEntity> resultsEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initMvp();
    }

    private void initMvp() {
        Persenter persenter = new Persenter(this);
        persenter.p_datapresenter();
    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.rlv);

        rlvAdapter = new RlvAdapter(this);
        mRlv.setAdapter(rlvAdapter);

        resultsEntities = new ArrayList<>();

        mRlv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        rlvAdapter.setOnClier(new RlvAdapter.onClier() {
            @Override
            public void getOnClier(int i) {
                String url = resultsEntities.get(i).getUrl();
                int size = resultsEntities.size();
                Intent intent = new Intent(MainActivity.this,Main2Activity_viewpage.class);
                intent.putExtra("url",url);
                intent.putExtra("size",size+"");
                intent.putExtra("i",i+"");
                startActivity(intent);
                Mass mass = new Mass();
                mass.setList(resultsEntities);
                EventBus.getDefault().postSticky(mass);
            }
        });
    }

    @Override
    public void v_datalist(ArrayList<Data.ResultsEntity> arrayList) {
        resultsEntities.addAll(arrayList);
        rlvAdapter.setArrayList(resultsEntities);
    }
}
