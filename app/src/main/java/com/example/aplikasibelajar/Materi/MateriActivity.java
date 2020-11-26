package com.example.aplikasibelajar.Materi;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasibelajar.Materi.Adapter.MateriAdapter;
import com.example.aplikasibelajar.R;
import com.example.aplikasibelajar.UtilsApi.ApiInterface;
import com.example.aplikasibelajar.UtilsApi.UtilsApi;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MateriActivity extends AppCompatActivity {


    RecyclerView recycleMateri;
    List<Materi.DataBean> dataBeans;
    MateriAdapter materiAdapter;

    ApiInterface apiInterface;
    Context context;

    @BindView(R.id.toolbarMateri)
    Toolbar toolbarMateri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
        ButterKnife.bind(this);
        recycleMateri = findViewById(R.id.recycleMateri);
        context = this;

        setSupportActionBar(toolbarMateri);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Materi");

        apiInterface = UtilsApi.getApiService();
        fetchMateri();
    }

    private void fetchMateri() {
        apiInterface.getMateri().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject object = new JSONObject(response.body().string());
                        if (object.getInt("status") == 200) {
                            JSONArray array = object.getJSONArray("data");

                            dataBeans = new ArrayList<>();
                            Gson gson = new Gson();
                            for (int i = 0; i < array.length(); i++) {
                                Materi.DataBean dataBean = gson.fromJson(array.getJSONObject(i).toString(), Materi.DataBean.class);
                                dataBeans.add(dataBean);
                            }

                            materiAdapter = new MateriAdapter(context, dataBeans);
                            recycleMateri.setAdapter(materiAdapter);
                            recycleMateri.setLayoutManager(new LinearLayoutManager(context));
                            recycleMateri.setHasFixedSize(true);

                        } else {
                            //Toast.makeText(context, ""+object.getString("status"), Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        JSONObject object = new JSONObject(response.errorBody().string());
                        //Toast.makeText(context, ""+object.getString("pesan"), Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(context, "Jaringan ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
