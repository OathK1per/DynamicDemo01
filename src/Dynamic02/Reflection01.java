package Dynamic02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 对象是表示或封装一些数据。一个类被加载后，JVM会创建一个对应该类的Class对象，类的整个结构信息会放到对应的Class对象中
 * 这个Class对象就像一面镜子一样，通过这面镜子我可以看到对应类的全部信息
 * 三种获得Class类的方式
 * 反射：Class.forName()
 * 类名：String.class
 * 对象名：str.getClass()
 *
 * 一个类只有一个对应的对象
 */
public class Reflection01 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        String path = "Dynamic02.Example";

        Class<?> clazz = Class.forName(path);
        // 类名
        System.out.println("Name: ");
        System.out.println(clazz);
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        // 获取类的属性
        System.out.println("Fields: ");
        //Field[] fields = clazz.getFields(); // 只能获取public的属性
        Field[] fields = clazz.getDeclaredFields(); // 获取全部属性
        Field field = clazz.getDeclaredField("name"); //获取指定属性
        System.out.println(field);
        // 获取类的方法
        System.out.println("Methods: ");
        //Method[] methods = clazz.getMethods(); // 只能获取public的方法
        Method[] methods = clazz.getDeclaredMethods(); //获取所有方法
        Method method = clazz.getDeclaredMethod("print", String.class); //获取指定方法，带参数类型
        System.out.println(method);
        // 获取构造器
        Constructor[] constructors = clazz.getDeclaredConstructors(); // 规律同上
        System.out.println("Constructors: ");
        for(Constructor constructor : constructors){
            System.out.println(constructor);
        }
        Constructor constructor = clazz.getDeclaredConstructor(int.class, String.class);
    }
}
