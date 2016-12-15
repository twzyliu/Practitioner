/**
 * Created by zyongliu on 15/12/16.
 */
public class SayHello implements Say {
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String hello() {
        return person.getName();
    }

    public static void main(String args[]) {
        Person andy = new Person("Andy");
        SayHello sayHello = new SayHello();
        sayHello.setPerson(andy);
        System.out.print(sayHello.hello());
    }
}
