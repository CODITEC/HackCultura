package com.example.culturio.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.culturio.Common;
import com.example.culturio.R;
import com.example.culturio.activity.CulturioActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    FloatingActionButton floatingActionButton;
    ImageView imgPerfil,imgqr;
    TextView txtNomPerfil,txtLugar,txtRanking,txtPuntos,txtBatallas;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        if(Common.returnHome == 1){
            return view;
        }
        floatingActionButton = getActivity().findViewById(R.id.floatButton);
        floatingActionButton.hide();
        imgPerfil = view.findViewById(R.id.imgPerfil);
        imgqr = view.findViewById(R.id.image_qr);
        int id = getResources().getIdentifier(Common.datosPersona.get(3), "drawable",getContext().getPackageName());
        imgPerfil.setImageResource(id);
        int id2 = getResources().getIdentifier(Common.datosPersona.get(8), "drawable",getContext().getPackageName());
        imgqr.setImageResource(id2);
        txtNomPerfil = view.findViewById(R.id.txtNomPerfil);
        txtNomPerfil.setText(Common.datosPersona.get(1));
        txtLugar = view.findViewById(R.id.txtLugar);
        txtLugar.setText(Common.datosPersona.get(5));
        txtRanking = view.findViewById(R.id.txtRanking);
        txtRanking.setText(Common.datosPersona.get(4));
        txtPuntos = view.findViewById(R.id.txtPuntos);
        txtPuntos.setText(Common.datosPersona.get(6));
        txtBatallas = view.findViewById(R.id.txtBatallas);
        txtBatallas.setText(Common.datosPersona.get(7));

        return view;
    }

}
