package shahin.quranmisharyrashid.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import shahin.quranmisharyrashid.R;

public class MainActivity extends AppCompatActivity {

    private TextView tvQuranPlayer;
    private TextView tvAzkarSabahwMasaa;
    private TextView tvFridayKahfFadaal;
    private TextView tvAltawba;
    private TextView tvTasabeeh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvQuranPlayer = (TextView) findViewById(R.id.tvQuranPlayer);
        tvAzkarSabahwMasaa = (TextView) findViewById(R.id.tvAzkarSabahwMasaa);
        tvFridayKahfFadaal = (TextView) findViewById(R.id.tvFridayKahfFadaal);
        tvAltawba = (TextView) findViewById(R.id.tvAltawba);
        tvTasabeeh = (TextView) findViewById(R.id.tvTasabeeh);


        tvQuranPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PlayerActivity.class));
            }
        });

        tvAzkarSabahwMasaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AzkarSabahMasaaActivity.class));
            }
        });

        tvFridayKahfFadaal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FridayAndAlkahfActivity.class));
            }
        });

        tvAltawba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AltawbaActivity.class));
            }
        });

        tvTasabeeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TasabeehAzkarActivity.class));
            }
        });
    }
}
