
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
* 系统访问记录
* </p>
*
* @author dadayu
* @since 2021-10-05
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value="sys_logininfor")
public class SysLogininforEntity {
        private static final long serialVersionUID = 1L;

        /**  访问ID  */
        @TableId(value = "info_id", type = IdType.ASSIGN_UUID)
        private String infoId;

        /**  用户账号  */
        private String userName;

        /**  登录IP地址  */
        private String ipaddr;

        /**  登录地点  */
        private String loginLocation;

        /**  浏览器类型  */
        private String browser;

        /**  操作系统  */
        private String os;

        /**  登录状态（0成功 1失败）  */
        private String status;

        /**  提示消息  */
        private String msg;

        /**  访问时间  */
        private Date loginTime;

}
