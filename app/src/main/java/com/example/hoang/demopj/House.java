package com.example.hoang.demopj;

/**
 * Created by Owner on 4/7/2018.
 */

public class House {
    int posHouse;
    int price;
    int playerOccupy;
    int lvHouse;

    public House(int posHouse, int price, int playerOccupy, int lvHouse, int houseId) {
        this.posHouse = posHouse;
        this.lvHouse = lvHouse;
        this.price = price;
        this.playerOccupy = playerOccupy;
    }

    public static House[] houses = new House[] {
      new House(1, 2000, 0, 0, R.id.tv_house_01),
      new House(1, 2000, 0, 0, R.id.tv_house_02),
      new House(1, 2000, 0, 0, R.id.tv_house_03),
      new House(1, 2000, 0, 0, R.id.tv_house_04),
      new House(1, 2000, 0, 0, R.id.tv_house_05),
      new House(1, 2000, 0, 0, R.id.tv_house_06),
      new House(1, 2000, 0, 0, R.id.tv_house_07),
      new House(1, 2000, 0, 0, R.id.tv_house_08),
      new House(1, 2000, 0, 0, R.id.tv_house_09),
      new House(1, 2000, 0, 0, R.id.tv_house_10),
      new House(1, 2000, 0, 0, R.id.tv_house_11),
      new House(1, 2000, 0, 0, R.id.tv_house_12),
      new House(1, 2000, 0, 0, R.id.tv_house_13),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0)
    };
}
