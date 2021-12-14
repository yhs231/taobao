package cn.edu.ncu.yhs.mapper;

import cn.edu.ncu.yhs.Utils.RespBean;
import cn.edu.ncu.yhs.pojo.Good;
import cn.edu.ncu.yhs.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Mapper
@Repository
public interface  UserMapper {
    List<User> queryAllUser();

    User queryUserByNameAndPassword(@Param("name")String name,@Param("password")String password);

    int addUser(User user);

    User queryUserByName(@Param("name")String name);


    List<User> queryGoods(@Param("uid")int id);

    int BecomeShopper(User user);

    int updatePrice(User user);






}
