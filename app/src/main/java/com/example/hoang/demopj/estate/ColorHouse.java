package com.example.hoang.demopj.estate;

import com.example.hoang.demopj.R;

/**
 * Created by Owner on 4/8/2018.
 */

public class ColorHouse {
    public int posHouse;
    public int posHouseID;

    public ColorHouse(int posHouse, int posHouseID) {
        this.posHouse = posHouse;
        this.posHouseID = posHouseID;
    }

    public static ColorHouse[] colorHouses = new ColorHouse[] {
            new ColorHouse(0,R.id.tv_demo),
            new ColorHouse(1,R.id.tv_color_01),
            new ColorHouse(2,R.id.tv_color_02),
            new ColorHouse(3,R.id.tv_demo),
            new ColorHouse(4,R.id.tv_color_04),
            new ColorHouse(5,R.id.tv_color_05),
            new ColorHouse(6,R.id.tv_demo),
            new ColorHouse(7,R.id.tv_color_07),
            new ColorHouse(8,R.id.tv_color_08),
            new ColorHouse(9,R.id.tv_demo),
            new ColorHouse(10,R.id.tv_color_10),
            new ColorHouse(11,R.id.tv_color_11),
            new ColorHouse(12,R.id.tv_demo),
            new ColorHouse(13,R.id.tv_color_13),
            new ColorHouse(14,R.id.tv_color_14),
            new ColorHouse(15,R.id.tv_demo),
            new ColorHouse(16,R.id.tv_color_16),
            new ColorHouse(17,R.id.tv_color_17),
            new ColorHouse(18,R.id.tv_demo),
            new ColorHouse(19,R.id.tv_color_19),
            new ColorHouse(20,R.id.tv_color_20),
            new ColorHouse(21,R.id.tv_demo),
            new ColorHouse(22,R.id.tv_color_22),
            new ColorHouse(23,R.id.tv_color_23)
    };
}
