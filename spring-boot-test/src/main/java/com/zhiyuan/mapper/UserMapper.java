package com.zhiyuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiyuan.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Kite
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
