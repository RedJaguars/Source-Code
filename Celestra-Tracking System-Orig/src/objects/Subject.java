package objects;

public interface Subject {
	public void register(Observer obv);
	public void unregister(Observer obv);
	public void notifyObservers();
}
