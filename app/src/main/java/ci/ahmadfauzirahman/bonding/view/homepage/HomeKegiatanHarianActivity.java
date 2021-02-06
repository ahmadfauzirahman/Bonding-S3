package ci.ahmadfauzirahman.bonding.view.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import ci.ahmadfauzirahman.bonding.R;
import ci.ahmadfauzirahman.bonding.view.DiaryActivity;

public class HomeKegiatanHarianActivity extends AppCompatActivity {

    RelativeLayout rDiaryIbu;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_kegiatan_harian);
        rDiaryIbu = findViewById(R.id.rDiaryIbu);

        rDiaryIbu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), DiaryActivity.class);
                startActivity(intent);
            }
        });
    }
}