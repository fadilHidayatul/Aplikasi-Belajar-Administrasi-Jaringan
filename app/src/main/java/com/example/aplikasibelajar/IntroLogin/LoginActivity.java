package com.example.aplikasibelajar.IntroLogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasibelajar.MainActivity;
import com.example.aplikasibelajar.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        login();
    }

    private void login() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loggedIn = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(loggedIn);
                finish();
            }
        });
    }

    public void goSignUp(View view) {
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        finish();
        super.onDestroy();
    }
}
