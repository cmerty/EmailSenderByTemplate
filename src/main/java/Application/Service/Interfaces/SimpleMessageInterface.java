package Application.Service.Interfaces;

import Application.Model.Mail;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;

public interface SimpleMessageInterface {
    void sendSimpleMessage(Mail mail) throws MessagingException, IOException, TemplateException;
}
