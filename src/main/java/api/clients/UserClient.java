package api.clients;

import io.restassured.http.Header;
import io.restassured.response.Response;
import api.models.User;



public class UserClient extends APIClient {
        private static final String USERS_ENDPOINT = "/api/users";



        public Response createUser(User user) {


            return post(USERS_ENDPOINT, user);
        }

        public Response getUser(String userId) {
            return get(USERS_ENDPOINT + "/" + userId);
        }

        public Response updateUser(String userId, User user) {
            return put(USERS_ENDPOINT + "/" + userId, user);
        }

    }

