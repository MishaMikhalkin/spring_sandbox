package lab1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Scanner;

@Component
public class ConsoleUtil {

    private MessageSource messageSource;

    private AppLanguage appLanguage;

    private Scanner scanner = new Scanner(System.in);

    @Autowired
    public ConsoleUtil(AppLanguage appLanguage, MessageSource messageSource) {
        this.messageSource = messageSource;
        this.appLanguage = appLanguage;
    }




    public void printLocalizedString(String name, String[] args) {
        String message = messageSource.getMessage(name, args, appLanguage.getLocale());
        System.out.println(message);
    }

    public  String getLocalizedString(String name, String[] args) {
        return messageSource.getMessage(name, args, appLanguage.getLocale());
    }


    public String readString() {
        return  scanner.nextLine();
    }

    public Integer readInt() {
        return  scanner.nextInt();
    }
}
