package com.linkpal.domain.entity;

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
 * @author yuan
 * @since 2021-07-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Image extends Model<Image> {

    private static final long serialVersionUID = 1L;

    private String imageurl;

    @TableField("invoiceTypeOrg")
    private String invoiceTypeOrg;

    @TableField("InvoiceCode")
    private String InvoiceCode;

    @TableField("InvoiceNum")
    private String InvoiceNum;

    @TableField("PurchaserName")
    private String PurchaserName;

    @TableField("PurchaserRegisterNum")
    private String PurchaserRegisterNum;

    @TableField("PurchaserAddress")
    private String PurchaserAddress;

    @TableField("PurchaserBank")
    private String PurchaserBank;

    @TableField("SellerName")
    private String SellerName;

    @TableField("SellerRegisterNum")
    private String SellerRegisterNum;

    @TableField("SellerAddress")
    private String SellerAddress;

    @TableField("SellerBank")
    private String SellerBank;

    @TableField("AmountInWords")
    private String AmountInWords;

    @TableField("AmountInFiguers")
    private String AmountInFiguers;

    @TableField("Payee")
    private String Payee;

    @TableField("Checker")
    private String Checker;

    @TableField("NoteDrawer")
    private String NoteDrawer;

    private Integer id;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
