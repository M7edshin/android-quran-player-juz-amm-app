package shahin.quranmisharyrashid.Activities;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import shahin.quranmisharyrashid.CustomAdapters.AudioAdapter;
import shahin.quranmisharyrashid.Models.Audio;
import shahin.quranmisharyrashid.R;

public class PlayerActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    private AudioManager.OnAudioFocusChangeListener autoFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition());
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran_main);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        ListView lstQuran = findViewById(R.id.lstQuran);
        final ArrayList<Audio> audioArrayList = new ArrayList<>();

        audioArrayList.add(new Audio(" النبأ ", " AnNaba'", "The Great News", R.raw.q78));
        audioArrayList.add(new Audio(" النازعات ", " AnNazi'at", "Those Who Pull Out", R.raw.q79));
        audioArrayList.add(new Audio(" عبس ", " Abasa", "He Frowned", R.raw.q80));
        audioArrayList.add(new Audio(" التكوير ", " AtTakwir", "The Overthrowing", R.raw.q81));
        audioArrayList.add(new Audio(" الانفطار ", " AlInfitar", "The Cleaving", R.raw.q82));
        audioArrayList.add(new Audio(" المطففين ", " AlMutaffifin", "Those Who Dealin Fraud", R.raw.q83));
        audioArrayList.add(new Audio(" الانشقاق ", " AlInshiqaq", "The Splitting Asunder", R.raw.q84));
        audioArrayList.add(new Audio(" البروج ", " AlBuruj", "The Stars", R.raw.q85));
        audioArrayList.add(new Audio(" الطارق ", " AtTariq", "The Night comer", R.raw.q86));
        audioArrayList.add(new Audio(" الأعلى ", " AlA'la", "The Most High", R.raw.q87));
        audioArrayList.add(new Audio(" الغاشية ", " AlGhashiyah", "The Overwhelming", R.raw.q88));
        audioArrayList.add(new Audio(" الفجر ", " AlFajr", "The Dawn", R.raw.q89));
        audioArrayList.add(new Audio(" البلد ", " AlBalad", "The City", R.raw.q90));
        audioArrayList.add(new Audio(" الشمس ", " AshShams", "The  Sun", R.raw.q91));
        audioArrayList.add(new Audio(" الليل  ", " AlLail", "The Night", R.raw.q92));
        audioArrayList.add(new Audio(" الضحى ", " AdDuha", "The Forenoon", R.raw.q93));
        audioArrayList.add(new Audio(" الشرح ", " AshSharh", "The Opening Forth", R.raw.q94));
        audioArrayList.add(new Audio(" التين ", " AtTin", "The Fig", R.raw.q95));
        audioArrayList.add(new Audio(" العلق ", " AlAlaq", "The Clot", R.raw.q96));
        audioArrayList.add(new Audio(" القدر ", " AlQadr", "The Night of Decree", R.raw.q97));
        audioArrayList.add(new Audio(" البينة ", " AlBayyinah", "The Proof", R.raw.q98));
        audioArrayList.add(new Audio(" الزلزلة ", " AzZalzalah", "The Earthquake", R.raw.q99));
        audioArrayList.add(new Audio(" العاديات ", " AlAadiyat", "The Runners", R.raw.q100));
        audioArrayList.add(new Audio(" القارعة ", " AlQari'ah", "The StrikingHour", R.raw.q101));
        audioArrayList.add(new Audio(" التكاثر ", " AtTakathur", "The PilingUp", R.raw.q102));
        audioArrayList.add(new Audio(" العصر ", " AlAsr", "The Time", R.raw.q103));
        audioArrayList.add(new Audio(" الهمزة ", " AlHumazah", "The Slanderer", R.raw.q104));
        audioArrayList.add(new Audio("  الفيل ", "  AlFil", "The Elephant", R.raw.q105));
        audioArrayList.add(new Audio(" قريش ", " Quraish", "Quraish", R.raw.q106));
        audioArrayList.add(new Audio(" الماعون ", " AlMa'un", "The Assistance", R.raw.q107));
        audioArrayList.add(new Audio(" الكوثر ", " AlKauthar", "The River of Abundance", R.raw.q108));
        audioArrayList.add(new Audio(" الكافرون ", " AlKafirun", "The Disbelievers", R.raw.q109));
        audioArrayList.add(new Audio(" النصر ", " AnNasr", "The Help", R.raw.q110));
        audioArrayList.add(new Audio(" المسد ", " AlMasad", "The PalmFiber", R.raw.q111));
        audioArrayList.add(new Audio(" الإخلاص ", " AlIkhlas", "The Sincerity", R.raw.q112));
        audioArrayList.add(new Audio(" الفلق ", " AlFalaq", "The Daybreak", R.raw.q113));
        audioArrayList.add(new Audio(" الناس ", " AnNas  ", "Mankind", R.raw.q114));

        AudioAdapter adapter = new AudioAdapter(this, audioArrayList);

        lstQuran.setAdapter(adapter);

        lstQuran.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                releaseMediaPlayer();

                final Audio audio = audioArrayList.get(position);

                int result = audioManager.requestAudioFocus(autoFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(PlayerActivity.this, audio.getVerseAudioFile());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releaseMediaPlayer();
                        }
                    });
                }
            }
        });


    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(autoFocusChangeListener);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_buttons, menu);
        menu.findItem(R.id.btnSuggest).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.action_stop:
                releaseMediaPlayer();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
