package org.vk.commons.utils.mapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.vk.commons.utils.constants.UtilConstants;
import org.vk.commons.utils.properties.ResourceUtils;

public final class MapperFactory {

	private static final Logger LOGGER = Logger.getLogger(MapperFactory.class);
	private static Properties properties = ResourceUtils.loadProperties(UtilConstants.DEFAULT_CONFIGURATION_FILE);

	private MapperFactory() {

	}

	public static final Mapper getMapper() {

		return new DozerBeanMapper();

	}

	public static final Mapper getMapper(String... configurationFiles) {

		if (configurationFiles != null) {

			List<String> configurationList = new LinkedList<String>();
			for (String iterator : configurationFiles) {
				configurationList.add(iterator);
			}
			return new DozerBeanMapper(configurationList);

		} else {

			LOGGER.info("No configuration files given for Mapper.");
			return getMapper();

		}
	}

}
