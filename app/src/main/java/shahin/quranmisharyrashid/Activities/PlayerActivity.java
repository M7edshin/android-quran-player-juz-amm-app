package shahin.quranmisharyrashid.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;

import java.util.ArrayList;

import shahin.quranmisharyrashid.CustomAdapters.AudioAdapter;
import shahin.quranmisharyrashid.Models.Audio;
import shahin.quranmisharyrashid.R;

public class PlayerActivity extends AppCompatActivity implements MediaController.MediaPlayerControl {

    private ListView lstQuran;
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private MediaController mediaController;
    private Audio audio;
    private int audioIndex;

    private int[] audioFiles = {R.raw.q78, R.raw.q79, R.raw.q80, R.raw.q81, R.raw.q82, R.raw.q83,
            R.raw.q84, R.raw.q85, R.raw.q86, R.raw.q87, R.raw.q88, R.raw.q89, R.raw.q90,
            R.raw.q91, R.raw.q92, R.raw.q93, R.raw.q94, R.raw.q95, R.raw.q96,
            R.raw.q97, R.raw.q98, R.raw.q99, R.raw.q100, R.raw.q101, R.raw.q102, R.raw.q103, R.raw.q104
            , R.raw.q105, R.raw.q106, R.raw.q107, R.raw.q108, R.raw.q109, R.raw.q110, R.raw.q111, R.raw.q112
            , R.raw.q113, R.raw.q114};


    //General to act whenever the playing audio get interrupted by other sounds in the phone
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

        lstQuran = (ListView) findViewById(R.id.lstQuran);
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

        //MediaController settings
        mediaController = new MediaController(PlayerActivity.this);
        mediaController.setMediaPlayer(PlayerActivity.this);
        mediaController.setAnchorView(lstQuran);
        mediaController.setEnabled(true);

        lstQuran.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                releaseMediaPlayer();

                audio = audioArrayList.get(position);

                audioIndex = position;
                // Request audio focus so in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int result = audioManager.requestAudioFocus(autoFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.
                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current audio

                    lstQuran.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            if (mediaPlayer != null) {
                                mediaController.show();
                            }
                            return false;
                        }
                    });

                    mediaPlayer = MediaPlayer.create(PlayerActivity.this, audio.getVerseAudioFile());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            audioIndex++;
                            mp.reset();
                            if (audioIndex < audioArrayList.size()) {
                                try {
                                    AssetFileDescriptor afd = getResources().openRawResourceFd(audioFiles[audioIndex]);
                                    if (afd != null) {
                                        mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                                        afd.close();
                                        mp.prepare();
                                        mp.start();
                                    }
                                } catch (Exception e) {
                                    Toast.makeText(getApplicationContext(), String.valueOf(e), Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                if (mp.isPlaying()) {
                                    mp.stop();
                                }
                                mp.release();
                                mp = null;
                                lstQuran.setOnTouchListener(null);
                                Toast.makeText(getApplicationContext(), "all done", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }
            }
        });


    }


    // Clean up the media player by releasing its resources.
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
            // Abandon audio focus when playback complete
            audioManager.abandonAudioFocus(autoFocusChangeListener);
        }
    }


    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }

    @Override
    public int getBufferPercentage() {
        return mediaPlayer != null ? (mediaPlayer.getCurrentPosition() * 100 / mediaPlayer.getDuration())
                : 0;
    }

    @Override
    public int getCurrentPosition() {
        return mediaPlayer != null ? mediaPlayer.getCurrentPosition() : 0;
    }

    @Override
    public int getDuration() {
        return mediaPlayer != null ? mediaPlayer.getDuration() : 0;
    }

    @Override
    public boolean isPlaying() {
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    @Override
    public void pause() {
        mediaPlayer.pause();
    }

    @Override
    public void seekTo(int pos) {
        mediaPlayer.seekTo(pos);
    }

    @Override
    public void start() {
        mediaPlayer.start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnMishary:
                //Open Website Intent
                String url = "https://en.wikipedia.org/wiki/Mishary_Rashid_Alafasy";
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                return true;
            case R.id.btnSuggest:
                sendEmail("Suggest or Report");
                return true;
            case R.id.btnExit:
                finish();
                System.exit(0);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_buttons, menu);
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
            Toast.makeText(PlayerActivity.this, "There are no email clients or apps installed on your device.", Toast.LENGTH_SHORT).show();
        }
    }
}
