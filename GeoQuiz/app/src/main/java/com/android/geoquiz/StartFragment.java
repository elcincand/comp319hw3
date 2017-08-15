package com.android.geoquiz;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class StartFragment extends Fragment {

    ImageButton startButton;
    public static int gamecount;



    public StartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        startButton = (ImageButton) view.findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                    Thread mainThread = new Thread() {
            public void run() {
                gamecount = 0;
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(100); // 1 sec
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                gamecount++;
                            }

                        });

                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        };
        mainThread.start();


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
