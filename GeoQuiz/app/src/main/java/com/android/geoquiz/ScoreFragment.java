package com.android.geoquiz;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class ScoreFragment extends Fragment {

    private TextView mScoreDisplay;
    private TextView mUserDisplay;
    private TextView mplayTimeDisplay;
    private ImageButton retry;



    public ScoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);

            retry = (ImageButton) view.findViewById(R.id.retryButton);
            mScoreDisplay=(TextView) view.findViewById(R.id.finalscore);
            mUserDisplay=(TextView) view.findViewById(R.id.projectuserName);
            mplayTimeDisplay=(TextView) view.findViewById(R.id.playTime);


        // mUserDisplay.setText(" Congratulations! " + name);
                mUserDisplay.setText(" Congratulations! ");




            int score = QuestionFragment.mScore;
            mScoreDisplay.setText("Your Score : " + score);

           int playTime = StartFragment.gamecount;
           mplayTimeDisplay.setText("Your total play time is : " + playTime);


        retry.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LogoFragment fragment = new LogoFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

            });

          return view;
        }
    }