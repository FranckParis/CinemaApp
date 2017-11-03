package manager;

import model.Personnage;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Quentin on 03/11/2017.
 */

public interface PersonnageRepository extends CrudRepository <Personnage, Long> {
}
