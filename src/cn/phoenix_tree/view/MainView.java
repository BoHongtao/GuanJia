package cn.phoenix_tree.view;

import cn.phoenix_tree.controller.ZhangWuController;
import cn.phoenix_tree.domain.ZhangWu;
import cn.phoenix_tree.service.ZhangWuService;

import java.util.List;
import java.util.Scanner;

public class MainView {
    private ZhangWuController controller = new ZhangWuController();
    private static MainView view = new MainView();
    public void run() {
        boolean flag = true;
        Scanner in = new Scanner(System.in);
        while (flag) {
            System.out.println("---------------管家婆家庭记账软件---------------");
            System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
            System.out.println("请输入要操作的功能序号[1-5]:");
            int op = in.nextInt();
            switch (op) {
                case 1:
                    view.addZhangWu();
                    break;
                case 2:
                    view.editZhangWu();
                    break;
                case 3:
                    view.deleteZhangWu();
                    break;
                case 4:
                    view.selectZhangWu();
                    break;
                case 5:
                    System.out.println("再见！");
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误！");
            }
        }
    }

    private void addZhangWu(){
        Scanner in = new Scanner(System.in);
        ZhangWu zw = new ZhangWu();
        System.out.print("请输入类别：");
        zw.setFlname(in.next());
        System.out.print("请输入账户：");
        zw.setZhangHu(in.next());
        System.out.print("请输入金额：");
        zw.setMoney(in.nextDouble());
        System.out.print("请输入时间：");
        zw.setCreatetime(in.next());
        System.out.print("请输入说明：");
        zw.setDescription(in.next());
        controller.addZhangWu(zw);

    }
    /*
     * 删除账务
     */
    private void deleteZhangWu(){
        view.selectAll();
        System.out.println("请输入要删除的id");
        Scanner sc = new Scanner(System.in);
        int zw_id = sc.nextInt();
        if(controller.deleteZhangWu(zw_id)){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }
    private void editZhangWu(){

    }
    private void selectZhangWu() {
        System.out.println("1.查询所有　2.按条件查询");
        Scanner in = new Scanner(System.in);
        int op = in.nextInt();
        switch (op) {
            case 1:
                view.selectAll();
                break;
            case 2:
                view.select();
                break;
            default:
                System.out.println("输入错误！");
        }
    }

    /*
     * 查询所有的账务
     */
    private void selectAll(){
        List<ZhangWu> zhangWuAllList = controller.selectAll();
        if(zhangWuAllList.size()==0){
            System.out.println("没有数据");
        }else{
            print(zhangWuAllList);
        }
    }

    /*
     * 按条件查询
     */
    private void select(){
        Scanner in = new Scanner(System.in);
        System.out.print("请输入查询起始时间：");
        String start = in.next();
        System.out.print("请输入查询结束时间：");
        String end = in.next();
        List<ZhangWu> zhangWuList = controller.select(start, end);
        print(zhangWuList);
    }

    /*
     * 输出账务
     */
    private void print(List<ZhangWu> zhangWuList){
        System.out.println("ID\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
        for (ZhangWu zw : zhangWuList) {
            System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t\t"
                    + zw.getZhangHu() + "\t\t" + zw.getMoney() + "\t\t"
                    + zw.getCreatetime() + "\t" + zw.getDescription());
        }
    }
}
