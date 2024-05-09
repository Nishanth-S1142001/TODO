package com.example.todo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    EditText edit; TextView task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("hey");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        edit = (EditText) findViewById(R.id.edit);
        task = (TextView) findViewById(R.id.task);

    }
    // change 1
    // change 1
        public void AddText(View view)
        {
            System.out.print("Clicked\n");
            task.setText(edit.getText().toString().trim());
            System.out.println("Value of input :"+ edit.getText());

        }
        public void DelText(View view)
        {
            System.out.print("Clicked\n");
            task.setText(null);

        }

}