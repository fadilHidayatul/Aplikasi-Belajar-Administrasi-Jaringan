package com.example.aplikasibelajar.Soal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasibelajar.Materi.Materi;
import com.example.aplikasibelajar.R;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SoalAdapter extends RecyclerView.Adapter<SoalAdapter.viewHolder> {
    private Context context;
    private List<Materi.DataBean> dataBeans;

    public SoalAdapter(Context context, List<Materi.DataBean> dataBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public SoalAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_soal,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoalAdapter.viewHolder holder, int position) {
        holder.namaSoal.setText(dataBeans.get(position).getJudul_materi());
    }

    @Override
    public int getItemCount() {
        return (dataBeans!=null ? dataBeans.size() : 0);
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.namaSoal)
        TextView namaSoal;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
