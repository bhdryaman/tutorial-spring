package _02.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import _02.configuration.AppConfig;
import _02.service.MessageService;

public class MessageTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// From context
		String messageEN = ctx.getMessage("employee.information", 
				new Object[] { "91", "5000", "$" }, Locale.US);

		String messageTR = ctx.getMessage("employee.information", 
				new Object[] { "91", "5000", "TL" }, new Locale("tr", "TR"));
		
        String noMessage = ctx.getMessage("nonemployee",null, "guest" ,Locale.UK );

		System.out.println(messageEN);
		System.out.println(messageTR);
        System.out.println(noMessage);
        
        // From service
		MessageService messageService = ctx.getBean("messageService", MessageService.class);
		MessageSource messageSource = messageService.getMessageSource();

		messageEN = messageSource.getMessage("employee.information", new Object[] { "91", "5000", "$" },
				Locale.US);
		messageTR = messageSource.getMessage("employee.information", new Object[] { "92", "5000", "TL" },
				new Locale("tr", "TR"));

		System.out.println(messageEN);
		System.out.println(messageTR);
		
		((AnnotationConfigApplicationContext) ctx).close();

	}
	
}
