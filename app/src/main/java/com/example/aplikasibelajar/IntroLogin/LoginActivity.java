package com.example.aplikasibelajar.IntroLogin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasibelajar.MainActivity;
import com.example.aplikasibelajar.R;
import com.example.aplikasibelajar.UtilsApi.ApiInterface;
import com.example.aplikasibelajar.UtilsApi.UtilsApi;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    Context context;

    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.inputUsername)
    EditText inputUsername;
    @BindView(R.id.inputPassword)
    EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        context = this;
        apiInterface = UtilsApi.getApiLogin();

        login();
    }

    private void login() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(inputUsername.getText().toString())){
                    inputUsername.setError("Masukkan Username");
                    return;
                }else if(TextUtils.isEmpty(inputPassword.getText().toString())){
                    inputPassword.setError("Masukkan Password");
                    return;
                }else{
                    apiInterface.loginUser(inputUsername.getText().toString(),inputPassword.getText().toString()).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()){
                                try {
                                    JSONObject object = new JSONObject(response.body().string());
                                    if (object.getString("status").equals("200")){
                                        JSONObject data = object.getJSONObject("data");

                                        Gson gson = new Gson();
                                        Siswa.DataBean siswa = gson.fromJson(data+"",Siswa.DataBean.class);

                                        //session here

                                        Intent loggedIn = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(loggedIn);
                                        finish();
                                    }else {
                                        Toast.makeText(context, ""+object.getString("message"), Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {

                        }
                    });
                }
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
