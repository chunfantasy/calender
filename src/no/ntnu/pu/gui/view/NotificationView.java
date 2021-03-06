package no.ntnu.pu.gui.view;

import no.ntnu.pu.control.CalendarControl;
import no.ntnu.pu.control.NotificationControl;
import no.ntnu.pu.model.*;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.beans.PropertyChangeEvent;
import java.util.Date;

public class NotificationView extends SidePanel{

    private static Border notificationBorder = new TitledBorder(LineBorder.createGrayLineBorder(),"Notifikasjoner");

    public NotificationView(){
        super();
        CalendarControl.getModel().addPropertyChangeListener(this);
        this.setBorder(notificationBorder);

        for(Notification n: CalendarControl.getNotifications()){
            this.addNotification(n);
        }
    }

    public void addNotification(Notification notification){
        addElement(notification);
    }

    public void removeNotification(Notification notification){
        removeElement(notification);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() == Calendar.NOTIFICATION_PROPERTY){
            if(evt.getNewValue() instanceof Notification){
                addNotification((Notification) evt.getNewValue());
            }else{
                removeNotification((Notification) evt.getOldValue());
            }

        }
    }
}
