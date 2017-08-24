package com.jhjj9158.baguayu.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jhjj9158.baguayu.R;
import com.tiange.tmvp.XActivity;
import com.tiange.tmvp.XPresenter;

public abstract class BaseActivity extends XActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    protected abstract View getChildView();
}
