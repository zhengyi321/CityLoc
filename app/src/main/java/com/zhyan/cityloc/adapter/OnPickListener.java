package com.zhyan.cityloc.adapter;


import com.zhyan.cityloc.model.City;

public interface OnPickListener {
    void onPick(int position, City data);
    void onLocate();
    void onCancel();
}
