package org.example;

public class EmailNotifier implements Notifier{
    @Override
    public void notify(String userName, String message) {
        System.out.println("Sent email to " + userName + " with this message "+message);
    }
}
