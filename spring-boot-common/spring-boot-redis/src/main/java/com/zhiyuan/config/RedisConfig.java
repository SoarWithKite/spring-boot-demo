package com.zhiyuan.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.lang.reflect.Field;

/**
 * Redis配置类
 *
 * @author Kite
 */
@Configuration
public class RedisConfig {
    /**
     * 创建 RedisTemplate Bean，使用 JSON 序列化方式
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) throws NoSuchFieldException, IllegalAccessException {
        // 创建 RedisTemplate 对象
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 设置 RedisConnection 工厂
        template.setConnectionFactory(factory);
        // 使用 String 序列化方式，序列化 KEY 。
        template.setKeySerializer(RedisSerializer.string());
        template.setHashKeySerializer(RedisSerializer.string());
        // 使用 JSON 序列化方式（库是 Jackson ），序列化 VALUE 。
        template.setValueSerializer(buildRedisSerializer());
        template.setHashValueSerializer(buildRedisSerializer());
        return template;
    }


    /**
     * 构建 Redis 序列化程序
     * 解决 LocalDateTime 的序列化
     */
    @SuppressWarnings("rawtypes")
    public static RedisSerializer<?> buildRedisSerializer() {
        RedisSerializer<Object> json = RedisSerializer.json();
        // 获取 RedisSerializer 类型
        Class<? extends RedisSerializer> clazz = json.getClass();
        try {
            // 获取 mapper 字段
            Field mapperField = clazz.getDeclaredField("mapper");
            // 设置 mapper 字段可访问
            mapperField.setAccessible(true);
            // 获取 mapper 对象
            ObjectMapper objectMapper = (ObjectMapper) mapperField.get(json);
            objectMapper.registerModules(new JavaTimeModule());
            return json;
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

}
