package com.example.aplikasibelajar.Video.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasibelajar.R;
import com.example.aplikasibelajar.Video.PlayVideoActivity;
import com.example.aplikasibelajar.Video.Video;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.viewholder> {
    private Context context;
    private List<Video.DataBean> dataBeanList;

    public VideoAdapter(Context context, List<Video.DataBean> dataBeanList) {
        this.context = context;
        this.dataBeanList = dataBeanList;
    }

    @NonNull
    @Override
    public VideoAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_video,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.viewholder holder, int position) {
        holder.namaVideo.setText(dataBeanList.get(position).getJudul_video());
        holder.cardSelectVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayVideoActivity.class);
                intent.putExtra("id", dataBeanList.get(position).getLink());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (dataBeanList!=null ? dataBeanList.size() : 0);
    }

    public class viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.namaVideo)
        TextView namaVideo;
        @BindView(R.id.cardSelectVideo)
        CardView cardSelectVideo;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
