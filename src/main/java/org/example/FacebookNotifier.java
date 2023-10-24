package org.example;

public class FacebookNotifier extends NotifierDecorator{


    protected FacebookNotifier(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void notify(String userName, String message) {
        System.out.println("Posted on user's "+ userName +
                " Facebook page the following message: " +
                message);
        super.notify(userName, message);
    }

}
