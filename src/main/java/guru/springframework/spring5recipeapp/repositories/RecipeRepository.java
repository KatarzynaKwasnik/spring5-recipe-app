package guru.springframework.spring5recipeapp.repositories;

import guru.springframework.spring5recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //Jeśli implementujemy CrudRepository, to @Repository można pominąć
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
