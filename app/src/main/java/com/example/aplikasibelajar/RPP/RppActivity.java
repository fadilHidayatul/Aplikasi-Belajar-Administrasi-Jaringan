package com.example.aplikasibelajar.RPP;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasibelajar.Materi.Materi;
import com.example.aplikasibelajar.R;
import com.example.aplikasibelajar.RPP.Adapter.RppAdapter;
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

public class RppActivity extends AppCompatActivity {

    @BindView(R.id.toolbarRPP)
    Toolbar toolbarRPP;
    @BindView(R.id.recyclerRpp)
    RecyclerView recyclerRpp;
    
    ApiInterface apiInterface;
    Context context;
    RppAdapter adapter;
    List<Materi.DataBean> listRpp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rpp);
        ButterKnife.bind(this);
        context = this;
        
        setSupportActionBar(toolbarRPP);
        getSupportActionBar().setTitle("RPP");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        
        apiInterface = UtilsApi.getApiService();
        fetchRPP();
    }

    private void fetchRPP() {
        apiInterface.getMateri().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject object = new JSONObject(response.body().string());
                        if (object.getString("status").equals("200")){
                            JSONArray array = object.getJSONArray("data");

                            listRpp = new ArrayList<>();
                            Gson gson = new Gson();
                            for (int i = 0; i < array.length(); i++) {
                                Materi.DataBean dataBean = gson.fromJson(array.getJSONObject(i).toString(), Materi.DataBean.class);
                                listRpp.add(dataBean);
                            }

                            adapter = new RppAdapter(context,listRpp);
                            recyclerRpp.setAdapter(adapter);
                            recyclerRpp.setLayoutManager(new LinearLayoutManager(context));
                            recyclerRpp.setHasFixedSize(true);
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
