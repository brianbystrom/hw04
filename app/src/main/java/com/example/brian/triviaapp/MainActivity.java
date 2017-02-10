package com.example.brian.triviaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity implements GetJSONAsync.IData {

    ProgressBar loadingTrivia;
    TextView loadingTriviaLabel, triviaReadyLabel;
    ImageView triviaReadyImage;
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingTrivia = (ProgressBar) findViewById(R.id.loading_progress_bar);
        loadingTriviaLabel = (TextView) findViewById(R.id.loading_trivia_label);
        triviaReadyImage = (ImageView) findViewById(R.id.trivia_image);
        triviaReadyLabel = (TextView) findViewById(R.id.trivia_ready_label);
        startBtn = (Button) findViewById(R.id.start_btn);

        String URL;

        URL = "http://dev.theappsdr.com/apis/trivia_json/index.php";
        new GetJSONAsync(MainActivity.this).execute(URL);
    }

    public void setupData(final ArrayList<Data> s) {
        if (s != null) {

            for (int i = 0; i < s.size(); i++) {
                Log.d("DEMO", s.get(i).toString());
            }

            loadingTrivia.setVisibility(GONE);
            loadingTriviaLabel.setVisibility(GONE);
            triviaReadyImage.setVisibility(VISIBLE);
            triviaReadyLabel.setVisibility(VISIBLE);
            startBtn.setEnabled(true);



            /*setArticleInformation(current_article, s);

            new SetImageAsync(MainActivity.this).execute(s.get(0).getUrlToImage().toString());

            first_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    current_article = 0;
                    setArticleInformation(current_article, s);
                }
            });

            prev_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(current_article > 0) {
                        current_article--;
                        setArticleInformation(current_article, s);
                    } else {
                        Toast.makeText(MainActivity.this, "You are already on the first article.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(current_article < s.size()-1 ) {
                        current_article++;
                        setArticleInformation(current_article, s);
                    } else {
                        Toast.makeText(MainActivity.this, "You are already on the last article.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            last_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    current_article = s.size()-1;
                    setArticleInformation(current_article, s);
                }
            });*/

        } else {
            //Log.d("DEMO","");
        }
    }
}
