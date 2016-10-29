package _02.service;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Service;

@Service(value="messageService")
public class MessageService implements MessageSourceAware {

	private MessageSource messageSource;

	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println("~~~\tsetMessageSource()");
		this.messageSource = messageSource;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

}