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

public class DummyFragment extends Fragment implements View.OnClickListener{
    Button pop;
    ViewGroup container1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        container1 = container;
        View view = inflater.inflate(R.layout.fragment_dummy, container, false);
        System.out.println(view);
        pop = view.findViewById(R.id.pop);
        System.out.println(pop);
        pop.setOnClickListener(this);
        return view;
    }
    private void showDialog(ViewGroup container) {

        Context context = container.getContext();
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.popup);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bt);
        ImageView btnClose = dialog.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
    @Override
    public void onClick(View v) {
        //do what you want to do when button is clicked

        showDialog(container1);
    }
}