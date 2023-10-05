package com.example.mycaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    TextView inputTop, inputBottom;
    Button buttonCe, buttonC, buttonCong, buttonTru, buttonNhan, buttonChia, buttonBang, buttonDauPhay,
            button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    String answerBottom = "";
    String answerTop = "";
    boolean isButton = false;
    boolean isButton1 = false;
    boolean isButton2 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        //Các nút
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDauPhay = (Button) findViewById(R.id.buttonDauPhay);
        buttonCe = (Button) findViewById(R.id.ce);
        buttonC = (Button) findViewById(R.id.c);
        buttonCong = (Button) findViewById(R.id.buttonCong);
        buttonTru = (Button) findViewById(R.id.buttonTru);
        buttonNhan = (Button) findViewById(R.id.buttonX);
        buttonChia = (Button) findViewById(R.id.buttonChia);
        buttonBang = (Button) findViewById(R.id.buttonBang);
        //input
        inputTop = (TextView) findViewById(R.id.inputTop);
        inputBottom = (TextView) findViewById(R.id.inputBottom);


        button0.setOnClickListener(createNumberClickListener("0"));
        button1.setOnClickListener(createNumberClickListener("1"));
        button2.setOnClickListener(createNumberClickListener("2"));
        button3.setOnClickListener(createNumberClickListener("3"));
        button4.setOnClickListener(createNumberClickListener("4"));
        button5.setOnClickListener(createNumberClickListener("5"));
        button6.setOnClickListener(createNumberClickListener("6"));
        button7.setOnClickListener(createNumberClickListener("7"));
        button8.setOnClickListener(createNumberClickListener("8"));
        button9.setOnClickListener(createNumberClickListener("9"));
        buttonDauPhay.setOnClickListener(createNumberClickListener("."));

        buttonCe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isButton1) {
                    char arr[] = answerBottom.toCharArray();
                    String s = "";
                    for (int i = 0; i < arr.length - 1; i++) {
                        s += arr[i];
                    }
                    answerBottom = s;
                }
                if (!isButton) {
                    inputBottom.setText(answerBottom);
                }
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });
        buttonCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isButton && !answerBottom.equals("")) {
                    answerTop = answerBottom + " +";
                    inputTop.setText(answerTop);
                    answerBottom = "";
                    isButton = true;
                    isButton2 = false;
                }

            }
        });
        buttonTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isButton && !answerBottom.equals("")) {
                    answerTop = answerBottom + " -";
                    inputTop.setText(answerTop);
                    answerBottom = "";
                    isButton = true;
                    isButton2 = false;
                }

            }
        });
        buttonNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isButton && !answerBottom.equals("")) {
                    answerTop = answerBottom + " *";
                    inputTop.setText(answerTop);
                    answerBottom = "";
                    isButton = true;
                    isButton2 = false;
                }

            }
        });
        buttonChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isButton && !answerBottom.equals("")) {
                    answerTop = answerBottom + " /";
                    inputTop.setText(answerTop);
                    answerBottom = "";
                    isButton = true;
                    isButton2 = false;
                }

            }
        });


        buttonBang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    isButton = false;
                    isButton1 = true;
                    isButton2 = true;
                    String arrAnswerTop[] = answerTop.split(" ");
                    double answerTopBang = Double.parseDouble(arrAnswerTop[0]);
                    double answerBottomBang = Double.parseDouble(answerBottom);

                    String answerSauKhiBang = "";
                    switch (arrAnswerTop[1]) {
                        case "+":
                            inputBottom.setText(String.valueOf(answerTopBang + answerBottomBang));
                            inputTop.setText(String.valueOf(answerTopBang + answerBottomBang));
                            answerSauKhiBang = String.valueOf(answerTopBang + answerBottomBang);
                            kiemTraSoNguyen(answerSauKhiBang);
                            break;
                        case "-":
                            inputBottom.setText(String.valueOf(answerTopBang - answerBottomBang));
                            inputTop.setText(String.valueOf(answerTopBang - answerBottomBang));
                            answerSauKhiBang = String.valueOf(answerTopBang - answerBottomBang);
                            kiemTraSoNguyen(answerSauKhiBang);
                            break;
                        case "*":
                            inputBottom.setText(String.valueOf(answerTopBang * answerBottomBang));
                            inputTop.setText(String.valueOf(answerTopBang * answerBottomBang));
                            answerSauKhiBang = String.valueOf(answerTopBang * answerBottomBang);
                            kiemTraSoNguyen(answerSauKhiBang);
                            break;
                        case "/":
                            inputBottom.setText(String.valueOf(answerTopBang / answerBottomBang));
                            inputTop.setText(String.valueOf(answerTopBang / answerBottomBang));
                            answerSauKhiBang = String.valueOf(answerTopBang / answerBottomBang);
                            kiemTraSoNguyen(answerSauKhiBang);
                            break;

                    }


                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }


            }
        });

    }

    private View.OnClickListener createNumberClickListener(final String number) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isButton = false;
                answerBottom += number;
                inputBottom.setText(answerBottom);
                if (isButton2) {
                    clear();
                }
            }
        };
    }

    private void clear() {
        answerBottom = "";
        answerTop = "";
        inputBottom.setText(answerBottom);
        inputTop.setText(answerTop);
        isButton2 = false;
    }
    private void kiemTraSoNguyen(String answerSauKhiBang){
        double s = Double.parseDouble(answerSauKhiBang);
        if(s % 1 == 0){
            inputTop.setText(String.format("%.0f", s));
            inputBottom.setText(String.format("%.0f", s));
            answerBottom = String.format("%.0f", s);
        }
    }
}