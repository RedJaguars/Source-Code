import java.util.Iterator;

public abstract class View implements Observer {
	protected Controller controller;
	
	public View(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void update(Iterator<?> iter) {
		// TODO Auto-generated method stub
	}

}
