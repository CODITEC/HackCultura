package com.example.culturio.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.culturio.R;

public class QuizFragment extends Fragment {

    ImageView respuestaA, respuestaB, respuestaC;

    public QuizFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_quiz, container, false);
        respuestaA = view.findViewById(R.id.respuestaA);
        respuestaB = view.findViewById(R.id.respuestaB);
        respuestaC = view.findViewById(R.id.respuestaC);

        respuestaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAnswer(0);
            }
        });
        respuestaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAnswer(0);
            }
        });
        respuestaC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAnswer(1);
            }
        });
        return view;
    }

    private void showDialogAnswer(int i) {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
        dialog.setTitle("RESULTADO: ");

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View login_layout = inflater.inflate(R.layout.layout_answer, null);
        ImageView imgResultado = login_layout.findViewById(R.id.imgResultado);
        TextView txtResultado = login_layout.findViewById(R.id.txtResultado);
        if(i == 1){
            dialog.setMessage("");
            imgResultado.setImageResource(R.drawable.ic_check);
            txtResultado.setText("¡RESPUESTA CORRECTA!");
        } else {
            dialog.setMessage("Respuesta correcta: A) TUMI");
            imgResultado.setImageResource(R.drawable.ic_cancel);
            txtResultado.setText("¡RESPUESTA INCORRECTA!");
        }
        /*
        final MaterialEditText edtUsuario = login_layout.findViewById(R.id.edtUsuario);
        final MaterialEditText edtPass = login_layout.findViewById(R.id.edtPassword);
        */
        dialog.setView(login_layout);
        dialog.show();
    }
}
