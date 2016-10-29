package _02.awareness;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringAwarenessWriter implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware {

	private String beanName;

	@Override
	public void setBeanName(String name) {
		System.out.println("--- _02.awareness.SpringAwarenessWriter.setBeanName("+name+")");
		this.beanName = name;
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("--- _02.awareness.SpringAwarenessWriter.setBeanClassLoader()"
				+ "\n---\tclass loader:" + classLoader.getClass());

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("--- _02.awareness.SpringAwarenessWriter.setApplicationContext()");
		System.out.println("---\t"+applicationContext.getDisplayName());
	}
	
	public void log() {
		System.out.println("--- _02.awareness.SpringAwarenessWriter.log()\n\tBean[" + beanName + "] log...");
	}

}
