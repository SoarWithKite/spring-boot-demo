package com.zhiyuan.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


/**
 * @author Kite
 */
@Data
@Entity
@Table(name = "sys_user")
@TableName("sys_user")
public class User {
    @Id
    private Long id;
    private Integer age;
    private String userName;
    private String password;
    private Integer status;

}
