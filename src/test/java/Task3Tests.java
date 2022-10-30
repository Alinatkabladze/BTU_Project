import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;


public class Task3Tests {
    @Test
    public void getResponseStatus(){
        int statusCode= given()
                        .when()
                        .get("https://bookstore.toolsqa.com/BookStore/v1/Books")
                        .getStatusCode();
        System.out.println("The response status is "+statusCode);
        Assert.assertEquals(statusCode,200);
    }

    public void checkIsbn(){
        given()
                .when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Books")
                .then()
                .assertThat()
                .body("books[-1].isbn",equalTo("9781593277574"));
    }

    @Test
    public void validateResult(){
        given()
                .when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Books")
                .then()
                .assertThat()
                .body("books[0].pages", equalTo(234), "books[1].pages", equalTo(254));
    }
}
