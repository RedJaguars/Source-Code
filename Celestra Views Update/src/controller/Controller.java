package controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import model.Model;
import objects.Observer;
import objects.Subject;


public abstract class Controller implements Subject, Observer {
	protected Model model;
	protected ArrayList<Observer> views;
	
	public Controller() {
		views = new ArrayList<>();
	}
	
	@Override
	public void update(Iterator<?> iter) {
		notifyObservers();
	}

	@Override
	public void register(Observer obv) {
		views.add(obv);
	}

	@Override
	public void unregister(Observer obv) {
		views.remove(obv);
	}

	@Override
	public void notifyObservers(){
		for(Observer o: views) {
			try {
				o.update(model.getModelList());
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
