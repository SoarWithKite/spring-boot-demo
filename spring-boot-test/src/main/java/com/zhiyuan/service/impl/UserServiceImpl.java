package com.zhiyuan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhiyuan.entity.User;
import com.zhiyuan.mapper.UserMapper;
import com.zhiyuan.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Kite
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
