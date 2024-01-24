package edu.christivie.java3kirkwood.shared;

import com.azure.communication.email.*;
import com.azure.communication.email.models.*;
import com.azure.core.util.polling.PollResponse;
import com.azure.core.util.polling.SyncPoller;
import io.github.cdimascio.dotenv.Dotenv;

public class AzureCommunication {
        public static void sendEmail( String emailAddress, String message )
        {
            // You can get your connection string from your resource in the Azure portal.
            Dotenv dotenv = Dotenv.load();
            String connectionString = dotenv.get("EMAIL_CONNECTION");
            EmailClient emailClient = new EmailClientBuilder().connectionString(connectionString).buildClient();

            EmailAddress toAddress = new EmailAddress("lisedjuma@gmail.com");

            EmailMessage emailMessage = new EmailMessage()
                    .setSenderAddress(dotenv.get("MAIL_FROM"))
                    .setToRecipients(toAddress)
                    .setSubject("testing java email")
                    .setBodyPlainText("Hello world via email.");

            SyncPoller<EmailSendResult, EmailSendResult> poller = emailClient.beginSend(emailMessage, null);
            PollResponse<EmailSendResult> result = poller.waitForCompletion();
        }
}
