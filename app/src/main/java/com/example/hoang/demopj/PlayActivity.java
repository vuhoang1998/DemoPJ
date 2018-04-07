package com.example.hoang.demopj;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoang.demopj.estate.Block;
import com.example.hoang.demopj.estate.House;
import com.example.hoang.demopj.estate.SpecialBlock;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.hoang.demopj.Player.players;


public class PlayActivity extends AppCompatActivity {
    String TAG = "lalaland";
    Random random = new Random();
    boolean endGame = false;
    int turn = 0;
    int dice1 = 0;
    int dice2 = 0;
    int dice = 0;
    int choose;
    float v = 0.0f;
    float h = 0.0f;

    @BindView(R.id.tv_name_1)
    TextView playerName1;

    @BindView(R.id.tv_name_2)
    TextView playerName2;

    @BindView(R.id.tv_name_3)
    TextView playerName3;

    @BindView(R.id.tv_name_4)
    TextView playerName4;


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
    @BindView(R.id.iv_arrow_pl1)
    ImageView ivArrowPl1;
    @BindView(R.id.iv_arrow_pl2)
    ImageView ivArrowPl2;
    @BindView(R.id.iv_arrow_pl3)
    ImageView ivArrowPl3;
    @BindView(R.id.iv_arrow_pl4)
    ImageView ivArrowPl4;

    TextView []tvColor = new TextView[24];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);
        create();
        setupText();
        setTvColor();
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
    //set find by ID color
    public void setTvColor(){
        tvColor[1]=findViewById(R.id.tv_color_01);
        tvColor[2]=findViewById(R.id.tv_color_02);
        tvColor[4]=findViewById(R.id.tv_color_04);
        tvColor[5]=findViewById(R.id.tv_color_05);
        tvColor[7]=findViewById(R.id.tv_color_07);
        tvColor[8]=findViewById(R.id.tv_color_08);
        tvColor[10]=findViewById(R.id.tv_color_10);
        tvColor[11]=findViewById(R.id.tv_color_11);
        tvColor[13]=findViewById(R.id.tv_color_13);
        tvColor[14]=findViewById(R.id.tv_color_14);
        tvColor[16]=findViewById(R.id.tv_color_16);
        tvColor[17]=findViewById(R.id.tv_color_17);
        tvColor[19]=findViewById(R.id.tv_color_19);
        tvColor[20]=findViewById(R.id.tv_color_20);
        tvColor[22]=findViewById(R.id.tv_color_22);
        tvColor[23]=findViewById(R.id.tv_color_23);
        tvColor[0]=null;
        tvColor[3]=null;
        tvColor[6]=null;
        tvColor[9]=null;
        tvColor[12]=null;
        tvColor[15]=null;
        tvColor[18]=null;
        tvColor[21]=null;
    }

    //getPosV
    public float getPosV(int p) {

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
        for (Block block : Block.blocks) {
            if (!(block instanceof SpecialBlock)) {
                ((House) block).price = (random.nextInt(5) + 5) * 100;
            }
        }
        ivArrowPl1.setVisibility(View.GONE);
        ivArrowPl2.setVisibility(View.GONE);
        ivArrowPl3.setVisibility(View.GONE);
        ivArrowPl4.setVisibility(View.GONE);

    }

    //roll
    public void roll() {
        dice1 = random.nextInt(6) + 1;
        dice2 = random.nextInt(6) + 1;
        if (dice1 == 1) {
            ivDice1st.setImageResource(R.drawable.diceone);
        } else if (dice1 == 2) {
            ivDice1st.setImageResource(R.drawable.dicetwo);
        } else if (dice1 == 3) {
            ivDice1st.setImageResource(R.drawable.dicethree);
        } else if (dice1 == 4) {
            ivDice1st.setImageResource(R.drawable.dicefour);
        } else if (dice1 == 5) {
            ivDice1st.setImageResource(R.drawable.dicefive);
        } else if (dice1 == 6) {
            ivDice1st.setImageResource(R.drawable.dicesix);
        }
        if (dice2 == 1) {
            ivDice2nd.setImageResource(R.drawable.diceone);
        } else if (dice2 == 2) {
            ivDice2nd.setImageResource(R.drawable.dicetwo);
        } else if (dice2 == 3) {
            ivDice2nd.setImageResource(R.drawable.dicethree);
        } else if (dice2 == 4) {
            ivDice2nd.setImageResource(R.drawable.dicefour);
        } else if (dice2 == 5) {
            ivDice2nd.setImageResource(R.drawable.dicefive);
        } else if (dice2 == 6) {
            ivDice2nd.setImageResource(R.drawable.dicesix);
        }

        players[turn].posPlayer += dice1;
        players[turn].posPlayer += dice2;
        if (players[turn].posPlayer >= 24) {
            players[turn].posPlayer -= 24;
        }

        if (turn == 0) {
            ConstraintLayout.LayoutParams paramsH = (ConstraintLayout.LayoutParams) glHPlayer01.getLayoutParams();
            paramsH.guidePercent = getPosH(0);
            glHPlayer01.setLayoutParams(paramsH);

            ConstraintLayout.LayoutParams paramsV = (ConstraintLayout.LayoutParams) glVPlayer01.getLayoutParams();
            paramsV.guidePercent = getPosV(0);
            glVPlayer01.setLayoutParams(paramsV);
        }
        if (turn == 1) {
            ConstraintLayout.LayoutParams paramsH = (ConstraintLayout.LayoutParams) glHPlayer02.getLayoutParams();
            paramsH.guidePercent = getPosH(1) + 0.03f;
            glHPlayer02.setLayoutParams(paramsH);

            ConstraintLayout.LayoutParams paramsV = (ConstraintLayout.LayoutParams) glVPlayer02.getLayoutParams();
            paramsV.guidePercent = getPosV(1);
            glVPlayer02.setLayoutParams(paramsV);
        }
        if (turn == 2) {
            ConstraintLayout.LayoutParams paramsH = (ConstraintLayout.LayoutParams) glHPlayer03.getLayoutParams();
            paramsH.guidePercent = getPosH(2);
            glHPlayer03.setLayoutParams(paramsH);

            ConstraintLayout.LayoutParams paramsV = (ConstraintLayout.LayoutParams) glVPlayer03.getLayoutParams();
            paramsV.guidePercent = getPosV(2) + 0.06f;
            glVPlayer03.setLayoutParams(paramsV);
        }
        if (turn == 3) {
            ConstraintLayout.LayoutParams paramsH = (ConstraintLayout.LayoutParams) glHPlayer04.getLayoutParams();
            paramsH.guidePercent = getPosH(3) + 0.03f;
            glHPlayer04.setLayoutParams(paramsH);

            ConstraintLayout.LayoutParams paramsV = (ConstraintLayout.LayoutParams) glVPlayer04.getLayoutParams();
            paramsV.guidePercent = getPosV(3) + 0.06f;
            glVPlayer04.setLayoutParams(paramsV);
        }
    }

    //setTurn
    public void setTurn() {

        if (turn == 0) {
            ivArrowPl1.setVisibility(View.VISIBLE);
            ivArrowPl2.setVisibility(View.GONE);
            ivArrowPl3.setVisibility(View.GONE);
            ivArrowPl4.setVisibility(View.GONE);
        } else if (turn == 1) {
            ivArrowPl1.setVisibility(View.GONE);
            ivArrowPl2.setVisibility(View.VISIBLE);
            ivArrowPl3.setVisibility(View.GONE);
            ivArrowPl4.setVisibility(View.GONE);
        } else if (turn == 2) {
            ivArrowPl1.setVisibility(View.GONE);
            ivArrowPl2.setVisibility(View.GONE);
            ivArrowPl3.setVisibility(View.VISIBLE);
            ivArrowPl4.setVisibility(View.GONE);
        } else if (turn == 3) {
            ivArrowPl1.setVisibility(View.GONE);
            ivArrowPl2.setVisibility(View.GONE);
            ivArrowPl3.setVisibility(View.GONE);
            ivArrowPl4.setVisibility(View.VISIBLE);
        }
    }

    //setBlock
    public void setBlock() {
//        if (!(block instanceof SpecialBlock)) {
//            House currentHouse = (House) Block.blocks[players[turn].posPlayer];
//            if (currentHouse.playerOccupy == 0) {
//                if (players[turn].money > currentHouse.price) {showDialogBuy();
//                }
//            }
//        }
        for (Block block : Block.blocks) {
            if (!(block instanceof SpecialBlock)) {
                if (((House) block).position == players[turn].posPlayer) {
                    if (((House) block).playerOccupy == 0) {
                        if (players[turn].money > ((House) block).price) {
                            showDialogBuy();
                        }
                    }
                }
            }
        }
    }

    public void setColor(){
        if (turn==0&&tvColor[players[turn].posPlayer]!=null){
            tvColor[players[turn].posPlayer].setBackgroundResource(R.color.player01);
        }
        if (turn==1&&tvColor[players[turn].posPlayer]!=null){
            tvColor[players[turn].posPlayer].setBackgroundResource(R.color.player02);
        }
        if (turn==2&&tvColor[players[turn].posPlayer]!=null){
            tvColor[players[turn].posPlayer].setBackgroundResource(R.color.player03);
        }
        if (turn==3&&tvColor[players[turn].posPlayer]!=null){
            tvColor[players[turn].posPlayer].setBackgroundResource(R.color.player04);
        }
    }
    public void showDialogBuy() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("GameConsole");
        String message = " Do you want to buy this land? ";
        builder.setMessage(message);
        builder.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                House currentHouse1 = (House) Block.blocks[players[turn].posPlayer];
                players[turn].money -= currentHouse1.price;
               // setColor();
                tvColor[11].setBackgroundResource(R.color.player01);
            }
        });
        builder.setNegativeButton("Ignore", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    @OnClick(R.id.bt_roll)
    public void onViewClicked() {
        checkAlive();
        if (turn == 4) {
            Log.d(TAG, "wtf?");
            turn = 0;
        }
        roll();
        setTurn();

        setBlock();
        turn += 1;
    }

    //check alive
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

    private void setupText() {
        for (int i = 0; i < 16; i++) {
            House currentHouse = (House) Block.blocks[i];
            TextView textView = findViewById(currentHouse.houseId);
            textView.setText(currentHouse.name + "\n" + Integer.toString(currentHouse.price));
        }
        playerName1.setText(Player.players[0].name);
        playerName2.setText(Player.players[1].name);
        playerName3.setText(Player.players[2].name);
        playerName4.setText(Player.players[3].name);

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

    public void onClickHouse(View view) {
        for (Block block : Block.blocks) {
            if (!(block instanceof SpecialBlock)) {
                if (((House) block).houseId == view.getId()) {
                    showInfo((House) block);
                }
            }
        }
    }

    private void showInfo(House house) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("GameConsole");
        String message = "Buy cost: " + house.price + "\nupgrade fee: " + house.price / 2;
        builder.setMessage(message);
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