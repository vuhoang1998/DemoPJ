package com.example.hoang.demopj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.bt_next)
    Button btnext;

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
        Intent intent = new Intent(RegisterActivity.this,PlayActivity.class);
        startActivity(intent);
    }
}
