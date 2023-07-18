package softuni.exam.models.dto.json_nested;

import java.util.List;

public class SoldProductsDTO {
    private int count;
    private List<ProductDTO> products;

    public SoldProductsDTO() {}

    public SoldProductsDTO(List<ProductDTO> products) {
        this.count = products.size();
        this.products = products;
    }
}
