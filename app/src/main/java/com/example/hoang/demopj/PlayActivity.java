package com.example.hoang.demopj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;
import java.util.Scanner;

public class PlayActivity extends AppCompatActivity {
    static Random rd = new Random();
    static Scanner sc = new Scanner(System.in);
    static int [][]map = new int[24][3];
    static int [][]player = new int[4][3];

    static boolean endGame = false;
    static int turn = 0;
    static int dice;
    static int choose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }
    @Override
    protected void onStart() {
        super.onStart();
        create();
        while (!endGame){
            play();
            draw();
            choosePlayer();
            checkDeath();
            turn++;
            if (turn==4){
                turn = 0;
            }
        }
    }
    //create
    public static void create(){
        for (int i = 0 ; i < 24 ; i++){
            map[i][0] = (rd.nextInt(5)+5)*100; // money
            map[i][1] = 0; // player occupy
            map[i][2] = 0; // player building
        }
        for (int i = 0 ; i < 4 ; i++){
            player[i][0] = 3000; //money
            player[i][1] = 0; //pos
            player[i][2] = 1; //death
        }
    }
    //draw
    public static void draw(){
        // draw money
        for (int i = 0 ; i < 24 ; i++) {
            if (i == 0||i == 12||i==6||i==18){
                System.out.print("|0000000|");
            } else {
                System.out.print("|--"+map[i][0]+"--|");
            }
        }
        System.out.println();
        // draw player occupy
        for (int i = 0 ; i < 24 ; i++) {
            if (i == 0||i == 12||i==6||i==18){
                System.out.print("|0000000|");
            } else {
                System.out.print("|---"+map[i][1]+"---|");
            }
        }
        System.out.println();
        // draw player building
        for (int i = 0 ; i < 24 ; i++) {
            if (i == 0||i == 12||i==6||i==18){
                System.out.print("|0000000|");
            } else {
                System.out.print("|---"+map[i][2]+"---|");
            }
        }
        System.out.println();
        // draw pos player 01
        if (player[0][2]==1){
            for (int i = 0 ; i < 24 ; i++) {
                if(i==player[0][1]){
                    System.out.print("|---1---|");
                } else {
                    System.out.print("|-------|");
                }
            }
            System.out.println();
        }
        // draw pos player 02
        if (player[1][2]==1){
            for (int i = 0 ; i < 24 ; i++) {
                if(i==player[1][1]){
                    System.out.print("|---2---|");
                } else {
                    System.out.print("|-------|");
                }
            }
            System.out.println();
        }// draw pos player 03
        if (player[2][2]==1){
            for (int i = 0 ; i < 24 ; i++) {
                if(i==player[2][1]){
                    System.out.print("|---3---|");
                } else {
                    System.out.print("|-------|");
                }
            }
            System.out.println();
        }// draw pos player 04
        if (player[3][2]==1){
            for (int i = 0 ; i < 24 ; i++) {
                if(i==player[3][1]){
                    System.out.print("|---4---|");
                } else {
                    System.out.print("|-------|");
                }
            }
            System.out.println();
        }


        System.out.print("Player 1: "+player[0][0]);
        System.out.print(" | Player 2: "+player[1][0]);
        System.out.print(" | Player 3: "+player[2][0]);
        System.out.print(" | Player 4: "+player[3][0]);
        System.out.println();

        System.out.print("Turn: Player "+(turn+1));
        System.out.println(" | Dice: "+dice);
    }
    //check death
    static void checkDeath(){
        int countDeath = 0;
        for (int i = 0 ; i <4 ; i++){
            if(player[i][2]==0){
                countDeath++;
            }
        }
        if (countDeath >=2){
            endGame = true;
        }
        for (int i = 0 ; i < 4 ; i++){
            if (player[i][0]<=0){
                player[i][2] = 0;
            }
        }
    }
    //logic
    public static void play(){
        dice = 0;
        dice = rd.nextInt(6)+1;
        dice += rd.nextInt(6)+1;
        player[turn][1] += dice;
        if (player[turn][1]>=20){
            player[turn][0] += 500;
            player[turn][1] -=20;
        }
    }

    public static void choosePlayer(){
        if (player[turn][1]!=0&&player[turn][1]!=12&&player[turn][1]!=18&&player[turn][1]!=6){
            if (map[player[turn][1]][1]==0){
                System.out.println("You choose: 1.Occupy  2.Ignore");
                choose = sc.nextInt();
                if(choose ==1){
                    map[player[turn][1]][1] = turn+1;
                    player[turn][0] -= map[player[turn][1]][0];
                }
            } else if(map[player[turn][1]][1]==turn+1){
                System.out.println("You choose: 1.Building  2.Ignore");
                choose = sc.nextInt();
                if(choose ==1){
                    player[turn][0] -= map[player[turn][1]][0];
                    map[player[turn][1]][2] += 1;
                }
            } else {
                int lost = (map[player[turn][1]][0]+map[player[turn][1]][0]*map[player[turn][1]][2])/5;
                System.out.println("Player "+(turn+1)+" lost: "+lost);
                System.out.println("Player "+(map[player[turn][1]][1])+" raise: "+lost);

                player[turn][0] = player[turn][0] - lost ;
                player[map[player[turn][1]][1]-1][0] = player[map[player[turn][1]][1]-1][0] + lost;
            }
        }
    }
}