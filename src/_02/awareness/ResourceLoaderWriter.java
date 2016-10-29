package _02.awareness;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service(value="resourceLoaderWriter")
public class ResourceLoaderWriter implements ResourceLoaderAware {

	private ResourceLoader resourceLoader;

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}
	
}
