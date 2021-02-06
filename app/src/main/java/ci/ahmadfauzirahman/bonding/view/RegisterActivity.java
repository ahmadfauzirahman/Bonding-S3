package ci.ahmadfauzirahman.bonding.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ci.ahmadfauzirahman.bonding.MainActivity;
import ci.ahmadfauzirahman.bonding.R;
import ci.ahmadfauzirahman.bonding.api.cache.SessionManager;
import ci.ahmadfauzirahman.bonding.api.response.AkunResponse;
import ci.ahmadfauzirahman.bonding.api.rest.ApiClient;
import ci.ahmadfauzirahman.bonding.api.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    EditText editTextName, editTextEmail, editTextMobile, editTextPassword;
    Button cirRegisterButton;
    SessionManager sessionManager;
    TextView loginText;
    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);
    private String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sessionManager = new SessionManager(this);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextMobile = findViewById(R.id.editTextMobile);
        editTextPassword = findViewById(R.id.editTextPassword);

        cirRegisterButton = findViewById(R.id.cirRegisterButton);
        loginText = findViewById(R.id.loginText);

        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        cirRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register(editTextMobile.getText().toString(), editTextName.getText().toString(), editTextEmail.getText().toString(), editTextPassword.getText().toString());
            }
        });
    }

    private void register(String no_telp, String nama_lengkap, String email, String password) {

        apiService.daftar(no_telp, nama_lengkap, email, password).enqueue(new Callback<AkunResponse>() {
            @Override
            public void onResponse(Call<AkunResponse> call, Response<AkunResponse> response) {
                if (response.isSuccessful()) {
                    Boolean success = response.body().getCon();
                    if (success) {
                        Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Log.e(TAG, response.body().toString());
                        Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                    }
                } else {
                    Log.e(TAG, response.body().toString());
                    Toast.makeText(getApplicationContext(), "Opps!!", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<AkunResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Anda Tidak Terhubung Kejaringan", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.getLocalizedMessage());
            }
        });
    }
}