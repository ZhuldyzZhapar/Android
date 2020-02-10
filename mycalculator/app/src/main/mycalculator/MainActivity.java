package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private boolean isOpPre = false;
    private double fstNum = 0;
    private int sndEltInd = 0;
    private char curOp ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView calculatorScreen = findViewById(R.id.myText);
        final Button zero = findViewById(R.id.zero);
        final Button one = findViewById(R.id.one);
        final Button two = findViewById(R.id.two);
        final Button three = findViewById(R.id.three);
        final Button four  = findViewById(R.id.four);
        final Button five = findViewById(R.id.five);
        final Button six = findViewById(R.id.six);
        final Button seven = findViewById(R.id.seven);
        final Button eight = findViewById(R.id.eight);
        final Button nine = findViewById(R.id.nine);
        final Button div = findViewById(R.id.div);
        final Button mult = findViewById(R.id.mult);
        final Button plus = findViewById(R.id.plus);
        final Button minus = findViewById(R.id.minus);
        final Button dot = findViewById(R.id.dot);
        final Button equal = findViewById(R.id.equal);




        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id = v.getId();
                switch(id) {
                    case R.id.zero:
                            calculatorScreen.append("0");
                        break;
                    case R.id.one:
                        calculatorScreen.append("1");
                        break;

                    case R.id.two:
                        calculatorScreen.append("2");
                        break;

                    case R.id.three:
                        calculatorScreen.append("3");
                        break;

                    case R.id.four:
                        calculatorScreen.append("4");
                        break;

                    case R.id.five:
                        calculatorScreen.append("5");
                        break;

                    case R.id.six:
                        calculatorScreen.append("6");
                        break;

                    case R.id.seven:
                        calculatorScreen.append("7");
                        break;

                    case R.id.eight:
                        calculatorScreen.append("8");
                        break;

                    case R.id.nine:
                        calculatorScreen.append("9");
                        break;

                    case R.id.div:
                        String scrContent = calculatorScreen.getText().toString();
                        sndEltInd =  scrContent.length() + 1;
                        fstNum = Double.parseDouble(calculatorScreen.getText().toString());
                        calculatorScreen.append("/");
                        isOpPre = true;
                        curOp = '/';

                        break;

                    case R.id.mult:

                        String scrContent1 = calculatorScreen.getText().toString();
                        sndEltInd =  scrContent1.length() + 1;
                        fstNum = Double.parseDouble(calculatorScreen.getText().toString());
                        calculatorScreen.append("×");
                        isOpPre = true;
                        curOp = '*';

                        break;

                    case R.id.plus:
                        String scrContent2 = calculatorScreen.getText().toString();
                        sndEltInd =  scrContent2.length() + 1;
                        fstNum = Double.parseDouble(calculatorScreen.getText().toString());
                        calculatorScreen.append("+");
                        isOpPre = true;
                        curOp = '+';
                        break;

                    case R.id.minus:
                        String scrContent3 = calculatorScreen.getText().toString();
                        sndEltInd =  scrContent3.length() + 1;
                        fstNum = Double.parseDouble(calculatorScreen.getText().toString());
                        calculatorScreen.append("-");
                        isOpPre = true;
                        curOp = '-';
                        break;

                    case R.id.equal:
                        if (isOpPre){
                            if (curOp == '/') {
                                String scrCnt = calculatorScreen.getText().toString();
                                double sndNum = Double.parseDouble(scrCnt.
                                        substring(sndEltInd, scrCnt.length()));
                                sndNum /= fstNum;
                                calculatorScreen.setText(String.valueOf(sndNum));
                            }
                            if (curOp == '*') {
                                String scrCnt = calculatorScreen.getText().toString();
                                double sndNum = Double.parseDouble(scrCnt.
                                        substring(sndEltInd, scrCnt.length()));
                                sndNum *= fstNum;
                                calculatorScreen.setText(String.valueOf(sndNum));
                            }

                            if (curOp == '+') {
                                String scrCnt = calculatorScreen.getText().toString();
                                double sndNum = Double.parseDouble(scrCnt.
                                        substring(sndEltInd, scrCnt.length()));
                                sndNum += fstNum;
                                calculatorScreen.setText(String.valueOf(sndNum));
                            }

                            if (curOp == '-') {
                                String scrCnt = calculatorScreen.getText().toString();
                                double sndNum = Double.parseDouble(scrCnt.
                                        substring(sndEltInd, scrCnt.length()));
                                sndNum -= fstNum;
                                calculatorScreen.setText(String.valueOf(sndNum));
                            }
                        }

                        break;
                }
            }
        };
        zero.setOnClickListener(calculatorListener);
        one.setOnClickListener(calculatorListener);
        two.setOnClickListener(calculatorListener);
        three.setOnClickListener(calculatorListener);
        four.setOnClickListener(calculatorListener);
        five.setOnClickListener(calculatorListener);
        six.setOnClickListener(calculatorListener);
        seven.setOnClickListener(calculatorListener);
        eight.setOnClickListener(calculatorListener);
        nine.setOnClickListener(calculatorListener);
        equal.setOnClickListener(calculatorListener);
        div.setOnClickListener(calculatorListener);
        mult.setOnClickListener(calculatorListener);
        plus.setOnClickListener(calculatorListener);
        minus.setOnClickListener(calculatorListener);
        dot.setOnClickListener(calculatorListener);

        final Button del = findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displEl = calculatorScreen.getText().toString();
                int length = displEl.length();
                if (length > 0){
                    displEl = displEl.substring(0, length-1);
                    calculatorScreen.setText(displEl);
                }
            }
        });

        final Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorScreen.setText("");
            }
        });
    }
}
