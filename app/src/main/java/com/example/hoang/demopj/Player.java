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

    public Player(int money, int posPlayer,boolean isJail, boolean alive, int playerID){
        this.alive = alive;
        this.money = money;
        this.posPlayer = posPlayer;
        this.isJail = isJail;
        this.playerID = playerID;
    }

    public static Player[]players = new Player[]{
            new Player(3000,0,false,true,R.id.iv_pl_1),
            new Player(3000,0,false,true,R.id.iv_pl_2),
            new Player(3000,0,false,true,R.id.iv_pl_3),
            new Player(3000,0,false,true,R.id.iv_pl_4)
    };
}
