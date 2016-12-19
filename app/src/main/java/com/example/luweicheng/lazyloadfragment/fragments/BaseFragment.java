package com.example.luweicheng.lazyloadfragment.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by luweicheng on 2016/12/19.
 * 懒加载fragment基类
 */

public abstract class BaseFragment extends Fragment {
    private static final String TAG = "BaseFragment";
    private Boolean isVisible = false;//是否可见
    private Boolean isCreateView = false;//是否UI创建完成
    private Boolean isFirstLoad= true;//是否是第一次加载
    private View convertView;  //fragment根View
    private SparseArray<View> mViews;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        convertView = inflater.inflate(getLayoutId(),null);
        mViews = new SparseArray<>();
        bindView(convertView);
        isCreateView = true;
        return convertView;
    }

    /**
     * 绑定控件监听等操作
     */
    protected abstract void bindView(View convertView);

    /**
     * 返回布局id
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 加载数据操作
     *
     */
    protected abstract void loadData();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            isVisible = true;

        }else{
            isVisible = false;
            return;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        lazyLoadData();
    }

    /**
     * 判断是否加载数据
     */
    private void lazyLoadData(){
     if(isFirstLoad){
         Log.e(TAG, "lazyLoadDta:第一次加载" );
     }else{
         Log.e(TAG, "lazyLoadDta: 不是第一次加载" );
     }
        Log.e(TAG, "lazyLoadData: "+isFirstLoad+isVisible+isCreateView );
    if(!isFirstLoad||!isCreateView||!isVisible){
        Log.e(TAG, "lazyLoadDta: 不加载" );
        return;
    }
        Log.e(TAG, "lazyLoadDta: 完成数据的第一次加载" );
        loadData();
        isFirstLoad = false;
    }

}
