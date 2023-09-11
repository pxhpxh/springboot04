package com.example.springboot04;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Vector;

@SpringBootTest
class Springboot04ApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void test1() {
        System.out.println(123);
    }


    @Test
    void test2() {
        Vector v = new Vector(10);

        for (int i = 0; i < 100; i++) {
            Object o = new Object();
            v.add(o);
            o = null;
        }

        for(int i = 0 ; i < v.size() ; i++){
            System.out.println(v.get(i));
        }

    }

}
