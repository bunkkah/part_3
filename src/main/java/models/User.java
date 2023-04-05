package models;

import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String name;
    String email;
    String password;

    // фабрика
    public static User getRandom() {
        String name = RandomStringUtils.randomAlphanumeric(8);
        String email = RandomStringUtils.randomAlphanumeric(10) + "@testemail.ru";
        String password = RandomStringUtils.randomAlphanumeric(6);

        return new User(name, email, password);
    }
}
