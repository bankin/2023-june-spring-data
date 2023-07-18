package softuni.exam.models.dto.json_nested;

import java.util.List;
import java.util.stream.Collectors;

public class UsersWithProductsDTO {

    private int usersCount;

    private List<UserWithProductsDTO> users;

    public UsersWithProductsDTO() {}

    public UsersWithProductsDTO(List<UserWithProductsDTO> users) {
        this.usersCount = users.size();
        this.users = users;
    }
}
