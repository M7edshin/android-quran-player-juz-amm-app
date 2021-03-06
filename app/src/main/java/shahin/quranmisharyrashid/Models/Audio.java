package shahin.quranmisharyrashid.Models;

public class Audio {

    private String verseTitle, verseTransliteration, verseEnglishTitle;
    private int verseAudioFile;

    public Audio(String verseTitle, String verseTransliteration, String verseEnglishTitle, int verseAudioFole) {
        this.verseTitle = verseTitle;
        this.verseTransliteration = verseTransliteration;
        this.verseEnglishTitle = verseEnglishTitle;
        this.verseAudioFile = verseAudioFole;
    }

    public String getVerseTitle() {
        return verseTitle;
    }

    public String getVerseTransliteration() {
        return verseTransliteration;
    }

    public String getVerseEnglishTitle() {
        return verseEnglishTitle;
    }


    public int getVerseAudioFile() {
        return verseAudioFile;
    }


}
