package ci.ahmadfauzirahman.bonding.view.homepage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import ci.ahmadfauzirahman.bonding.R;
import ci.ahmadfauzirahman.bonding.api.cache.SessionManager;
import ci.ahmadfauzirahman.bonding.api.response.CheckJawabanEPDSResponse;
import ci.ahmadfauzirahman.bonding.api.response.InformasiConsentResponse;
import ci.ahmadfauzirahman.bonding.api.rest.ApiClient;
import ci.ahmadfauzirahman.bonding.api.rest.ApiInterface;
import ci.ahmadfauzirahman.bonding.model.CheckJawabanEPDSModel;
import ci.ahmadfauzirahman.bonding.view.form.EPDSRespondenActivity;
import ci.ahmadfauzirahman.bonding.view.form.KusionerKDSActivity;
import ci.ahmadfauzirahman.bonding.view.form.KusionerKHSIActivity;
import ci.ahmadfauzirahman.bonding.view.form.KusionerPAIActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RespondenDataIbuActivity extends AppCompatActivity {
    SessionManager sessionManager;
    String id;
    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);
    private String TAG = this.getClass().getName();
    TextView persetujuanInfor;
    CardView cardKHSI, cardKDS, cardPAI, cardEPDS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responden_data_ibu);
        sessionManager = new SessionManager(this);
        persetujuanInfor = findViewById(R.id.persetujuanInfor);

        cardKHSI = findViewById(R.id.cardKHSI);
        cardKDS = findViewById(R.id.cardKDS);
        cardPAI = findViewById(R.id.cardPAI);
        cardEPDS = findViewById(R.id.cardEPDS);

        cardEPDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EPDSRespondenActivity.class);
                startActivity(intent);
            }
        });

        cardPAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), KusionerPAIActivity.class);
                intent.putExtra("PAI", "PAI");
                startActivity(intent);
            }
        });
        cardKDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), KusionerKDSActivity.class);
                intent.putExtra("KDS", "KDS");
                startActivity(intent);
            }
        });
        cardKHSI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), KusionerKHSIActivity.class);
                intent.putExtra("KHSI", "KHSI");
                startActivity(intent);
            }
        });
        id = sessionManager.getUserDetail().get("nik");
        checkInformasiConsent(id);

        //check EPDS
        checkEpds(id);

        persetujuanInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(RespondenDataIbuActivity.this).create();
                alertDialog.setTitle("Persetujuan Menjadi Responden");
                alertDialog.setMessage("Apakah Anda Yakin Ingin Menjadi Responden Data Penelitian!!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ya Saya Setuju!!",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });
    }

    private void checkEpds(String id) {
        apiService.getCheck(id).enqueue(new Callback<CheckJawabanEPDSResponse>() {
            @Override
            public void onResponse(Call<CheckJawabanEPDSResponse> call, Response<CheckJawabanEPDSResponse> response) {

                CheckJawabanEPDSModel checkJawabanEPDSModel = response.body().getResults();

//               checkJawabanEPDSResponse.
                if (response.isSuccessful()) {
                    if (checkJawabanEPDSModel.getIsJawabEPDS()) {
                        if (checkJawabanEPDSModel.getJumlahJawabanHasilEPDS() < 5) {
                            cardKHSI.setVisibility(View.VISIBLE);
                            cardKDS.setVisibility(View.VISIBLE);
                            cardPAI.setVisibility(View.VISIBLE);
                        } else {
                            cardKHSI.setVisibility(View.GONE);
                            cardKDS.setVisibility(View.GONE);
                            cardPAI.setVisibility(View.GONE);
                        }
                    } else {
                        cardKHSI.setVisibility(View.GONE);
                        cardKDS.setVisibility(View.GONE);
                        cardPAI.setVisibility(View.GONE);
                    }
                } else {

                }
            }

            @Override
            public void onFailure(Call<CheckJawabanEPDSResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Anda Tidak Terhubung Kejaringan", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.getLocalizedMessage());
            }
        });
    }

    private void checkInformasiConsent(String id) {
        apiService.getInformasi(id).enqueue(new Callback<InformasiConsentResponse>() {
            @Override
            public void onResponse(Call<InformasiConsentResponse> call, Response<InformasiConsentResponse> response) {
                if (response.isSuccessful()) {
                    Boolean status = response.body().getCon();
                    if (status) {
                        Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        persetujuanInfor.setText("Anda Menyetujui Menjadi Responden Data Penilitan");
                    } else {
                        persetujuanInfor.setText("Klik Ini Jika Anda Menyetujui Untuk Menyetujui Menjadi Responden Data Penilitian!!");
//
                    }
                } else {
                    Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<InformasiConsentResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Anda Tidak Terhubung Kejaringan", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.getLocalizedMessage());
            }
        });
    }

}