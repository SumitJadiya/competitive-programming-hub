package com.sumit.coding.design_patterns.behavioral.observer.solution.observer.impl;

import com.sumit.coding.design_patterns.behavioral.observer.solution.observer.DisplayObserver;
import com.sumit.coding.design_patterns.behavioral.observer.solution.observable.WeatherStationObservable;

public class MobileDisplayObserver implements DisplayObserver {

    WeatherStationObservable obj;

    public MobileDisplayObserver(WeatherStationObservable o) {
        this.obj = o;
    }

    @Override
    public void update(float temp) {
        obj.setTemp(temp);
        System.out.println("[Mobile] Current conditions: " + temp + "°C");
    }
}
