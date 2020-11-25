package com.example.aplikasibelajar.Video;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasibelajar.R;
import com.example.aplikasibelajar.UtilsApi.ApiInterface;
import com.example.aplikasibelajar.UtilsApi.UtilsApi;
import com.example.aplikasibelajar.Video.Adapter.VideoAdapter;
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

public class VideoActivity extends AppCompatActivity {

    @BindView(R.id.recyclerVideo)
    RecyclerView recyclerVideo;
    VideoAdapter videoAdapter;
    List<Video.DataBean> listVideo;

    Context context;
    ApiInterface apiInterface;

    @BindView(R.id.toolbarVideo)
    Toolbar toolbarVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        context = this;

        setSupportActionBar(toolbarVideo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Video");

        apiInterface = UtilsApi.getApiService();
        fetchVideo();
    }

    private void fetchVideo() {
        apiInterface.getVideo().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject object = new JSONObject(response.body().string());
                        if (object.getString("status").equals("200")) {
                            JSONArray array = object.getJSONArray("data");

                            listVideo = new ArrayList<>();
                            Gson gson = new Gson();
                            for (int i = 0; i < array.length(); i++) {
                                Video.DataBean dataBean = gson.fromJson(array.getJSONObject(i).toString(), Video.DataBean.class);
                                listVideo.add(dataBean);
                            }

                            videoAdapter = new VideoAdapter(context, listVideo);
                            recyclerVideo.setAdapter(videoAdapter);
                            recyclerVideo.setLayoutManager(new LinearLayoutManager(context));
                            recyclerVideo.setHasFixedSize(true);
                        } else {
                            Toast.makeText(context, "" + object.getString("status"), Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        JSONObject object = new JSONObject(response.errorBody().string());
                        Toast.makeText(context, "" + object.getString("pesan"), Toast.LENGTH_SHORT).show();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
