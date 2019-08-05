package Dynamic02;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 通过反射API获取容器中的泛型
 */
public class Reflection03 {

    public void test01(Map<String, Example> map, List<Example> list){
        System.out.println("Demo04.test01()");
    }

    public Map<Integer, Example> test02(){
        System.out.println("Demo04.test02()");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        //获得指定方法参数泛型信息
        Method m = Reflection03.class.getMethod("test01", Map.class,List.class);
        Type[] t = m.getGenericParameterTypes();
        for (Type paramType : t) {
            System.out.println("#" + paramType);
            if(paramType instanceof ParameterizedType){
                Type[] genericTypes = ((ParameterizedType)paramType).getActualTypeArguments();
                for (Type genericType : genericTypes) {
                    System.out.println("泛型类型：" + genericType);
                }
            }
        }

        //获得指定方法返回值泛型信息
        Method m2 = Reflection03.class.getMethod("test02");
        Type returnType = m2.getGenericReturnType();
        if(returnType instanceof ParameterizedType){
            Type[] genericTypes = ((ParameterizedType)returnType).getActualTypeArguments();

            for (Type genericType : genericTypes) {
                System.out.println("返回值，泛型类型：" + genericType);
            }

        }
    }
}
