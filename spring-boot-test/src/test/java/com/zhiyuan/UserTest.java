package com.zhiyuan;

import com.zhiyuan.service.UserService;


import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Kite
 */
@SpringBootTest
public class UserTest {
    @Resource
    private UserService userService;

    @Test
    public void list() {
        userService.list();
    }
}
