package com.zhyan.cityloc;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zhyan.cityloc.adapter.OnPickListener;
import com.zhyan.cityloc.model.City;
import com.zhyan.cityloc.model.HotCity;
import com.zhyan.cityloc.model.LocateState;
import com.zhyan.cityloc.model.LocatedCity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Main activity
 */
public class MainActivity extends AppCompatActivity {
    private boolean enable = true;
    private int anim = R.style.DefaultCityPickerAnimation;
    private List<HotCity> hotCities;
    /**
     * B city
     */
    @BindView(R.id.city)
    Button bCity;

    /**
     * City on click
     */
    @OnClick(R.id.city)
    public void cityOnClick(){
        CityPicker.from(MainActivity.this)

                .enableAnimation(enable)

                .setAnimationStyle(anim)

                .setLocatedCity(null)

                .setHotCities(hotCities)

                .setOnPickListener(new OnPickListener() {

                    @Override

                    public void onPick(int position, City data) {



                        Toast.makeText(

                                getApplicationContext(),

                                String.format("点击的数据：%s，%s", data.getName(), data.getCode()),

                                Toast.LENGTH_SHORT)

                                .show();

                    }



                    @Override

                    public void onCancel() {

                        Toast.makeText(getApplicationContext(), "取消选择", Toast.LENGTH_SHORT).show();

                    }



                    @Override

                    public void onLocate() {

                        //开始定位，这里模拟一下定位

                        new Handler().postDelayed(new Runnable() {

                            @Override

                            public void run() {

                                CityPicker.from(MainActivity.this).locateComplete(new LocatedCity("深圳", "广东", "101280601"), LocateState.SUCCESS);

                            }

                        }, 3000);

                    }

                })

                .show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);*/
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        hotCities = new ArrayList<>();

        hotCities.add(new HotCity("北京", "北京", "101010100"));

        hotCities.add(new HotCity("上海", "上海", "101020100"));

        hotCities.add(new HotCity("广州", "广东", "101280101"));

        hotCities.add(new HotCity("深圳", "广东", "101280601"));

        hotCities.add(new HotCity("杭州", "浙江", "101210101"));

        // Example of a call to a native method

    }
}