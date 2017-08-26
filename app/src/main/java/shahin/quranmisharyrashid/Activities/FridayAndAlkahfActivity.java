package shahin.quranmisharyrashid.Activities;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import shahin.quranmisharyrashid.R;

public class FridayAndAlkahfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friday_and_alkahf);
    }

    public void getFadaal(View view) {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(R.string.friday_kahf);
        alert.setMessage(R.string.friday_kahf_fadaal);
        // Create TextView
        final TextView input = new TextView(this);
        alert.setView(input);

        alert.setPositiveButton(R.string.done_jazak_allah_khir, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Do something with value!
            }
        });

        alert.show();


    }
}
