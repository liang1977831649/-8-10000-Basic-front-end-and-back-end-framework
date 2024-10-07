package com.studentGrade.server;

import com.studentGrade.entity.Menu;

import java.util.List;

public interface MenuServer {
    public List<Menu> getLevelMenuByFather(Integer id);
    public List<Menu> getMenuList();
}
