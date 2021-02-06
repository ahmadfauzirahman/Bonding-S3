package ci.ahmadfauzirahman.bonding.view.form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ci.ahmadfauzirahman.bonding.R;
import ci.ahmadfauzirahman.bonding.adapter.KusionerSoalAdapter;
import ci.ahmadfauzirahman.bonding.api.cache.SessionManager;
import ci.ahmadfauzirahman.bonding.api.response.LpgdResponse;
import ci.ahmadfauzirahman.bonding.api.rest.ApiClient;
import ci.ahmadfauzirahman.bonding.api.rest.ApiInterface;
import ci.ahmadfauzirahman.bonding.model.LpgdModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EPDSRespondenActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_e_p_d_s_responden);
        sessionManager = new SessionManager(this);
        swipeRefreshLayout = findViewById(R.id.swpEPDS);
        recyclerView = findViewById(R.id.reyEpds);



        getAllSoal();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // loading = ProgressDialog.show(context,null,"Sedang mendapatkan berita",true,false);
                swipeRefreshLayout.setRefreshing(false);
                getAllSoal();
            }
        });

    }

    private void getAllSoal() {
        final RecyclerView recyclerView = findViewById(R.id.reyEpds);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        String id = "LPGD";
        apiService.getSoal(id).enqueue(new Callback<LpgdResponse>() {
            @Override
            public void onResponse(Call<LpgdResponse> call, Response<LpgdResponse> response) {
                if (response.isSuccessful()) {
                    Boolean status = response.body().getCon();
                    if (status) {
                        List<LpgdModel> lpgdModels = response.body().getResults();
                        recyclerView.setAdapter(new KusionerSoalAdapter(lpgdModels, R.layout.list_epds, getApplicationContext()));

                    } else {
                        Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Opss", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<LpgdResponse> call, Throwable t) {
                System.out.println("Error Aplikasi" +
                        "" + t.getLocalizedMessage());
                Log.e(TAG, t.getLocalizedMessage());
            }
        });
    }
}