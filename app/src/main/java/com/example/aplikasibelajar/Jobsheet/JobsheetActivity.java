package com.example.aplikasibelajar.Jobsheet;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasibelajar.Jobsheet.Adapter.JobsheetAdapter;
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

public class JobsheetActivity extends AppCompatActivity {
    
    @BindView(R.id.recyclerJobsheet)
    RecyclerView recyclerJobsheet;
    JobsheetAdapter jobsheetAdapter;
    List<Jobsheet.DataBean> listJobsheet;
    
    Context context;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobsheet);
        ButterKnife.bind(this);
        context = this;
        
        apiInterface = UtilsApi.getApiService();
        fetchJobsheet();
    }

    private void fetchJobsheet() {
        apiInterface.getJobsheet().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject object = new JSONObject(response.body().string());
                        if (object.getString("status").equals("200")){
                            JSONArray array = object.getJSONArray("data");

                            listJobsheet = new ArrayList<>();
                            Gson gson = new Gson();
                            for (int i = 0; i <array.length() ; i++) {
                                Jobsheet.DataBean dataBean = gson.fromJson(array.getJSONObject(i).toString(), Jobsheet.DataBean.class);
                                listJobsheet.add(dataBean);
                            }

                            jobsheetAdapter = new JobsheetAdapter(context,listJobsheet);
                            recyclerJobsheet.setAdapter(jobsheetAdapter);
                            recyclerJobsheet.setLayoutManager(new LinearLayoutManager(context));
                            recyclerJobsheet.setHasFixedSize(true);

                        }else{
                            Toast.makeText(context, ""+object.getString("status"), Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    try {
                        JSONObject object = new JSONObject(response.errorBody().string());
                        Toast.makeText(context, ""+object.getString("pesan"), Toast.LENGTH_SHORT).show();
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
