package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView workingsTV;
    TextView resultsTV;

    String workings = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews(){
        workingsTV = (TextView)findViewById(R.id.workingTextView);
        resultsTV = (TextView)findViewById(R.id.resultsTextView);
    }

    private void setWorkings(String givenValue){
        workings = workings + givenValue;
        workingsTV.setText(workings);
    }
//  Values
    public void oneOnClick(View view){
        setWorkings("1");
    }
    public void twoOnClick(View view){
        setWorkings("2");
    }
    public void threeOnClick(View view){
        setWorkings("3");
    }
    public void fourOnClick(View view){
        setWorkings("4");
    }
    public void fiveOnClick(View view){
        setWorkings("5");
    }
    public void sixOnClick(View view){
        setWorkings("6");
    }
    public void sevenOnClick(View view){
        setWorkings("7");
    }
    public void eightOnClick(View view){
        setWorkings("8");
    }
    public void nineOnClick(View view){
        setWorkings("9");
    }
    public void zeroOnClick(View view){
        setWorkings("0");
    }
//    Operations
    public void equalsOnClick(View view){
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName(("rhino"));
        try{
        result = (double)engine.eval(workings);
        } catch (ScriptException e) {
            Toast.makeText(this,"Invalid Input",Toast.LENGTH_SHORT).show();
        }
        if(result!=null)
            resultsTV.setText(String.valueOf(result.doubleValue()));
    }
    public void clearOnClick(View view){
        workingsTV.setText("");
        workings = "";
        resultsTV.setText("");
        leftBracket = true;
    }
    boolean leftBracket = true;
    public void bracketsOnClick(View view){
        if(leftBracket) {
            setWorkings("(");
            leftBracket = false;
        }
        else{
            setWorkings(")");
            leftBracket = true;
        }
    }
    public void powerOfOnClick(View view){
        setWorkings("^");
    }
    public void divisionOnClick(View view){
        setWorkings("/");
    }
    public void timesOnClick(View view){
        setWorkings("*");
    }
    public void minusOnClick(View view){
        setWorkings("-");
    }
    public void plusOnClick(View view){
        setWorkings("+");
    }
    public void decimalOnClick(View view){
        setWorkings(".");
    }

}