
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
* 操作日志记录
* </p>
*
* @author dadayu
* @since 2021-10-05
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value="sys_oper_log")
public class SysOperLogEntity {
        private static final long serialVersionUID = 1L;

        @TableId(value = "oper_id", type = IdType.ASSIGN_UUID)
        private String operId;

        /**  模块标题  */
        private String title;

        /**  业务类型（0其它 1新增 2修改 3删除）  */
        private Integer businessType;

        /**  方法名称  */
        private String method;

        /**  请求方式  */
        private String requestMethod;

        /**  操作类别（0其它 1后台用户 2手机端用户）  */
        private Integer operatorType;

        /**  操作人员  */
        private String operName;

        /**  部门名称  */
        private String deptName;

        /**  请求URL  */
        private String operUrl;

        /**  主机地址  */
        private String operIp;

        /**  操作地点  */
        private String operLocation;

        /**  请求参数  */
        private String operParam;

        /**  返回参数  */
        private String jsonResult;

        /**  操作状态（0正常 1异常）  */
        private Integer status;

        /**  错误消息  */
        private String errorMsg;

        /**  操作时间  */
        private Date operTime;

}
