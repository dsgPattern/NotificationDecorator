package org.example;

public abstract class NotifierDecorator implements Notifier{
    protected Notifier _wrappee;

    protected NotifierDecorator(Notifier wrappee)
    {
        _wrappee = wrappee;
    }

    @Override
    public void notify(String userName, String message) {
        _wrappee.notify(userName,message);
    }
}
