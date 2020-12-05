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

import com.example.aplikasibelajar.R;
import com.example.aplikasibelajar.UtilsApi.ApiInterface;
import com.example.aplikasibelajar.UtilsApi.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    Context context;
    ApiInterface apiInterface;

    @BindView(R.id.editNama)
    EditText editNama;
    @BindView(R.id.editKelas)
    EditText editKelas;
    @BindView(R.id.editUsername)
    EditText editUsername;
    @BindView(R.id.editPassword)
    EditText editPassword;
    @BindView(R.id.btnSignUp)
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        context = this;
        apiInterface = UtilsApi.getApiLogin();

        doRegister();
    }

    private void doRegister() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editNama.getText().toString())){
                    editNama.setError("Masukkan Nama");
                }else if (TextUtils.isEmpty(editKelas.getText().toString())){
                    editKelas.setError("Masukkan Kelas");
                }else if (TextUtils.isEmpty(editUsername.getText().toString())){
                    editUsername.setText("Masukkan Username");
                }else if (TextUtils.isEmpty(editPassword.getText().toString())){
                    editPassword.setText("Masukkan Password");
                }else{
                    apiInterface.registerUser(editNama.getText().toString(),editKelas.getText().toString(),editUsername.getText().toString(),editPassword.getText().toString()).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()){
                                try {
                                    JSONObject object = new JSONObject(response.body().string());
                                    if (object.getString("status").equals("200")){
                                        Toast.makeText(context, ""+object.getString("message"), Toast.LENGTH_SHORT).show();
                                        Intent register = new Intent(getApplicationContext(),LoginActivity.class);
                                        startActivity(register);
                                        finish();
                                    }else{
                                        Toast.makeText(context, ""+object.getString("message"), Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }else{
                                try {
                                    JSONObject object = new JSONObject(response.errorBody().string());
                                    Toast.makeText(context, ""+object.getString("message"), Toast.LENGTH_SHORT).show();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(context, "Cek Koneksi Internet", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
