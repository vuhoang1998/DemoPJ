package com.example.hoang.demopj;

/**
 * Created by Owner on 4/7/2018.
 */

public class Player {
    int money;
    int posPlayer;
    boolean isJail;
    boolean alive;

    public Player(int money, int posPlayer,boolean isJail, boolean alive){
        this.alive = alive;
        this.money = money;
        this.posPlayer = posPlayer;
        this.isJail = isJail;
    }

    public static Player[]players = new Player[]{
            new Player(3000,0,false,true),
            new Player(3000,0,false,true),
            new Player(3000,0,false,true),
            new Player(3000,0,false,true)
    };
}
