package com.jd.patterns.observer;



public class ConcreteObserverOne implements Observer{
    @Override
    public void update(Message message) {
        //TODO
        System.out.println("ConcreteObserverOne is notified");
    }
}
