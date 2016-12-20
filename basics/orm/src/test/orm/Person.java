package orm;

/**
 * Created by zyongliu on 20/12/16.
 */
@AREntity(tableName = "person")
public class Person extends ActiveRecord{
    @Id
    @Column
    public int id;

    @Column
    public String name;

    @Column
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
