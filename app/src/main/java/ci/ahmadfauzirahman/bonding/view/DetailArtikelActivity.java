package ci.ahmadfauzirahman.bonding.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import ci.ahmadfauzirahman.bonding.R;

public class DetailArtikelActivity extends AppCompatActivity {

    TextView judulDetail, isiDetail;
    String sJudulDetail, sIsiDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_artikel);

        judulDetail = findViewById(R.id.judulDetail);
        isiDetail = findViewById(R.id.isiDetail);

        sJudulDetail = getIntent().getStringExtra("judul");
        sIsiDetail = getIntent().getStringExtra("isi");


        judulDetail.setText(sJudulDetail);
        isiDetail.setText(sIsiDetail);
    }
}