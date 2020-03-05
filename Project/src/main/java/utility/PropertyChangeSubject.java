package utility;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject {
    public void addListener(String evtid, PropertyChangeListener listener);
    public void removeListener(String evtid, PropertyChangeListener listener);
}
