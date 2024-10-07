package com.studentGrade.mapper;

import com.studentGrade.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    public List<Menu> getLevelMenu(Integer level);
    public List<Menu> getMenuList();
    public Menu getMenuById(Integer id);
}
