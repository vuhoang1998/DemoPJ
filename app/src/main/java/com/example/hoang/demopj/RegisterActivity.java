package com.example.hoang.demopj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.bt_next)
    Button btnext;

    @BindView(R.id.player_1_name)
    EditText player1Name;

    @BindView(R.id.player_2_name)
    EditText player2Name;

    @BindView(R.id.player_3_name)
    EditText player3Name;

    @BindView(R.id.player_4_name)
    EditText player4Name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {

        super.onStart();
    }

    @OnClick(R.id.bt_next)
    public void onViewClicked() {
        Intent intent = new Intent(RegisterActivity.this, PlayActivity.class);
        Player.players = new Player[]{
                new Player(player1Name.getText().toString(),3000, 0, false, true, R.id.iv_pl_1),
                new Player(player2Name.getText().toString(),3000, 0, false, true, R.id.iv_pl_2),
                new Player(player3Name.getText().toString(),3000, 0, false, true, R.id.iv_pl_3),
                new Player(player4Name.getText().toString(),3000, 0, false, true, R.id.iv_pl_4)

    };

    startActivity(intent);
}
}
