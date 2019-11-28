package com.example.dawid.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b[] = new Button[9];
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        reset = (Button) findViewById(R.id.rst);
        reset.setVisibility(View.GONE);
        reset.setOnClickListener(this);

        b[0] = (Button) findViewById(R.id.b11);
        b[1] = (Button) findViewById(R.id.b12);
        b[2] = (Button) findViewById(R.id.b13);
        b[3] = (Button) findViewById(R.id.b21);
        b[4] = (Button) findViewById(R.id.b22);
        b[5] = (Button) findViewById(R.id.b23);
        b[6] = (Button) findViewById(R.id.b31);
        b[7] = (Button) findViewById(R.id.b32);
        b[8] = (Button) findViewById(R.id.b33);


        for(int i=0;i<b.length;i++){
            b[i].setOnClickListener(this);
            b[i].setTextSize(50);
            b[i].setBackgroundColor(Color.parseColor("#156060"));
            b[i].setTextColor(Color.parseColor("#dddddd"));
        }
    }


    public void onClick(View button) {
        switch (button.getId()) {
            case R.id.b11: {
                update(0);
                break;
            }
            case R.id.b12: {
                update(1);
                break;
            }
            case R.id.b13: {
                update(2);
                break;
            }
            case R.id.b21: {
                update(3);
                break;
            }
            case R.id.b22: {
                update(4);
                break;
            }
            case R.id.b23: {
                update(5);
                break;
            }
            case R.id.b31: {
                update(6);
                break;
            }
            case R.id.b32: {
                update(7);
                break;
            }
            case R.id.b33: {
                update(8);
                break;
            }
            case R.id.rst: {
                clearState();
                break;
            }
        }
    }

    int state[] = new int[9];
    int turn = 1;
    int fieldUsed = 0;

    private void update(int tile){
        if (state[tile]!=1 && state[tile]!=-1) {
            fieldUsed++;
        }
        if (state[tile]==0){
            if(turn==1){
                b[tile].setText("X");
                state[tile] = turn;
                turn = -1;
            }else if(turn == -1){
                b[tile].setText("O");
                state[tile] = turn;
                turn = 1;
            }
        }

        if(check() || fieldUsed == b.length){
            turn = 0;
            reset.setVisibility(View.VISIBLE);
        }
    }

    private void clearState(){
        for(int i=0;i<b.length;i++){
            state[i]=0;
            b[i].setText(" ");
            b[i].setTextColor(Color.parseColor("#dddddd"));
        }
        turn = 1;
        reset.setVisibility(View.GONE);
        fieldUsed = 0;
    }

    private boolean check(){
        int value;
        for(int i=0;i<9;i+=3){
            value = state[i] + state[i+1] + state[i+2];
            if(value == -3){
                b[i].setTextColor(Color.parseColor("#dd2222"));
                b[i+1].setTextColor(Color.parseColor("#dd2222"));
                b[i+2].setTextColor(Color.parseColor("#dd2222"));
                return true;
            }else if(value == 3){
                b[i].setTextColor(Color.parseColor("#dd2222"));
                b[i+1].setTextColor(Color.parseColor("#dd2222"));
                b[i+2].setTextColor(Color.parseColor("#dd2222"));
                return true;
            }
        }
        for(int i=0;i<3;i++){
            value = state[i] + state[i+3] + state[i+6];
            if(value == -3){
                b[i].setTextColor(Color.parseColor("#dd2222"));
                b[i+3].setTextColor(Color.parseColor("#dd2222"));
                b[i+6].setTextColor(Color.parseColor("#dd2222"));
                return true;
            }else if(value == 3){
                b[i].setTextColor(Color.parseColor("#dd2222"));
                b[i+3].setTextColor(Color.parseColor("#dd2222"));
                b[i+6].setTextColor(Color.parseColor("#dd2222"));
                return true;
            }
        }

        value = state[0] + state[4] + state[8];
        if(value == -3){
            b[0].setTextColor(Color.parseColor("#dd2222"));
            b[4].setTextColor(Color.parseColor("#dd2222"));
            b[8].setTextColor(Color.parseColor("#dd2222"));
            return true;
        }else if(value == 3){
            b[0].setTextColor(Color.parseColor("#dd2222"));
            b[4].setTextColor(Color.parseColor("#dd2222"));
            b[8].setTextColor(Color.parseColor("#dd2222"));
            return true;
        }
        value = state[2] + state[4] + state[6];
        if(value == -3){
            b[2].setTextColor(Color.parseColor("#dd2222"));
            b[4].setTextColor(Color.parseColor("#dd2222"));
            b[6].setTextColor(Color.parseColor("#dd2222"));
            return true;
        }else if(value == 3){
            b[2].setTextColor(Color.parseColor("#dd2222"));
            b[4].setTextColor(Color.parseColor("#dd2222"));
            b[6].setTextColor(Color.parseColor("#dd2222"));
            return true;
        }

        return false;
    }
}