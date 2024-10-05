package com.sumit.coding.design_patterns.behavioral.observer.solution.observable.impl;

import com.sumit.coding.design_patterns.behavioral.observer.solution.observer.DisplayObserver;
import com.sumit.coding.design_patterns.behavioral.observer.solution.observable.WeatherStationObservable;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationObservableImpl implements WeatherStationObservable {

    float temp;
    List<DisplayObserver> displayObserverList = new ArrayList<>();

    @Override
    public void register(DisplayObserver obj) {
        displayObserverList.add(obj);
    }

    @Override
    public void remove(DisplayObserver obj) {
        displayObserverList.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (DisplayObserver obj : displayObserverList) {
            obj.update(temp);
        }
    }

    @Override
    public void setTemp(float newTemp) {
        if (temp != newTemp) {
            temp = newTemp;
            notifyObservers();
        }
    }
}
