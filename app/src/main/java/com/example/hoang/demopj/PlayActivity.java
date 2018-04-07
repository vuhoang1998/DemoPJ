package com.example.hoang.demopj;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.Guideline;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hoang.demopj.estate.House;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.hoang.demopj.Player.players;


public class PlayActivity extends AppCompatActivity {
    Random random = new Random();
    boolean endGame = false;
    int turn = 0;
    int dice1 = 0;
    int dice2 = 0;
    int dice = 0;
    int choose;
    @BindView(R.id.iv_dice_1st)
    ImageView ivDice1st;
    @BindView(R.id.iv_dice_2nd)
    ImageView ivDice2nd;
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
    @BindView(R.id.bt_roll)
    Button btRoll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);
        create();
    }

    @Override
    protected void onStart() {
        super.onStart();
        while (!endGame) {
//            roll();
////            draw();
////            choosePlayer();
////            checkDeath();
////            turn++;
////            if (turn==4){
////                turn = 0;
////            }
            endGame = true;
        }
    }

    //getPosV
    public float getPosV(int p) {
        float v = 0.0f;
        if (players[p].posPlayer >= 0 && players[p].posPlayer <= 6) {
            v = 0.83f;
        } else if (players[p].posPlayer >= 12 && players[p].posPlayer <= 18) {
            v = 0.05f;
        } else if (players[p].posPlayer == 7 || players[p].posPlayer == 23) {
            v = 0.68f;
        } else if (players[p].posPlayer == 8 || players[p].posPlayer == 22) {
            v = 0.56f;
        } else if (players[p].posPlayer == 9 || players[p].posPlayer == 21) {
            v = 0.44f;
        } else if (players[p].posPlayer == 10 || players[p].posPlayer == 20) {
            v = 0.32f;
        } else if (players[p].posPlayer == 11 || players[p].posPlayer == 19) {
            v = 0.20f;
        }
        return v;
    }
    //getPosH
    public float getPosH(int p) {
        float h = 0.0f;
        if (players[p].posPlayer >= 6 && players[p].posPlayer <= 12) {
            h = 0.03f;
        } else if (players[p].posPlayer >= 18 && players[p].posPlayer <= 23) {
            h = 0.49f;
        } else if (players[p].posPlayer == 0) {
            h = 0.49f;
        } else if (players[p].posPlayer == 1 || players[p].posPlayer == 17) {
            h = 0.40f;
        } else if (players[p].posPlayer == 2 || players[p].posPlayer == 16) {
            h = 0.33f;
        } else if (players[p].posPlayer == 3 || players[p].posPlayer == 15) {
            h = 0.26f;
        } else if (players[p].posPlayer == 4 || players[p].posPlayer == 14) {
            h = 0.19f;
        } else if (players[p].posPlayer == 5 || players[p].posPlayer == 13) {
            h = 0.12f;
        }
        return h;
    }

    //create
    public void create() {
        //create house price
        for (House house : House.houses) {
            house.price = (random.nextInt(5) + 5) * 100;
        }
    }
    //roll
    public void roll() {
        dice1 = random.nextInt(6) + 1;
        dice2 = random.nextInt(6) + 1;
        if(dice1==1){
            ivDice1st.setImageResource(R.drawable.diceone);
        } else if (dice1==2){
            ivDice1st.setImageResource(R.drawable.dicetwo);
        } else if (dice1==3){
            ivDice1st.setImageResource(R.drawable.dicethree);
        } else if (dice1==4){
            ivDice1st.setImageResource(R.drawable.dicefour);
        } else if (dice1==5){
            ivDice1st.setImageResource(R.drawable.dicefive);
        } else if (dice1==6){
            ivDice1st.setImageResource(R.drawable.dicesix);
        }
        if(dice2==1){
            ivDice2nd.setImageResource(R.drawable.diceone);
        } else if (dice2==2){
            ivDice2nd.setImageResource(R.drawable.dicetwo);
        } else if (dice2==3){
            ivDice2nd.setImageResource(R.drawable.dicethree);
        } else if (dice2==4){
            ivDice2nd.setImageResource(R.drawable.dicefour);
        } else if (dice2==5){
            ivDice2nd.setImageResource(R.drawable.dicefive);
        } else if (dice2==6){
            ivDice2nd.setImageResource(R.drawable.dicesix);
        }
    }
    @OnClick(R.id.bt_roll)
    public void onViewClicked() {
        roll();
    }
    //check death
    void checkAlive() {
        int countDeath = 0;
        for (int i = 0; i < 4; i++) {
            if (players[i].alive == false) {
                countDeath++;
            }
        }
        if (countDeath >= 2) {
            endGame = true;
        }
        for (int i = 0; i < 4; i++) {
            if (players[i].money <= 0) {
                players[i].alive = false;
            }
        }
    }
//    public void choosePlayer() {
//        if (player[turn][1] != 0 && player[turn][1] != 12 && player[turn][1] != 18 && player[turn][1] != 6) {
//            if (map[player[turn][1]][1] == 0) {
//                System.out.println("You choose: 1.Occupy  2.Ignore");
//                choose = sc.nextInt();
//                if (choose == 1) {
//                    map[player[turn][1]][1] = turn + 1;
//                    player[turn][0] -= map[player[turn][1]][0];
//                }
//            } else if (map[player[turn][1]][1] == turn + 1) {
//                System.out.println("You choose: 1.Building  2.Ignore");
//                choose = sc.nextInt();
//                if (choose == 1) {
//                    player[turn][0] -= map[player[turn][1]][0];
//                    map[player[turn][1]][2] += 1;
//                }
//            } else {
//                int lost = (map[player[turn][1]][0] + map[player[turn][1]][0] * map[player[turn][1]][2]) / 5;
//                System.out.println("Player " + (turn + 1) + " lost: " + lost);
//                System.out.println("Player " + (map[player[turn][1]][1]) + " raise: " + lost);
//
//                player[turn][0] = player[turn][0] - lost;
//                player[map[player[turn][1]][1] - 1][0] = player[map[player[turn][1]][1] - 1][0] + lost;
//            }
//        }
//    }

    public void onClick(View view) {
        for (House house : House.houses) {
            if (house.houseId == view.getId()) {
                showInfo(house);
            }
        }
    }

    private void showInfo(House house) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("GameConsole");
        builder.setMessage("house number" + house.mapPos);
        builder.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(PlayActivity.this, "purchased", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Nein", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(PlayActivity.this, "Heil hilter", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

}