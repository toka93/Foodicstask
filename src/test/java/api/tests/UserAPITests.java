package api.tests;

import api.clients.UserClient;
import api.models.User;
import base.BaseTest;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.ExtentManager;

import java.lang.reflect.Method;
import java.util.Locale;

public class UserAPITests extends BaseTest {

    private final Faker faker = new Faker(new Locale("en-EG"));
    private final UserClient userClient = new UserClient();

    private static String userId;
    private static User testUser;



    @Test(priority = 1, description = "Create a new user")
    public void testCreateUser(Method method) {
        test = extent.createTest(method.getName());

        testUser = new User();
        testUser.setName(faker.name().firstName());
        testUser.setJob(faker.job().title());

        ExtentManager.logInfo(test, "Sending POST request to create user with name: " + testUser.getName());
        Response createResponse = userClient.createUser(testUser);

        ExtentManager.logStep(test, "Verify response status code is 201", createResponse.getStatusCode() == 201);
        Assert.assertEquals(createResponse.getStatusCode(), 201, "User creation failed");

        userId = createResponse.jsonPath().getString("id");
        ExtentManager.logStep(test, "Extracted user ID: " + userId, userId != null);
        Assert.assertNotNull(userId, "User ID is null after creation");
    }

    @Test(priority = 2, dependsOnMethods = {"testCreateUser"}, description = "Retrieve created user")
    public void testGetUser(Method method) {
        test = extent.createTest(method.getName());

        ExtentManager.logInfo(test, "Sending GET request to retrieve user with ID: " + userId);
        Response getResponse = userClient.getUser(userId);

        ExtentManager.logStep(test, "Verify response status code is 200", getResponse.getStatusCode() == 200);
        Assert.assertEquals(getResponse.getStatusCode(), 200, "User retrieval failed");
        Assert.assertEquals(getResponse.jsonPath().getString("name"), testUser.getName());
        Assert.assertEquals(getResponse.jsonPath().getString("job"), testUser.getJob());

    }

    @Test(priority = 3, dependsOnMethods = {"testCreateUser"}, description = "Update created user")
    public void testUpdateUser(Method method) {
        test = extent.createTest(method.getName());

        String updatedName = faker.name().firstName();
        testUser.setName(updatedName);
        testUser.setJob(faker.job().position());

        ExtentManager.logInfo(test, "Sending PUT request to update user with ID: " + userId);
        Response updateResponse = userClient.updateUser(userId, testUser);

        ExtentManager.logStep(test, "Verify response status code is 200", updateResponse.getStatusCode() == 200);
        Assert.assertEquals(updateResponse.getStatusCode(), 200, "User update failed");
        Assert.assertEquals(updateResponse.jsonPath().getString("name"), testUser.getName());
    }


}
