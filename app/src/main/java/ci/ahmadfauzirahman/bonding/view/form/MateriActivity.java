package ci.ahmadfauzirahman.bonding.view.form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ci.ahmadfauzirahman.bonding.R;
import ci.ahmadfauzirahman.bonding.adapter.ExpandableListAdapter;

public class MateriActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
        listView = (ExpandableListView) findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash) {
        };
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Bagian 1 : Kehamilan");
        listDataHeader.add("Bagian 2 : Setelah Melahirkan");
        listDataHeader.add("Bagian 3 : masalah psikologis dan penyelesaian selama hamil sampai setelah lahir");

        List<String> edmtDev = new ArrayList<>();
        edmtDev.add("Perkembangan Janin");
        edmtDev.add("Perubahan Fisik Normal TM 1,2,&3");
        edmtDev.add("Perubahan Psikologis Normal TM 1,2,&3");
        edmtDev.add("Bonding Saat Hamil");

        List<String> androidStudio = new ArrayList<>();
        androidStudio.add("Perubahan Fisik Normal Setelah Melahirkan");
        androidStudio.add("Perubahan Psikologis Normal Setelah Melahirkan");
        androidStudio.add("Bonding Setelah Melahirkan");

        List<String> xamarin = new ArrayList<>();
        xamarin.add("Depresi Pada Ibu Saat Kehamilan");
        xamarin.add("Depresi Pada Ayah Saat Kehamilan Istri");
        xamarin.add("Depresi Pada Ibu Setelah Melahirkan");
        xamarin.add("Depresi pada Ayah Setelah Istri Melahirkan ");
        xamarin.add("Berpikir Positif ");
        xamarin.add("Komunikasi Asertif");
        xamarin.add("Teknik Relaksasi");

        listHash.put(listDataHeader.get(0), edmtDev);
        listHash.put(listDataHeader.get(1), androidStudio);
        listHash.put(listDataHeader.get(2), xamarin);
    }
}