package manager;

import model.Categorie;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Quentin on 03/11/2017.
 */

public interface CategorieRepository extends CrudRepository <Categorie, Long> {
}
