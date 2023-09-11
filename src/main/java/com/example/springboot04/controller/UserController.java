package com.example.springboot04.controller;


import com.alibaba.fastjson.JSON;
import com.example.springboot04.bean.User;
import com.example.springboot04.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author pxh
 * @since 2022-12-23
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户接口", tags = {"用户接口"})
public class UserController {

    @Autowired
    private UserService userService ;

    @GetMapping("/getUser/{id}")
    @ApiOperation("根据条件查询用户")
    public User index(@PathVariable("id")  @ApiParam(value = "请求参数说明id")  Integer  id) {
        User user = userService.getById(id);
        return user;
    }

}
