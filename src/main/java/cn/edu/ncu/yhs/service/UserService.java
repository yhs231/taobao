package cn.edu.ncu.yhs.service;


import cn.edu.ncu.yhs.Utils.RespBean;
import cn.edu.ncu.yhs.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Transactional
public interface UserService {


    public List<User> queryAllUser();
    public User queryUserByNameAndPassword(String name, String password);
    public int addUser(User user);
    public User queryUserByName(String name);
    public RespBean login(String name, String password, HttpServletRequest request);


    List<User> queryGoods(int id);

    int BecomeShopper(User user);

    int updatePrice(User user);

}
