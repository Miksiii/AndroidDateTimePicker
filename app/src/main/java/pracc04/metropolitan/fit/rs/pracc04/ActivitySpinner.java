package pracc04.metropolitan.fit.rs.pracc04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivitySpinner extends AppCompatActivity {

    private String[] countries;
    private Spinner spinnerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // load resources from strings.xml
        countries = getResources().getStringArray(R.array.countries);
        spinnerList = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, countries);
        spinnerList.setAdapter(adapter);

        onSpinnerItemSelectListener();
    }

    private void onSpinnerItemSelectListener() {
        spinnerList.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int which, long id) {
                        Toast.makeText(ActivitySpinner.this, "Selected: " + adapterView.getSelectedItem() + " on position: " + which + " with id: " + id, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        Toast.makeText(ActivitySpinner.this, "Sorry mate, nothing selected from the list.", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
