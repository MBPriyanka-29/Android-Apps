package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    int g_pts=0;
    int s_pts=0;
    ToggleButton turn;
    Boolean toggle_state;
    int win=0; // if win=0 no snitch, if win=1 Gryffindor has snitch, if win=2 slytherin has snitch
    int gameover=0; // decided by Golden Snitch
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turn =(ToggleButton)  findViewById(R.id.toggleButton);
        Toast msg = Toast.makeText(this,"Welcome to Qudditch game, Kindly Choose the team and then proceed!",Toast.LENGTH_LONG);
        msg.show();
    }

    public void turn(View view) {
        if(turn.isChecked()) {
            toggle_state=true;
            Toast msg = Toast.makeText(this,"Slytherin's Turn!",Toast.LENGTH_SHORT);
            msg.show();
            turn.setBackgroundColor(getResources().getColor(R.color.s_turn_bg));
            turn.setTextColor(getResources().getColor(R.color.s_turn_t));
        }
        else{
            toggle_state=false;
            Toast msg = Toast.makeText(this,"Griffindor's Turn!",Toast.LENGTH_SHORT);
            msg.show();
            turn.setBackgroundColor(getResources().getColor(R.color.g_turn_bg));
            turn.setTextColor(getResources().getColor(R.color.g_turn_t));
        }

    }
    public void g_count(View view) {
        Toast msg = Toast.makeText(this,"Griffindor scored : +"+String.valueOf(g_pts)+" points",Toast.LENGTH_SHORT);
        msg.show();

    }

    public void s_count(View view) {
        Toast msg = Toast.makeText(this,"Slytherin scored : +"+String.valueOf(s_pts)+" points",Toast.LENGTH_SHORT);
        msg.show();
    }

    public void p_20(View view) {
        if(gameover==0 && toggle_state!=null) {
            if (toggle_state) {  // Slytherin

                s_pts += 20;
                Toast msg = Toast.makeText(this, " +20 For Slytherin !!!", Toast.LENGTH_SHORT);
                msg.show();
            } else { // Gryffindor
                g_pts += 20;
                Toast msg = Toast.makeText(this, "+20 For Gryffindor !!!", Toast.LENGTH_SHORT);
                msg.show();
            }
        }
        else if(gameover!=0 && toggle_state!=null){

            Toast msg = Toast.makeText(this,"GAME OVER! press FINISH to RESTART",Toast.LENGTH_SHORT);
            msg.show();
        }
        else{
                Toast msg = Toast.makeText(this,"Please Choose the team!",Toast.LENGTH_SHORT);
                msg.show();

        }
    }

    public void p_10(View view) {
        if(gameover==0 && toggle_state!=null) {
            if (toggle_state) {  // Slytherin

                s_pts += 10;
                Toast msg = Toast.makeText(this, " +10 For Slytherin !!!", Toast.LENGTH_SHORT);
                msg.show();
            } else { // Gryffindor
                g_pts += 10;
                Toast msg = Toast.makeText(this, "+10 For Gryffindor !!!", Toast.LENGTH_SHORT);
                msg.show();
            }
        }

        else if(gameover!=0 && toggle_state!=null){

            Toast msg = Toast.makeText(this,"GAME OVER! press FINISH to RESTART",Toast.LENGTH_SHORT);
            msg.show();

        }
        else{
            Toast msg = Toast.makeText(this,"Please Choose the team!",Toast.LENGTH_SHORT);
            msg.show();

        }
    }

    public void p_30(View view) {
        if(gameover==0 && toggle_state!=null) {
            if (toggle_state) {  // Slytherin

                s_pts += 30;
                Toast msg = Toast.makeText(this, " +30 For Slytherin !!!", Toast.LENGTH_SHORT);
                msg.show();
            } else { // Gryffindor
                g_pts += 30;
                Toast msg = Toast.makeText(this, "+30 For Gryffindor !!!", Toast.LENGTH_SHORT);
                msg.show();
            }
        }

        else if(gameover!=0 && toggle_state!=null){

            Toast msg = Toast.makeText(this,"GAME OVER! press FINISH to RESTART",Toast.LENGTH_SHORT);
            msg.show();

        }
            else{
            Toast msg = Toast.makeText(this,"Please Choose the team!",Toast.LENGTH_SHORT);
            msg.show();

        }
    }

    public void p_150(View view) {
        if(gameover==0 && toggle_state!=null) {

            if (toggle_state) {  // Slytherin

                s_pts += 150;
                win = 2;
                Toast msg = Toast.makeText(this, " The Seeker caught the GOLDEN SNITCH, +150 For Slytherin !!!", Toast.LENGTH_SHORT);
                msg.show();
                Toast win = Toast.makeText(this, " Congratulations Syltherin, You won the match !!!", Toast.LENGTH_SHORT);
                win.show();
                gameover = 1;
            } else { // Gryffindor
                g_pts += 150;
                win = 1;
                Toast msg = Toast.makeText(this, " The Seeker caught the GOLDEN SNITCH, +150 For Gryffindor !!!", Toast.LENGTH_SHORT);
                msg.show();
                Toast win = Toast.makeText(this, " Congratulations Gryffindor, You won the match !!!", Toast.LENGTH_SHORT);
                win.show();
                gameover = 1;
            }
        }
        else if(gameover!=0 && toggle_state!=null){

            Toast msg = Toast.makeText(this,"GAME OVER! press FINISH to RESTART",Toast.LENGTH_SHORT);
            msg.show();

        }
        else{
            Toast msg = Toast.makeText(this,"Please Choose the team!",Toast.LENGTH_SHORT);
            msg.show();

        }
    }

    public void finish(View view) {
        String text;
        if(win==0){
            if(g_pts>s_pts)
            {
                text= "Gryffindor WON by "+String.valueOf(g_pts);
            }
            else if(g_pts==s_pts)
            {
                text="Its a Draw!";
            }
            else{
                text= "Slytherin WON by "+String.valueOf(s_pts);

            }
        }
        else if(win==1){ // Griffindor
            text= "Golden Snitch is in possession, Gryffindor WON by +"+String.valueOf(g_pts)+" Points";

        }
        else{
            text= "Golden Snitch is in possession, Slytherin WON by +"+String.valueOf(s_pts)+" Points";

        }
        Toast msg = Toast.makeText(this,text,Toast.LENGTH_LONG);
        msg.show();

        gameover=0;
        g_pts=0;
        s_pts=0;
        win=0;
        Toast m = Toast.makeText(this,"MATCH RESTARTED !",Toast.LENGTH_LONG);
        m.show();
    }


}