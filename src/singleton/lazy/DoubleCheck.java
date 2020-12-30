package singleton.lazy;


/**
 * 懒加载，双重检查，线程安全
 *
 * @author wanson
 * @date 2020/12/29 下午9:49
 */
public class DoubleCheck {
    public static void main(String[] args) {
        // 测试
//        new Singleton();
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
    }
}


class Singleton {

    private static volatile Singleton instance;

    private Singleton() {
    }


    public static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}