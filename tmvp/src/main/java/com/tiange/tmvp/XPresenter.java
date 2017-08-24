package com.tiange.tmvp;

/**
 * @CreadBy ：DramaScript
 * @date 2017/3/22
 */
public abstract class XPresenter<T extends XBaseView> {

    public T mView;

    //做绑定view的操作
    public void attach(T mView) {
        this.mView = mView;
    }

    //做分离view的操作
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }
}
