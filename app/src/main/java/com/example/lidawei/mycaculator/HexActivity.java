package com.example.lidawei.mycaculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class HexActivity extends AppCompatActivity {

    private TextView[] textViews;   //textView表示进制名称
    private EditText[] editTexts;   //editText用来输入
    private Button btDo,btClean;    //Confirm和Clean两个button

    private static final String TAG = "my tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hex);

        textViews = new TextView[4];
        editTexts = new EditText[4];
        btDo = (Button) findViewById(R.id.buttonDo);
        btClean = (Button) findViewById(R.id.buttonClean);

        textViews[0] = (TextView) findViewById(R.id.text1);
        textViews[1] = (TextView) findViewById(R.id.text2);
        textViews[2] = (TextView) findViewById(R.id.text3);
        textViews[3] = (TextView) findViewById(R.id.text4);

        textViews[0].setText("二进制");
        textViews[1].setText("八进制");
        textViews[2].setText("十进制");
        textViews[3].setText("十六进制");

        editTexts[0] = (EditText) findViewById(R.id.edit1);
        editTexts[1] = (EditText) findViewById(R.id.edit2);
        editTexts[2] = (EditText) findViewById(R.id.edit3);
        editTexts[3] = (EditText) findViewById(R.id.edit4);

        btDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //如果在什么都不输入的情况下点Confirm则提示
                if (editTexts[0].getText().length() == 0 && editTexts[1].getText().length() == 0 &&
                        editTexts[2].getText().length() == 0 && editTexts[3].getText().length() == 0) {
                    Toast.makeText(HexActivity.this, "Please input a number!", Toast.LENGTH_SHORT).show();
                }
                else {
                    int num = -1;   //用num来表示第几行
                    for (int i = 0; i < editTexts.length; i++) {
                        //确定在第几行输入
                        if (!editTexts[i].getText().toString().equals("")) {
                            num = i;
                            break;
                        }
                    }
                    //input表示在该行输入的东西
                    String input = editTexts[num].getText().toString();

                    if (num != -1) {
                        switch (num) {

                            //第0行（二进制）
                            case 0: {

                                //如果输入的不是数字，则提示
                                if (!input.matches("[0-9]{1,}")) {
                                    Toast.makeText(HexActivity.this, "Please input correctly!", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    int n = Integer.parseInt(input);
                                    input = n + "";
                                    editTexts[1].setText(Integer.toOctalString(Integer.parseInt(input, 2)));
                                    editTexts[2].setText(Integer.valueOf(input, 2).toString());
                                    editTexts[3].setText(Integer.toHexString(Integer.parseInt(input, 2)));
                                }
                                break;
                            }

                            //第1行（八进制）
                            case 1: {
                                if (!input.matches("[0-9]{1,}")) {
                                    Toast.makeText(HexActivity.this, "Please input correctly!", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    int n = Integer.parseInt(input);
                                    input = n + "";
                                    editTexts[0].setText(Integer.toBinaryString(Integer.valueOf(input, 8)));
                                    editTexts[2].setText(Integer.valueOf(input, 8).toString());
                                    editTexts[3].setText(Integer.toHexString(Integer.valueOf(input, 8)));
                                }
                                break;
                            }

                            //第2行（十进制）
                            case 2: {
                                if (!input.matches("[0-9]{1,}")) {
                                    Toast.makeText(HexActivity.this, "Please input correctly!", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    int n = Integer.parseInt(input);
                                    editTexts[0].setText(Integer.toBinaryString(n));
                                    editTexts[1].setText(Integer.toOctalString(n));
                                    editTexts[3].setText(Integer.toHexString(n));
                                }
                                break;
                            }

                            //第3行（十六进制）
                            case 3: {
                                if(input.matches("^[A-Fa-f0-9]+$")){
                                    editTexts[0].setText(Integer.toBinaryString(Integer.valueOf(input, 16)));
                                    editTexts[1].setText(Integer.toOctalString(Integer.parseInt(input, 16)));
                                    editTexts[2].setText(Integer.valueOf(input, 16).toString());
                                }
                                else{
                                    Toast.makeText(HexActivity.this, "Please input correctly!", Toast.LENGTH_SHORT).show();
                                }
                                break;
                            }
                        }
                    }
                }
            }
        });

        //清空
        btClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i<editTexts.length; i++){
                    editTexts[i].setText("");
                }
            }
        });
    }
}


