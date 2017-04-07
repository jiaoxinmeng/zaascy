package com.netcenter.zaascy.service.impl;

import com.netcenter.zaascy.bean.Trade;
import com.netcenter.zaascy.bean.TradeChild;
import com.netcenter.zaascy.dao.TradeChildMapper;
import com.netcenter.zaascy.dao.TradeMapper;
import com.netcenter.zaascy.service.TradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Service(value="tradeService")
public class TradeServiceImpl implements TradeService,Serializable {

    @Resource(name="tradeDao")
    private TradeMapper dao;

    @Resource(name="tradeChildDao")
    private TradeChildMapper childDao;

    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int insert(Trade record) {
        return dao.insert(record);
    }

    public int insertSelective(Trade record) {
        return dao.insertSelective(record);
    }

    public Trade selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Trade record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Trade record) {
        return dao.updateByPrimaryKey(record);
    }

    public List<Trade> selectAll() {
        return dao.selectAll();
    }

    public List<TradeChild> selectAllTradeChildByQuarter(String quarter) {
        return childDao.selectAll();
    }

    public int insertTradeChildsByQuarty() {
        return 0;
    }
}
