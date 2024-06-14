package site.stellarburgers.client;

import lombok.Data;

@Data
public class RegisterUser {
    public RegisterUser(String email, String password, String name)
    {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    private final String email;
    private final String password;
    private final String name;
}
