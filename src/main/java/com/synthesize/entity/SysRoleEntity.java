
package com.synthesize.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
* <p>
* 角色信息表
* </p>
*
* @author dadayu
* @since 2021-10-05
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value="sys_role")
public class SysRoleEntity {
        private static final long serialVersionUID = 1L;

        @TableId(value = "role_id", type = IdType.ASSIGN_UUID)
        private String roleId;

        /**  角色名称  */
        private String roleName;

        /**  角色权限字符串  */
        private String roleKey;

        /**  显示顺序  */
        private Integer roleSort;

        /**  数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）  */
        private String dataScope;

        /**  菜单树选择项是否关联显示  */
        private Boolean menuCheckStrictly;

        /**  部门树选择项是否关联显示  */
        private Boolean deptCheckStrictly;

        /**  角色状态（0正常 1停用）  */
        private String status;

        /**  删除标志（0代表存在 2代表删除）  */
        private String delFlag;

        /**  创建者  */
        private String createBy;

        /**  创建时间  */
        private Date createTime;

        /**  更新者  */
        private String updateBy;

        /**  更新时间  */
        private Date updateTime;

        /**  备注  */
        private String remark;

}
