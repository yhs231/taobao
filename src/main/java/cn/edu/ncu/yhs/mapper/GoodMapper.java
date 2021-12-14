package cn.edu.ncu.yhs.mapper;


import cn.edu.ncu.yhs.pojo.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodMapper {

   List<Good> queryAllGood();

   Good queryGoodByName(@Param("goodName") String goodName);

   Good queryGoodById(@Param("goodId") int goodId);

   int addGood(Good good);

   int deleteGoodByGoodId(@Param("goodId") int goodId);

   int updateGood(Good good);



}
