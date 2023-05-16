package sg.edu.rp.c346.id22001095.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText phone;
    EditText pax;
    DatePicker dp;
    TimePicker tp;
    Button btnConfirm;
    Button btnReset;
    RadioGroup smokeOrNoSmoke;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextName);
        phone = findViewById(R.id.editTextNum);
        pax = findViewById(R.id.editTextPax);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnConfirm = findViewById(R.id.buttonConfirm);
        btnReset = findViewById(R.id.buttonReset);
        smokeOrNoSmoke = findViewById(R.id.radioSmokeOrNoSmoke);


        tp.setHour(19);
        tp.setMinute(30);
        dp.updateDate(2023,5, 1);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                phone.setText("");
                pax.setText("");
                dp.updateDate(2023,5,1);
                tp.setHour(19);
                tp.setMinute(30);
                smokeOrNoSmoke.clearCheck();

            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().trim().length() != 0 && phone.getText().toString().trim().length() != 0 && pax.getText().toString().trim().length() != 0)
                {
                    if(smokeOrNoSmoke.getCheckedRadioButtonId() == R.id.radioButtonSmoke) {
                        String time = String.format("%02d:%02d", tp.getHour(), tp.getMinute());
                        String date = String.format("%d/%d/%d", dp.getDayOfMonth(), dp.getMonth(), dp.getYear());
                        String message = "Name: " + name.getText().toString() + "\n"
                                + "Mobile Number: " + phone.getText().toString() + "\n"
                                + "Size of group: " + pax.getText().toString() + "\n"
                                + "Date: " + date +" "
                                + "Time: " + time + "\n"
                                + "Smoking area: Yes" + "\n";
                        Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                    }
                    else{
                        String time = String.format("%02d:%02d", tp.getHour(), tp.getMinute());
                        String date = String.format("%d/%d/%d", dp.getDayOfMonth(), dp.getMonth(), dp.getYear());
                        String message = "Name: " + name.getText().toString() + "\n"
                                + "Mobile Number: " + phone.getText().toString() + "\n"
                                + "Size of group: " + pax.getText().toString() + "\n"
                                + "Date: " + date +" "
                                + "Time: " + time + "\n"
                                + "Smoking area: No" + "\n";
                        Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    Toast.makeText(MainActivity.this,"Error, there are empty field(s) ",Toast.LENGTH_SHORT).show();

                }



            }
        });

    }
}