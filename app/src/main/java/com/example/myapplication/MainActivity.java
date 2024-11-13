package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText email, password, confirmPassword;
    private TextView message;
    private Button regButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.poczta);
        password = findViewById(R.id.pass);
        confirmPassword = findViewById(R.id.passrepeat);
        message = findViewById(R.id.komunikat);
        regButton = findViewById(R.id.knopka);

        message.setText("Autor: Vitalii Shtenyk");

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateRegistration();
            }
        });
    }

    private void validateRegistration() {
        String emailString = email.getText().toString().trim();
        String passwordString = password.getText().toString().trim();
        String confirmPasswordString = confirmPassword.getText().toString().trim();

        if (!emailString.contains("@")) {
            message.setText("Nieprawidłowy adres e-mail");
            return;
        }

        if (!passwordString.equals(confirmPasswordString)) {
            message.setText("Hasła się różnią");
            return;
        }

        message.setText("Witaj " + emailString);
    }
}