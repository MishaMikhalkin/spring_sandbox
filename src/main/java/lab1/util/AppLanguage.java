package lab1.util;

import org.springframework.beans.factory.annotation.Value;

import java.util.Locale;

public class AppLanguage {

    private String locale;

    public AppLanguage(@Value("${language}") String locale) {
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
