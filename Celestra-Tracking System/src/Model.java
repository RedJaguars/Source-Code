import java.util.ArrayList;
import java.util.Iterator;

public abstract class Model implements Subject {
	protected DatabaseConnection con;
	protected ArrayList<Observer> controllers;
	protected ArrayList<?> modelList;
	
	public Model() {
		con = DatabaseConnection.getInstance();
		controllers = new ArrayList<>();
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
	
	public Iterator<?> getModelList() {
		return modelList.iterator();
	}
}
