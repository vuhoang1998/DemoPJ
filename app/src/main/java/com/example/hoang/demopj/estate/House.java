package com.example.hoang.demopj.estate;

import com.example.hoang.demopj.R;

import java.util.Random;

/**
 * Created by Owner on 4/7/2018.
 */

public class House {
    int posHouse;
    int price;
    int playerOccupy;
    int lvHouse;
    int houseId;

    private Random random = new Random();

    public House(String name,int posHouse, int price, int playerOccupy, int lvHouse, int houseId) {
        this.posHouse = posHouse;
        this.lvHouse = lvHouse;
        this.price = price;
        this.playerOccupy = playerOccupy;
        this.houseId = houseId;
    }

    public static House[] houses = new House[] {
            new House("Casterly Rock",1, 2000, 0, 0, R.id.tv_house_01),
            new House("Winterfell",2, 2000, 0, 0, R.id.tv_house_02),
            new House("Eyrie",3, 2000, 0, 0, R.id.tv_house_03),
            new House("Highgarden",4, 2000, 0, 0, R.id.tv_house_04),
            new House("Harrenhal",5, 2000, 0, 0, R.id.tv_house_05),
            new House("Qarth",6, 2000, 0, 0, R.id.tv_house_06),
            new House("Braavos",7, 2000, 0, 0, R.id.tv_house_07),
            new House("Dragon Stone",8, 2000, 0, 0, R.id.tv_house_08),
            new House("Oldtown",9, 2000, 0, 0, R.id.tv_house_09),
            new House("Moat Cailin",10, 2000, 0, 0, R.id.tv_house_10),
            new House("Valryia",11, 2000, 0, 0, R.id.tv_house_11),
            new House("Bloody Gate",12, 2000, 0, 0, R.id.tv_house_12),
            new House("Storm End",13, 2000, 0, 0, R.id.tv_house_13),
            new House("King Landing",14, 2000, 0, 0, R.id.tv_house_14),
            new House("Riverrun",15, 2000, 0, 0, R.id.tv_house_15),
            new House("Sunspear",16, 2000, 0, 0, R.id.tv_house_16)
    };
}
