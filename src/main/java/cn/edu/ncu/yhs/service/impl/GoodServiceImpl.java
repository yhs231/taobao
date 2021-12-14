package cn.edu.ncu.yhs.service.impl;


import cn.edu.ncu.yhs.mapper.GoodMapper;
import cn.edu.ncu.yhs.pojo.Good;
import cn.edu.ncu.yhs.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodServiceImpl implements GoodService {


    @Autowired
    private GoodMapper goodMapper;

    @Override
    public List<Good> queryAllGood() {
        return goodMapper.queryAllGood();
    }

    @Override
    public Good queryGoodByName(String goodName) {
        return goodMapper.queryGoodByName(goodName );
    }

    @Override
    public Good queryGoodById(int goodId) {
        return goodMapper.queryGoodById(goodId);
    }

    @Override
    public int addGood(Good good) {
        return goodMapper.addGood(good);
    }

    @Override
    public int deleteGoodByGoodId(int goodId) {
        return goodMapper.deleteGoodByGoodId(goodId);
    }

    @Override
    public int updateGood(Good good) {
        return goodMapper.updateGood(good);
    }
}
