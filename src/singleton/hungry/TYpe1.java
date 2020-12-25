package singleton.hungry;

/**
 * 单例模式第一种写法 饿汉式（静态变量）
 *
 * @author wanson
 * @date 2020/12/25 上午7:59
 */
public class TYpe1 {
    public static void main(String[] args) {
        // 测试
//        new Singleton();
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance==instance2);
    }
}

// 饿汉式（静态变量）
class Singleton {
    //1.构造器私有化,外部不能new实例
    private Singleton() {

    }

    // 2.在本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    // 3.提供一个公有的静态方法，对外返回实例对象
    public static Singleton getInstance(){
        return instance;
    }
}

//优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
//缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存浪费
//这种方式基于classloder机制避免了多线程的同步问题，不过，instance在类装载时就实例化，在单例模式中大多数都是调用getInstance 方法，但是导致类装载的原因有很多种，因此不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化instance 就没有达到 lazy loading 的效果
//结论：这种单例模式可用，可能造成内存浪费
