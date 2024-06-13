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
 * 角色和部门关联 sys_role_dept
 *
 * @author Lion Li
 */

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_role_dept")
@Entity
@Table(name = "sys_role_dept")
public class SysRoleDept extends BaseEntity {

    /**
     * 角色ID
     */
    @TableId(type = IdType.INPUT)
    @Id
    private Long roleId;

    /**
     * 部门ID
     */
    private Long deptId;

}
