package com.waynesun.utils.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observer;

public class ObserverHelper {
	private static final Map<String,List<Observer>> OBSERVERS = new HashMap<String, List<Observer>>();
	public static Observer[] getObservers(Observable observable){
		List<Observer> observers = new ArrayList<Observer>();
		for(String observableId : observable.getObservableIds()){
			List<Observer> data = OBSERVERS.get(observableId);
			if(data!=null)
				observers.addAll(data);
		}
		return observers.toArray(new Observer[0]);
	}
	public static void registerObserver(String key,Observer observer){
		List<Observer> observers = OBSERVERS.get(key);
		if(observers==null){
			observers = new ArrayList<Observer>();
			OBSERVERS.put(key, observers);
		}
		observers.add(observer);
	}
}
