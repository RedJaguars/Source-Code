package model;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import objects.Observer;
import objects.OrderList;
import objects.Subject;
import database.DatabaseConnection;

public abstract class Model implements Subject {
	protected DatabaseConnection con;
	protected ArrayList<Observer> controllers;
	protected ArrayList<Object> modelList;
	protected static Model instance;
	
	protected Model() {
		con = DatabaseConnection.getInstance();
		controllers = new ArrayList<>();
		modelList = new ArrayList<>();
	}
	
	@Override
	public void register(Observer obv) {
		controllers.add(obv);
	}

	@Override
	public void unregister(Observer obv) {
		controllers.remove(obv);
	}

	@Override
	public void notifyObservers() {
		for(Observer o: controllers) {
			o.update(modelList.iterator());
		}
	}
	
	public abstract Iterator<?> getModelList() throws SQLException;

	
}
