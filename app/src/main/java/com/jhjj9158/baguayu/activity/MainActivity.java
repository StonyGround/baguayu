package com.jhjj9158.baguayu.activity;

import android.os.Bundle;
import android.view.View;

import com.jhjj9158.baguayu.R;
import com.jhjj9158.baguayu.base.BaseActivity;
import com.tiange.tmvp.XPresenter;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initViews(View view) {

    }

    @Override
    protected View getChildView() {
        return null;
    }

    @Override
    public XPresenter getPresenter() {
        return null;
    }

    @Override
    public void bindView(Bundle savedInstanceState) {

    }
}
