package site.stellarburgers.client;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import site.stellarburgers.*;

import static io.restassured.RestAssured.given;

public class UserClient extends Client{

    private final static String REGISTER_USER_PATH = "api/auth/register";
    private final static String UPDATE_USER_PATH = "api/auth/user";

    @Step("Создание пользователя")
    public static  ValidatableResponse registerUser(RegisterUser data) {
        return given()
                .spec(getSpec())
                .body(data)
                .when()
                .post(REGISTER_USER_PATH)
                .then();
    }

    @Step("Удаление пользователя")
    public static ValidatableResponse deleteUser(String bearerPlusToken) {
        return given()
                .spec(getSpec(bearerPlusToken))
                .when()
                .delete(UPDATE_USER_PATH)
                .then();
    }

}
