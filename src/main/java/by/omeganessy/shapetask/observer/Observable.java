package by.omeganessy.shapetask.observer;

public interface Observable {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObserver();
}
