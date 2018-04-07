package com.example.hoang.demopj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;
import java.util.Scanner;

public class PlayActivity extends AppCompatActivity {
    Random rd = new Random();
    Scanner sc = new Scanner(System.in);
    int [][]map = new int[24][3];
    int [][]player = new int[4][3];

    boolean endGame = false;
    int turn = 0;
    int dice;
    int choose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        create();
//        while (!endGame){
//            play();
//            draw();
//            choosePlayer();
//            checkDeath();
//            turn++;
//            if (turn==4){
//                turn = 0;
//            }
//        }
    }

    public float getPosV(int p){
        float v = 0.0f;
        if(player[p][1]>=0&&player[p][1]<=6){
            v = 0.83f;
        } else if (player[p][1]>=12&&player[p][1]<=18){
            v = 0.05f;
        } else if (player[p][1]==7||player[p][1]==23){
            v = 0.68f;
        } else if (player[p][1]==8||player[p][1]==22){
            v = 0.56f;
        } else if (player[p][1]==9||player[p][1]==21){
            v = 0.44f;
        } else if (player[p][1]==10||player[p][1]==20){
            v = 0.32f;
        } else if (player[p][1]==11||player[p][1]==19){
            v = 0.20f;
        }
        return v;
    }
    public float getPosH(int p){
        float h = 0.0f;
        if(player[p][1]>=6&&player[p][1]<=12){
            h = 0.03f;
        } else if (player[p][1]>=18&&player[p][1]<=23) {
            h = 0.49f;
        } else if (player[p][1]==0){
            h = 0.49f;
        } else if (player[p][1]==1||player[p][1]==17){
            h = 0.40f;
        } else if (player[p][1]==2||player[p][1]==16){
            h = 0.33f;
        } else if (player[p][1]==3||player[p][1]==15){
            h = 0.26f;
        } else if (player[p][1]==4||player[p][1]==14){
            h = 0.19f;
        } else if (player[p][1]==5||player[p][1]==13){
            h = 0.12f;
        }
        return h;
    }

    //create
    public void create(){
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
    public void draw(){
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
    void checkDeath(){
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
    public void play(){
        dice = 0;
        dice = rd.nextInt(6)+1;
        dice += rd.nextInt(6)+1;
        player[turn][1] += dice;
        if (player[turn][1]>=20){
            player[turn][0] += 500;
            player[turn][1] -=20;
        }
    }

    public void choosePlayer(){
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