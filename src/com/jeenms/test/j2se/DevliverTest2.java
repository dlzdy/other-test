package com.jeenms.test.j2se;
class Emp {
    public int age;
}
public class DevliverTest2 {
    public static void change1(Emp emp)
    {
        emp.age = 100;
    }
    public static void change2(Emp emp)
    {
        emp = new Emp();//再创建一个对象
        emp.age=200;
    }
    
    public static void main(String[] args) {
        Emp emp = new Emp();
        emp.age = 0;
        System.out.println(emp.age);
        //============成功改变
        change1(emp);//100
        System.out.println(emp.age);
        
        //==================
        Emp emp2 = new Emp();
        emp2.age = 0;
        change2(emp2);//emp 没变化
        System.out.println(emp2.age);
    }
}