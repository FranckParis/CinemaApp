package manager;

import model.Film;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Quentin on 03/11/2017.
 */

public interface FilmRepository extends CrudRepository <Film, Integer> {
}
