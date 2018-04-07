package com.example.hoang.demopj;

/**
 * Created by Owner on 4/7/2018.
 */

public class Player {
    int money;
    int posPlayer;
    boolean alive;

    public Player(int money, int posPlayer, boolean alive){
        this.alive = alive;
        this.money = money;
        this.posPlayer = posPlayer;
    }
}
