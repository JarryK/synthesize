
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
* 
* </p>
*
* @author dadayu
* @since 2021-10-05
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value="sys_verify")
public class SysVerifyEntity {
        private static final long serialVersionUID = 1L;

        /**  id  */
        @TableId(value = "id", type = IdType.ASSIGN_UUID)
        private String id;

        /**  用户id  */
        private String userId;

        /**  密码  */
        private String password;

        @TableField(value = "create_dt", fill = FieldFill.INSERT)
        private Date createDt;

        @TableField(value = "update_dt", fill = FieldFill.INSERT_UPDATE)
        private Date updateDt;

}
