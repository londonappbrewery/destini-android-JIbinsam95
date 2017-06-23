package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mTopButton, mBottomButton;
    TextView mQuestionView;
    int mStoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mStoryIndex = savedInstanceState.getInt("IndexKey");
        } else {
            mStoryIndex = 1;
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);
        mQuestionView = (TextView) findViewById(R.id.storyTextView);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1) {
                    mQuestionView.setText(R.string.T3_Story);
                    mTopButton.setText(R.string.T3_Ans1);
                    mBottomButton.setText(R.string.T3_Ans2);
                    updateIndex();
                } else if (mStoryIndex == 2) {
                    mQuestionView.setText(R.string.T6_End);
                    mTopButton.setVisibility(View.GONE);
                    mBottomButton.setVisibility(View.GONE);
                    updateIndex();

                }


            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1) {
                    mQuestionView.setText(R.string.T2_Story);
                    mTopButton.setText(R.string.T2_Ans1);
                    mBottomButton.setText(R.string.T2_Ans2);
                    updateIndex();
                } else if (mStoryIndex == 2) {
                    mQuestionView.setText(R.string.T4_End);
                    mTopButton.setVisibility(View.GONE);
                    mBottomButton.setVisibility(View.GONE);
                    updateIndex();

                }
            }

        });
    }

    public void updateIndex() {
        mStoryIndex = (mStoryIndex + 1) % 3;

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("IndexKey", mStoryIndex);
    }
}
