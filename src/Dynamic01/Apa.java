package Dynamic01;

@ApaTable(value = "costa_verde")
public class Apa {
    @ApaField(columnName = "id", type = "int", size = 10)
    private int id;
    @ApaField(columnName = "building_name", type = "varchar", size = 255)
    private String name;
    @ApaField(columnName = "capacity", type = "int", size = 10)
    private int capacity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Apa() {
    }

    public Apa(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }
}
