package singleton.lazy;

/**
 * 使用静态内部类的方式实现懒加载
 *
 * @author wanson
 * @date 2020/12/30 上午7:59
 */
public class StaticInnerClass {
    public static void main(String[] args) {
        Singleton2 instance = Singleton2.getInstance();
        Singleton2 instance2 = Singleton2.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}


class Singleton2 {
    private Singleton2() {
    }


    private static class SingletonInstance {
        private static final Singleton2 INSTANCE = new Singleton2();
    }


    public static synchronized Singleton2 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
