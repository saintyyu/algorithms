package enumeration;

/**
 * Created by cdyujing7 on 2018/3/18.
 */
public class EnumSingleton {

    private EnumSingleton() {

    }

    //对外提供的单例获取方法
    public static EnumSingleton getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private EnumSingleton singleton;
        //JVM会保证此方法绝对只调用一次
        Singleton(){
            singleton = new EnumSingleton();
        }
        public EnumSingleton getInstance(){
            return singleton;
        }
    }
}