package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
public TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=findViewById(R.id.equal);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv=findViewById(R.id.textView);
                try {
                    String data=tv.getText().toString();
String ans=calculate(data);
tv.setText(ans);

                }catch (Exception e){
                    tv.setText("Err");
                }

            }
        });


    }
    public static String calculate(String data){
        String s=data;
        ArrayList<String> arr=new ArrayList<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            arr.add(s.substring(i, i+1));
        }

        //1627
        int j=0;
        int k=0;
        int digit=1;

        for(int i=0;i<arr.size();i++){
            if(arr.get(i).equals("+") || arr.get(i).equals("-") || arr.get(i).equals("*") || arr.get(i).equals("/") || arr.get(i).equals("%")){
                digit++;

            }
        }
        System.out.println(arr);
        ArrayList<String> arr2=new ArrayList<>(digit+(digit-1));
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).equals("+") || arr.get(i).equals("-") || arr.get(i).equals("*") || arr.get(i).equals("/") || arr.get(i).equals("%")){
                String temp=s.substring(j, i);
                arr2.add(temp);
                arr2.add(arr.get(i));


                j=i+1;
                k=k+2;

            }
        }


        arr2.add(s.substring(j, s.length()));



        for(int i=0;i<arr2.size()+1;i++){
            if(arr2.contains("%") ){
//Not working yet
            double a=Double.parseDouble(arr2.get(arr2.indexOf("%")-1).toString());
            double b=Double.parseDouble(arr2.get(arr2.indexOf("%")+1).toString());

            double ans=percent(a,b);
//            System.out.println(ans);
            String temp=Double.toString(ans);
            arr2.set(arr2.indexOf("%"),temp);
            arr2.remove(arr2.indexOf("%")+1);
            arr2.remove(arr2.indexOf("%")+2);
        }else if(arr2.contains("/") ){
            double a=Double.parseDouble(arr2.get(arr2.indexOf("/")-1).toString());
            double b=Double.parseDouble(arr2.get(arr2.indexOf("/")+1).toString());
            double ans=div(a,b);
            String temp=Double.toString(ans);
            arr2.set(arr2.indexOf("/"),temp);
            arr2.remove(arr2.indexOf(temp)-1);
            arr2.remove(arr2.indexOf(temp)+1);
        }
        else if(arr2.contains("*") ){
            double a=Double.parseDouble(arr2.get(arr2.indexOf("*")-1).toString());
            double b=Double.parseDouble(arr2.get(arr2.indexOf("*")+1).toString());
            double ans=mul(a,b);
            String temp=Double.toString(ans);
            arr2.set(arr2.indexOf("*"),temp);

            arr2.remove(arr2.indexOf(temp)-1);
            arr2.remove(arr2.indexOf(temp)+1);
        }else if(arr2.contains("+") ){
            double a=Double.parseDouble(arr2.get(arr2.indexOf("+")-1).toString());
            double b=Double.parseDouble(arr2.get(arr2.indexOf("+")+1).toString());
            double ans=add(a,b);
            String temp=Double.toString(ans);
            arr2.set(arr2.indexOf("+"),temp);
            arr2.remove(arr2.indexOf(temp)-1);
            arr2.remove(arr2.indexOf(temp)+1);
        }else if(arr2.contains("-") ){
            double a=Double.parseDouble(arr2.get(arr2.indexOf("-")-1).toString());
            double b=Double.parseDouble(arr2.get(arr2.indexOf("-")+1).toString());
            double ans=sub(a,b);
            String temp=Double.toString(ans);
            arr2.set(arr2.indexOf("-"),temp);
            arr2.remove(arr2.indexOf(temp)-1);
            arr2.remove(arr2.indexOf(temp)+1);
        }}

        String Answer=arr2.get(0).toString();
return Answer;
    }
    public static double add(double a, double b){
        return a+b;
    }
    public static double sub(double a, double b){
        return a-b;
    }
    public static double mul(double a, double b){
        return a*b;
    }
    public static double div(double a, double b){
        return a/b;
    }
    public static double mod(double a, double b){
        return a%b;
    }
    public static double percent(double a,double b){
        double c=(a/b)*100;
        return b;
    }

    public void tap(View view){
        MaterialButton btn=(MaterialButton) view;
        TextView tv=findViewById(R.id.textView);

        tv.setText(tv.getText()+btn.getText().toString());
    }

    public void ac(View v){
        TextView tv=findViewById(R.id.textView);
        tv.setText("");
    }
    public void back(View v){

        try {
            TextView tv=findViewById(R.id.textView);
            String data=tv.getText().toString();
            data=data.substring(0,data.length()-1);
            tv.setText(data);
        }catch (Exception e){
            tv.setText("Err");
        }

    }



}