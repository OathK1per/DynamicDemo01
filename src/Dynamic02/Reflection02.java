package Dynamic02;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射API动态的操作：构造器、方法、属性
 * 跳过安全检查能极快的提高运行速度
 */
public class Reflection02 {
    public static void main(String[] args) throws Exception {
        String path = "Dynamic02.Example";

        Class<?> clazz = Class.forName(path);
        //通过反射调用无参构造函数 newInstance
        Example e1 = (Example)clazz.getDeclaredConstructor().newInstance();
        //通过反射调用有参构造函数
        Example e2 = (Example) clazz.getDeclaredConstructor(int.class, String.class).newInstance(1, "aaa");
        System.out.println(e2.getId() + "-->" + e2.getName());
        //通过反射调用方法 invoke
        Method method = clazz.getDeclaredMethod("setName", String.class);
        method.invoke(e1, "法国蛇棒");
        System.out.println(e1.getName());
        //通过反射操作属性 set/get
        Field field = clazz.getDeclaredField("info");
        //跳过安全检查！提升速度
        field.setAccessible(true);
        field.set(e1, "this is an example instance");
        System.out.println(field.get(e1));
    }
}
