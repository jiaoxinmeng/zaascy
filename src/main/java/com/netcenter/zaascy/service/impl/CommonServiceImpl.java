package com.netcenter.zaascy.service.impl;

import com.netcenter.zaascy.bean.Depart;
import com.netcenter.zaascy.bean.TradeResource;
import com.netcenter.zaascy.dao.DepartMapper;
import com.netcenter.zaascy.dao.TradeResourceMapper;
import com.netcenter.zaascy.service.CommonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/3/20.
 */
@Service(value = "commonService")
public class CommonServiceImpl implements CommonService{

    @Resource(name="departDao")
    private DepartMapper departDao;

    @Resource(name = "tradeResourceDao")
    private TradeResourceMapper resourceDao;

    public List<Depart> getDepartList() {
        return departDao.getAll();
    }

    public List<Depart> getInstituteList(){return departDao.getAllInstitute();}

    public List<TradeResource> getResourceByType(String type){
        return resourceDao.selectByType(type);
    }
}
