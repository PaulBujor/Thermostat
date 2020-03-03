package view;

import java.io.IOException;
import javafx.fxml.FXML;
import 

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
