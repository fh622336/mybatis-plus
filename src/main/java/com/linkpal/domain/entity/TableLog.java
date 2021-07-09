package com.linkpal.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 樊浩
 * @since 2021-07-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Table_log")
public class TableLog extends Model<TableLog> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
