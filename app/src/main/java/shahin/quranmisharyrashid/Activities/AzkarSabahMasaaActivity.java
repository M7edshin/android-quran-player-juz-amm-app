package shahin.quranmisharyrashid.Activities;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import shahin.quranmisharyrashid.CustomAdapters.AzkarAdapter;
import shahin.quranmisharyrashid.Models.Azkar;
import shahin.quranmisharyrashid.R;

public class AzkarSabahMasaaActivity extends AppCompatActivity {

    private ListView listView_azkarSabahMasaa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar_sabah_masaa);

        listView_azkarSabahMasaa = (ListView) findViewById(R.id.listView_azkarSabahMasaa);
        ArrayList<Azkar> azkarArrayList = new ArrayList<>();

        azkarArrayList.add(new Azkar(getString(R.string.alkorsy_verse), 1,
                getString(R.string.alkorsy_benefits)));

        azkarArrayList.add(new Azkar(getString(R.string.sorat_alikhlas) +
                getString(R.string.sorat_alfalaq) +
                getString(R.string.sorat_alnas), 3, getString(R.string.three_sorat_benefits)));

        azkarArrayList.add(new Azkar(getString(R.string.la_ilah_ila_allah_wahdo_la_sharek),
                100, getString(R.string.la_ilah_ila_allah_wahdo_la_sharek_benefits)));

        azkarArrayList.add(new Azkar(getString(R.string.sobhan_allah_w_behamdo), 100,
                getString(R.string.sobhan_allah_w_behamdo_benefits)));

        azkarArrayList.add(new Azkar(getString(R.string.bsm_allah_allazy_la_yador), 3,
                getString(R.string.bsm_allah_allazy_la_yador_benefits)));

        azkarArrayList.add(new Azkar(getString(R.string.aooz_bekalmat_allah), 3,
                getString(R.string.aooz_bekalmat_allah_benefits)));

        azkarArrayList.add(new Azkar(getString(R.string.radito_belallah), 3,
                getString(R.string.radito_belallah_benefits)));

        azkarArrayList.add(new Azkar(getString(R.string.sobhan_allah_wbehamdo_adada_khalkoo), 3,
                getString(R.string.sobhan_allah_wbehamdo_adada_khalkoo_benefits)));

        azkarArrayList.add(new Azkar(getString(R.string.ya_hay_ya_kayoum), 3,
                getString(R.string.ya_hay_ya_kayoum_benefits)));

        azkarArrayList.add(new Azkar(getString(R.string.allahom_saly_ala_mohamed), 10,
                getString(R.string.allahom_saly_ala_mohamed_benefits)));

        azkarArrayList.add(new Azkar(getString(R.string.asbhna_amsayna_ala_ftrat_alislam), 1,
                getString(R.string.asbhna_amsayna_ala_ftrat_alislam_benefits)));

        azkarArrayList.add(new Azkar(getString(R.string.allahom_ma_asbah_ma_amsa_bi), 1,
                getString(R.string.allahom_ma_asbah_ma_amsa_bi_benefits)));

        azkarArrayList.add(new Azkar(getString(R.string.asbhna_w_asbha_almolk_liallah), 1,
                getString(R.string.asbhna_w_asbha_almolk_liallah_benefits)));

        azkarArrayList.add(new Azkar(getString(R.string.allhom_bka_asbhna_w_bka_amsayna), 1,
                getString(R.string.allhom_bka_asbhna_w_bka_amsayna_benefits)));

        azkarArrayList.add(new Azkar(getString(R.string.allhom_afeny_fe_badany), 1,
                getString(R.string.allhom_afeny_fe_badany_benefits)));

        azkarArrayList.add(new Azkar(getString(R.string.sayed_alastghfar), 1,
                getString(R.string.sayed_alastghfar_benefits)));

        azkarArrayList.add(new Azkar(getString(R.string.allhom_allem_al_ghabyb), 1,
                getString(R.string.allhom_allem_al_ghabyb_benefits)));

        azkarArrayList.add(new Azkar(getString(R.string.allhom_iny_asalak_alafw), 1,
                getString(R.string.allhom_iny_asalak_alafw_benefits)));


        AzkarAdapter adapter = new AzkarAdapter(this, azkarArrayList);
        listView_azkarSabahMasaa.setAdapter(adapter);

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
