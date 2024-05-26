package models.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
public class LoginRequestModel {
    @JsonProperty("userName")
    private String username;
    private String password;
}
