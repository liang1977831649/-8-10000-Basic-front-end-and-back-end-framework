package com.studentGrade;

import com.studentGrade.entity.Menu;
import com.studentGrade.entity.Student;
import com.studentGrade.mapper.MenuMapper;
import com.studentGrade.mapper.StudentMapper;
import com.studentGrade.utils.Md5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
public class MapperTest {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void queryStudentById() {
        Student student = new Student();
        student.setId(123456);
        Student student1 = studentMapper.queryStudentById(student);
        System.out.println(student1);
    }

    @Test
    public void updatePassword() {
        Student student = new Student();
        student.setId(123456);
        String pwd = Md5Util.getMD5String("123456");
        student.setPassword(pwd);
        studentMapper.updateStudentPassword(student);
    }

    @Test
    public void queryMenuByType() {
        List<Menu> menuList = menuMapper.getMenuList();
        recursionMenu(menuList,0);
        cleanHasFatherMenu(menuList);
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
