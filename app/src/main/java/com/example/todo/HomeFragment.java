package com.example.todo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.ImageView;

import androidx.annotation.NonNull;


public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @NonNull ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;

    }

}



