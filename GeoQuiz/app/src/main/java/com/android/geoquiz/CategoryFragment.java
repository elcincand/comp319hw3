package com.android.geoquiz;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
public static String category;
    public static int cat ;
    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);



        Button general = (Button)view.findViewById(R.id.general);

        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           category = "general";
                cat = 1;
                QuizFragment fragment = new QuizFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


               // Bundle bundle = new Bundle();
               // bundle.putString("category", "general");

            }
        });

        Button movies = (Button)view.findViewById(R.id.movies);

        movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category = "movie";
                cat =2;
                QuizFragment fragment = new QuizFragment();

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        Button game = (Button)view.findViewById(R.id.game);

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category = "game";
                cat =3;
                QuizFragment fragment = new QuizFragment();

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        Button rick = (Button)view.findViewById(R.id.rick);

        rick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category = "dabadabadubdub";
                cat =4;
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

}
