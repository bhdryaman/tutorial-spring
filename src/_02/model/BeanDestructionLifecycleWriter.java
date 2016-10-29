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
		System.out.println("%%% _02.model.BeanDestructionLifecycleWriter.PreDestroy()...");
	}

	@PreDestroy
	public void preDestroyTestMethod2() {
		System.out.println("%%% _02.model.BeanDestructionLifecycleWriter.PreDestroy2()...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("%%% _02.model.BeanDestructionLifecycleWriter.destroy()... DisposableBean");
	}

	public void testDestroyMethod() {
		System.out.println("%%% _02.model.BeanDestructionLifecycleWriter.testDestroyMethod()");
	}

	@Override
	public String toString() {
		return "%%% _02.model.BeanDestructionLifecycleWriter.BeanDestructionLifecycleWriter [property1=" + property1 + "]";
	}

}
