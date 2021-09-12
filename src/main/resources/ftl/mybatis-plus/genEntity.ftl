
package ${package.Entity};

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
<#if swagger2>
import io.swagger.annotations.ApiModelProperty;
</#if>
<#if entityLombokModel>
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
</#if>

import java.util.Date;

/**
* <p>
* ${table.comment!}
* </p>
*
* @author ${author}
* @since ${date}
*/
<#if entityLombokModel>
@Data
<#if superEntityClass??>
@EqualsAndHashCode(callSuper = true)
<#else>
@EqualsAndHashCode(callSuper = false)
</#if>
@Accessors(chain = true)
</#if>
@TableName(value="${table.name}")
public class ${entity} {
<#if entitySerialVersionUID>
        private static final long serialVersionUID = 1L;
</#if>
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>

        <#if field.comment!?length gt 0>
                <#if swagger2>
        @ApiModelProperty(value = "${field.comment}")
                <#else>
        /**  ${field.comment}  */
                </#if>
        </#if>
        <#if field.keyFlag>
        <#-- 主键 -->
        @TableId(value = "${field.name}", type = IdType.ASSIGN_UUID)
        <#-- 普通字段 -->
        <#else>
        <#if field.name == "create_dt">
        @TableField(value = "create_dt", fill = FieldFill.INSERT)
        </#if>
        <#if field.name == "update_dt">
        @TableField(value = "update_dt", fill = FieldFill.INSERT_UPDATE)
        </#if>
        </#if>
<#-- 乐观锁注解 -->
        <#if (versionFieldName!"") == field.name>
        @Version
        </#if>
<#-- 逻辑删除注解 -->
        <#if (logicDeleteFieldName!"") == field.name>
        @TableLogic
        </#if>
        private <#if field.propertyType == "LocalDateTime">Date<#else>${field.propertyType}</#if> ${field.propertyName};
</#list>
<#------------  END 字段循环遍历  ---------->
<#if !entityLombokModel>
        <#list table.fields as field>
                <#if field.propertyType == "boolean">
                        <#assign getprefix="is"/>
                <#else>
                        <#assign getprefix="get"/>
                </#if>
                public ${field.propertyType} ${getprefix}${field.capitalName}() {
                return ${field.propertyName};
                }

                <#if entityBuilderModel>
                        public ${entity} set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
                <#else>
                        public void set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
                </#if>
                this.${field.propertyName} = ${field.propertyName};
                <#if entityBuilderModel>
                        return this;
                </#if>
                }
        </#list>
</#if>

<#if !entityLombokModel>
        @Override
        public String toString() {
        return "${entity}{" +
        <#list table.fields as field>
                <#if field_index==0>
                        "${field.propertyName}=" + ${field.propertyName} +
                <#else>
                        ", ${field.propertyName}=" + ${field.propertyName} +
                </#if>
        </#list>
        "}";
        }
</#if>
}
