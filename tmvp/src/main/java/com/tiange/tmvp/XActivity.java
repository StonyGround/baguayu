package com.tiange.tmvp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tbruyelle.rxpermissions.RxPermissions;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

/**
 * @CreadBy ：DramaScript
 * @date 2017/3/22
 */
public abstract class XActivity<T extends XPresenter<XBaseView>> extends RxAppCompatActivity
        implements XBase,XBaseView {


    private long mUIThreadId;
    protected String TAG = "";
    protected XPresenter mPresenter;
    protected View mRootView;
    protected int mContentViewId;

    private RxPermissions rxPermissions;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initOncreaterBefore();
        mUIThreadId = android.os.Process.myTid();
        TAG = this.getClass().getSimpleName();
        mPresenter = getPresenter();
        if (mPresenter != null && this instanceof XBaseView) {
            mPresenter.attach((XBaseView) this);
        }
        mRootView = createView(null, null, savedInstanceState);
        setContentView(mRootView);
        bindView(savedInstanceState);
        initOncreaterAfter();
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getClass().isAnnotationPresent(XInject.class)) {
            XInject annotation = getClass()
                    .getAnnotation(XInject.class);
            mContentViewId = annotation.contentViewId();
        }else {
            throw new RuntimeException(
                    "Activity must add annotations of XInitParams.class");
        }
        View view = View.inflate(this,mContentViewId,null);
        ButterKnife.bind(this, view);
        initViews(view);
        return view;
    }

    public  void initOncreaterBefore(){

    }

    public void initOncreaterAfter(){

    }

    protected abstract void initViews(View view);

    protected RxPermissions getRxPermissions(){
        rxPermissions = new RxPermissions(this);
        rxPermissions.setLogging(Config.DEV);
        return rxPermissions;
    }

    @Override
    public View getView() {
        return mRootView;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        mUIThreadId = android.os.Process.myTid();
        super.onNewIntent(intent);
    }

    /**
     * 获取UI线程ID
     *
     * @return UI线程ID
     */
    public long getUIThreadId() {
        return mUIThreadId;
    }


    @Override
    protected void onDestroy() {
        if (mPresenter != null && this instanceof XBaseView) {
            mPresenter.detachView();
            mPresenter = null;
        }
        super.onDestroy();
    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg, View.OnClickListener onClickListener) {

    }

    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener) {

    }

    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener, int imageId) {

    }

    @Override
    public void showNetError(View.OnClickListener onClickListener) {

    }

}
