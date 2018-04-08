package com.example.hoang.demopj.estate;

import com.example.hoang.demopj.Player;

public class RandomHouse extends Block implements SpecialBlock {



    public RandomHouse(String name,int mapPos, int price, int playerOccupy, int lvHouse, int houseId) {
        this.position = mapPos;
        this.lvHouse = lvHouse;
        this.price = price;
        this.playerOccupy = playerOccupy;
        this.houseId = houseId;
        this.name = name;
    }

    @Override
    public void doSpecial(Player player) {

    }

}
