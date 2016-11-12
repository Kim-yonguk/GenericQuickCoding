package com.example.a1a1a1.quickgeneric;


import android.*;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final generic<Integer,String> a= new generic<>();

        final Button input = (Button) findViewById(R.id.input);
        final Button end = (Button) findViewById(R.id.end);
        final EditText inputValue = (EditText) findViewById(R.id.inputValue);
        final TextView inputInteger = (TextView) findViewById(R.id.input_integer);
        final TextView inputString = (TextView) findViewById(R.id.input_string);
        final Button reset = (Button) findViewById(R.id.reset);

        input.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        String inputstirng = inputValue.getText().toString();
                        try{
                            int inputint = Integer.parseInt(inputstirng);
                            a.array_integer.add(inputint);
                        }catch(Exception e){
                            a.array_string.add(inputstirng);
                        }
                        inputValue.setText("");
                    }
                }
        );

        end.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        inputString.setText("입력된 문자열 : "+a.array_string);
                        inputInteger.setText("입력된 숫자 : "+a.array_integer);
                    }
                }
        );

        reset.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                       a.array_integer.clear(); //배열 초기화하는 함수
                        a.array_string.clear(); //배열 초기화함수 clear
                        inputString.setText("입력된 문자열 : ");
                        inputInteger.setText("입력된 숫자 : ");
                    }
                }
        );

    }

}
