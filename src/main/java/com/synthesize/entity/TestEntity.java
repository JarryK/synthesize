
package com.synthesize.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
* <p>
* 测试数据表
* </p>
*
* @author dadayu
* @since 2021-09-11
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value="test")
public class TestEntity implements Serializable {

        /**  主键id  */
        @TableId(value = "id", type = IdType.ASSIGN_UUID)
        private String id;

        /**  姓名  */
        private String name;

        /**  类型  */
        private Integer type;

        /**  备注  */
        private String remake;

        /**  创建时间  */
        @TableField(value = "create_dt", fill = FieldFill.INSERT)
        private Date createDt;

        /**  更新时间  */
        @TableField(value = "update_dt", fill = FieldFill.INSERT_UPDATE)
        private Date updateDt;

}
