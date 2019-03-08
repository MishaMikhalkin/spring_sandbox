package lab1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.*;
import java.util.Scanner;

@Component
public class ConsoleUtil {
    private static ConsoleUtil instance;

    private Scanner scanner = new Scanner(System.in);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private AppLanguage language;


    @PostConstruct
    public void init() {
        instance = this;
    }

    public static void printLocalizedString(String name, String[] args) {
        String message = instance.messageSource.getMessage(name, args, instance.language.getLocale());
        System.out.println(message);
    }

    public static String getLocalizedString(String name, String[] args) {
        return instance.messageSource.getMessage(name, args, instance.language.getLocale());
    }


    public static String readString() {
        return  instance.scanner.nextLine();
    }

    public static int readInt() {
        return  instance.scanner.nextInt();
    }
}
