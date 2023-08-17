package rocks.zipcode.Spring.PersonController.CRUD2;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonRepository people;

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    Person createPerson(@RequestBody Person p) {
        //ResponseEntity<Person> createPerson(@RequestBody Person p) {

        return people.save(p);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    Person getPerson(@PathVariable Long id) {
        if (people.findById(id).isPresent()) {
            return people.findById(id).get();
        }
        return null;
    }

    @RequestMapping(value = "/people", method = RequestMethod.GET)
        //ResponseEntity<List<Person>> getPersonList() {
        //List<Person> personList = new ArrayList<>();
        //people.findAll().forEach(personList::add);
        // return new ResponseEntity<>(personList, HttpStatus.OK);
    List<Person> getPersonList() {
        List<Person> personList = new ArrayList<>();
        people.findAll().forEach(personList::add);
        return personList;
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
    Person updatePerson(@RequestBody Person p) {

        return people.save(p);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    void deletePerson(@PathVariable Long id) {
        people.deleteById(id);
    }

}

