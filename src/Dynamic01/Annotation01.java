package Dynamic01;

/**
 * 内置注解
 * 常用：@Override， @Deprecated
 */
public class Annotation01 {

    @Override
    public String toString() {
        return "自定义： " + this.hashCode();
    }

    @Deprecated
    public void print() {
        System.out.println("Annotation01");
    }

    public static void main(String[] args) {
        Annotation01 annotation01 = new Annotation01();
        annotation01.print();

        System.out.println(annotation01.toString());
    }
}
