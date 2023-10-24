package org.example;

public class Main {
    public static void main(String[] args) {

        Notifier email = new EmailNotifier();

        // chaining sms to facebook notifier
        // flow goes like this: facebook.notify -> sms.notify(here the order is changed in code; see SmsNotifier impl) -> email.notify
        SmsNotifier smsNotifier = new SmsNotifier(email);
        FacebookNotifier facebookNotifier = new FacebookNotifier(smsNotifier);
        facebookNotifier.notify("User1", "was notified");

        System.out.println("~~~~~~~~");

        // chaining facebook to sms notifier
        // flow goes like this: sms.notify(here the order is changed in code; see SmsNotifier impl) -> facebook.notify -> email.notify
        // the result is the same as above, because the way Sms overrides notify method, by first calling super and then doing it's own implementation
        // you can change that implementation and see how it behaves
        facebookNotifier = new FacebookNotifier(email);
        smsNotifier = new SmsNotifier(facebookNotifier);
        smsNotifier.notify("User1", "was notified");


        System.out.println("~~~~~~~~");

        // without chaining, the email is sent twice
        Notifier anotherSmsNotifier = new SmsNotifier(email);
        anotherSmsNotifier.notify("User1", "was notified");

        Notifier anotherFacebookNotifier = new FacebookNotifier(email);
        anotherFacebookNotifier.notify("User1", "was notified");

        System.out.println("~~~~~~~~");

    }
}