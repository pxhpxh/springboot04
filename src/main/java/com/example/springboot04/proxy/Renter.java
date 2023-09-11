package com.example.springboot04.proxy;

/**
 * @ClassName Renter
 * @Description TODO
 * @Author pxh
 * @Date 2023/5/19 15:24
 * @Version 1.0
 */

public class Renter implements Person{

    @Override
    public void rentHouse() {
        System.out.println("租客租房成功！");
    }


}

