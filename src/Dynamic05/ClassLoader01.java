package Dynamic05;

/**
 * 系统类加载器原理：代理模式中的双亲委托机制
 * BootStrap ClassLoader --> Extension ClassLoader --> Application ClassLoader --> Customize ClassLoader
 * ClassLoader的获得和相关API
 */
public class ClassLoader01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获得ClassLoader
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass("Dynamic02.Example");
        System.out.println(clazz.getName());
        ClassLoader loader = clazz.getClassLoader();
        System.out.println(loader);
    }
}
