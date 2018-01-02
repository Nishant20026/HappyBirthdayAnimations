package com.apai.happybirthday;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Deque;
import java.util.LinkedList;

public class IntroductionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        String text = "Good morning, I am told that its your birthday today! How many years would you complete on this beautiful planet today?";
        String[] split = text.split(" ");
        Deque<String> words = new LinkedList<String>();
        for (int i = 0; i<split.length; i++)
        {
            words.addLast(split[i]);
        }
        showNextWord(words);
        final EditText ageTextBox = (EditText) findViewById(R.id.ageTextBox);
        Button next = (Button)findViewById(R.id.nextButton);
        next.setEnabled(false);
        ageTextBox.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Check if 's' is empty

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                Button next = (Button)findViewById(R.id.nextButton);
                // TODO Auto-generated method stub
                next.setEnabled(true);

            }
        });
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondPageActivity.class);
                intent.putExtra("age", ageTextBox.getText().toString());
                view.getContext().startActivity(intent);
            }
        });
    }

    public void showNextWord(final Deque<String> words)
    {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            public void run()
            {
                TextView firstPageTextView = (TextView) findViewById(R.id.firstPageText);
                firstPageTextView.append(words.pollFirst()+" ");
                if (words.size()>0)
                    showNextWord(words);
            }
        }, 500);
    }
    }
