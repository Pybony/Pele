package br.com.chamados.view;

import java.io.FileInputStream;
import java.util.*;
import javax.mail.*;

/**
 *
 * @author lksbr
 */
public class Mail extends Thread {

    public void run() {
        while (true) {
            Properties props = new Properties();
            try {
                props.load(new FileInputStream(Mail.class.getResource("/mail.properties").getFile()));
                Session session = Session.getDefaultInstance(props, null);

                Store store = session.getStore("imaps");
                store.connect("smtp.gmail.com", "suporte.cook@gmail.com", "suporte01");

                Folder inbox = store.getFolder("inbox");
                inbox.open(Folder.READ_WRITE);
                int messageCount = inbox.getMessageCount();

                System.out.println("Total Messages:- " + messageCount);

                Message[] messages = inbox.getMessages();
                String result = "";
                for (int i = 0; i < messageCount; i++) {
                    System.out.println("------------------------------");
                    System.out.println("Mail Subject:- " + messages[i].getSubject());
                    Object contentObject = messages[i].getContent();
                    if (contentObject instanceof Multipart) {
                        BodyPart clearTextPart = null;
                        BodyPart htmlTextPart = null;
                        Multipart content = (Multipart) contentObject;
                        for (int j = 0; j < content.getCount(); j++) {
                            BodyPart part = content.getBodyPart(j);
                            if (part.isMimeType("text/plain")) {
                                clearTextPart = part;
                                System.out.println("clearTextPart - ");
                                break;
                            } else if (part.isMimeType("text/html")) {
                                System.out.println("htmlTextPart - ");
                                htmlTextPart = part;
                            }
                        }

                        if (clearTextPart != null) {
                            result = (String) clearTextPart.getContent();
                            System.out.println("clearTextPart - " + result);
                        } else if (htmlTextPart != null) {
                            String html = (String) htmlTextPart.getContent();
                            result = html;
                            System.out.println("htmlTextPart - " + result);
                        }

                    }
                    messages[i].setFlag(Flags.Flag.DELETED, true);
                }
                inbox.close(true);
                store.close();
                Thread.sleep(60000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
