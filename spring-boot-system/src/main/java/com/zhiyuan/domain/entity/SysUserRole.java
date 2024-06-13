package com.zhiyuan.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户和角色关联 sys_user_role
 *
 * @author Lion Li
 */

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_user_role")
@Entity
@Table(name = "sys_user_role")
public class SysUserRole extends BaseEntity {

    /**
     * 用户ID
     */
    @TableId(type = IdType.INPUT)
    @Id
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

}
