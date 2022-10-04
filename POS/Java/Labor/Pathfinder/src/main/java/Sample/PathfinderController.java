package Sample;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import java.net.URL;
import java.util.ResourceBundle;

public class PathfinderController implements Initializable {

    @FXML
    private Canvas canvas;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnGo;
    @FXML
    private Slider slider;
    @FXML
    private CheckBox checkGrid;
    @FXML
    private HBox hBox;
    @FXML
    private VBox vbox;

    private GraphicsContext gc;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnGo.setOnAction(e -> calculate());
        btnClear.setOnAction(e -> clearCanvas());
        gc = canvas.getGraphicsContext2D();
        checkGrid.setOnAction(e -> drawGRID());
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                GridData.setNodesize(number.intValue());
                killGRID();
                drawGRID();
            }
        });

    }

    public void calculate() {
        System.out.println("TBD");
    }

    public void clearCanvas() {
    }

    public void drawGRID() {
        if (checkGrid.isSelected()) {
            for (int i = 0; i < canvas.getWidth(); i += GridData.nodesize) {
                gc.strokeLine(i, 0, i, canvas.getWidth());

            }
            for (int i = 0; i < canvas.getHeight(); i += GridData.nodesize) {
                gc.strokeLine(i, 0, i, canvas.getHeight());

            }
        } else {
            killGRID();
        }
    }

    public void killGRID() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
