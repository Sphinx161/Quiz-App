package com.example.hackersquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button trueButton;
    private Button falseButton;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private TextView showText;
    private int index=0;


    questions[] questionbank = new questions[]{
            new questions(R.string.showQuestion,true),
            new questions(R.string.one,false),
            new questions(R.string.two,true),
            new questions(R.string.three,true),
            new questions(R.string.four,false),

};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next);
        prevButton = findViewById(R.id.previous);
        showText = findViewById(R.id.showText);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.true_button:
//                Toast.makeText(MainActivity.this,"True button",Toast.LENGTH_LONG)
//                        .show();
                checkAnswer(true);
                break;


            case R.id.false_button:
//                Toast.makeText(MainActivity.this,"False button",Toast.LENGTH_LONG)
//                        .show();
                checkAnswer(false);
                break;


            case R.id.next:
//                Toast.makeText(MainActivity.this,"Next button",Toast.LENGTH_LONG)
//                        .show();
                MoveNext();
                break;

            case R.id.previous:
//                Toast.makeText(MainActivity.this,"Previous button",Toast.LENGTH_LONG)
//                        .show();
                MovePrev();
                break;


        }

    }

    private void checkAnswer(boolean userinput){
        boolean correctAns = questionbank[index].getAnswer();
        int toastId;

        if(userinput == correctAns) {
            toastId = R.string.correct;
        }else
        {
            toastId = R.string.Incorrect;
        }

        Toast.makeText(MainActivity.this,toastId,Toast.LENGTH_SHORT)
                .show();
    }

    private void MoveNext(){
        index =( index+1) % questionbank.length;
        showText.setText(questionbank[index].getGetresid());
    }
    private void MovePrev(){
        if(index>0)
            index =( index-1) % questionbank.length;

        showText.setText(questionbank[index].getGetresid());


    }


}
