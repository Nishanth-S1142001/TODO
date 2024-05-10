package com.example.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private EditText edit;
    private TextView task;
    private Button logOut, add, del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Start of Home Activity");
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
        logOut = (Button) findViewById(R.id.logOut);
        add = (Button) findViewById(R.id.add);
        del = (Button) findViewById(R.id.del);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.print("Clicked\n");
                task.setText(edit.getText().toString().trim());
                System.out.println("Value of input :"+ edit.getText());
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.print("Clicked\n");
                task.setText(null);

            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(HomeActivity.this, "Log Out Successful!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomeActivity.this, StartActivity.class));
            }
        });
    }
}