package cn.phoenix_tree.service;

import cn.phoenix_tree.dao.ZhangWuDao;
import cn.phoenix_tree.domain.ZhangWu;

import java.util.List;

/*
 *  业务层类
 *  接收上一层,控制层controller的数据
 *  经过计算,传递给dao层,操作数据库
 *  调用dao层中的类,类成员位置,创建Dao类的对象
 */
public class ZhangWuService {
    private ZhangWuDao dao = new ZhangWuDao();
    public List<ZhangWu> select(String start,String end){
        return dao.select(start,end);
    }
    public List<ZhangWu> selectAll(){
        return dao.selectAll();
    }
    public void addZhangWu(ZhangWu zw){
        dao.addZhangWu(zw);
    }
    public boolean deleteZhangWu(int id){
       return dao.deleteZhangWu(id);
    }
}
