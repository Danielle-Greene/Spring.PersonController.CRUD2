package rocks.zipcode.Spring.PersonController.CRUD2;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository <Person, Long> {
}
