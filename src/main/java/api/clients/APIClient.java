package api.clients;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import utils.ConfigManager;
public class APIClient

{

        protected RequestSpecification requestSpec;
    Header header = new Header("x-api-key",ConfigManager.getProperty("api.key") );

        public APIClient() {
            requestSpec = given()
                    .baseUri(ConfigManager.getProperty("api.base.url"))
                    .contentType(ContentType.JSON).header(header)
                    .log().all();
        }


        protected Response get(String endpoint) {
            return requestSpec.get(endpoint);
        }

        protected Response post(String endpoint, Object body) {
            return requestSpec.body(body).post(endpoint);
        }

        protected Response put(String endpoint, Object body) {
            return requestSpec.body(body).put(endpoint);
        }

        protected Response delete(String endpoint) {
            return requestSpec.delete(endpoint);
        }
    }
