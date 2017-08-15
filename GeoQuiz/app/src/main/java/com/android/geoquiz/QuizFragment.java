package com.android.geoquiz;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class QuizFragment extends Fragment {
    public static int quiz;
    public static int[][] colorArray = new int[5][11];



    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);



            for (int j = 0; j < 11; j++) {

                if (colorArray[CategoryFragment.cat][j] == 0) {
                    colorArray[CategoryFragment.cat][j] = Color.GRAY;
                }
                if (colorArray[CategoryFragment.cat][j] == 1) {
                    colorArray[CategoryFragment.cat][j] = Color.GREEN;
                }
                if (colorArray[CategoryFragment.cat][j] == 2) {
                    colorArray[CategoryFragment.cat][j] = Color.RED;
                }
                if (colorArray[CategoryFragment.cat][j] == 3) {
                    colorArray[CategoryFragment.cat][j] = Color.BLUE;
                }
            }





        Button one= (Button) view.findViewById(R.id.yuz1);
        Button two = (Button) view.findViewById(R.id.yuz2);
        Button three = (Button) view.findViewById(R.id.yuz3);
        Button four = (Button) view.findViewById(R.id.ikiyuz1);
        Button five = (Button) view.findViewById(R.id.ikiyuz2);
        Button six = (Button) view.findViewById(R.id.ikiyuz3);
        Button seven = (Button) view.findViewById(R.id.ucyuz1);
        Button eight = (Button) view.findViewById(R.id.ucyuz2);
        Button nine = (Button) view.findViewById(R.id.dortyuz1);
        Button ten = (Button) view.findViewById(R.id.dortyuz2);
        Button finish = (Button) view.findViewById(R.id.bitis);
        Button returncat = (Button) view.findViewById(R.id.returncat);

             one.setBackgroundColor(colorArray[CategoryFragment.cat][1]);
             two.setBackgroundColor(colorArray[CategoryFragment.cat][2]);
             three.setBackgroundColor(colorArray[CategoryFragment.cat][3]);
             four.setBackgroundColor(colorArray[CategoryFragment.cat][4]);
             five.setBackgroundColor(colorArray[CategoryFragment.cat][5]);
             six.setBackgroundColor(colorArray[CategoryFragment.cat][6]);
             seven.setBackgroundColor(colorArray[CategoryFragment.cat][7]);
             eight.setBackgroundColor(colorArray[CategoryFragment.cat][8]);
             nine.setBackgroundColor(colorArray[CategoryFragment.cat][9]);
             ten.setBackgroundColor(colorArray[CategoryFragment.cat][10]);



        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionFragment fragment = new QuestionFragment();
                quiz = 1;
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                QuestionFragment fragment = new QuestionFragment();
                quiz = 2;

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                QuestionFragment fragment = new QuestionFragment();
                quiz = 3;

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quiz = 4;
                QuestionFragment fragment = new QuestionFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quiz = 5;
                QuestionFragment fragment = new QuestionFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionFragment fragment = new QuestionFragment();
                quiz = 6;
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionFragment fragment = new QuestionFragment();
                quiz = 7;

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionFragment fragment = new QuestionFragment();
                quiz = 8;


                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionFragment fragment = new QuestionFragment();
                quiz = 9;
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionFragment fragment = new QuestionFragment();
                quiz = 10;
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScoreFragment fragment = new ScoreFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });

        returncat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CategoryFragment fragment = new CategoryFragment();
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


