package guru.springframework.spring5recipeapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    @ManyToMany
    @JoinTable(name="recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")//recipe to nazwa propertisa z klasy Ingredient
    private Set<Ingredient> ingredients = new HashSet<>();

    @Enumerated(value = EnumType.STRING) //ordinal - default, ale my chcemy raczej zachować string,
    // zeby po dodaniu nowej opcji w środku w enumie liczby w BD odpowiadały rzeczywistej trudności
    private Difficulty difficulty;

    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    public Recipe addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        ingredient.setRecipe(this);
        return this;
    }

}
