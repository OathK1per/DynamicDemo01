package Dynamic04;

import javassist.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Javassist的API
 */
public class Javassist02 {
    /**
     * 获取类的信息
     */
    private void classInfo() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass club = classPool.get("Dynamic04.SportClub");
        byte[] bytes = club.toBytecode();
//        System.out.println(Arrays.toString(bytes));
        System.out.println(club.getName());
        System.out.println(club.getSimpleName());
        System.out.println(club.getSuperclass());
        System.out.println(club.getInterfaces());
    }

    /**
     * 添加新的方法
     * 可以使用CtMethod.make
     */
    private void addMethod() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass club = classPool.get("Dynamic04.SportClub");
        //返回值，方法名和形参
        CtMethod method = new CtMethod(CtClass.intType, "addSeats", new CtClass[]{CtClass.intType}, club);
        method.setModifiers(Modifier.PUBLIC);
        method.setBody("{standiumSeat += $1;return standiumSeat;}");
        club.addMethod(method);
        //使用反射调用该方法，不能使用forName()，因为这是新添的方法，不在原类体中
        Class<?> clazz = club.toClass();
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Method addSeats = clazz.getDeclaredMethod("addSeats", int.class);
        Object seats = addSeats.invoke(instance, 10);
        System.out.println(seats);
    }

    /**
     * 修改原方法
     */
    private void modifyMethod() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass club = classPool.get("Dynamic04.SportClub");

        CtMethod method = club.getDeclaredMethod("getCity");
        method.insertBefore("System.out.println(\"city: \" + city);");
        //insertAt(index, string), insertAfter(str)

        Class<?> clazz = club.toClass();
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Method addSeats = clazz.getDeclaredMethod("getCity");
        Object city = addSeats.invoke(instance);
        System.out.println(city);
    }

    private void modifyField() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass club = classPool.get("Dynamic04.SportClub");

        CtField field = new CtField(CtClass.intType, "fansNum", club);
        field.setModifiers(Modifier.PRIVATE);
        club.addField(field);
        club.addMethod(CtNewMethod.getter("getFansNum", field));
        club.addMethod(CtNewMethod.setter("setFansNum", field));

        Class<?> clazz = club.toClass();
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Method method = clazz.getDeclaredMethod("setFansNum", int.class);
        method.invoke(instance, 120);
        Method method1 = clazz.getDeclaredMethod("getFansNum");
        Object ans = method1.invoke(instance);
        System.out.println(ans);
    }

    /**
     * 得到构造器
     * @throws Exception
     */
    private void getConstructor() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass club = classPool.get("Dynamic04.SportClub");

        CtConstructor[] cs = club.getConstructors();
        for (CtConstructor c : cs) {
            System.out.println(c.getLongName());
        }
    }


    public static void main(String[] args) throws Exception {
        Javassist02 j = new Javassist02();
        j.getConstructor();
    }
}
