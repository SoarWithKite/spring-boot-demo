package com.zhiyuan;

import com.zhiyuan.domain.entity.SysUser;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;

/**
 * @author Kite
 */
@SpringBootTest
public class RedisTest {
    @Resource
    private RedisTemplate<String, LocalDateTime> redisTemplate;

    @Test
    public void setRedisTemplate() {
        SysUser sysUser = new SysUser();
        sysUser.setCreateTime(LocalDateTime.now());
        redisTemplate.opsForValue().set("test",LocalDateTime.now());
        LocalDateTime sysUser1 = redisTemplate.opsForValue().get("test");
        System.out.println(sysUser1);
    }
}
