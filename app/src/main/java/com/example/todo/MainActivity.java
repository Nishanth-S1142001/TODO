package com.example.todo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText editText1; TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("hey");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        editText1 = (EditText) findViewById(R.id.edittext1);
        textView1 = (TextView) findViewById(R.id.textView2);

    }
    // change 1
        public void AddText(View view)
        {
            System.out.print("Clicked\n");
            textView1.setText(editText1.getText().toString().trim());
            System.out.println("Value of input :"+ editText1.getText());

        }
        public void DelText(View view)
        {
            System.out.print("Clicked\n");
            textView1.setText(null);


        }

}