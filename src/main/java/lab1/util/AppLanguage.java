package lab1.util;

import java.util.Locale;

public class AppLanguage {

    private String locale;

    public AppLanguage(String locale) {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return locale;
    }

    public Locale getLocale() {
        return new Locale(locale);
    }
}
