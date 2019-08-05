package Dynamic01;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解的信息，模拟处理注解信息的流程
 */
public class Annotation03 {

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("Dynamic01.Apa");

            //获得类的所有有效注解，仅包括类的注解，不包括类中属性和方法的注解
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
            }
            //获得类的指定的注解
            ApaTable st = (ApaTable) clazz.getAnnotation(ApaTable.class);
            System.out.println(st.value());

            //获得类的属性的注解
            Field f = clazz.getDeclaredField("name");
            ApaField ApaField = f.getAnnotation(ApaField.class);
            System.out.println(ApaField.columnName()+"-->"+ApaField.type()+"-->"+ApaField.size());

            //根据获得的表名、字段的信息，拼出DDL语句，然后，使用JDBC执行这个SQL，在数据库中生成相关的表

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
