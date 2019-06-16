package com.example.culturio.fragment;


import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.culturio.Common;
import com.example.culturio.R;
import com.example.culturio.Retrofit.INodeJS;
import com.example.culturio.Retrofit.RetrofitClient;
import com.mikhaellopez.circularimageview.CircularImageView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Locale;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class MuseoMapFragment extends Fragment {

    Button btnStart;
    FloatingActionButton floatingActionButton;
    INodeJS myAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    TextView txtFacebook, txtPuntaje, txtNombre;
    CircularImageView imgLider;
    LinearLayout guiaGo;

    public MuseoMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_museo_map, container, false);
        if(Common.returnHome == 1){
            return view;
        }
        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(INodeJS.class);
        floatingActionButton = getActivity().findViewById(R.id.floatButton);
        floatingActionButton.hide();
        btnStart = view.findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarFramento(new QuizFragment());
            }
        });
        txtFacebook = view.findViewById(R.id.txtFacebook);
        txtPuntaje = view.findViewById(R.id.txtPuntaje);
        txtNombre = view.findViewById(R.id.txtNombre);
        imgLider = view.findViewById(R.id.imgLider);
        guiaGo = view.findViewById(R.id.guiaGo);
        guiaGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarFramento(new GuiaFragment());
            }
        });
        Common.positionQuiz = 0;
        Common.puntajeTotal = 0;
        Common.preg1 = 0;
        Common.preg2 = 0;
        Common.preg3 = 0;
        getDatosLider();

        return view;
    }

    private void getDatosLider() {
        compositeDisposable.add(myAPI.datosLider(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        if(s.contains("data")){
                            JSONObject jsonObj = new JSONObject(s);
                            JSONArray array = jsonObj.getJSONArray("data");
                            Log.e("data",""+jsonObj.get("data"));
                            JSONObject jsonObj2 = (JSONObject) array.get(0);
                            txtNombre.setText(jsonObj2.getString("TXTNOMBRELIDER"));
                            txtFacebook.setText(jsonObj2.getString("TXTFACEBOOK"));
                            txtPuntaje.setText(jsonObj2.getString("NUMPUNTAJELIDER"));
                            int id = getResources().getIdentifier(jsonObj2.getString("TXTIMGURLLIDER"), "drawable",getContext().getPackageName());
                            imgLider.setImageResource(id);

                            //txtLab.setText(jsonObj2.getString("TXTDESCAULA"));
                        }
                    }
                })
        );
    }

    private void cargarFramento(Fragment fragment){
        /*Bundle bundle = new Bundle();
        bundle.putString("id",id);
        fragment.setArguments(bundle);*/

        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.map_home,fragment).addToBackStack(null).commit();
    }

}
