package com.waynesun.utils.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import com.waynesun.utils.UserUtils;

public abstract class Observable extends java.util.Observable {
	public static final String OBSERVABLE_ID_GROBAL = "grobal";
	public List<String> getObservableIds(){
		List<String> observableIds = new ArrayList<String>();
		observableIds.add(this.getClass().getName());
		return observableIds;
	}
	protected abstract ObserverParam getObserverParam(int operateType);
	public void notifyChange(ObserverParam observerParam){
		setChanged();
		notifyObservers(observerParam);
	}
	public void addObserver(){
		for(Observer observer : ObserverHelper.getObservers(this)){
			this.addObserver(observer);
		}
	}
}
