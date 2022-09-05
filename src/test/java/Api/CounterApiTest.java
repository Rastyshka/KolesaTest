package Api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CounterApiTest {

    @Test
    @Tag("Counters")
    @DisplayName("Получение количества просмотров поста")
    void postPostCounters() {

        step("Получение количества просмотров поста", () -> {

                    given()
                            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                            .when()
                            .body("post_id=288122&lang=ru")
                            .post("https://kolesa.kz/content/wp-json/v1/counters")
                            .then()
                            .statusCode(200)
                            .body("status", is("ok"), "views", is(notNullValue()),
                                    "comments", is("0"));
                }
        );
    }

}
