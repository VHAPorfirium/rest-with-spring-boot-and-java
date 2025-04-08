package br.com.vhaporfiro;

import br.com.vhaporfiro.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        logger.info("Finding all Person!");

        List<Person> persons = new ArrayList<Person>();

        for(int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    public Person findById(String id){
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFistName("Victor");
        person.setLastName("Hugo");
        person.setAddress("Goiânia - GO");
        person.setGender("Male");
        return person;
    }

    public Person create(Person person){
        logger.info("Creating one Person!");
        return person;
    }

    public Person update(Person person){
        logger.info("Update one Person!");
        return person;
    }

    public void delete(String id){
        logger.info("Deleting one Person!");

    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFistName("Fistname " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("Some Address in Goiânia - GO");
        person.setGender("Male");
        return person;

    }
}
