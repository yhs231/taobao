package cn.edu.ncu.yhs.controller;


import cn.edu.ncu.yhs.Utils.RespBean;
import cn.edu.ncu.yhs.pojo.Good;
import cn.edu.ncu.yhs.pojo.User;
import cn.edu.ncu.yhs.service.GoodService;
import cn.edu.ncu.yhs.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@Api(tags = "GoodController")
@RestController
public class GoodController {

    @Autowired
    private GoodService goodService;
    @Autowired
    private UserService userService;

    private Good good ;

    @ApiModelProperty(value ="返回所有商品信息" )
    @PostMapping("/good/queryAllGoods")
    public RespBean queryAllGoods(){
        List<Good> goods = goodService.queryAllGood();
        return RespBean.success("返回所有商品信息",goods);

    }


    @ApiModelProperty(value ="通过名字查询商品" )
    @PostMapping("/good/queryGoodByName")
    public RespBean queryGoodByName(String name){
        Good good = goodService.queryGoodByName(name);
        return RespBean.success("通过名字查询商品",good);
    }


    @ApiModelProperty(value ="将商品加入购物车" )
    @PostMapping("/good/addGoodToCart")
    public RespBean addGoodToCart(int goodId,Principal principal ){
        String name = principal.getName();
        User user = userService.queryUserByName(name);
        Good good = goodService.queryGoodById(goodId);
        good.setCid(user.getId());
        goodService.updateGood(good);
        return RespBean.success("将商品加入购物车");
    }


    @ApiModelProperty(value ="付款" )
    @PostMapping("/good/payment")
    public RespBean payment(Principal principal){
        String name = principal.getName();
        User user = userService.queryUserByName(name);
        good.setCid(0);
        user.setPrice(user.getPrice()-good.getPrice());
        userService.updatePrice(user);
        goodService.updateGood(good);
        return RespBean.success("付款成功");
    }

    @ApiModelProperty(value ="添加商品" )
    @PostMapping("/good/addGood")
    public RespBean addGood(Good good,Principal principal){
        String name = principal.getName();
        User user = userService.queryUserByName(name);
        if( user.isSeller()){
            good.setCid(0);
             goodService.addGood(good);
             return RespBean.success("添加商品成功");
        }else{
            return RespBean.error("添加商品失败");
        }
    }


    @ApiModelProperty(value ="通过id删除商品" )
    @PostMapping("/good/deleteGoodById")
    public RespBean deleteGoodById(int id,Principal principal){
        String name = principal.getName();
        User user = userService.queryUserByName(name);
        if( user.isSeller()){
            goodService.deleteGoodByGoodId(id);
            return RespBean.success("删除商品成功");
        }else{
            return RespBean.error("删除商品失败");
        }
    }

}

