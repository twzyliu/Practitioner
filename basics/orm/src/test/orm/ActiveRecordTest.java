package orm;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 20/12/16.
 */
public class ActiveRecordTest {

    public static final String NAME = "andy";
    public static final int AGE = 18;
    public static final String OTHER_NAME = "bob";
    public static final int OTHER_AGE = 16;
    private Person person;
    private Person other;

    @Before
    public void setUp() throws Exception {
        person = new Person(NAME, AGE);
        other = new Person(OTHER_NAME, OTHER_AGE);
        person.delete();
    }

    @Test
    public void should_return_ture_when_insert() throws Exception {
        assertThat(person.insert(), is(true));
    }

    @Test
    public void should_return_ture_when_deleteAll() throws Exception {
        assertThat(person.delete(), is(true));
    }

    @Test
    public void should_return_all_when_getAll() throws Exception {
        person.insert();
        person.insert();
        List<Person> personList = person.getAll();
        assertThat(personList.size(), is(2));
        assertThat(personList.get(0).getName(), is(NAME));
        assertThat(personList.get(0).getAge(), is(AGE));
    }

    @Test
    public void should_return_person_when_getById() throws Exception {
        person.insert();
        Person personById = person.getById(person.getId());
        assertThat(personById.getId(), is(person.getId()));
        assertThat(personById.getAge(), is(AGE));
        assertThat(personById.getName(), is(NAME));
    }

    @Test
    public void should_return_new_person_when_update() throws Exception {
        person.insert();
        other.insert();
        other.update(person.getId());
        Person newPerson = person.getById(person.getId());
        assertThat(newPerson.getName(), is(OTHER_NAME));
        assertThat(newPerson.getAge(), is(OTHER_AGE));
    }

    @Test
    public void should_return_null_when_delById() throws Exception {
        person.insert();
        person.delById(person.getId());
        List<Person> allPerson = person.getAll();
        assertThat(allPerson.size(), is(person.getId()));
    }
}
