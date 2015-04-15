package objects;
import java.util.Iterator;

public interface Observer {
	public void update(Iterator<?> iter);
}
