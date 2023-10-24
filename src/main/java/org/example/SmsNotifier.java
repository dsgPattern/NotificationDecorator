package org.example;

public class SmsNotifier extends NotifierDecorator{
    protected SmsNotifier(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void notify(String userName, String message) {
        super.notify(userName, message);
        System.out.println("Sent SMS");
    }
}
