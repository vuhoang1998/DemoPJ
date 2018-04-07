package com.example.hoang.demopj;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.hoang.demopj.estate.House;

import java.util.Random;

import butterknife.ButterKnife;


public class PlayActivity extends AppCompatActivity {
    Random random = new Random();
    Player[] player = new Player[4];

    boolean endGame = false;
    int turn = 0;
    int dice1 = 0;
    int dice2 = 0;
    int dice = 0;
    int choose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // create();
//        while (!endGame) {
//            roll();
////            draw();
////            choosePlayer();
////            checkDeath();
////            turn++;
////            if (turn==4){
////                turn = 0;
////            }
//            endGame = true;
//        }
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
        //create house price
        for (House house : House.houses) {
            house.price = (random.nextInt(5) + 5) * 100;
        }
        for (int i = 0; i < 4; i++) {
            player[i].money = 3000; //money
            player[i].posPlayer = 0; //pos
            player[i].alive = true; //death
        }
    }

    //roll
    public void roll() {

    }

    //check death
    void checkAlive() {
        int countDeath = 0;
        for (int i = 0; i < 4; i++) {
            if (player[i].alive == false) {
                countDeath++;
            }
        }
        if (countDeath >= 2) {
            endGame = true;
        }
        for (int i = 0; i < 4; i++) {
            if (player[i].money <= 0) {
                player[i].alive = false;
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
        for (House house: House.houses) {
            if (house.houseId == view.getId()) {
                showInfo(house);
            }
        }
    }

    private void showInfo(House house) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("GameConsole");
        builder.setMessage("house number" + house.posHouse);
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