package ci.ahmadfauzirahman.bonding.view.form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ci.ahmadfauzirahman.bonding.R;
import ci.ahmadfauzirahman.bonding.api.cache.SessionManager;
import ci.ahmadfauzirahman.bonding.api.response.AkunResponse;
import ci.ahmadfauzirahman.bonding.api.response.DiaryIbuResponse;
import ci.ahmadfauzirahman.bonding.api.response.LpgdResponse;
import ci.ahmadfauzirahman.bonding.api.rest.ApiClient;
import ci.ahmadfauzirahman.bonding.api.rest.ApiInterface;
import ci.ahmadfauzirahman.bonding.model.AkunModel;
import ci.ahmadfauzirahman.bonding.view.DiaryActivity;
import ci.ahmadfauzirahman.bonding.view.HomePageActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormDiaryIbuActivity extends AppCompatActivity {

    EditText perasaaanEdit;
    CheckBox checkbox1, checkbox2, checkbox3, checkbox4;
    Button btn_diary;
    String c1;
    String id;

    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);
    SessionManager sessionManager;
    private String TAG = this.getClass().getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_diary_ibu);
        perasaaanEdit = findViewById(R.id.perasaaanEdit);

        sessionManager = new SessionManager(this);
        id = sessionManager.getUserDetail().get("nik");

        btn_diary = findViewById(R.id.btn_diary);

        btn_diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDiary(perasaaanEdit.getText().toString());
            }
        });

    }

    private void sendDiary(String perasaan) {

        apiService.diaryIbu(id, perasaan).enqueue(new Callback<DiaryIbuResponse>() {
            @Override
            public void onResponse(Call<DiaryIbuResponse> call, Response<DiaryIbuResponse> response) {
                if (response.isSuccessful()) {
                    Boolean success = response.body().getCon();
                    Log.e(TAG, response.body().getCon().toString());

                    if (success) {
                        Log.e(TAG, response.body().toString());
                        Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), DiaryActivity.class);
                        startActivity(intent);
                    } else {
                        Log.e(TAG, response.body().toString());
                        Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), DiaryActivity.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Opss Something Wrong", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), DiaryActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<DiaryIbuResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Anda Tidak Terhubung Kejaringan", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.getLocalizedMessage());
            }
        });
    }


}