package com.zhyan.cityloc.adapter;


import com.zhyan.cityloc.model.City;

public interface InnerListener {
    void dismiss(int position, City data);
    void locate();
}
