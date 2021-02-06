package ci.ahmadfauzirahman.bonding.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import ci.ahmadfauzirahman.bonding.R;
import ci.ahmadfauzirahman.bonding.adapter.ArtikelAdapter;
import ci.ahmadfauzirahman.bonding.adapter.DiaryAdapter;
import ci.ahmadfauzirahman.bonding.api.cache.SessionManager;
import ci.ahmadfauzirahman.bonding.api.response.ArtikelResponse;
import ci.ahmadfauzirahman.bonding.api.rest.ApiClient;
import ci.ahmadfauzirahman.bonding.api.rest.ApiInterface;
import ci.ahmadfauzirahman.bonding.model.ArtikelModel;
import ci.ahmadfauzirahman.bonding.model.DiaryIbuModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtikelActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);
    private String TAG = this.getClass().getName();
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel);


        swipeRefreshLayout = findViewById(R.id.swpArtikel);
        recyclerView = findViewById(R.id.reyArtikel);

        getArtikel();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                // loading = ProgressDialog.show(context,null,"Sedang mendapatkan berita",true,false);
                swipeRefreshLayout.setRefreshing(false);
                getArtikel();
            }
        });
    }

    private void getArtikel() {
        final RecyclerView recyclerView = findViewById(R.id.reyArtikel);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        apiService.getArtikel().enqueue(new Callback<ArtikelResponse>() {
            @Override
            public void onResponse(Call<ArtikelResponse> call, Response<ArtikelResponse> response) {
                if (response.isSuccessful()) {
                    System.out.println("OnResponse Url" + response.toString());
                    System.out.println("OnResponse Data" + response.body().getResults());
                    Boolean status = response.body().getCon();
                    System.out.println(TAG + status);
                    if (status) {
                        List<ArtikelModel> artikelModels = response.body().getResults();
                        recyclerView.setAdapter(new ArtikelAdapter(artikelModels, R.layout.list_artikel, getApplicationContext()));
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
            public void onFailure(Call<ArtikelResponse> call, Throwable t) {
                System.out.println("Error Aplikasi" +
                        "" + t.getLocalizedMessage());
                Log.e(TAG, t.getLocalizedMessage());
            }
        });
    }
}