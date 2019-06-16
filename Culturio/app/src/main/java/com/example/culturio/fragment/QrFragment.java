package com.example.culturio.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.culturio.R;
import com.google.zxing.Result;

import org.json.JSONArray;
import org.json.JSONObject;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class QrFragment extends Fragment implements ZXingScannerView.ResultHandler {

    ZXingScannerView scannerView;
    FloatingActionButton floatingActionButton;

    public QrFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_qr, container, false);
        floatingActionButton = getActivity().findViewById(R.id.floatButton);
        floatingActionButton.hide();
        scannerView = new ZXingScannerView(getContext());

        return scannerView;
    }

    @Override
    public void handleResult(Result result) {

        Bundle bundle = new Bundle();
        bundle.putString("key",result.toString());

        Fragment retosFragment = new RetosFragment();
        retosFragment.setArguments(bundle);
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.map_home,retosFragment).addToBackStack(null).commit();
        //getFragmentManager().beginTransaction().replace(R.id.map_home, retosFragment).commit();

    }

    @Override
    public void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    public void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }
}
