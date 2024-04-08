package edu.christivie.java3kirkwood.shared;

import com.azure.communication.email.EmailClient;
import com.azure.communication.email.EmailClientBuilder;
import com.azure.communication.email.implementation.models.ErrorResponseException;
import com.azure.communication.email.models.EmailAddress;
import com.azure.communication.email.models.EmailMessage;
import com.azure.communication.email.models.EmailSendResult;
import com.azure.core.util.polling.PollResponse;
import com.azure.core.util.polling.SyncPoller;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.servlet.http.HttpServletRequest;

public class ComServices {
    public static void main(String[] args) {
        sendEmail("christivie", "Testing", "Testing again");
    }
    private static EmailClient createEmailClient() {
        Dotenv dotenv = Dotenv.load();
        String connectionString = dotenv.get("EMAIL_CONNECTION");
        EmailClient emailClient = new EmailClientBuilder()
                .connectionString(connectionString)
                .buildClient();
        return emailClient;
    }

    public static String sendNewUserEmail(String email, String code) {
        String subject = "View anime New User";
        String message = "<h2>Welcome to View Anime</h2>";
        message += "<p>Please enter code <b>" + code + "</b> on the website to activate your account</p>";
        boolean sent = ComServices.sendEmail(email, subject, message);
        return sent ? code : "";
    }

    public static boolean sendPasswordResetEmail(String email, String uuid, HttpServletRequest req) {
        String subject = "Anime Reset Password";
        String message = "<h2>Welcome to View Anime</h2>";
        message += "<p>Please use this link to securely reset your password.</p>";
        String appURL;
        if(req.isSecure()){
            appURL = req.getServletContext().getInitParameter("appURLCloud");
        }else{
            appURL = req.getServletContext().getInitParameter("appURLLocal");
        }
        String fullURL = String.format("%s/newPassword?token=%s", appURL, uuid);
        message += String.format("<p><a href=\"%s\" target =\"_blank\">%s</a></p>", fullURL,fullURL);
        message += "<p>If you didn't request to reset the password, you can ignore this message, your password will not be changed</p>";
        boolean sent = ComServices.sendEmail(email, subject, message);
        return sent;
    }

    public static boolean sendEmail(String toEmailAddress, String subject, String message)    {
        try {
            EmailClient emailClient = createEmailClient();

            EmailAddress toAddress = new EmailAddress(toEmailAddress);

            EmailMessage emailMessage = new EmailMessage()
                    .setSenderAddress(Dotenv.load().get("MAIL_FROM"))
                    .setToRecipients(toAddress)
                    .setSubject(subject)
                    .setBodyHtml(message);

            SyncPoller<EmailSendResult, EmailSendResult> poller = emailClient.beginSend(emailMessage, null);
            PollResponse<EmailSendResult> result = poller.waitForCompletion();
            return true;
        } catch(ErrorResponseException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
