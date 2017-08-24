package com.jhjj9158.baguayu.observer;


import com.jhjj9158.baguayu.bean.NetworkType;

/**
 * Created by oneki on 2017/5/17.
 */

public interface NetStateChangeObserver {

    void onNetDisconnected();

    void onNetConnected(NetworkType networkType);
}
