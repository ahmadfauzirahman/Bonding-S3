package ci.ahmadfauzirahman.bonding.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ci.ahmadfauzirahman.bonding.R;
import ci.ahmadfauzirahman.bonding.api.response.AkunResponse;
import ci.ahmadfauzirahman.bonding.api.rest.ApiClient;
import ci.ahmadfauzirahman.bonding.api.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends AppCompatActivity {
    EditText editTextNoHp, editTextPasswordBaru, editTextPasswordConfirm;
    Button cirLupaPassword;
    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);
    private String TAG = this.getClass().getName();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        editTextNoHp = findViewById(R.id.editTextNoHp);
        editTextPasswordBaru = findViewById(R.id.editTextPasswordBaru);
        editTextPasswordConfirm = findViewById(R.id.editTextPasswordConfirm);

        cirLupaPassword = findViewById(R.id.cirLupaPassword);


        cirLupaPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lupaPassword(editTextNoHp.getText().toString(), editTextPasswordBaru.getText().toString(), editTextPasswordConfirm.getText().toString());
            }
        });
    }

    private void lupaPassword(String no_hp, String password_baru, String password_confirm) {

        apiService.lupa(no_hp, password_baru, password_confirm).enqueue(new Callback<AkunResponse>() {
            @Override
            public void onResponse(Call<AkunResponse> call, Response<AkunResponse> response) {
                if (response.isSuccessful()) {
                    Boolean success = response.body().getCon();
                    Log.e(TAG, response.body().getCon().toString());
                    if (success) {
                        Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        intent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Opps Something Wrong", Toast.LENGTH_SHORT).show();
                    intent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
                    startActivity(intent);
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