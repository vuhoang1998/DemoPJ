package com.example.hoang.demopj.estate;

import com.example.hoang.demopj.R;

import java.util.Random;

/**
 * Created by Owner on 4/7/2018.
 */

public class House extends Block {
    String name;
    public int price;
    public int playerOccupy;
    public int lvHouse;
    public int houseId;

    public House(String name,int mapPos, int price, int playerOccupy, int lvHouse, int houseId) {
        this.position = mapPos;
        this.lvHouse = lvHouse;
        this.price = price;
        this.playerOccupy = playerOccupy;
        this.houseId = houseId;
        this.name = name;
    }

}
