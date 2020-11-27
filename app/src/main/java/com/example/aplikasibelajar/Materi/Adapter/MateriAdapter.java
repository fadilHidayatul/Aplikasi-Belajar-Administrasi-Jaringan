package com.example.aplikasibelajar.Materi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasibelajar.Materi.Materi;
import com.example.aplikasibelajar.Materi.MateriReadActivity;
import com.example.aplikasibelajar.R;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MateriAdapter extends RecyclerView.Adapter<MateriAdapter.viewHolder> {
    private Context context;
    private List<Materi.DataBean> dataBeans;

    public MateriAdapter(Context context, List<Materi.DataBean> dataBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_materi, parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.txtJudulMateri.setText(dataBeans.get(position).getJudul_materi());
        holder.cardSelectMateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MateriReadActivity.class);
                intent.putExtra("idMateri",dataBeans.get(position).getId_materi());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtJudulMateri)
        TextView txtJudulMateri;
        @BindView(R.id.cardSelectMateri)
        CardView cardSelectMateri;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
