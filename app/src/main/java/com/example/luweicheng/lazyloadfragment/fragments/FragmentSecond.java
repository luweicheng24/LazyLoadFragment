package com.example.luweicheng.lazyloadfragment.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.luweicheng.lazyloadfragment.R;

/**
 * Created by luweicheng on 2016/12/19.
 */

public class FragmentSecond extends BaseFragment {
    private static final String TAG = "FragmentSecond";
    @Override
    protected void bindView(View convertView) {
        Log.e(TAG, "bindView: 绑定视图" );
    }

    @Override
    protected int getLayoutId() {
        return R.layout.second;
    }

    @Override
    protected void loadData() {
        Log.e(TAG, "loadData:加载数据了");
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: " );
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "onDetach: " );
    }
}
