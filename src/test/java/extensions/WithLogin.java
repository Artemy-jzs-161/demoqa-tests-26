package extensions;

import org.junit.jupiter.api.extension.ExtendWith;
import java.lang.annotation.*;

@ExtendWith(LoginExtension.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WithLogin {}
