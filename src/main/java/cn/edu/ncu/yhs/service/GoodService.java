package cn.edu.ncu.yhs.service;

import cn.edu.ncu.yhs.pojo.Good;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodService {


    List<Good> queryAllGood();

    Good queryGoodByName(String goodName);

    Good queryGoodById(int goodId);

    int addGood(Good good);

    int deleteGoodByGoodId( int goodId);

    int updateGood(Good good);
}
