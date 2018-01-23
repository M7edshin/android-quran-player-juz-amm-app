package shahin.quranmisharyrashid.CustomAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import shahin.quranmisharyrashid.Models.Azkar;
import shahin.quranmisharyrashid.R;


public class AzkarAdapter extends ArrayAdapter<Azkar> {

    public AzkarAdapter(Activity context, ArrayList<Azkar> azkarList) {
        super(context, 0, azkarList);
    }

    static class ViewHolder {
        TextView tvAlzikr;
        TextView tvTimes;
        TextView tvBenefits;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Azkar currentZikr = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.azkar_item_list, parent, false);
            viewHolder.tvAlzikr = convertView.findViewById(R.id.tvAlzikr);
            viewHolder.tvTimes = convertView.findViewById(R.id.tvTimes);
            viewHolder.tvBenefits = convertView.findViewById(R.id.tvBenefits);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (currentZikr != null) {
            viewHolder.tvAlzikr.setText(currentZikr.getAlzikr());
        }

        if (currentZikr != null) {
            viewHolder.tvTimes.setText("عدد المرات: " + String.valueOf(currentZikr.getTimes()));
        }

        if (currentZikr != null) {
            viewHolder.tvBenefits.setText(currentZikr.getBenefits());
        }

        return convertView;

    }
}
