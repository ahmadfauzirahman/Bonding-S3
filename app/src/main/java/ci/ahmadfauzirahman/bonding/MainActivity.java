package ci.ahmadfauzirahman.bonding;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import net.colindodd.gradientlayout.GradientRelativeLayout;

import ci.ahmadfauzirahman.bonding.api.cache.SessionManager;
import ci.ahmadfauzirahman.bonding.view.DiaryActivity;
import ci.ahmadfauzirahman.bonding.view.InstrumenAyahActivity;
import ci.ahmadfauzirahman.bonding.view.LoginActivity;
import ci.ahmadfauzirahman.bonding.view.homepage.RespondenDataIbuActivity;

public class MainActivity extends AppCompatActivity {
    SessionManager sessionManager;
    RelativeLayout InstrumenAyah;
    GradientRelativeLayout respondenIbu, diary, akun;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sessionManager = new SessionManager(this);

        checkSessionLogin();

        InstrumenAyah = findViewById(R.id.InstrumenAyah);
        respondenIbu = findViewById(R.id.respondenIbu);
//        akun = findViewById(R.id.akun);
        diary = findViewById(R.id.diary);

        InstrumenAyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), InstrumenAyahActivity.class);
                startActivity(intent);
            }
        });
        respondenIbu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), RespondenDataIbuActivity.class);
                startActivity(intent);
            }
        });
        diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), DiaryActivity.class);
                startActivity(intent);
            }
        });
//        akun.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                intent = new Intent(getApplicationContext(), AkunActivity.class);
//                startActivity(intent);
//            }
//        });


    }

    private void checkSessionLogin() {
        if (!sessionManager.isLoggedIn()) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            MainActivity.this.finish();
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