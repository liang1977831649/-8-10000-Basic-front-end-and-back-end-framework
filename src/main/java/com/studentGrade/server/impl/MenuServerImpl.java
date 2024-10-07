package com.studentGrade.server.impl;

import com.studentGrade.entity.Menu;
import com.studentGrade.mapper.MenuMapper;
import com.studentGrade.server.MenuServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class MenuServerImpl implements MenuServer {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> getLevelMenuByFather(Integer id) {
        return  menuMapper.getLevelMenu(id);
    }

    @Override
    public List<Menu> getMenuList() {
        List<Menu> menuList = menuMapper.getMenuList();
        recursionMenu(menuList,0);
        cleanHasFatherMenu(menuList);
        return menuList;
    }

    public void recursionMenu(List<Menu> menuList, int index) {
        if (index+1 > menuList.size()) {
            return;
        }
        Menu menu = menuList.get(index);
        if (menu.getFather() != 0) {
            Menu menuFather = menuList.get(getFatherIndex(menu.getFather(),menuList));
            List<Menu> menuListSub = menuFather.getMenuList();
            if(menuListSub==null){
                menuListSub=new ArrayList<>();
            }
            menuListSub.add(menu);
            menuFather.setMenuList(menuListSub);
        }
        recursionMenu(menuList,++index);
    }
    public void cleanHasFatherMenu(List<Menu> menuList){
        Iterator<Menu> iterator = menuList.iterator();
        while (iterator.hasNext()){
            Menu next = iterator.next();
            if(next.getFather()!=0){
                iterator.remove();
            }
        }
    }
    public int getFatherIndex(int fatherId,List<Menu> list){
        for(int i=0;i<=list.size();i++){
            Menu menu = list.get(i);
            if(menu.getId()==fatherId){
                return i;
            }
        }
        return -1;
    }
}
