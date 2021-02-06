package ci.ahmadfauzirahman.bonding.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import ci.ahmadfauzirahman.bonding.R;

public class InstrumenAyahActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] agama = {"Islam", "Kristen", "Budha", "Protestan", "Other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrumen_ayah);

        Spinner agamaSelect = findViewById(R.id.agamaSelect);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, agama);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        agamaSelect.setAdapter(adapter);
        agamaSelect.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(), "Selected User: " + agama[i], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}