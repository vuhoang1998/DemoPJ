package com.example.hoang.demopj.estate;

import com.example.hoang.demopj.R;

public class Block {
    public int position;

    public static Block[] blocks = new Block[] {
            new House("Casterly Rock",1, 2000, 0, 0, R.id.tv_house_01),
            new House("Winterfell",2, 2000, 0, 0, R.id.tv_house_02),
            new House("Eyrie",4, 2000, 0, 0, R.id.tv_house_03),
            new House("Highgarden",5, 2000, 0, 0, R.id.tv_house_04),
            new House("Harrenhal",7, 2000, 0, 0, R.id.tv_house_05),
            new House("Qarth",8, 2000, 0, 0, R.id.tv_house_06),
            new House("Braavos",10, 2000, 0, 0, R.id.tv_house_07),
            new House("Dragon Stone",11, 2000, 0, 0, R.id.tv_house_08),
            new House("Oldtown",13, 2000, 0, 0, R.id.tv_house_09),
            new House("Moat Cailin",14, 2000, 0, 0, R.id.tv_house_10),
            new House("Valryia",16, 2000, 0, 0, R.id.tv_house_11),
            new House("Bloody Gate",17, 2000, 0, 0, R.id.tv_house_12),
            new House("Storm End",19, 2000, 0, 0, R.id.tv_house_13),
            new House("King Landing",20, 2000, 0, 0, R.id.tv_house_14),
            new House("Riverrun",22, 2000, 0, 0, R.id.tv_house_15),
            new House("Sunspear",23, 2000, 0, 0, R.id.tv_house_16),

            new RandomHouse(3),
            new RandomHouse(9),
            new RandomHouse(15),
            new RandomHouse(21),

            new SpecialHouse(0),
            new SpecialHouse(6),
            new SpecialHouse(12),
            new SpecialHouse(18)
    };

}

