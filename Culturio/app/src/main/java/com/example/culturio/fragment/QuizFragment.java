package com.example.culturio.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.culturio.Common;
import com.example.culturio.R;

public class QuizFragment extends Fragment {

    ImageView respuestaA, respuestaB, respuestaC;
    TextView txtQuestion, txtRespuestaA, txtRespuestaB, txtRespuestaC;

    public QuizFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Common.positionQuiz++;
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_quiz, container, false);
        respuestaA = view.findViewById(R.id.respuestaA);
        respuestaB = view.findViewById(R.id.respuestaB);
        respuestaC = view.findViewById(R.id.respuestaC);

        Log.d("QUIZ", ""+Common.positionQuiz);
        Log.d("QUIZ", ""+Common.listaPreguntas.get(Common.positionQuiz));
        String quiz = Common.listaPreguntas.get(Common.positionQuiz);
        final String[] split = quiz.split("-");

        Log.d("QUIZ", ""+split);
        txtQuestion = view.findViewById(R.id.txtQuestion);
        txtRespuestaA = view.findViewById(R.id.txtRespuestaA);
        txtRespuestaB = view.findViewById(R.id.txtRespuestaB);
        txtRespuestaC = view.findViewById(R.id.txtRespuestaC);

        txtQuestion.setText(split[0]);
        txtRespuestaA.setText(split[1]);
        txtRespuestaB.setText(split[2]);
        txtRespuestaC.setText(split[3]);

        respuestaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer answer = 0;
                if(split[4].equals("1")){
                    answer = 1;
                }
                showDialogAnswer(answer,split[5],split[6],split[7]);
            }
        });
        respuestaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer answer = 0;
                if(split[4].equals("2")){
                    answer = 1;
                }
                showDialogAnswer(answer,split[5],split[6],split[7]);
            }
        });
        respuestaC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer answer = 0;
                if(split[4].equals("3")){
                    answer = 1;
                }
                showDialogAnswer(answer,split[5],split[6],split[7]);
            }
        });
        return view;
    }

    private void showDialogAnswer(int i, String s1, String s2, String s3) {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
        dialog.setTitle("RESULTADO: ");

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View login_layout = inflater.inflate(R.layout.layout_answer, null);
        ImageView imgResultado = login_layout.findViewById(R.id.imgResultado);
        TextView txtResultado = login_layout.findViewById(R.id.txtResultado);
        TextView txtDescripcion = login_layout.findViewById(R.id.txtDescripcion);
        ImageView imgAnswer = login_layout.findViewById(R.id.imgAnswer);
        txtDescripcion.setText(s3);
        int id = getResources().getIdentifier(s1, "drawable",getContext().getPackageName());

        imgAnswer.setImageResource(id);
        dialog.setMessage("Respuesta correcta: "+s2);
        if(i == 1){
            imgResultado.setImageResource(R.drawable.ic_check);
            txtResultado.setText("¡RESPUESTA CORRECTA!");
        } else {
            imgResultado.setImageResource(R.drawable.ic_cancel);
            txtResultado.setText("¡RESPUESTA INCORRECTA!");
        }

        dialog.setView(login_layout);
        String textoBotton = "SIGUIENTE";
        if(Common.positionQuiz == 3){
            textoBotton = "FINALIZAR";
        }
        dialog.setNegativeButton(textoBotton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(Common.positionQuiz == 3){
                    cargarFramento(new ResultadoFragment());
                } else {
                    cargarFramento(new QuizFragment());
                }
            }
        });
        dialog.show();
    }

    private void cargarFramento(Fragment fragment){
        /*Bundle bundle = new Bundle();
        bundle.putString("id",id);
        fragment.setArguments(bundle);*/

        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.map_home,fragment).addToBackStack(null).commit();
    }
}
