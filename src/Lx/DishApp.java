package Lx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 点菜系统
 */
public class DishApp {
    //定义集合
    static ArrayList<Dish> list = new ArrayList<>();
    //存用户点的菜
    static ArrayList<Dish> list2 = new ArrayList<>();

    //提前准备一些菜品
    public static void main(String[] args) {
        //初始化菜品
        initDish();
        //创建扫描对象，获取控制台输入的对象
        Scanner s = new Scanner(System.in);
        while (true){
            //展示菜单
            showMenu();
            //获取内容
            int anInt = s.nextInt();
            switch (anInt){
                case 1:
                    while (true){
                        //展示饭店菜品
                        showDishMenu();
                        //获取内容
                        int i = s.nextInt();
                        if(i == 0){
                            break;
                        }
                        System.out.println("亲，您点了"+list.get(i - 1).getName());
                        list2.add(list.get(i - 1));
                    }
                    break;
                case 2:
                    //展示已点菜品
                    showPersonDish();
                    //获取内容
                    int i = s.nextInt();
                    if(i == 0){
                        break;
                    }
                case 3:
                    //买单
                    buy();
                    return;
            }
        }
    }
    /**
     * 初始化菜品
     */
    public static void initDish(){
        Dish dish = new Dish(1, "鱼香肉丝", 23.0);
        Dish dish2 = new Dish(2, "炖王八", 66.0);
        Dish dish3 = new Dish(3, "青菜汤", 12.0);
        Dish dish4 = new Dish(4, "小炒肉", 18.0);
        Collections.addAll(list,dish,dish2,dish3,dish4);

    }

    public static void showMenu(){
        System.out.println("----主菜单----");
        System.out.println("菜单\t\t\t 1");
        System.out.println("已点菜品\t\t 2");
        System.out.println("买单\t\t\t 3");
        System.out.println("根据编号选择服务");
    }

    public static void showDishMenu(){
        System.out.println("----请您点菜----");
        for (Dish ss:list) {
            System.out.println(ss.getId()+"=="+ss.getName()+"=="+ss.getPrice());
        }
        System.out.println("----输入序号点菜，按0返回上一级----");
    }
    public static void showPersonDish(){
        System.out.println("----已点菜品----");
        for (Dish d:list2) {
            System.out.println("已点菜品"+d.getName());
        }
        System.out.println("----输入序号点菜，按0返回上一级----");
    }
    public static void buy() {
        System.out.println("----结算中----");
        double ss = 0;
        for (Dish d:list2) {
            ss =  ss+d.getPrice();
        }
        System.out.println("需要支付的金额为"+ss);
    }
}
