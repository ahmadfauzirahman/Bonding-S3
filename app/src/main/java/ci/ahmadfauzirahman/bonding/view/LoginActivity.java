package ci.ahmadfauzirahman.bonding.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ci.ahmadfauzirahman.bonding.MainActivity;
import ci.ahmadfauzirahman.bonding.R;
import ci.ahmadfauzirahman.bonding.api.response.AkunResponse;
import ci.ahmadfauzirahman.bonding.api.cache.SessionManager;
import ci.ahmadfauzirahman.bonding.api.rest.ApiClient;
import ci.ahmadfauzirahman.bonding.api.rest.ApiInterface;
import ci.ahmadfauzirahman.bonding.model.AkunModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {


    EditText editTextNoHp, editTextPassword;
    Button cirLoginButton;
    String no_hp, password;
    TextView register, lupaPassword;
    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);
    private String TAG = this.getClass().getName();
    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sessionManager = new SessionManager(this);


        editTextNoHp = findViewById(R.id.editTextNoHp);
        editTextPassword = findViewById(R.id.editTextPassword);
        cirLoginButton = findViewById(R.id.cirLoginButton);
        register = findViewById(R.id.register);
        lupaPassword = findViewById(R.id.lupaPassword);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        lupaPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        cirLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), editTextNoHp.getText().toString() + editTextPassword.getText().toString(), Toast.LENGTH_SHORT).show();
                login(editTextNoHp.getText().toString(), editTextPassword.getText().toString());
            }
        });

    }

    private void login(String no_hp, String password) {
        System.out.println("No Hp " + no_hp);
        apiService.login(no_hp, password).enqueue(new Callback<AkunResponse>() {
            @Override
            public void onResponse(Call<AkunResponse> call, Response<AkunResponse> response) {
                if (response.isSuccessful()) {
                    Boolean success = response.body().getCon();
                    Log.e(TAG, response.body().getCon().toString());

                    if (success) {
                        AkunModel loginModel = response.body().getResults();
                        sessionManager.createLoginSession(loginModel);
                        Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                        startActivity(intent);
                    } else {
                        Log.e(TAG, response.body().toString());
                        Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                        startActivity(intent);
                    }
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