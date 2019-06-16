package com.example.culturio.fragment;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.culturio.R;
import com.example.culturio.adapter.AdapterMedals;
import com.example.culturio.model.Medal;
import com.example.culturio.utils.DataGenerator;
import com.example.culturio.utils.SpacingItemDecoration;
import com.example.culturio.utils.Tools;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MedalsFragment extends Fragment {

    private View parent_view;
    private RecyclerView recyclerView;
    private AdapterMedals mAdapter;


    public MedalsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        parent_view = inflater.inflate(R.layout.fragment_medals, container, false);
        initComponent(parent_view);

        return parent_view;
    }

    private void initComponent(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(getContext(), 8), true));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        List<Medal> items = DataGenerator.getShoppingCategory(getContext());

        //set data and list adapter
        mAdapter = new AdapterMedals(getContext(), items);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new AdapterMedals.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Medal obj, int position) {
                Snackbar.make(parent_view, "Item" + obj.title + " clickeado", Snackbar.LENGTH_SHORT).show();
            }
        });

    }

}
