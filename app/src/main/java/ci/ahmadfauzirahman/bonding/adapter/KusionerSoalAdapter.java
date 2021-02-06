package ci.ahmadfauzirahman.bonding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ci.ahmadfauzirahman.bonding.R;
import ci.ahmadfauzirahman.bonding.model.LpgdModel;

public class KusionerSoalAdapter extends RecyclerView.Adapter<KusionerSoalAdapter.AdapterViewHolder> {

    private List<LpgdModel> lpgdModels;
    private int rowLayout;
    private Context context;
    private String TAG = this.getClass().getName();

    public KusionerSoalAdapter(List<LpgdModel> lpgdModels, int rowLayout, Context context) {
        this.lpgdModels = lpgdModels;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new KusionerSoalAdapter.AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.soal.setText(lpgdModels.get(position).getQuotes());
        holder.id_spm.setText(lpgdModels.get(position).getJenis());

        System.out.println("JENIS SPM " + lpgdModels.get(position).getJenis());

        if (lpgdModels.get(position).getJenis().equals("LPGD")) {
            holder.lebih.setVisibility(View.GONE);
            holder.biasa.setVisibility(View.GONE);
            holder.kurang.setVisibility(View.GONE);
            holder.tidakpernah.setVisibility(View.GONE);

            holder.SELALU.setVisibility(View.GONE);
            holder.SERING.setVisibility(View.GONE);
            holder.kadang.setVisibility(View.GONE);
            holder.tidak.setVisibility(View.GONE);

        } else if (lpgdModels.get(position).getJenis().equals("PAI")) {
            holder.lebih.setVisibility(View.GONE);
            holder.biasa.setVisibility(View.GONE);
            holder.kurang.setVisibility(View.GONE);
            holder.tidakpernah.setVisibility(View.GONE);
            holder.Tidak.setVisibility(View.GONE);
            holder.Ya.setVisibility(View.GONE);
        } else if (lpgdModels.get(position).getJenis().equals("KHSI")) {
            holder.lebih.setVisibility(View.GONE);
            holder.biasa.setVisibility(View.GONE);
            holder.kurang.setVisibility(View.GONE);
            holder.tidakpernah.setVisibility(View.GONE);
            holder.Tidak.setVisibility(View.GONE);
            holder.Ya.setVisibility(View.GONE);
        } else if (lpgdModels.get(position).getJenis().equals("KDS")) {

            holder.Tidak.setVisibility(View.GONE);
            holder.Ya.setVisibility(View.GONE);
            holder.SELALU.setVisibility(View.GONE);
            holder.SERING.setVisibility(View.GONE);
            holder.kadang.setVisibility(View.GONE);
            holder.tidak.setVisibility(View.GONE);
        }
//        holder.SELALU.setVisibility();
    }

    @Override
    public int getItemCount() {
        return lpgdModels.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        LinearLayout lnEPDS;
        TextView soal, id_spm;
        RadioGroup edps, khsi, kds;
        RadioButton SELALU, SERING, Ya, Tidak, kadang, tidakpernah, lebih, biasa, kurang, tidak;


        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            lnEPDS = itemView.findViewById(R.id.lnEPDS);
            soal = itemView.findViewById(R.id.soal);
            id_spm = itemView.findViewById(R.id.id_spm);
            edps = (RadioGroup) itemView.findViewById(R.id.opsiEpds);
            khsi = (RadioGroup) itemView.findViewById(R.id.opsiKHSI);
            kds = (RadioGroup) itemView.findViewById(R.id.opsiKDS);


//        radio button
            Tidak = itemView.findViewById(R.id.Tidak);
            Ya = itemView.findViewById(R.id.Ya);
            tidak = itemView.findViewById(R.id.tidak);
            tidakpernah = itemView.findViewById(R.id.tidakpernah);
            lebih = itemView.findViewById(R.id.lebih);
            biasa = itemView.findViewById(R.id.biasa);
            kurang = itemView.findViewById(R.id.kurang);
            kadang = itemView.findViewById(R.id.kadang);
            SERING = itemView.findViewById(R.id.SERING);
            SELALU = itemView.findViewById(R.id.SELALU);

            //opsi khsi

//            EPDS
//            Tidak.setVisibility(View.GONE);
//            Ya.setVisibility(View.GONE);

//        khsi.setVisibility(View.GONE);

            //kds


        }
    }
}
