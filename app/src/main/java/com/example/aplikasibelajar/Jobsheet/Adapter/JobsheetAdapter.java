package com.example.aplikasibelajar.Jobsheet.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasibelajar.Jobsheet.Jobsheet;
import com.example.aplikasibelajar.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JobsheetAdapter extends RecyclerView.Adapter<JobsheetAdapter.viewholder> {
    private Context context;
    private List<Jobsheet.DataBean> dataBeans;

    public JobsheetAdapter(Context context, List<Jobsheet.DataBean> dataBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public JobsheetAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_jobsheet,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobsheetAdapter.viewholder holder, int position) {
        holder.namaJobsheet.setText(dataBeans.get(position).getJudul_jobsheet());
    }

    @Override
    public int getItemCount() {
        return (dataBeans != null ? dataBeans.size() : 0);
    }

    public class viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.namaJobsheet)
        TextView namaJobsheet;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
