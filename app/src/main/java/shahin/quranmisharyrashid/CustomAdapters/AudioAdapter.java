package shahin.quranmisharyrashid.CustomAdapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import shahin.quranmisharyrashid.Models.Audio;
import shahin.quranmisharyrashid.R;


public class AudioAdapter extends ArrayAdapter<Audio> {


    public AudioAdapter(Activity context, ArrayList<Audio> surasList) {
        super(context, 0, surasList);
    }

    static class ViewHolder {
        TextView verseTitle;
        TextView verseTransliteration;
        TextView verseEnglishTitle;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Audio currentAudio = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.verse_item_list, parent, false);
            viewHolder.verseTitle = convertView.findViewById(R.id.tvSura);
            viewHolder.verseTransliteration = convertView.findViewById(R.id.tvSuraArEn);
            viewHolder.verseEnglishTitle = convertView.findViewById(R.id.tvSuraEn);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (currentAudio != null) {
            viewHolder.verseTitle.setText(currentAudio.getVerseTitle());
        }

        if (currentAudio != null) {
            viewHolder.verseTransliteration.setText(currentAudio.getVerseTransliteration());
        }

        if (currentAudio != null) {
            viewHolder.verseEnglishTitle.setText(currentAudio.getVerseEnglishTitle());
        }

        return convertView;

    }

}