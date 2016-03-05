package org.vk.commons.utils.properties;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.vk.commons.utils.string.StringUtils;

public final class ResourceUtils {

	private ResourceUtils() {
	}

	public static URL getResource(String fileName) {
		ClassLoader classLoader = getClassLoader();
		return classLoader.getResource(fileName);
	}

	public static ClassLoader getClassLoader() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader == null) {
			classLoader = ResourceUtils.class.getClassLoader();
		}
		return classLoader;
	}

	public static List<URL> getResources(String fileName) {
		ClassLoader classLoader = getClassLoader();
		List<URL> resources = new ArrayList<URL>();
		try {
			Enumeration<URL> urls = classLoader.getResources(fileName);
			while (urls.hasMoreElements()) {
				resources.add(urls.nextElement());
			}
		} catch (Exception e) {
			resources.add(classLoader.getResource(fileName));
		}
		return resources;
	}

	public static Properties loadProperties(String fileName) {
		Properties properties = new Properties();
		try {
			List<URL> resources = getResources(fileName);
			for (URL iterator : resources) {
				properties.load(iterator.openStream());
			}
		} catch (Exception e) {
			properties.clear();
		}
		return properties;
	}

	public static Properties loadProperties(String fileName, String... fileNames) {
		Properties properties = new Properties();
		try {
			properties = loadProperties(fileName);
			if (fileNames != null) {
				for (String iterator : fileNames) {

					List<URL> resources = getResources(iterator);
					for (URL urlIterator : resources) {
						properties.load(urlIterator.openStream());
					}

				}
			}
		} catch (Exception e) {
			properties.clear();
		}
		return properties;
	}

	public static boolean isResource(String fileName) {
		URL url = getResource(fileName);
		return (url != null);
	}

	public static List<String> getStringList(String value, String... values) {
		List<String> list = new ArrayList<String>();

		if (values != null) {
			for (String iterator : values) {
				if (iterator != null) {
					list.add(StringUtils.concatenate(value, iterator));
				}
			}
		} else {
			list.add(value);
		}

		return list;
	}

}