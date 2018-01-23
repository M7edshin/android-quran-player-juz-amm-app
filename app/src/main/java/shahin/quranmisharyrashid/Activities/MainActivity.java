package shahin.quranmisharyrashid.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import shahin.quranmisharyrashid.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvQuranPlayer = findViewById(R.id.tvQuranPlayer);
        TextView tvAzkarSabahwMasaa = findViewById(R.id.tvAzkarSabahwMasaa);
        TextView tvFridayKahfFadaal = findViewById(R.id.tvFridayKahfFadaal);
        TextView tvTasabeeh = findViewById(R.id.tvTasabeeh);


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


        tvTasabeeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TasabeehAzkarActivity.class));
            }
        });

        VideoView video_view_quran_asrafoo = findViewById(R.id.video_view_quran_asrafoo);

        MediaController mediaController = new MediaController(MainActivity.this);

        Uri uri_asrafoo = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.quran_asrafoo_ala_anfosihem);

        video_view_quran_asrafoo.setVideoURI(uri_asrafoo);
        video_view_quran_asrafoo.setMediaController(mediaController);
        video_view_quran_asrafoo.seekTo(100);
        mediaController.setAnchorView(video_view_quran_asrafoo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnSuggest:
                sendEmail(getString(R.string.suggest_report));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_buttons, menu);
        menu.findItem(R.id.action_stop).setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    private void sendEmail(String text) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"M7edshin@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, text);
        i.putExtra(Intent.EXTRA_TEXT, "Your Message");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "There are no email clients or apps installed on your device.", Toast.LENGTH_SHORT).show();
        }
    }
}
