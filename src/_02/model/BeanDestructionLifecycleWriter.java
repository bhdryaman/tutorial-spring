package _02.model;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;

public class BeanDestructionLifecycleWriter implements DisposableBean {

	private String property1;

	public String getProperty1() {
		return property1;
	}

	public void setProperty1(String property1) {
		this.property1 = property1;
	}

	@PreDestroy
	public void preDestroyTestMethod() {
		System.out.println("\t%%% PreDestroy...");
	}

	@PreDestroy
	public void preDestroyTestMethod2() {
		System.out.println("\t%%% PreDestroy 2...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("\t%%% DisposableBean - destroy method");
	}

	public void testDestroyMethod() {
		System.out.println("\t%%% testDestroyMethod()");
	}

	@Override
	public String toString() {
		return "\t%%% BeanDestructionLifecycleWriter [property1=" + property1 + "]";
	}

}
