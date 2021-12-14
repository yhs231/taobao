package cn.edu.ncu.yhs.controller;


import cn.edu.ncu.yhs.Utils.RespBean;
import cn.edu.ncu.yhs.pojo.Good;
import cn.edu.ncu.yhs.pojo.User;
import cn.edu.ncu.yhs.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Api(tags = "LoginController")
@RestController
public class LoginController {

    @Autowired
    private UserService userService;



    @ApiModelProperty(value ="登陆之后返回token" )
    @PostMapping("/login")
    public RespBean login( User user, HttpServletRequest request){
        return userService.login(user.getName(),user.getPassword(),request);
    }


    @ApiModelProperty(value ="退出登录" )
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success("退出登录");
    }



    @ApiModelProperty(value ="注册用户" )
    @PostMapping("/register")
    public RespBean register(User user){
        int i = userService.addUser(user);
        return i>0?RespBean.success("注册成功"):RespBean.error("注册失败");
    }


    //Security 中提供了全局变量获取方法Principal
    @ApiModelProperty(value ="提取当前用户登录信息" )
    @GetMapping("/user/info")
    public RespBean  getUser(Principal principal){
        String name = principal.getName();
        User user = userService.queryUserByName(name);
        user.setPassword(null);
        return RespBean.success("用户信息",user);
    }


    @ApiModelProperty(value ="查询购物车的物品" )
    @GetMapping("/user/queryGoods")
    public RespBean queryGoods(Principal principal){
        String name = principal.getName();
        User user = userService.queryUserByName(name);
        int id = user.getId();
        List<User> users = userService.queryGoods(id);
        return RespBean.success("查询购物车的商品",users);
    }



    @ApiModelProperty(value ="是否成为商家" )
    @GetMapping("/user/BecomeShopper")
    public RespBean BecomeShopper(Principal principal){
        String name = principal.getName();
        User user = userService.queryUserByName(name);
        user.setSeller(true);
        userService.BecomeShopper(user);
        return RespBean.success("成为商家操作成功");
    }


    @ApiModelProperty(value ="确认收货" )
    @GetMapping("/user/takeDelivery")
    public RespBean takeDelivery(int[] a){
        return RespBean.success("确认收货");
    }








}
