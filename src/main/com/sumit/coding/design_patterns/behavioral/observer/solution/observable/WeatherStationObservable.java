package com.sumit.coding.design_patterns.behavioral.observer.solution.observable;

import com.sumit.coding.design_patterns.behavioral.observer.solution.observer.DisplayObserver;

public interface WeatherStationObservable {

    void register(DisplayObserver obj);

    void remove(DisplayObserver obj);

    void notifyObservers();

    void setTemp(float newTemp);
}
