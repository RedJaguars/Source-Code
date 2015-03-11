import java.util.ArrayList;
import java.util.Iterator;


public abstract class Controller implements Subject, Observer {
	protected Model model;
	protected ArrayList<Observer> views;
	
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
	public void notifyObservers() {
		for(Observer o: views) {
			o.update(model.getModelList());
		}
	}

}
