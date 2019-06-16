package com.example.culturio.fragment;


import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.culturio.Common;
import com.example.culturio.R;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class MuseoMapFragment extends Fragment {

    Button btnStart;
    FloatingActionButton floatingActionButton;

    public MuseoMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_museo_map, container, false);
        floatingActionButton = getActivity().findViewById(R.id.floatButton);
        floatingActionButton.hide();
        btnStart = view.findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarFramento(new QuizFragment());
            }
        });
        Common.positionQuiz = 0;
        Common.puntajeTotal = 0;
        Common.preg1 = 0;
        Common.preg2 = 0;
        Common.preg3 = 0;

        return view;
    }

    private void cargarFramento(Fragment fragment){
        /*Bundle bundle = new Bundle();
        bundle.putString("id",id);
        fragment.setArguments(bundle);*/

        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.map_home,fragment).addToBackStack(null).commit();
    }

}
