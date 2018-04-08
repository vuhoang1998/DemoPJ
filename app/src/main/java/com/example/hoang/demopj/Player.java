package com.example.hoang.demopj;


/**
 * Created by Owner on 4/7/2018.
 */

public class Player {
    int money;
    int posPlayer;
    boolean isJail;
    boolean alive;
    int playerID;
    public String name;

    public Player(String name, int money, int posPlayer, boolean isJail, boolean alive, int playerID) {
        this.alive = alive;
        this.money = money;
        this.posPlayer = posPlayer;
        this.isJail = isJail;
        this.playerID = playerID;
        this.name = name;
    }

    public static Player[] players;
}
