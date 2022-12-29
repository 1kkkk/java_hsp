public class Extends_detail {
    public static void main(String[] args) {

        //继承的本质分析（创建子类对象时的内存布局）
        Son son = new Son(); /* 先在方法区依次加载Object类、Grandpa类、Father类、Son类信息；
                                在堆中分配地址空间给son对象：分别有空间存放爷爷的属性、爸爸的属性、儿子的属性；
                                主栈理son对象引用地址空间。
                                */
        
        //按照查找关系来返回信息
        /* 首先看子类是否有该属性：如果有，并且可以访问 -> 返回信息
                               如果没有，就看父类 -> 如果父类有，并且可以访问 -> 返回信息
                                                  如果父类没有，继续找上级父类，直到Object 
        */
        System.out.println(son.name); //返回子类name
        //System.out.println(son.age); //子类没有age，父类有私有age，会报错（尽管爷类有共有age）
        System.out.println(son.hobby); //子类没有hobby，父类没有hobby，爷类有共有，返回爷爷age
    }
}

class Grandpa {
    String name = "爷爷";
    String hobby = "旅游";
    //int age = 70;
}
class Father extends Grandpa {
    String name = "爸爸";
    private int age = 39;
}
class Son extends Father {
    String name = "儿子";
}
