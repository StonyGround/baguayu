package com.tiange.tmvp;

import android.view.View;

/**
 * @CreadBy ：DramaScript
 * @date 2017/3/22
 */
public interface XBaseView {

    void showLoading(String msg);

    void hideLoading();

    void showError(String msg, View.OnClickListener onClickListener);

    void showEmpty(String msg, View.OnClickListener onClickListener);

    void showEmpty(String msg, View.OnClickListener onClickListener, int imageId);

    void showNetError(View.OnClickListener onClickListener);
}
