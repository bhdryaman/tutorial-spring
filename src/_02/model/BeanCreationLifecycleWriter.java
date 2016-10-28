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
		System.out.println("\t>>> postConstructTest");
	}

	@PostConstruct
	public void postConstructTest2() {
		System.out.println("\t>>> postConstructTest2");
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("\t>>> afterPropertiesSet");
	}

	public void initTestMethod() {
		System.out.println("\t>>> initTestMethod");
	}

	@Override
	public String toString() {
		return "\t>>> BeanCreationLifecycleWriter [property1=" + property1 + "]";
	}

}
