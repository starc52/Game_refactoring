import java.util.*;

public class PubAndSubs {

    public static Vector subscribe(UnivObserver uObserve, Vector subscribers){
        subscribers.add(uObserve);
        return subscribers;
    }

    public static void  publish(UnivEvent uEvent, Vector subscribers, String identify){
        if(identify == (String)"Control"){
            Iterator eventIterator = subscribers.iterator();
            while (eventIterator.hasNext()) {
                ((ControlDeskObserver) eventIterator.next()).receiveControlDeskEvent((ControlDeskEvent) uEvent);
            }
        }
        else if(identify == (String)"Lane"){
            if( subscribers.size() > 0 ) {
                Iterator eventIterator = subscribers.iterator();

                while ( eventIterator.hasNext() ) {
                    ( (LaneObserver) eventIterator.next()).receiveLaneEvent( (LaneEvent) uEvent);
                }
            }
        }
    }
}
