package softuni.exam.models.dto.json_nested;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JsonMain implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        ProductDTO product1 = new ProductDTO("Some name", 18.94);
        ProductDTO product2 = new ProductDTO("Some other name", 19.34);

        SoldProductsDTO soldProductsDTO = new SoldProductsDTO(List.of(product1, product2));

        UserWithProductsDTO user =
                new UserWithProductsDTO("first name", null, 20, soldProductsDTO);

        UsersWithProductsDTO main = new UsersWithProductsDTO(List.of(user));

        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();

        gson.toJson(main, System.out);
    }
}
