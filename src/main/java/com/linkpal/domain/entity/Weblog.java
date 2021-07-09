package com.linkpal.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Weblog extends Model<Weblog> {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String url;

    private String method;

    private String ip;

    private String classMethod;

    private String args;

    private String reponse;

    private String creatime;

    private String browser;

    private String version;

    @TableField("System")
    private String System;

    @TableField("TimeCost")
    private Long TimeCost;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
