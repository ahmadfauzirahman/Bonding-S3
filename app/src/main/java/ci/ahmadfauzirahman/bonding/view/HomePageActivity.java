package ci.ahmadfauzirahman.bonding.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import net.colindodd.gradientlayout.GradientRelativeLayout;

import java.util.Objects;

import ci.ahmadfauzirahman.bonding.R;
import ci.ahmadfauzirahman.bonding.api.cache.SessionManager;
import ci.ahmadfauzirahman.bonding.view.form.MateriActivity;
import ci.ahmadfauzirahman.bonding.view.homepage.HomeKegiatanHarianActivity;
import ci.ahmadfauzirahman.bonding.view.homepage.HomeMaterInformasiActivity;
import ci.ahmadfauzirahman.bonding.view.homepage.RespondenDataIbuActivity;

public class HomePageActivity extends AppCompatActivity {
    SessionManager sessionManager;
    GradientRelativeLayout penilian, materiInformasi;
    RelativeLayout kegiatan;
    Intent intent;
    String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        sessionManager = new SessionManager(this);
        checkSessionLogin();
        System.out.println("Role " + role);
        role = sessionManager.getUserDetail().get("role");
        if (Objects.equals(role, "ayah")) {
            intent = new Intent(getApplicationContext(), HomePageAyahActivity.class);
            startActivity(intent);
            finish();
        }


        penilian = findViewById(R.id.penilian);
        materiInformasi = findViewById(R.id.materiInformasi);
        kegiatan = findViewById(R.id.kegiatan);


        penilian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), RespondenDataIbuActivity.class);
                startActivity(intent);
            }
        });
        materiInformasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MateriActivity.class);
                startActivity(intent);
            }
        });
        kegiatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), HomeKegiatanHarianActivity.class);
                startActivity(intent);
            }
        });

    }

    private void checkSessionLogin() {
        if (!sessionManager.isLoggedIn()) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            HomePageActivity.this.finish();
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Tutup Aplikasi?")
                .setMessage("Ya, untuk tutup aplikasi dan aplikasi akan melakukan log out pada akun anda secara otomatis")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sessionManager.logoutUser();
                        finish();
                        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                    }
                })
                .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.show();
    }
}