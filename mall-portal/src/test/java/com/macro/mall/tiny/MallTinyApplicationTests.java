package com.macro.mall.tiny;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.macro.mall.tiny.service.UmsAdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallTinyApplicationTests {
	@Autowired
    private UmsAdminService adminService;
    @Test
    public void contextLoads() {
    	System.out.println(adminService.getAdminByUsername("lxb"));
    }

}
