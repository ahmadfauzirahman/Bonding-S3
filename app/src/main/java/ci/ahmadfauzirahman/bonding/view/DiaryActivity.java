package ci.ahmadfauzirahman.bonding.view;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ci.ahmadfauzirahman.bonding.R;
import ci.ahmadfauzirahman.bonding.adapter.DiaryAdapter;
import ci.ahmadfauzirahman.bonding.api.cache.SessionManager;
import ci.ahmadfauzirahman.bonding.api.response.DiaryIbuResponse;
import ci.ahmadfauzirahman.bonding.api.rest.ApiClient;
import ci.ahmadfauzirahman.bonding.api.rest.ApiInterface;
import ci.ahmadfauzirahman.bonding.model.DiaryIbuModel;
import ci.ahmadfauzirahman.bonding.view.form.FormDiaryIbuActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiaryActivity extends AppCompatActivity {

    TextView feel, perasaan;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);
    private String TAG = this.getClass().getName();
    SessionManager sessionManager;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        sessionManager = new SessionManager(this);
        id = sessionManager.getUserDetail().get("nik");

        swipeRefreshLayout = findViewById(R.id.swpDiary);
        recyclerView = findViewById(R.id.reyDiary);
        FloatingActionButton fab = findViewById(R.id.fab);

        getAllDataDiaryIbu(id);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                // loading = ProgressDialog.show(context,null,"Sedang mendapatkan berita",true,false);
                swipeRefreshLayout.setRefreshing(false);
                getAllDataDiaryIbu(id);

            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(getApplicationContext(), FormDiaryIbuActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getAllDataDiaryIbu(String id) {
        final RecyclerView recyclerView = findViewById(R.id.reyDiary);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        apiService.getDiaryIbu(id).enqueue(new Callback<DiaryIbuResponse>() {
            @Override
            public void onResponse(Call<DiaryIbuResponse> call, Response<DiaryIbuResponse> response) {
                if (response.isSuccessful()) {
                    System.out.println("OnResponse Url" + response.toString());
                    System.out.println("OnResponse Data" + response.body().getResults());
                    Boolean status = response.body().getCon();
                    System.out.println(TAG + status);
                    if (status) {
                        List<DiaryIbuModel> diaryIbuModels = response.body().getResults();
                        recyclerView.setAdapter(new DiaryAdapter(diaryIbuModels, R.layout.list_diary, getApplicationContext()));
                    } else {
                        System.out.println("OnResponse Data" + response.body().toString());

                        Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    System.out.println("OnResponse Data" + response.body().toString());

                    Toast.makeText(getApplicationContext(), "Opss Something Wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DiaryIbuResponse> call, Throwable t) {
                System.out.println("Error Aplikasi" +
                        "" + t.getLocalizedMessage());
                Log.e(TAG, t.getLocalizedMessage());
            }
        });
    }
}