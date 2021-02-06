package ci.ahmadfauzirahman.bonding.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import ci.ahmadfauzirahman.bonding.MainActivity;
import ci.ahmadfauzirahman.bonding.R;
import ci.ahmadfauzirahman.bonding.api.cache.SessionManager;

public class SplashScreenActivity extends AppCompatActivity {
    private int waktu_loading = 4000;
    SessionManager sessionManager;
    String role;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
//        sessionManager = new SessionManager(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //setelah loading maka akan langsung berpindah ke home activity
                Intent home = new Intent(SplashScreenActivity.this, HomePageActivity.class);
                startActivity(home);
                finish();

            }
        }, waktu_loading);
    }
}