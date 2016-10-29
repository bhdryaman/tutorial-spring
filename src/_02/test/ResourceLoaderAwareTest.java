package _02.test;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import _02.awareness.ResourceLoaderWriter;
import _02.configuration.AppConfig;

public class ResourceLoaderAwareTest {

	public static void main(String[] args) throws IOException {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		ResourceLoaderWriter resourceLoaderService = ctx.getBean("resourceLoaderWriter", ResourceLoaderWriter.class);
		ResourceLoader resourceLoader = resourceLoaderService.getResourceLoader();
		Resource resource = resourceLoader.getResource("classpath:company.properties");

		System.out.println(resource.getURL());

		((AnnotationConfigApplicationContext) ctx).close();

	}
}
