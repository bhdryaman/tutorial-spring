package _02.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import _02.configuration.AppConfig;
import _02.event.MessageEvent;

public class EventTest {
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		ctx.publishEvent(new MessageEvent(new Object(), "Message 1!"));
		ctx.publishEvent(new MessageEvent(new Object(), "Message 2!"));
		ctx.publishEvent(new MessageEvent(new Object(), "Message 3!"));
		
		((AnnotationConfigApplicationContext) ctx).close();

	}
}
