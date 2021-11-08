package builders;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LogIn {

    private String email;
    private String password;
}
