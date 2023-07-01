package bg.softuni.springrepositories;

import bg.softuni.springrepositories.entities.Ingredient;
import bg.softuni.springrepositories.entities.Shampoo;
import bg.softuni.springrepositories.repositories.IngredientsRepository;
import bg.softuni.springrepositories.services.IngredientsService;
import bg.softuni.springrepositories.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private ShampooService shampooService;

    private IngredientsService ingredientsService;

    public Runner(ShampooService shampooService, IngredientsService ingredientsService) {
        this.shampooService = shampooService;
        this.ingredientsService = ingredientsService;
    }

    @Override
    public void run(String... args) throws Exception {
//        List<Shampoo> byBrand = shampooService.findByBrand("Swiss Green Apple & Nettle");
//        List<Shampoo> byBrandAndSize =
//                shampooService.findByBrandAndSize("Swiss Green Apple & Nettle", Size.SMALL);

//        byBrandAndSize.forEach(System.out::println);

//        List<Shampoo> bySize = shampooService.findBySize(Size.MEDIUM);

//        List<Shampoo> result = shampooService.findBySizeOrLabelId(Size.MEDIUM, 10L);

//        List<Shampoo> result = shampooService.findByPriceGreaterThan(BigDecimal.valueOf(5));

//        List<Ingredient> result = ingredientsService.findByName("M");

//        List<Ingredient> result = ingredientsService.findByNameWithin(List.of("Lavender","Herbs","Apple"));

//        int count = shampooService.findCheaperThanCount(BigDecimal.valueOf(8.50));
//
//        System.out.println(count);

//        List<Shampoo> result = shampooService.findAllWithIngredients(List.of("Berry", "Mineral-Collagen"));
//
//        result.forEach(System.out::println);

//        ingredientsService.increasePrice();

//        ingredientsService.deleteByName("Apple");
    }
}
