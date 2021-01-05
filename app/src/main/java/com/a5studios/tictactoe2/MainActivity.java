package com.a5studios.tictactoe2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    TextView header;

    int PLAYER_O =0;
    int PLAYER_X =1;
    int activeplayer=PLAYER_O;


    // array for fillpostitob

    int[] fillpos = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    boolean isGameActive=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        header=findViewById(R.id.heading);
        header.setText("O's Turn");

        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);

        btn2.setOnClickListener(this);

        btn3.setOnClickListener(this);

        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if(!isGameActive){
            return;
        }
        Button clickedButton = findViewById(v.getId());
        int clickedTag = Integer.parseInt(v.getTag().toString());

        if(fillpos[clickedTag]  != -1){
            return;
        }
        fillpos[clickedTag]=activeplayer;
        if(activeplayer==PLAYER_O){
            clickedButton.setText("O");
            activeplayer=PLAYER_X;
            clickedButton.setBackground(getDrawable(android.R.color.holo_orange_light));
            header.setText("X's Turn");
        }
        else{
            clickedButton.setText("X");
            activeplayer=PLAYER_O;
            clickedButton.setBackground(getDrawable(android.R.color.holo_blue_light));
            header.setText("O's Turn");
        }

        checkforwin();
    }

    private void checkforwin(){

        int[][] winner={{0,1,2}, {3,4,5},{6,7,8},
                { 0,3,6},{1,4,7},{2,5,8},
                {0,4,8},{2,4,6}};

        for(int i=0;i<8;i++){

            int val0=winner[i][0];
            int val1=winner[i][1];
            int val2=winner[i][2];

            if(fillpos[val0]==fillpos[val1] && fillpos[val1]==fillpos[val2]){

                if(fillpos[val0] != -1){

                    isGameActive=false;
                    if(fillpos[val0]==PLAYER_O)
                        showDialog("Hurray! Player O is Winner");
                    else
                        showDialog("Hurray! Player X is winner");
                }

            }

        }
        int count=0;
        for(int i=0;i<fillpos.length;i++){
            if(fillpos[i] != -1)
                count++;
        }
        if(count==9){
            showDialog("Match is Drawn!!");
        }


    }
    private void showDialog(String winnerText){
        new AlertDialog.Builder(this).setTitle(winnerText).setPositiveButton("Restart Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                restartGame();
            }
        }).show();
    }

    private void restartGame(){
        activeplayer=PLAYER_O;
        fillpos=new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
        btn0.setText("");
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");


        btn0.setBackground(getDrawable(android.R.color.darker_gray));
        btn1.setBackground(getDrawable(android.R.color.darker_gray));
        btn2.setBackground(getDrawable(android.R.color.darker_gray));
        btn3.setBackground(getDrawable(android.R.color.darker_gray));
        btn4.setBackground(getDrawable(android.R.color.darker_gray));
        btn5.setBackground(getDrawable(android.R.color.darker_gray));
        btn6.setBackground(getDrawable(android.R.color.darker_gray));
        btn7.setBackground(getDrawable(android.R.color.darker_gray));
        btn8.setBackground(getDrawable(android.R.color.darker_gray));
        header.setText("O's Turn");
        isGameActive=true;

    }


}
