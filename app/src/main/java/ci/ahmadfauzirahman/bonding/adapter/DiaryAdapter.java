package ci.ahmadfauzirahman.bonding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ci.ahmadfauzirahman.bonding.R;
import ci.ahmadfauzirahman.bonding.model.DiaryIbuModel;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.AdapterViewHolder> {

    private List<DiaryIbuModel> diaryIbuModels;
    private int rowLayout;
    private Context context;
    private String TAG = this.getClass().getName();

    public DiaryAdapter(List<DiaryIbuModel> diaryIbuModels, int rowLayout, Context context) {
        this.diaryIbuModels = diaryIbuModels;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.feel.setText(diaryIbuModels.get(position).getNoted());
        holder.perasaan.setText(diaryIbuModels.get(position).getPerasaan());

    }

    @Override
    public int getItemCount() {
        return diaryIbuModels.size();
    }


    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        TextView feel, perasaan;
        LinearLayout lnDiaryIbu;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            lnDiaryIbu = itemView.findViewById(R.id.lnDiaryIbu);
            feel = itemView.findViewById(R.id.feel);
            perasaan = itemView.findViewById(R.id.perasaan);

        }
    }
}
