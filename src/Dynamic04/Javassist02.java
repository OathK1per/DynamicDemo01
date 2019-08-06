package Dynamic04;

import javassist.ClassPool;
import javassist.CtClass;

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
        System.out.println(Arrays.toString(bytes));
    }

    public static void main(String[] args) throws Exception {
        Javassist02 j = new Javassist02();
        j.classInfo();
    }
}
