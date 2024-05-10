package com.example.todo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText editEmail, editPassword;
    private Button login,back;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            editEmail = (EditText) findViewById(R.id.editEmail);
            editPassword = (EditText) findViewById(R.id.editPassword);
            auth=FirebaseAuth.getInstance();
            login = (Button) findViewById(R.id.login);
            back = (Button) findViewById(R.id.back) ;
            login.setOnClickListener( new OnClickListener() {

                @Override
                public void onClick(View view) {
                    System.out.println("Login onClick");
                    String email =  editEmail.getText().toString().trim();
                    String password =  editPassword.getText().toString().trim();
                    loginUser(email,password);
                }
            });
            back.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(LoginActivity.this, StartActivity.class));
                    finish();
                }
            });
            return insets;
        });
    }

    private void loginUser(String email, String password) {
        auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this, "Successful login", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();

            }
        });
    }
}