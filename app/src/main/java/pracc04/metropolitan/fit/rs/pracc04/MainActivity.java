package pracc04.metropolitan.fit.rs.pracc04;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button openDatePickerButton,
                   openTimePickerButton;

    private int dateYear, dateMonth, dateDay,
                timeHour, timeMinute, timeSecond;

    static final int DIALOG_DATEPICKER_ID = 0,
                     DIALOG_TIMEPICKER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();
        dateYear   = calendar.get(Calendar.YEAR);
        dateMonth  = calendar.get(Calendar.MONTH);
        dateDay    = calendar.get(Calendar.DAY_OF_MONTH);
        timeHour   = calendar.get(Calendar.HOUR);
        timeMinute = calendar.get(Calendar.MINUTE);
        timeSecond = calendar.get(Calendar.SECOND);

        onOpenDateListener();
        onOpenTimeListener();
    }

    public void onOpenDateListener() {
        openDatePickerButton = (Button) findViewById(R.id.openDatePickerButton);

        openDatePickerButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showDialog(DIALOG_DATEPICKER_ID);
                    }
                }
        );
    }

    public void onOpenTimeListener() {
        openTimePickerButton = (Button) findViewById(R.id.openTimePickerButton);

        openTimePickerButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showDialog(DIALOG_TIMEPICKER_ID);
                    }
                }
        );
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        switch (id) {
            case DIALOG_DATEPICKER_ID:
                return new DatePickerDialog(this, onDatePickListener, dateYear, dateMonth, dateDay);
            case DIALOG_TIMEPICKER_ID:
                return new TimePickerDialog(this, onTimePickListener, timeHour, timeMinute, true); // true is 24hourview
        }

        return null;
    }

    private DatePickerDialog.OnDateSetListener onDatePickListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            Toast.makeText(MainActivity.this, "y: " + year + " m: " + month + " d: " + day, Toast.LENGTH_SHORT).show();
        }
    };

    private TimePickerDialog.OnTimeSetListener onTimePickListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int minute) {
            Toast.makeText(MainActivity.this, "hour: " + hour + " | minute: " + minute, Toast.LENGTH_SHORT).show();
        }
    };
}
