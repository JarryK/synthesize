
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
* 字典类型表
* </p>
*
* @author dadayu
* @since 2021-10-05
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value="sys_dict_type")
public class SysDictTypeEntity {
        private static final long serialVersionUID = 1L;

        @TableId(value = "dict_id", type = IdType.ASSIGN_UUID)
        private String dictId;

        /**  字典名称  */
        private String dictName;

        /**  字典类型  */
        private String dictType;

        /**  状态（0正常 1停用）  */
        private String status;

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
