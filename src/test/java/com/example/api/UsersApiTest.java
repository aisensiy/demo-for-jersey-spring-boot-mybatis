package com.example.api;

import com.example.domain.User;
import com.example.domain.UserRepository;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsersApiTest {

    @Value("${local.server.port}")
    int port;

    @MockBean
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void should_get_empty_user_lists() throws Exception {
        when(userRepository.getAll()).thenReturn(Arrays.asList(new User("123", "aisensiy")));
        io.restassured.RestAssured.when()
            .get("/users")
            .then()
            .statusCode(200)
            .body("size()", equalTo(1))
            .body("[0].username", equalTo("aisensiy"));
    }
}
