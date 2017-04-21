package com.netcenter.zaascy.service;

import com.netcenter.zaascy.bean.Depart;
import com.netcenter.zaascy.bean.TradeResource;

import java.util.List;

/**
 * Created by Administrator on 2017/3/20.
 */
public interface CommonService {
    List<Depart> getDepartList();

    List<Depart> getInstituteList();

    List<TradeResource> getResourceByType(String type);
}
