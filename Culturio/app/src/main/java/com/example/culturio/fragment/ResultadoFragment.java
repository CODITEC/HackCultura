package com.example.culturio.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.culturio.Common;
import com.example.culturio.R;
import com.example.culturio.activity.CulturioActivity;

public class ResultadoFragment extends Fragment {

    TextView txtMsjResultado, txtTotal, txtPreg1, txtPreg2, txtPreg3;
    Button btnFinalizar;

    public ResultadoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resultado, container, false);
        txtMsjResultado = view.findViewById(R.id.txtMsjResultado);
        txtTotal = view.findViewById(R.id.txtTotal);
        txtPreg1 = view.findViewById(R.id.txtPreg1);
        txtPreg2 = view.findViewById(R.id.txtPreg2);
        txtPreg3 = view.findViewById(R.id.txtPreg3);
        btnFinalizar = view.findViewById(R.id.btnFinalizar);
        final Activity activity = (Activity) getContext();
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarFramento(new MuseoMapFragment());
            }
        });

        Common.puntajeTotal = Common.preg1*100 + Common.preg2*200 + Common.preg3*300;
        txtTotal.setText("Has logrado: "+ Common.puntajeTotal+" PUNTOS");
        if(Common.puntajeTotal >= 600){
            txtMsjResultado.setText("¡Felicitaciones, has superado al lider del Museo, eres el nuevo Líder!");
        } else {
            txtMsjResultado.setText("No lograste superar al lider del Museo, ¡sigue intentando!");
        }
        txtPreg1.setText(Common.preg1 == 0 ? "Pregunta 1: Incorrecta(+0)" : "Pregunta 1: Correcta(+100)");
        txtPreg2.setText(Common.preg2 == 0 ? "Pregunta 2: Incorrecta(+0)" : "Pregunta 2: Correcta(+200)");
        txtPreg3.setText(Common.preg3 == 0 ? "Pregunta 3: Incorrecta(+0)" : "Pregunta 3: Correcta(+300)");

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
