import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.SkiersApi;
import io.swagger.client.model.LiftRide;
import models.LiftData;

/**
 * @className: test
 * @author: Bingfan Tian
 * @description: TODO
 * @date: 10/4/22 2:34 AM
 */
public class test {
    public static void main(String[] args) {
        LiftRide liftRide = new LiftRide();
        liftRide.setLiftID(10);
        liftRide.setTime(10);
        LiftData tmp = new LiftData(1, "2022", "2", 12, liftRide);
        ApiClient client = new ApiClient();
        // todo: set base path after deploy
        client.setBasePath("http://127.0.0.1:8080/SkiResortServlet_war_exploded/");
        SkiersApi api = new SkiersApi();
        api.setApiClient(client);
        try {
            api.writeNewLiftRide(tmp.getLiftRide(), tmp.getResortID(), tmp.getSeasonID(), tmp.getDayID(), tmp.getSkierID());
            System.out.println("Success!");
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }
}
