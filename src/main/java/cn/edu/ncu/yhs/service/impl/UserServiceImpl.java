package cn.edu.ncu.yhs.service.impl;

import cn.edu.ncu.yhs.Utils.RespBean;
import cn.edu.ncu.yhs.config.security.JwtTokenUtil;
import cn.edu.ncu.yhs.mapper.UserMapper;
import cn.edu.ncu.yhs.pojo.User;
import cn.edu.ncu.yhs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder; // 安全框架-密码加密解密

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }



    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return userMapper.queryUserByNameAndPassword(name,password);
    }


    @Override
    public int addUser(User user) {
        user.setPrice(500);
        user.setCartName("购物车");
        user.setSeller(true);
        return userMapper.addUser(user);
    }

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    @Override
    public RespBean login(String name, String password, HttpServletRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(name);

        System.out.println( userDetails.getUsername());

        if(userDetails==null|| !passwordEncoder.matches(userDetails.getPassword(),passwordEncoder.encode(password)))
            return RespBean.error("用户名和密码不正确！");
        if(userDetails.isEnabled() )
            return RespBean.error("账号被禁！请联系管理员");
        // 更新 security 登录用户对象，设置到全局
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails
                , null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //生成token
        String token  = jwtTokenUtil.generateToken(userDetails);

        System.out.println(userDetails);



        HashMap<String,String> tokenMap=new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return RespBean.success("用户登录成功",tokenMap);
    }

    @Override
    public List<User> queryGoods(int id) {
        return userMapper.queryGoods(id);
    }

    @Override
    public int BecomeShopper(User user) {


        return userMapper.BecomeShopper(user );
    }

    @Override
    public int updatePrice(User user) {
        return userMapper.updatePrice(user);
    }


}
