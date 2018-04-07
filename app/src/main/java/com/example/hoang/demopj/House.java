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
      new House(1, 2000, 0, 0, R.id.textView3),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0),
      new House(1, 2000, 0, 0)
    };
}
