package com.example.luweicheng.lazyloadfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.luweicheng.lazyloadfragment.fragments.FragmentFirst;
import com.example.luweicheng.lazyloadfragment.fragments.FragmentSecond;
import com.example.luweicheng.lazyloadfragment.fragments.FragmentThree;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.mViewPager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();

    }
    private FragmentFirst F1;
    private FragmentSecond F2;
    private FragmentThree F3;
    private List<Fragment> mList;
    private void initData() {
        mList = new ArrayList<>();
        F1 = new FragmentFirst();
        F2 = new FragmentSecond();
        F3 = new FragmentThree();
        mList.add(F1);
        mList.add(F2);
        mList.add(F3);
        mViewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),mList));
    }


}
