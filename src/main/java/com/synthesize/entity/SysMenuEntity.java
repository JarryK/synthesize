
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
* 菜单权限表
* </p>
*
* @author dadayu
* @since 2021-10-05
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value="sys_menu")
public class SysMenuEntity {
        private static final long serialVersionUID = 1L;

        @TableId(value = "menu_id", type = IdType.ASSIGN_UUID)
        private String menuId;

        /**  菜单名称  */
        private String menuName;

        private String parentId;

        /**  显示顺序  */
        private Integer orderNum;

        /**  路由地址  */
        private String path;

        /**  组件路径  */
        private String component;

        /**  路由参数  */
        private String query;

        /**  是否为外链（0是 1否）  */
        private Integer isFrame;

        /**  是否缓存（0缓存 1不缓存）  */
        private Integer isCache;

        /**  菜单类型（M目录 C菜单 F按钮）  */
        private String menuType;

        /**  菜单状态（0显示 1隐藏）  */
        private String visible;

        /**  菜单状态（0正常 1停用）  */
        private String status;

        /**  权限标识  */
        private String perms;

        /**  菜单图标  */
        private String icon;

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
