package com.synthesize.base;



import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * <b>项目名称：</b>synthesize<br>
 * <b>类所处包：</b>com.synthesize.base<br>
 * <b>创建人：</b>DadaYu<br>
 * <b>类描述：</b>交互定义<br>
 * <b>创建时间：</b>2021/9/11 20:59<br>
 */
@Data
public class JsonResult {

    private int code;         //状态码
    private String msg;       //消息
    private Object data;      //数据对象

    /**
     * 无参构造器
     */
    public JsonResult(){
        super();
    }

    /**
     * 只返回状态码，消息
     * @param code
     * @param msg
     */
    public JsonResult(int code, String msg){
        super();
        this.code=code;
        this.msg=msg;
    }

    /**
     只返回状态码，消息，数据对象
     @param code
     @param msg
     @param data
     */
    public JsonResult(int code, String msg, Object data){
        super();
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
