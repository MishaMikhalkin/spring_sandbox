package lab1.util;

import lab1.config.GenericConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.*;
import java.util.Scanner;

@Component
public class ConsoleUtil {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private AppLanguage appLanguage;

    private Scanner scanner = new Scanner(System.in);

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

    public int readInt() {
        return  scanner.nextInt();
    }
}
