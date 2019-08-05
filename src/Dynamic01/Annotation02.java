package Dynamic01;

/**
 * 自定义注解都是继承基础注解
 * 基础注解：@Document, @Target, @Retention
 * @Target 常用ElementType.TYPE 类级别, FIELD, METHOD
 * @Retention RetentionPolicy.RUNTIME > CLASS > SOURCE
 */
@Apartment
public class Annotation02 {

    private int price;

    @Apartment
    public int apartmentPrice() {
        return 500;
    }

    @House(name = "MIRA MESA")
    public int housePrice() {
        return 700;
    }

    @House
    public int housePrice2() {
        return 800;
    }

    public static void main(String[] args) {
        Annotation02 annotation02 = new Annotation02();
        int price = annotation02.apartmentPrice();
        System.out.println(price);
    }
}
