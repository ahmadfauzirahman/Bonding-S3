package ci.ahmadfauzirahman.bonding.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import ci.ahmadfauzirahman.bonding.R;
import ci.ahmadfauzirahman.bonding.model.ArtikelModel;
import ci.ahmadfauzirahman.bonding.view.DetailArtikelActivity;

public class ArtikelAdapter extends RecyclerView.Adapter<ArtikelAdapter.AdapterViewHolder> {

    private List<ArtikelModel> artikelModels;
    private int rowLayout;
    private Context context;
    private String TAG = this.getClass().getName();
    Intent intent;

    public ArtikelAdapter(List<ArtikelModel> artikelModels, int rowLayout, Context context) {
        this.artikelModels = artikelModels;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ArtikelAdapter.AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ArtikelAdapter.AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtikelAdapter.AdapterViewHolder holder, int position) {
        holder.id_artikel.setText(artikelModels.get(position).getIdArtikel());
        holder.judul.setText(artikelModels.get(position).getJudul());
        holder.isi.setText(artikelModels.get(position).getIsi());

    }

    @Override
    public int getItemCount() {
        return artikelModels.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        LinearLayout lnArtikel;
        TextView id_artikel, judul, isi;

        public AdapterViewHolder(@NonNull View itemView) {

            super(itemView);

            lnArtikel = itemView.findViewById(R.id.lnArtikel);
            id_artikel = itemView.findViewById(R.id.id_artikel);
            judul = itemView.findViewById(R.id.judul);
            isi = itemView.findViewById(R.id.isi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent = new Intent(itemView.getContext(), DetailArtikelActivity.class);
                    intent.putExtra("judul", judul.getText());
                    intent.putExtra("isi", isi.getText());
                    itemView.getContext().startActivity(intent);

                }
            });

        }
    }
}
