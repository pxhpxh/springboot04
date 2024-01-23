package com.example.springboot04.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author pxh
 * @since 2022-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("Swagger返回值user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;



    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("id")
    private Integer id;

    @TableField("userName")
    @ApiModelProperty("姓名")
    private String username;

    @ApiModelProperty("密码")
    @TableField("passWord")
    private String password;

    @ApiModelProperty("真实名称")
    @TableField("realName")
    private String realname;



}
