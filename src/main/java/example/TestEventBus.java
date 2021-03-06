package example;

import com.google.common.eventbus.EventBus;

/**
 * Created by tanjingru on 3/25/16.
 */
public class TestEventBus {

    public static void main(String[] args) {

        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener();

        eventBus.register(listener);

        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent(300));
        eventBus.post(new TestEvent(400));

        System.out.println("LastMessage:"+listener.getLastMessage());
    }
}