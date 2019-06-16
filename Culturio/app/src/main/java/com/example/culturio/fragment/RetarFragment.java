package com.example.culturio.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.culturio.R;
import com.example.culturio.activity.ScanCodeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class RetarFragment extends Fragment {

    Button btnQR;
    //RelativeLayout relativeLayout;

    public RetarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_retar, container, false);
        /*btnQR = view.findViewById(R.id.btnQR);

        btnQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Abriendo QR",Toast.LENGTH_SHORT).show();
                /*Intent intent = new Intent(getActivity(), QrFragment.class);
                startActivity(intent);
                QrFragment qrFragment = new QrFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.map_home, qrFragment)
                .addToBackStack(null).commit();
            }
        });*/
        /*relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });*/
        return view;
    }

}
