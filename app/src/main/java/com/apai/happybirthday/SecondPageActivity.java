package com.apai.happybirthday;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Deque;
import java.util.LinkedList;

public class SecondPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        Bundle bundle = getIntent().getExtras();
        String ageToBeDisplayed = bundle.getString("age");
        String text = "COOL! So happy " + ageToBeDisplayed + " BIRTHDAY. Hope you like the decorations we have made and hope you liked your gift too!!! Wait hope you did find your gift, if not here's your chance...go find it should be somewhere around. HAPPY BIRTHDAY again.";
        String[] split = text.split(" ");
        Deque<String> words = new LinkedList<String>();
        for (int i = 0; i<split.length; i++)
        {
            words.addLast(split[i]);
        }
        showNextWord(words);
    }

    public void showNextWord(final Deque<String> words)
    {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            public void run()
            {
                TextView firstPageTextView = (TextView) findViewById(R.id.secondPageText);
                firstPageTextView.append(words.pollFirst()+" ");
                if (words.size()>0)
                    showNextWord(words);
            }
        }, 500);
    }

}
