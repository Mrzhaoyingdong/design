package com.zhaoyd6.patternface.door.store.impl;

import com.alibaba.fastjson.JSON;
import com.zhaoyd6.patternface.door.goods.DeliverReq;
import com.zhaoyd6.patternface.door.goods.GoodsService;
import com.zhaoyd6.patternface.door.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class GoodsCommodityService implements ICommodity {

    private Logger logger = LoggerFactory.getLogger(GoodsCommodityService.class);
    private GoodsService goodsService = new GoodsService();

    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        DeliverReq deliverReq = new DeliverReq();

        deliverReq.setUserName(queryUserName(uId));
        deliverReq.setUserPhone(queryUserPhoneNumber(uId));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));
        Boolean isSuccess = goodsService.deliverGoods(deliverReq);
        logger.info("请求参数[优惠券] => uId:{} commodityId:{} bizId:{} extMap:{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[优惠券]:{}", isSuccess);
        if (!isSuccess) throw new RuntimeException("ਫᇔࠟݎߝන०ᨳ");
    }
    private String queryUserName(String uId) {
        return "ᜰᜰ";
    }
    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }


}
