package com.sumit.coding.design_patterns.behavioral.observer.solution;

import com.sumit.coding.design_patterns.behavioral.observer.solution.observable.WeatherStationObservable;
import com.sumit.coding.design_patterns.behavioral.observer.solution.observer.impl.MobileDisplayObserver;
import com.sumit.coding.design_patterns.behavioral.observer.solution.observer.impl.TVDisplayObserver;
import com.sumit.coding.design_patterns.behavioral.observer.solution.observable.impl.WeatherStationObservableImpl;

public class MainClass {

    public static void main(String[] args) {
        WeatherStationObservable stationObservable = new WeatherStationObservableImpl();

        MobileDisplayObserver mobileDisplayObserver = new MobileDisplayObserver(stationObservable);
        TVDisplayObserver tvDisplayObserver = new TVDisplayObserver(stationObservable);

        stationObservable.register(mobileDisplayObserver);
        stationObservable.register(tvDisplayObserver);

        stationObservable.setTemp(26f);
        stationObservable.setTemp(29f);
        stationObservable.setTemp(24f);
    }
}
