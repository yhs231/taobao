package cn.edu.ncu.yhs;


import cn.edu.ncu.yhs.pojo.Good;
import cn.edu.ncu.yhs.pojo.User;
import cn.edu.ncu.yhs.service.GoodService;
import cn.edu.ncu.yhs.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class TaobaoApplicationTests {

    @Autowired
    private UserService userService;


    @Autowired
    private GoodService goodService;



   @Test
    public void test(){
       List<User> users = userService.queryAllUser();
       for (User user : users) {
           System.out.println(user);
       }


   }


   @Test
    public void test02(){
       List<Good> goods = goodService.queryAllGood();
       for (Good good : goods) {
           System.out.println(good );
       }
   }



}
