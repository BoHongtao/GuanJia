package cn.phoenix_tree.controller;

import cn.phoenix_tree.domain.ZhangWu;
import cn.phoenix_tree.service.ZhangWuService;

import java.util.List;

/*
 *  控制器层
 *  接收试图层的数据,数据传递给service层
 *  成员位置,创建service对象
 */
public class ZhangWuController {
    private ZhangWuService service = new ZhangWuService();

    public List<ZhangWu> select(String start,String end){
        return service.select(start,end);
    }

    public List<ZhangWu> selectAll(){
        return  service.selectAll();
    }
    public void addZhangWu(ZhangWu zw){
        service.addZhangWu(zw);
    }

}
