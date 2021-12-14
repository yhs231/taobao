package cn.edu.ncu.yhs.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value ="用户" ,description = " ")
public class User implements UserDetails, Serializable  {
    @ApiModelProperty(value = "id")
    private int id;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "价格")
    private int price;
    @ApiModelProperty(value = "购物车名字")
    private String cartName;
    @ApiModelProperty(value = "是否成为商家")
    private boolean seller;
    @ApiModelProperty(value = "获取与货物联系")
    private List<Good> goods;


    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, int price, String cartName, boolean seller) {
        this.name = name;
        this.password = password;
        this.price = price;
        this.cartName = cartName;
        this.seller = seller;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }



}
