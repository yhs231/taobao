package cn.edu.ncu.yhs.test;

import cn.edu.ncu.yhs.mapper.UserMapper;
import cn.edu.ncu.yhs.pojo.User;
import cn.edu.ncu.yhs.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class test1 {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        List<User> users = userMapper.queryAllUser();
        for (User user : users) {
            System.out.println(user);
        }

    }

}
