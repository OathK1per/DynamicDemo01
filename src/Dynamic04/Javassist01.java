package Dynamic04;

import javassist.*;

/**
 * 字节码操作能够创建新的类，创建或修改方法，获取注解等，速度优于反射，作用范围较小，不能处理较复杂的
 * 可以在源码级别(如下)和字节码级别编写
 * 1.模仿sportclub创建新类
 */
public class Javassist01 {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass club = pool.makeClass("ESportClub");
        //创建属性
        CtField field1 = CtField.make("private String city;", club);
        CtField field2 = CtField.make("private int fansNum;", club);
        club.addField(field1);
        club.addField(field2);
        //创建方法
        CtMethod method1 = CtMethod.make("public void setCity(String city) {this.city = city;}", club);
        CtMethod method2 = CtMethod.make("public String getCity() {return city;}", club);
        CtMethod method3 = CtMethod.make("public void setFansNum(int fansNum) {this.fansNum = fansNum;}", club);
        CtMethod method4 = CtMethod.make("public int getFansNum() {return fansNum;}", club);
        club.addMethod(method1);
        club.addMethod(method2);
        club.addMethod(method3);
        club.addMethod(method4);
        //创建构造器
        CtConstructor constructor1 = new CtConstructor(new CtClass[]{}, club);
        CtConstructor constructor2 = new CtConstructor(new CtClass[]{pool.get("java.lang.String"), CtClass.intType}, club);
        //setBody需要大括号，获取形参需要使用$符号
        constructor2.setBody("{this.city = $1; this.fansNum = $2;}");
        club.addConstructor(constructor1);
        club.addConstructor(constructor2);

        club.writeFile("src/resources/");
    }
}
