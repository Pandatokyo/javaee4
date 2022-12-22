package lesson11.persistence.configurations.jjw;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
