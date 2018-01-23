package shahin.quranmisharyrashid.Activities;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import shahin.quranmisharyrashid.CustomAdapters.AzkarAdapter;
import shahin.quranmisharyrashid.Models.Azkar;
import shahin.quranmisharyrashid.R;

public class TasabeehAzkarActivity extends AppCompatActivity {

    private ListView listview_tasabeeh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasabeeh_azkar);

        listview_tasabeeh = (ListView) findViewById(R.id.listview_tasabeeh);
        ArrayList<Azkar> tasabeehArrayList = new ArrayList<>();

        tasabeehArrayList.add(new Azkar(getString(R.string.best_words_for_god), 1, getString(R.string.best_words_for_god_benefits)));
        tasabeehArrayList.add(new Azkar(getString(R.string.two_from_best_for_god), 1, getString(R.string.two_from_best_for_god_benefits)));
        tasabeehArrayList.add(new Azkar(getString(R.string.sobhan_allah), 1, getString(R.string.sobhan_allah_benefits)));
        tasabeehArrayList.add(new Azkar(getString(R.string.allah_akbar), 1, getString(R.string.allah_akbar_benefits)));
        tasabeehArrayList.add(new Azkar(getString(R.string.la_elaah_ila_allah), 1, getString(R.string.la_elaah_ila_allah_benefits)));
        tasabeehArrayList.add(new Azkar(getString(R.string.sobhan_allah_wbehamdo), 1, getString(R.string.sobhan_allah_wbehamdo_benefits)));
        tasabeehArrayList.add(new Azkar(getString(R.string.sobhan_allah_alhamdo_lelah), 1, getString(R.string.sobhan_allah_alhamdo_lelah_benefits)));
        tasabeehArrayList.add(new Azkar(getString(R.string.la_hawl_walla_kowa), 1, getString(R.string.la_hawl_walla_kowa_benefits)));
        tasabeehArrayList.add(new Azkar(getString(R.string.thank_god), 1, getString(R.string.thank_god_benefits)));
        tasabeehArrayList.add(new Azkar(getString(R.string.tashahod), 1, getString(R.string.tashahod_benefits)));


        AzkarAdapter adapter = new AzkarAdapter(this, tasabeehArrayList);
        listview_tasabeeh.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_buttons, menu);
        menu.findItem(R.id.btnSuggest).setVisible(false);
        menu.findItem(R.id.action_stop).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
