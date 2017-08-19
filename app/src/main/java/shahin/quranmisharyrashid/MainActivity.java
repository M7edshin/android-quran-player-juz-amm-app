package shahin.quranmisharyrashid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvQuranPlayer;
    private TextView tvAzkarSabahwMasaa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvQuranPlayer = (TextView) findViewById(R.id.tvQuranPlayer);
        tvAzkarSabahwMasaa = (TextView) findViewById(R.id.tvAzkarSabahwMasaa);

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
    }
}
