package com.example.hoang.demopj;

import android.os.Bundle;
import android.support.constraint.Guideline;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;
import java.util.Scanner;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PlayActivity extends AppCompatActivity {
    Random rd = new Random();
    Scanner sc = new Scanner(System.in);
    House[] house = new House[24];
    Player[] player = new Player[4];

    boolean endGame = false;
    int turn = 0;
    int dice1 = 0;
    int dice2 = 0;
    int dice = 0;
    int choose;
    @BindView(R.id.tv_name_11)
    TextView tvName11;
    @BindView(R.id.tv_name_10)
    TextView tvName10;
    @BindView(R.id.tv_name_09)
    TextView tvName09;
    @BindView(R.id.tv_name_08)
    TextView tvName08;
    @BindView(R.id.tv_name_07)
    TextView tvName07;
    @BindView(R.id.tv_06)
    TextView tv06;
    @BindView(R.id.tv_name_05)
    TextView tvName05;
    @BindView(R.id.tv_name_04)
    TextView tvName04;
    @BindView(R.id.tv_name_03)
    TextView tvName03;
    @BindView(R.id.tv_name_02)
    TextView tvName02;
    @BindView(R.id.tv_name_01)
    TextView tvName01;
    @BindView(R.id.tv_00)
    TextView tv00;
    @BindView(R.id.tv_name_23)
    TextView tvName23;
    @BindView(R.id.tv_name_22)
    TextView tvName22;
    @BindView(R.id.tv_name_21)
    TextView tvName21;
    @BindView(R.id.tv_name_20)
    TextView tvName20;
    @BindView(R.id.tv_name_19)
    TextView tvName19;
    @BindView(R.id.tv_18)
    TextView tv18;
    @BindView(R.id.tv_name_13)
    TextView tvName13;
    @BindView(R.id.tv_name_14)
    TextView tvName14;
    @BindView(R.id.tv_name_15)
    TextView tvName15;
    @BindView(R.id.tv_name_16)
    TextView tvName16;
    @BindView(R.id.tv_name_17)
    TextView tvName17;
    @BindView(R.id.tv_color_13)
    TextView tvColor13;
    @BindView(R.id.tv_color_14)
    TextView tvColor14;
    @BindView(R.id.tv_color_16)
    TextView tvColor16;
    @BindView(R.id.tv_color_17)
    TextView tvColor17;
    @BindView(R.id.tv_color_19)
    TextView tvColor19;
    @BindView(R.id.tv_color_20)
    TextView tvColor20;
    @BindView(R.id.tv_color_22)
    TextView tvColor22;
    @BindView(R.id.tv_color_23)
    TextView tvColor23;
    @BindView(R.id.tv_color_08)
    TextView tvColor08;
    @BindView(R.id.tv_color_07)
    TextView tvColor07;
    @BindView(R.id.tv_color_10)
    TextView tvColor10;
    @BindView(R.id.tv_color_11)
    TextView tvColor11;
    @BindView(R.id.tv_mono)
    TextView tvMono;
    @BindView(R.id.tv_color_05)
    TextView tvColor05;
    @BindView(R.id.tv_color_04)
    TextView tvColor04;
    @BindView(R.id.tv_color_01)
    TextView tvColor01;
    @BindView(R.id.tv_color_02)
    TextView tvColor02;
    @BindView(R.id.gl_h_65)
    Guideline glH65;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.gl_v_59)
    Guideline glV59;
    @BindView(R.id.linearLayout3)
    LinearLayout linearLayout3;
    @BindView(R.id.gl_v_29)
    Guideline glV29;
    @BindView(R.id.linearLayout2)
    LinearLayout linearLayout2;
    @BindView(R.id.gl_v_74)
    Guideline glV74;
    @BindView(R.id.linearLayout4)
    LinearLayout linearLayout4;
    @BindView(R.id.gl_v_89)
    Guideline glV89;
    @BindView(R.id.linearLayout5)
    LinearLayout linearLayout5;
    @BindView(R.id.iv_name_pl1)
    ImageView ivNamePl1;
    @BindView(R.id.iv_name_pl2)
    ImageView ivNamePl2;
    @BindView(R.id.iv_name_pl3)
    ImageView ivNamePl3;
    @BindView(R.id.iv_name_pl4)
    ImageView ivNamePl4;
    @BindView(R.id.tv_name_pl1)
    TextView tvNamePl1;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.textView7)
    TextView textView7;
    @BindView(R.id.textView8)
    TextView textView8;
    @BindView(R.id.textView9)
    TextView textView9;
    @BindView(R.id.guideline7)
    Guideline guideline7;
    @BindView(R.id.iv_dice_1st)
    ImageView ivDice1st;
    @BindView(R.id.iv_dice_2nd)
    ImageView imageView8;
    @BindView(R.id.iv_arrow_pl1)
    ImageView imageView9;
    @BindView(R.id.iv_arrow_pl2)
    ImageView imageView10;
    @BindView(R.id.iv_arrow_pl3)
    ImageView imageView11;
    @BindView(R.id.iv_arrow_pl4)
    ImageView imageView13;
    @BindView(R.id.gl_h_player01)
    Guideline glHPlayer01;
    @BindView(R.id.gl_v_player01)
    Guideline glVPlayer01;
    @BindView(R.id.gl_h_player02)
    Guideline glHPlayer02;
    @BindView(R.id.gl_v_player02)
    Guideline glVPlayer02;
    @BindView(R.id.gl_h_player03)
    Guideline glHPlayer03;
    @BindView(R.id.gl_v_player03)
    Guideline glVPlayer03;
    @BindView(R.id.gl_h_player04)
    Guideline glHPlayer04;
    @BindView(R.id.gl_v_player04)
    Guideline glVPlayer04;
    @BindView(R.id.iv_pl_1)
    ImageView ivPl1;
    @BindView(R.id.iv_pl_2)
    ImageView ivPl2;
    @BindView(R.id.iv_pl_3)
    ImageView ivPl3;
    @BindView(R.id.iv_pl_4)
    ImageView ivPl4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        create();
        while (!endGame) {
            play();
//            draw();
//            choosePlayer();
//            checkDeath();
//            turn++;
//            if (turn==4){
//                turn = 0;
//            }
            endGame = true;
        }
    }

    //getPosV
    public float getPosV(int p) {
        float v = 0.0f;
        if (player[p].posPlayer >= 0 && player[p].posPlayer <= 6) {
            v = 0.83f;
        } else if (player[p].posPlayer >= 12 && player[p].posPlayer <= 18) {
            v = 0.05f;
        } else if (player[p].posPlayer == 7 || player[p].posPlayer == 23) {
            v = 0.68f;
        } else if (player[p].posPlayer == 8 || player[p].posPlayer == 22) {
            v = 0.56f;
        } else if (player[p].posPlayer == 9 || player[p].posPlayer == 21) {
            v = 0.44f;
        } else if (player[p].posPlayer == 10 || player[p].posPlayer == 20) {
            v = 0.32f;
        } else if (player[p].posPlayer == 11 || player[p].posPlayer == 19) {
            v = 0.20f;
        }
        return v;
    }

    //getPosH
    public float getPosH(int p) {
        float h = 0.0f;
        if (player[p].posPlayer >= 6 && player[p].posPlayer <= 12) {
            h = 0.03f;
        } else if (player[p].posPlayer >= 18 && player[p].posPlayer <= 23) {
            h = 0.49f;
        } else if (player[p].posPlayer == 0) {
            h = 0.49f;
        } else if (player[p].posPlayer == 1 || player[p].posPlayer == 17) {
            h = 0.40f;
        } else if (player[p].posPlayer == 2 || player[p].posPlayer == 16) {
            h = 0.33f;
        } else if (player[p].posPlayer == 3 || player[p].posPlayer == 15) {
            h = 0.26f;
        } else if (player[p].posPlayer == 4 || player[p].posPlayer == 14) {
            h = 0.19f;
        } else if (player[p].posPlayer == 5 || player[p].posPlayer == 13) {
            h = 0.12f;
        }
        return h;
    }

    //create
    public void create() {
        for (int i = 0; i < 24; i++) {
            house[i].price = (rd.nextInt(5) + 5) * 100; // money
            house[i].playerOccupy = 0; // player occupy
            house[i].lvHouse = 0; // player building
        }
        for (int i = 0; i < 4; i++) {
            player[i].money = 3000; //money
            player[i].posPlayer = 0; //pos
            player[i].alive = true; //death
        }
    }

    //dive
    public void dive() {

    }

    //draw
    public void draw() {
        // draw money
        for (int i = 0; i < 24; i++) {
            if (i == 0 || i == 12 || i == 6 || i == 18) {
                System.out.print("|0000000|");
            } else {
                System.out.print("|--" + map[i][0] + "--|");
            }
        }
        System.out.println();
        // draw player occupy
        for (int i = 0; i < 24; i++) {
            if (i == 0 || i == 12 || i == 6 || i == 18) {
                System.out.print("|0000000|");
            } else {
                System.out.print("|---" + map[i][1] + "---|");
            }
        }
        System.out.println();
        // draw player building
        for (int i = 0; i < 24; i++) {
            if (i == 0 || i == 12 || i == 6 || i == 18) {
                System.out.print("|0000000|");
            } else {
                System.out.print("|---" + map[i][2] + "---|");
            }
        }
        System.out.println();
        // draw pos player 01
        if (player[0][2] == 1) {
            for (int i = 0; i < 24; i++) {
                if (i == player[0][1]) {
                    System.out.print("|---1---|");
                } else {
                    System.out.print("|-------|");
                }
            }
            System.out.println();
        }
        // draw pos player 02
        if (player[1][2] == 1) {
            for (int i = 0; i < 24; i++) {
                if (i == player[1][1]) {
                    System.out.print("|---2---|");
                } else {
                    System.out.print("|-------|");
                }
            }
            System.out.println();
        }// draw pos player 03
        if (player[2][2] == 1) {
            for (int i = 0; i < 24; i++) {
                if (i == player[2][1]) {
                    System.out.print("|---3---|");
                } else {
                    System.out.print("|-------|");
                }
            }
            System.out.println();
        }// draw pos player 04
        if (player[3][2] == 1) {
            for (int i = 0; i < 24; i++) {
                if (i == player[3][1]) {
                    System.out.print("|---4---|");
                } else {
                    System.out.print("|-------|");
                }
            }
            System.out.println();
        }


        System.out.print("Player 1: " + player[0][0]);
        System.out.print(" | Player 2: " + player[1][0]);
        System.out.print(" | Player 3: " + player[2][0]);
        System.out.print(" | Player 4: " + player[3][0]);
        System.out.println();

        System.out.print("Turn: Player " + (turn + 1));
        System.out.println(" | Dice: " + dice);
    }

    //check death
    void checkDeath() {
        int countDeath = 0;
        for (int i = 0; i < 4; i++) {
            if (player[i][2] == 0) {
                countDeath++;
            }
        }
        if (countDeath >= 2) {
            endGame = true;
        }
        for (int i = 0; i < 4; i++) {
            if (player[i][0] <= 0) {
                player[i][2] = 0;
            }
        }
    }

    //logic
    public void play() {
        dice = rd.nextInt(6) + 1;
        dice += rd.nextInt(6) + 1;
        player[turn][1] += dice;
        if (player[turn][1] >= 20) {
            player[turn][0] += 500;
            player[turn][1] -= 20;
        }
    }

    public void choosePlayer() {
        if (player[turn][1] != 0 && player[turn][1] != 12 && player[turn][1] != 18 && player[turn][1] != 6) {
            if (map[player[turn][1]][1] == 0) {
                System.out.println("You choose: 1.Occupy  2.Ignore");
                choose = sc.nextInt();
                if (choose == 1) {
                    map[player[turn][1]][1] = turn + 1;
                    player[turn][0] -= map[player[turn][1]][0];
                }
            } else if (map[player[turn][1]][1] == turn + 1) {
                System.out.println("You choose: 1.Building  2.Ignore");
                choose = sc.nextInt();
                if (choose == 1) {
                    player[turn][0] -= map[player[turn][1]][0];
                    map[player[turn][1]][2] += 1;
                }
            } else {
                int lost = (map[player[turn][1]][0] + map[player[turn][1]][0] * map[player[turn][1]][2]) / 5;
                System.out.println("Player " + (turn + 1) + " lost: " + lost);
                System.out.println("Player " + (map[player[turn][1]][1]) + " raise: " + lost);

                player[turn][0] = player[turn][0] - lost;
                player[map[player[turn][1]][1] - 1][0] = player[map[player[turn][1]][1] - 1][0] + lost;
            }
        }
    }
}