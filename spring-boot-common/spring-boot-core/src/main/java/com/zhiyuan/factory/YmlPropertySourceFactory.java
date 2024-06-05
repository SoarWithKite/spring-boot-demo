package com.zhiyuan.factory;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.util.Objects;

/**
 * yml 配置源工厂
 *
 * @author Kite
 */
public class YmlPropertySourceFactory extends DefaultPropertySourceFactory {

    @Override
    @NonNull
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        String sourceName = resource.getResource().getFilename();
        if (StringUtils.isNotBlank(sourceName) && (sourceName.endsWith(".yml") || sourceName.endsWith(".yaml"))) {
            YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
            factory.setResources(resource.getResource());
            factory.afterPropertiesSet();
            return new PropertiesPropertySource(sourceName, Objects.requireNonNull(factory.getObject()));
        }
        return super.createPropertySource(name, resource);
    }

}
