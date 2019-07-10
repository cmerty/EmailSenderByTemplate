package Application;

import Application.Model.Mail;
import Application.Service.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application implements ApplicationRunner {

    private LocalDateTime dateOfStart = LocalDateTime.now();

    @Autowired
    private MailServiceImpl emailService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        int counter = 0;
        while (counter<15) {
            counter++;
            LocalDateTime localDateTimeStart = LocalDateTime.now();
            Mail mail = new Mail();
            mail.setFrom("tt934112@gmail.com");
            mail.setTo("tt934112@gmail.com");
            mail.setSubject("We invite you to hellfest");

            Map<String, Object> model = new HashMap<>();
            model.put("name", "Andrii");
            model.put("location", "France");
            model.put("signature", "https://www.hellfest.fr/");
            mail.setModel(model);

            emailService.sendSimpleMessage(mail);

            LocalDateTime localDateTimeEnd = LocalDateTime.now();
            long minutes = ChronoUnit.MINUTES.between(localDateTimeStart, localDateTimeEnd);
            long sec = ChronoUnit.SECONDS.between(localDateTimeStart, localDateTimeEnd);
            long milliSec = ChronoUnit.MILLIS.between(localDateTimeStart, localDateTimeEnd);
            System.out.println("Iteration: №" + counter + ", " + "time: " + minutes + "." + sec + "." + milliSec);
        }
        System.out.println(ChronoUnit.HOURS.between(dateOfStart,LocalDateTime.now())+":"+ChronoUnit.MINUTES.between(dateOfStart,LocalDateTime.now())+":"+ChronoUnit.SECONDS.between(dateOfStart,LocalDateTime.now()));
    }
}
