package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
   private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
     this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display=findViewById(R.id.editText);

        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
          if(getString(R.string.display).equals(display.getText().toString())){
           display.setText("");
          }
         }
        });
    }

    private void updateText(String strToAdd){
     String oldStr =display.getText().toString();
     int cursorPos=display.getSelectionStart();
     String leftStr =oldStr.substring(0,cursorPos);
     String rightStr=oldStr.substring(cursorPos);
     if(getString(R.string.display).equals(display.getText().toString())){
      display.setText(strToAdd);
      display.setSelection(cursorPos + 1);
     }
     else{
      display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
      display.setSelection(cursorPos + 1);
     }

    }
    public void btn0 (View view){
        updateText("0");
    }
    public void btn1 (View view){
     updateText("1");
    }
    public void btn2 (View view){
     updateText("2");
    }
    public void btn3 (View view){
     updateText("3");
    }
    public void btn4 (View view){
     updateText("4");
    }
    public void btn5 (View view){
     updateText("5");
    }
    public void btn6 (View view){
     updateText("6");
    }
    public void btn7 (View view){
     updateText("7");
    }
    public void btn8 (View view){
     updateText("8");
    }
    public void btn9 (View view){
     updateText("9");
    }
    public void btnclear (View view){
     display.setText("");
    }
    public void btnüs (View view){
     updateText("^");
    }
    public void btnparantez (View view){
     int cursorPos=display.getSelectionStart();
     int openPar=0;
     int closedPar=0;
     int textLen=display.getText().length();
     for(int i=0;i<cursorPos;i++){
      if(display.getText().toString().substring(i,i+1).equals("(")){
       openPar+=1;
      }
      if(display.getText().toString().substring(i,i+1).equals(")")){
       closedPar+=1;
      }
     }
     if(openPar==closedPar||display.getText().toString().substring(textLen-1,textLen).equals("(")){
      updateText("(");
     }
   else if(closedPar < openPar && !display.getText().toString().substring(textLen-1,textLen).equals("(")){
      updateText(")");
     }
     display.setSelection(cursorPos+1);
    }
    public void btnböl (View view){
     updateText("÷");
    }
    public void btnçarp (View view){
     updateText("×");
    }
    public void btnartıeksi (View view){
     updateText("-");
    }
    public void btntopla (View view){
     updateText("+");
    }
    public void btnçıkar (View view){
     updateText("-");
    }
    public void btnvirgül (View view){
     updateText(".");
    }
    public void btneşittir (View view){
    String userExp=display.getText().toString();
    userExp = userExp.replaceAll("÷","/");
    userExp = userExp.replaceAll("×","*");
    Expression exp = new Expression(userExp);
    String result = String.valueOf(exp.calculate());
    display.setText(result);
    display.setSelection(result.length());
    }
    public void btnbackspace (View view){
        int crsorPos=display.getSelectionStart();
        int textLen=display.getText().length();
        if(crsorPos != 0 && textLen != 0){
         SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
         selection.replace(crsorPos - 1, crsorPos,"");
         display.setText(selection);
         display.setSelection(crsorPos - 1);
        }
    }
}