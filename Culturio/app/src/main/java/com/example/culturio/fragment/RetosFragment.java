package com.example.culturio.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.culturio.R;


public class RetosFragment extends Fragment {

    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_retos, container, false);

        textView = view.findViewById(R.id.userPeleador);

        String value = this.getArguments().getString("key");
        String[] nombre = value.split(" ");
        String finalValue = "¡Has retado a"+nombre[0]+"!";
        textView.setText(finalValue);
        return view;
    }

}
