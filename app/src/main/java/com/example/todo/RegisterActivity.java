package com.example.todo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private Button register, back;      private EditText editEmail,editPassword;    private FirebaseAuth auth;  private int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            register = (Button) findViewById(R.id.register);
            editEmail = (EditText) findViewById(R.id.editEmail);
            editPassword = (EditText) findViewById(R.id.editPassword);
            auth = FirebaseAuth.getInstance();
            back = (Button)findViewById(R.id.back);
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String email = editEmail.getText().toString();
                    String password = editPassword.getText().toString();
                    if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) )
                    {
                        Toast.makeText(RegisterActivity.this,"Empty Credentials!",Toast.LENGTH_LONG).show();
                    }
                    else if (password.length()<7)
                    {
                        Toast.makeText(RegisterActivity.this,"Password too short!",Toast.LENGTH_LONG).show();
                    }
                    else if (!email.endsWith(".com"))
                    {
                        Toast.makeText(RegisterActivity.this,"Incorrect mail!",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        registerUser(email,password);

                    }

                }


            });
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(RegisterActivity.this, StartActivity.class));
                    finish();
                }
            });


            return insets;
        });

    }

    private void registerUser(String email, String password) {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this,new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful())
                    {
                        System.out.println("Hi, successful message here");
                        Toast.makeText(RegisterActivity.this,"Successful Registration", Toast.LENGTH_SHORT ).show();
                        startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                        finish();
                    }
                    else
                    {
                        System.out.println("Hi, unsuccessful message here");
                        Toast.makeText(RegisterActivity.this,"Unsuccessful Registration", Toast.LENGTH_SHORT ).show();
                    }
                }
            });
    }
}