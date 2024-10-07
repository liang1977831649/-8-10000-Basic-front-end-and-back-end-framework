package com.studentGrade;

import com.studentGrade.entity.Menu;
import com.studentGrade.server.MenuServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServerTest {
    @Autowired
    private MenuServer menuServer;
    @Test
    public void GetMenuListTest(){
        List<Menu> menuList = menuServer.getMenuList();
        for (Menu menu : menuList) {
            System.out.println(menu);
        }
    }
}
