package cn.edu.ncu.yhs.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Good {
    private int goodId;
    private String goodName;
    private int price;
    private String image;
    private String details;
    private String storeName;
    private int sales;
    private int cid;


    public Good( String goodName, int price, String image, String details, String storeName, int sales, int cid) {
        this.goodName = goodName;
        this.price = price;
        this.image = image;
        this.details = details;
        this.storeName = storeName;
        this.sales = sales;
        this.cid = cid;
    }
}
