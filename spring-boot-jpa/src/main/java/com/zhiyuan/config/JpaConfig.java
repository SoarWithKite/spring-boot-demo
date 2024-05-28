package com.zhiyuan.config;

import com.zhiyuan.factory.YmlPropertySourceFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * jpa配置类
 *
 * @author Kite
 */
@EnableTransactionManagement(proxyTargetClass = true)
//@PropertySource 注解用于指定外部属性文件，以便 Spring 环境可以读取这些属性。
// 在这个例子中，属性文件是一个 YAML 文件，并且通过自定义的 YmlPropertySourceFactory 工厂类来解析该文件。
//为了使 @PropertySource 支持 YAML 文件，需要自定义一个 PropertySourceFactory,使 Spring 能够解析 YAML 格式的属性文件。
@PropertySource(value = "classpath:common-jpa.yml", factory = YmlPropertySourceFactory.class)
public class JpaConfig {

}
