package singleton.hungry;

/**
 * 单例模式第一种写法 饿汉式（静态代码快中创建）
 *
 * @author wanson
 * @date 2020/12/25 上午7:59
 */
public class TYpe2 {
    public static void main(String[] args) {
        // 测试
//        new Singleton();
        Singleton2 instance = Singleton2.getInstance();
        Singleton2 instance2 = Singleton2.getInstance();
        System.out.println(instance==instance2);
    }
}

// 饿汉式（静态变量）
class Singleton2 {
    //1.构造器私有化,外部不能new实例
    private Singleton2() {

    }

    // 2.在本类内部创建对象实例
    private static Singleton2 instance2 ;

    //3.在静态代码块中创建单例对象
    static {
        instance2 = new Singleton2();
    }
    // 4.提供一个公有的静态方法，对外返回实例对象
    public static Singleton2 getInstance(){
        return instance2;
    }
}

//这种方式和Type1的方式其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。优缺点和上面是一样的。
//结论：这种单例模式可用，但是可能造成内存浪费