package mylab.user.di;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.ContextConfiguration;
import org.junit.jupiter.api.Assertions;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserServiceDI() {
        Assertions.assertNotNull(userService, "UserService should not be null");
        Assertions.assertNotNull(userService.getUserRepository(), "UserRepository should not be null");
        Assertions.assertEquals("MySQL", userService.getUserRepository().getDbType(), "DB Type should be MySQL");
        Assertions.assertNotNull(userService.getSecurityService(), "SecurityService should not be null");
    }

    @Test
    public void testRegisterUser() {
        boolean result = userService.registerUser("user1", "John Doe", "password123");
        Assertions.assertTrue(result, "User registration should return true");
    }
}
