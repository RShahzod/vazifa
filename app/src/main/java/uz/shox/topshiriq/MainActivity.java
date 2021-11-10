package uz.shox.topshiriq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCal;
    private TextView seekFoiz;
    private TextView foizda;
    private TextView umumiynatija;
    private SeekBar seekBar;
    private EditText editText;
    private int seekbarfoiz;
    private float billamount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.skBar);
        btnCal =findViewById(R.id.calculator);
        seekFoiz = findViewById(R.id.foiz);
        foizda = findViewById(R.id.foizda);
        umumiynatija = findViewById(R.id.umumiy);
        editText =findViewById(R.id.editText);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekFoiz.setText(seekBar.getProgress() + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbarfoiz = seekBar.getProgress();


            }
        });

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator();

            }
        });
    }
    public void calculator() {
        float result = 0.0f;

        if (!editText.getText().toString().equals(" ")) {
             billamount = Float.parseFloat(editText.getText().toString());

             result = billamount * seekbarfoiz/100;
             foizda.setText("Foizda: " + String.valueOf(result));
             umumiynatija.setText("Umumiy: " + (billamount+result));
        } else {
            Toast.makeText(this, "Raqam kiriting: ", Toast.LENGTH_SHORT).show();
        }
    }
}