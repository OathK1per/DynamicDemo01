package Dynamic02;

import Dynamic01.ApaField;
import Dynamic01.ApaTable;

@ApaTable("example")
public class Example {
    @ApaField(columnName = "id", type = "int", size = 10)
    private int id;
    @ApaField(columnName = "name", type = "varchar", size = 255)
    private String name;

    public String info = "this is a example";

    public Example() {
    }

    private Example(int id) {
        this.id = id;
    }

    public Example(int id, String name) {
        this(id);
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        print(info);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void print(String str) {
        System.out.println(str);
    }
}
