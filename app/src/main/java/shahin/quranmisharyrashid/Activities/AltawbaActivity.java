package shahin.quranmisharyrashid.Activities;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

import shahin.quranmisharyrashid.CustomAdapters.AzkarAdapter;
import shahin.quranmisharyrashid.Models.Azkar;
import shahin.quranmisharyrashid.R;

public class AltawbaActivity extends AppCompatActivity {

    private VideoView video_view_quran_asrafoo;
    private ListView list_altawba;

    private MediaController mediaController;
    private ArrayList<String> arrayListTawba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altawba);

        video_view_quran_asrafoo = (VideoView) findViewById(R.id.video_view_quran_asrafoo);
        list_altawba = (ListView) findViewById(R.id.list_altawba);

        mediaController = new MediaController(AltawbaActivity.this);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.quran_asrafoo_ala_anfosihem);
        video_view_quran_asrafoo.setVideoURI(uri);
        video_view_quran_asrafoo.setMediaController(mediaController);
        video_view_quran_asrafoo.seekTo(100);
        mediaController.setAnchorView(video_view_quran_asrafoo);

        arrayListTawba = new ArrayList<>();

        arrayListTawba.add(getString(R.string.tawba_one));
        arrayListTawba.add(getString(R.string.tawba_two));
        arrayListTawba.add(getString(R.string.tawba_three));
        arrayListTawba.add(getString(R.string.tawba_four));
        arrayListTawba.add(getString(R.string.tawba_five));

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListTawba);
        list_altawba.setAdapter(adapter);
    }

}
