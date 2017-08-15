package com.android.geoquiz;


import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class QuestionFragment extends Fragment {
    private Button mAButton;
    private Button mBButton;
    private Button mCButton;
    private Button mDButton;
    private Button mNextButton;
    public int questionCount = 10;
    int pn;

    private TextView mScoreView;
    private TextView mCountView;
    private TextView mQuestionTextView;
    ProgressDialog progress;


    public static int mScore;

    private boolean running;
    private boolean isRunning;



    public QuestionFragment() {
        // Required empty public constructor¢
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_question, container, false);




        mScoreView = (TextView) view.findViewById(R.id.score);
        mQuestionTextView = (TextView) view.findViewById(R.id.question_text_view);
        mCountView = (TextView) view.findViewById(R.id.questionCo);


        if (savedInstanceState != null) {

            mScoreView = (TextView) savedInstanceState.getCharSequence("mScoreView");
            mQuestionTextView = (TextView) savedInstanceState.getCharSequence("mQuestionTextView");
            mCountView = (TextView) savedInstanceState.getCharSequence("mCountView");
            mScore = savedInstanceState.getInt("mScore");
            running= savedInstanceState.getBoolean("running");
            isRunning = savedInstanceState.getBoolean("isRunning");
        }

        if (isRunning) {
            running = true;
        }


        updateQuestion();
        updateScore();

        Thread t = new Thread() {
            public void run() {
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(1000); // 1 sec
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (questionCount > 0) {
                                    questionCount--;
                                        mCountView.setText(String.valueOf(questionCount));

                                } else {
                                    updateQuestion();
                                    questionCount =10;

                                }

                            }
                        });

                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }

        };
        t.start();



        mAButton = (Button) view.findViewById(R.id.a_button);
        mAButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mScore = mScore + pn;
                updateScore();
                //Log.d("ked", String.valueOf(mScore));
                mAButton.setBackgroundColor(Color.GREEN);
                QuizFragment.colorArray[CategoryFragment.cat][QuizFragment.quiz] = 1;

                QuizFragment fragment = new QuizFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });


        mBButton = (Button) view.findViewById(R.id.b_button);
        mBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBButton.setBackgroundColor(Color.RED);
                updateScore();
                QuizFragment.colorArray[CategoryFragment.cat][QuizFragment.quiz] = 2;
                QuizFragment fragment = new QuizFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });
        mCButton = (Button) view.findViewById(R.id.c_button);
        mCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore();
                mCButton.setBackgroundColor(Color.RED);
                QuizFragment.colorArray[CategoryFragment.cat][QuizFragment.quiz] = 2;

                QuizFragment fragment = new QuizFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });
        mDButton = (Button) view.findViewById(R.id.d_button);
        mDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore();
                QuizFragment.colorArray[CategoryFragment.cat][QuizFragment.quiz] = 2;
                mDButton.setBackgroundColor(Color.RED);
                QuizFragment fragment = new QuizFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        mNextButton = (Button) view.findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore();
                mNextButton.setBackgroundColor(Color.BLUE);
                QuizFragment.colorArray[CategoryFragment.cat][QuizFragment.quiz] = 3;
                Log.d("kedi", String.valueOf(QuizFragment.colorArray[CategoryFragment.cat][QuizFragment.quiz]));
                Log.d("ked", String.valueOf(CategoryFragment.cat));
                Log.d("ke", String.valueOf(QuizFragment.quiz));

                QuizFragment fragment = new QuizFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });



        return view;

    }


    private void updateScore() {

        mScoreView.setText("Score:  " + mScore);


    }

    private void updateQuestion() {

        progress = ProgressDialog.show(getActivity(), "Loading",
                "Questions are loading...", true);

        DatabaseReference mQuestionRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://geoquiz-fc40a.firebaseio.com/"+
                    CategoryFragment.category +"/" + QuizFragment.quiz + "/soru");
            mQuestionRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String question = dataSnapshot.getValue(String.class);
                    mQuestionTextView.setText(question);
                    progress.dismiss();


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });

        DatabaseReference mARef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://geoquiz-fc40a.firebaseio.com/"+
                CategoryFragment.category +"/" + QuizFragment.quiz + "/A");
        mARef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String a = dataSnapshot.getValue(String.class);
                mAButton.setText(a);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        DatabaseReference mscoreRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://geoquiz-fc40a.firebaseio.com/"+
                CategoryFragment.category +"/" + QuizFragment.quiz + "/puan");
        mscoreRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                 pn = dataSnapshot.getValue(Integer.class);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        DatabaseReference mBRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://geoquiz-fc40a.firebaseio.com/"+
                CategoryFragment.category +"/" + QuizFragment.quiz + "/B");
        mBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String b = dataSnapshot.getValue(String.class);
                mBButton.setText(b);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        DatabaseReference mCRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://geoquiz-fc40a.firebaseio.com/"+
                CategoryFragment.category +"/" + QuizFragment.quiz + "/C");
        mCRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String c = dataSnapshot.getValue(String.class);
                mCButton.setText(c);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        DatabaseReference mDRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://geoquiz-fc40a.firebaseio.com/"+
                CategoryFragment.category +"/" + QuizFragment.quiz + "/D");
        mDRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String d = dataSnapshot.getValue(String.class);
                mDButton.setText(d);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });



        }


    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("questionCount", questionCount);
        savedInstanceState.putInt("mScore", mScore);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("isRunning", isRunning);
    }



}


















