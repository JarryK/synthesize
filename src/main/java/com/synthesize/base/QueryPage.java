package com.synthesize.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.session.RowBounds;

/**
 * <b>项目名称：</b>synthesize<br>
 * <b>类所处包：</b>com.synthesize.base<br>
 * <b>创建人：</b>DadaYu<br>
 * <b>类描述：</b><br>
 * <b>创建时间：</b>2021/9/11 22:03<br>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QueryPage<T> extends RowBounds {

    private Integer size;

    private Integer num;

    private T query;


    public QueryPage(int num, int size , T query) {
        super(num * size,size);
        this.num = num;
        this.size = size;
        this.query = query;
    }

}
