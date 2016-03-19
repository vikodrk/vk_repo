package org.vk.commons.utils.mapper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.vk.commons.utils.constants.UtilConstants;
import org.vk.commons.utils.properties.ResourceUtils;
import org.vk.commons.utils.string.StringUtils;

public final class MapperFactory {

	private static final Logger LOGGER = Logger.getLogger(MapperFactory.class);
	private static final String CONFIGURATION_FILE_NOT_FOUND = "No se encontro el archivo {0}.";

	private MapperFactory() {

	}

	private static final Mapper getEmptyMapper() {

		return new DozerBeanMapper();

	}

	public static final Mapper getDefaultMapper() {
		Mapper mapper;
		List<String> files;
		if (ResourceUtils.isResource(UtilConstants.MAPPER_DEFAUL_CONFIGURACION)) {
			files = new ArrayList<String>();
			files.add(UtilConstants.MAPPER_DEFAUL_CONFIGURACION);
			mapper = new DozerBeanMapper(files);
			return mapper;
		} else {
			LOGGER.warn(
					StringUtils.buildString(CONFIGURATION_FILE_NOT_FOUND, UtilConstants.MAPPER_DEFAUL_CONFIGURACION));
			return getEmptyMapper();
		}
	}

	public static final Mapper getCustomMapper() {
		Mapper mapper;
		List<String> files;
		if (ResourceUtils.isResource(UtilConstants.MAPPER_CONFIGURATION_FILE)) {
			files = new ArrayList<String>();
			files.add(UtilConstants.MAPPER_CONFIGURATION_FILE);
			mapper = new DozerBeanMapper(files);
			return mapper;
		} else {
			LOGGER.warn(StringUtils.buildString(CONFIGURATION_FILE_NOT_FOUND, UtilConstants.MAPPER_CONFIGURATION_FILE));
			return getDefaultMapper();
		}
	}

	public static final Mapper getCustomMapper(String... configurationFiles) {

		if (configurationFiles != null) {

			List<String> configurationList = new LinkedList<String>();
			for (String iterator : configurationFiles) {
				if (ResourceUtils.isResource(iterator)) {
					configurationList.add(iterator);
				} else {
					LOGGER.warn(StringUtils.buildString(CONFIGURATION_FILE_NOT_FOUND, iterator));
				}

			}
			return configurationList.isEmpty() ? getCustomMapper() : new DozerBeanMapper(configurationList);

		} else {

			LOGGER.info("No configuration files given for Mapper.");
			return getDefaultMapper();

		}
	}

}
