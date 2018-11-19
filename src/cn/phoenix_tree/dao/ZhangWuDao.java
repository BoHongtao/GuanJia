package cn.phoenix_tree.dao;
/*
 *  实现对数据表 gjp_zhangwu 数据增删改查操作
 *  dbuils工具类完成,类成员创建QueryRunner对象,指定数据源
 */
import cn.phoenix_tree.domain.ZhangWu;
import cn.phoenix_tree.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ZhangWuDao {
    private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    //按时间查询
    public List<ZhangWu> select(String start,String end){
        String sql = "select * from gjp_zhangwu where createttime between ? and ?";
        Object[] params = {start,end};
        try {
            return qr.query(sql,new BeanListHandler<>(ZhangWu.class),params);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    //查询所有
    public List<ZhangWu> selectAll(){
        String sql = "select * from gjp_zhangwu";
        try {
            return qr.query(sql,new BeanListHandler<ZhangWu>(ZhangWu.class));
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    //添加
    public void addZhangWu(ZhangWu zw){
        String sql = "insert into gjp_zhangwu(flname,money,zhangHu,createtime,description) value(?,?,?,?,?)";
        Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhangHu(),zw.getCreatetime(),zw.getDescription()};
        try {
            qr.update(sql,params);
        }catch (SQLException e){
            System.out.println(e);
            throw new RuntimeException("添加失败");
        }
    }
}
