package _02.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;

public class BeanCreationLifecycleWriter implements InitializingBean {

	private String property1;

	public String getProperty1() {
		return property1;
	}

	public void setProperty1(String property1) {
		this.property1 = property1;
	}

	@PostConstruct
	public void postConstructTest() {
		System.out.println(">>> _02.model.BeanCreationLifecycleWriter.postConstructTest()");
	}

	@PostConstruct
	public void postConstructTest2() {
		System.out.println(">>> _02.model.BeanCreationLifecycleWriter.postConstructTest2");
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println(">>> _02.model.BeanCreationLifecycleWriter.afterPropertiesSet()");
	}

	public void initTestMethod() {
		System.out.println(">>> _02.model.BeanCreationLifecycleWriter.initTestMethod()");
	}

	@Override
	public String toString() {
		return ">>> _02.model.BeanCreationLifecycleWriter.BeanCreationLifecycleWriter [property1=" + property1 + "]";
	}

}
