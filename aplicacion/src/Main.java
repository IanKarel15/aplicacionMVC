import controllers.AuthController;
import models.AuthModel;

public class Main {
    public static void main(String[] args) {
        AuthModel model = new AuthModel();
        new AuthController(model);
    }
}