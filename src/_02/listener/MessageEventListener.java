package _02.listener;

import org.springframework.context.ApplicationListener;

import _02.event.MessageEvent;

public class MessageEventListener implements ApplicationListener<MessageEvent> {
	
	@Override
	public void onApplicationEvent(MessageEvent event) {

		MessageEvent messageEvent = event;
		System.out.println("=== _02.event.MessageEventListener\n\t\t>> Message Received : " + messageEvent.getMessage());

	}

}
