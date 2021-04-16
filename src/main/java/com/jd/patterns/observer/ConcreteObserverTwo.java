package com.jd.patterns.observer;



public class ConcreteObserverTwo implements Observer{
    @Override
    public void update(Message message) {
        //TODO
        System.out.println("ConcreteObserverTwo is notified");
    }
}
