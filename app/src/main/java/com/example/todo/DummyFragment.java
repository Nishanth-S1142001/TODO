package com.example.todo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.snackbar.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class DummyFragment extends Fragment implements View.OnClickListener{
    Button pop;
    ViewGroup container1;
    Button snackbutton;
    ConstraintLayout layout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        container1 = container;
        View view = inflater.inflate(R.layout.fragment_dummy, container, false);
        snackbutton = view.findViewById(R.id.snackBarTest);
        layout = view.findViewById(R.id.dummyFragment);
        System.out.println(view + "view");
        pop = view.findViewById(R.id.pop);
        System.out.println(pop + "pop");
        pop.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       showDialog(container1);
                                   }
                               });
                snackbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackBar();
                    }
                });
        return view;

    }
    private void showDialog(ViewGroup container) {

        Context context = container.getContext();
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.popup);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bt);
        ImageView btnClose = dialog.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dialog.dismiss();
            }
        }
        );

        dialog.show();
    }
    private void snackBar()
    {
        Snackbar snackbar
                = Snackbar
                .make(  layout,
                        "Snack Message is here!",
                        Snackbar.LENGTH_LONG);
        snackbar.show();
    }
    @Override
    public void onClick(View v) {
        //do not remove this method, it is used to implement View.OnclickListener
            }
}