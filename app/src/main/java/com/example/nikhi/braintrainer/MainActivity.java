package com.example.nikhi.braintrainer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button startButton;
    Button button0,easyButton,mediumButton;
    Button button1;
    Button button2;
    Button button3;
    TextView resultTextView;
    TextView pointsTextView;
    TextView sumTextView;
    TextView timerTextView;
    RelativeLayout gameRelativeLayout;
    final boolean[] click = {false};
    RelativeLayout difficultyRelativeLayout;

    Button playAgainButton;
    ArrayList<Integer> answers=new ArrayList<Integer>();
    ArrayList<Integer>answers1=new ArrayList<>();
    int locationOfCorrectAnswer,score=0;
    int numberOfQuestions=0;

    public void playAgain( View view)
    {
        score=0;
        numberOfQuestions=0;
        button0.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        sumTextView.setVisibility(View.VISIBLE);
        timerTextView.setText("30s");
        pointsTextView.setText("0/0");
        resultTextView.setText("");
        playAgainButton.setVisibility(View.INVISIBLE);
        generateQuestion();
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                //playAgainButton.setVisibility(View.VISIBLE);
                button0.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
                sumTextView.setVisibility(View.INVISIBLE);
                MediaPlayer mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                mPlayer.start();
                timerTextView.setText("0s");
                resultTextView.setText("Your Score"+Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
            }
        }.start();

    }
    public void generateQuestion() {
        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        int c = rand.nextInt(61-20)+60;
        int d = rand.nextInt(61-30)+60;
        locationOfCorrectAnswer = rand.nextInt(4);

        int inCorrectAnswer;
        if (click[0]) {
            answers.clear();
            sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));
            for (int i = 0; i < 4; i++) {
                if (i == locationOfCorrectAnswer) {
                    answers.add(a + b);
                } else {
                    inCorrectAnswer = rand.nextInt(41);
                    while (inCorrectAnswer == a + b) {
                        inCorrectAnswer = rand.nextInt(41);
                    }
                    answers.add(inCorrectAnswer);
                }
            }
            button0.setText(Integer.toString(answers.get(0)));
            button1.setText(Integer.toString(answers.get(1)));
            button2.setText(Integer.toString(answers.get(2)));
            button3.setText(Integer.toString(answers.get(3)));
        }
        else
        {
            answers1.clear();
            sumTextView.setText(Integer.toString(c) + " + " + Integer.toString(d));
            for (int i = 0; i < 4; i++) {
                if (i == locationOfCorrectAnswer) {
                    answers1.add(c + d);
                } else {
                    inCorrectAnswer = rand.nextInt(121);
                    while (inCorrectAnswer == c + d || inCorrectAnswer < c || inCorrectAnswer < d||inCorrectAnswer>2*(c+d)) {
                        inCorrectAnswer = rand.nextInt(121);
                    }
                    answers1.add(inCorrectAnswer);
                }
            }
            button0.setText(Integer.toString(answers1.get(0)));
            button1.setText(Integer.toString(answers1.get(1)));
            button2.setText(Integer.toString(answers1.get(2)));
            button3.setText(Integer.toString(answers1.get(3)));
        }


    }

    public void generateQuestion1() {
        Random rand = new Random();
        int a = rand.nextInt(11);
        int b = rand.nextInt(11);
        int c = rand.nextInt(21-11)+10;
        int d= rand.nextInt(11)+20;
        locationOfCorrectAnswer = rand.nextInt(4);
        int inCorrectAnswer;
        if (click[0] == true) {
            answers.clear();
            sumTextView.setText(Integer.toString(a) + " * " + Integer.toString(b));
            for (int i = 0; i < 4; i++) {
                if (i == locationOfCorrectAnswer) {
                    answers.add(a * b);
                } else {
                    inCorrectAnswer = rand.nextInt(101);
                    while (inCorrectAnswer == a * b || inCorrectAnswer < a || inCorrectAnswer < b) {
                        inCorrectAnswer = rand.nextInt(101);
                    }
                    answers.add(inCorrectAnswer);
                }
            }
            button0.setText(Integer.toString(answers.get(0)));
            button1.setText(Integer.toString(answers.get(1)));
            button2.setText(Integer.toString(answers.get(2)));
            button3.setText(Integer.toString(answers.get(3)));
        }
        else {
            answers1.clear();
            sumTextView.setText(Integer.toString(c) + " * " + Integer.toString(d));
            for (int i = 0; i < 4; i++) {
                if (i == locationOfCorrectAnswer) {
                    answers1.add(c * d);
                }
                else {
                    inCorrectAnswer = rand.nextInt(901);
                    while (inCorrectAnswer == c * d || inCorrectAnswer < c || inCorrectAnswer < d) {
                        inCorrectAnswer = rand.nextInt(901);
                    }
                    answers1.add(inCorrectAnswer);
                }
            }

            button0.setText(Integer.toString(answers1.get(0)));
            button1.setText(Integer.toString(answers1.get(1)));
            button2.setText(Integer.toString(answers1.get(2)));
            button3.setText(Integer.toString(answers1.get(3)));
        }
    }
    public void generateQuestion2() {
        Random rand = new Random();
        int a = rand.nextInt(41);
        int b = rand.nextInt(41);
        //int c = rand.nextInt(41);
        //int d =rand.nextInt(41);
        locationOfCorrectAnswer = rand.nextInt(4);
        int inCorrectAnswer;
            answers.clear();
            sumTextView.setText(Integer.toString(a) + " - " + Integer.toString(b));
            for (int i = 0; i < 4; i++) {
                if (i == locationOfCorrectAnswer) {
                    answers.add(a - b);
                } else {
                    inCorrectAnswer = rand.nextInt(41);
                    while (inCorrectAnswer == a - b) {
                        inCorrectAnswer = rand.nextInt(41);
                    }
                    answers.add(inCorrectAnswer);
                }
            }
            button0.setText(Integer.toString(answers.get(0)));
            button1.setText(Integer.toString(answers.get(1)));
            button2.setText(Integer.toString(answers.get(2)));
            button3.setText(Integer.toString(answers.get(3)));


    }
    public void chooseAnswer(View view) {
        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {
            score++;
            resultTextView.setText("Correct!!");
        } else {
            resultTextView.setText("WRONG!!");
        }
        numberOfQuestions++;
        pointsTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        Random rand = new Random();
       int a = rand.nextInt(3);
        if (a == 0)
        {
            generateQuestion1();
        } else if(a==1)
        {
            generateQuestion();
        }
        else
        {
            generateQuestion2();
        }
    }
    public void start(View view)
    {
        startButton.setVisibility(View.INVISIBLE);
        difficultyRelativeLayout.setVisibility(View.VISIBLE);
    }
    public void start1(View view)
    {
        gameRelativeLayout.setVisibility(View.VISIBLE);
        click[0]=true;
        playAgain(findViewById(R.id.playAgainButton));
    }
    public void start2(View view)
    {
        gameRelativeLayout.setVisibility(View.VISIBLE);
        click[0]=false;
        playAgain(findViewById(R.id.playAgainButton));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        easyButton=(Button)findViewById(R.id.easyButton);


        mediumButton=(Button)findViewById(R.id.mediumButton);
        startButton=(Button)findViewById(R.id.startButton);
        difficultyRelativeLayout=(RelativeLayout)findViewById(R.id.difficultyRelativeLayout);
        sumTextView=(TextView)findViewById(R.id.sumTextView);
        timerTextView=(TextView)findViewById(R.id.timerTextView);
        button0=(Button)findViewById(R.id.button0);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        resultTextView=(TextView)findViewById(R.id.resultTextView);
        pointsTextView=(TextView)findViewById(R.id.pointsTextView);
        playAgainButton=(Button)findViewById(R.id.playAgainButton);
        gameRelativeLayout=(RelativeLayout)findViewById(R.id.gameRelativeLayout);

    }
}
