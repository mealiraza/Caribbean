package com.codecoy.caribbean.fragments.shop_view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codecoy.caribbean.R;
import com.codecoy.caribbean.adaptor.recycler_adaptor.DealsAdaptor;
import com.codecoy.caribbean.databinding.FragmentHistoricalSitesBinding;
import com.codecoy.caribbean.databinding.FragmentHistoryBinding;


public class HistoricalSites extends Fragment {



    public HistoricalSites() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentHistoricalSitesBinding mDataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_historical_sites, container, false);

        mDataBinding.historicalSitesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mDataBinding.historicalSitesRecyclerView.setAdapter(new DealsAdaptor(getContext()));

        return mDataBinding.getRoot();
    }
}