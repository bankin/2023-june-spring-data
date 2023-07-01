package bg.softuni.springrepositories.repositories;

import bg.softuni.springrepositories.entities.Shampoo;
import bg.softuni.springrepositories.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findByBrandAndSize(String brand, Size size);

    List<Shampoo> findBySizeOrderById(Size size);

    List<Shampoo> findBySizeOrLabelIdOrderByPrice(Size size, long labelId);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countByPriceLessThan(BigDecimal price);

    // SELECT s FROM Shampoo AS s JOIN s.ingredients AS i WHERE i.name IN :ingredientNames
    @Query("SELECT s " +
            "FROM Shampoo AS s " +
            "JOIN s.ingredients AS i " +
            "WHERE i.name IN :names")
    List<Shampoo> findByIngredientsNameIn(@Param("names") List<String> ingredientNames);
}
