package br.com.quarkus.resource;

import br.com.quarkus.model.Bitcoin;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;

@QuarkusTest
public class BitcoinResourceTest {

    @Test
    public void testarSeStatusCodeDaRequE200(){
        RestAssured.given()
                .get("bitcoins")
                .then().statusCode(200);
    }

    @Test
    public void testarContextTypeEJson(){
        RestAssured.given()
                .get("bitcoins")
                .then().contentType(ContentType.JSON);
    }
    @Test
    public void testarTipodeRetornoEListDeBitcoins(){
        RestAssured.given()
                .get("bitcoins")
                .then()
                .extract()
                .as(List.class);
    }
}
