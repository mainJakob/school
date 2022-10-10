package Pathfinder;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;


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
    private VBox vBox;
    @FXML
    private HBox hBox;

    @FXML
    private RadioButton rbtnStart;

    @FXML
    private RadioButton rbtnBarrier;

    @FXML
    private RadioButton rbtnEmpty;

    @FXML
    private RadioButton rbtnTarget;
    private GraphicsContext gc;

    private GridData data;

    private  Node oldNode;

    private ToggleGroup tg;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tg = new ToggleGroup();
        rbtnStart.setToggleGroup(tg);
        rbtnEmpty.setToggleGroup(tg);
        rbtnBarrier.setToggleGroup(tg);
        rbtnTarget.setToggleGroup(tg);
        data = new GridData((int)canvas.getWidth(),(int)canvas.getHeight());
        data.fillGrid();
        btnGo.setOnAction(e -> calculate());
        btnClear.setOnAction(e -> killGRID());
        gc = canvas.getGraphicsContext2D();
        checkGrid.setOnAction(e -> drawGRID());
        vBox.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                canvas.setHeight(t1.intValue()/1.5);
                data = new GridData((int)canvas.getWidth(),(int)canvas.getHeight());
                data.fillGrid();
                clearCanvas();
                drawGRID();
                System.out.println("changed");
            }
        });
        vBox.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                canvas.setWidth(t1.intValue()/1.5);
                data = new GridData((int)canvas.getWidth(),(int)canvas.getHeight());
                data.fillGrid();
                clearCanvas();
                drawGRID();
                System.out.println("changed");
            }
        });
        slider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(slider.getValue());
                GridData.setNodesize((int)slider.getValue());
                data = new GridData((int)canvas.getWidth(),(int)canvas.getHeight());
                clearCanvas();
                data.fillGrid();
                drawGRID();
            }
        });

        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int x = (int) mouseEvent.getX();
                int y = (int) mouseEvent.getY();
                doDraw(x,y);
                /*
                int clickX = x/ GridData.nodesize;
                int clickY = y/ GridData.nodesize;
                Node clicked = data.getNode(clickX,clickY);
                System.out.println(clicked.getNeighbours());

                if(clicked.getType() == Type.EMPTY){
                    System.out.println("Empty");
                    clicked.setType(Type.BARRIER);
                    gc.setFill(Paint.valueOf("Blue"));

                    gc.fillRect(clickX * GridData.nodesize, clickY * GridData.nodesize, GridData.nodesize,GridData.nodesize);
                    return;
                }
                if(clicked.getType() == Type.BARRIER ){
                    System.out.println("Barrier");
                    clicked.setType(Type.EMPTY);
                    gc.clearRect(clickX * GridData.nodesize, clickY * GridData.nodesize, GridData.nodesize,GridData.nodesize);
                    return;
                }
                */




            }
        });
        canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int x = (int) mouseEvent.getX();
                int y = (int) mouseEvent.getY();
                doDraw(x,y);
                /*
                int clickX = x/ GridData.nodesize;
                int clickY = y/ GridData.nodesize;
                //doDraw(x,y);

                Node clicked = data.getNode(clickX,clickY);
                if(clicked.getType() == Type.EMPTY && oldNode != clicked){
                    System.out.println("Empty");
                    clicked.setType(Type.BARRIER);
                    gc.setFill(Paint.valueOf("Blue"));
                    gc.fillRect(clickX * GridData.nodesize, clickY * GridData.nodesize, GridData.nodesize,GridData.nodesize);
                    oldNode = clicked;
                    return;
                }
                if(clicked.getType() == Type.BARRIER && oldNode != clicked){
                    System.out.println("Barrier");
                    clicked.setType(Type.EMPTY);
                    gc.clearRect(clickX * GridData.nodesize, clickY * GridData.nodesize, GridData.nodesize,GridData.nodesize);
                    oldNode = clicked;
                    return;
                }

                 */


            }
        });

    }

    public void calculate() {
        System.out.println("TBD");
    }

    public void clearCanvas() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void drawGRID() {
        if (checkGrid.isSelected()) {
            for (int i = 0; i < data.getMaxX(); i += GridData.nodesize) {
                gc.strokeLine(i, 0, i, data.getMaxX());

            }
            for (int i = 0; i < data.getMaxY(); i += GridData.nodesize) {
                gc.strokeLine(0, i,  data.getMaxY(), i );

            }
        } else {
            killGRID();
        }
    }

    public void killGRID() {
        data = new GridData((int)canvas.getWidth(),(int)canvas.getHeight());
        data.fillGrid();
        clearCanvas();
        checkGrid.setSelected(false);
    }
    public void doDraw(int x , int y){
        int clickX = x/GridData.nodesize;
        int clickY = y/GridData.nodesize;
        Node clicked = data.getNode(x/GridData.nodesize,y/GridData.nodesize);
        if(rbtnStart.isSelected() && !data.hasStart()){
            gc.setFill(Paint.valueOf("Green"));
            gc.fillRect(clickX * GridData.nodesize, clickY * GridData.nodesize, GridData.nodesize,GridData.nodesize);
            clicked.setType(Type.START);

            return;
        }
        if(rbtnTarget.isSelected() && !data.hasTarget()){
            gc.setFill(Paint.valueOf("Red"));
            gc.fillRect(clickX * GridData.nodesize, clickY * GridData.nodesize, GridData.nodesize,GridData.nodesize);
            clicked.setType(Type.TARGET);
            return;
        }
        if(rbtnBarrier.isSelected()){
            gc.setFill(Paint.valueOf("Blue"));
            gc.fillRect(clickX * GridData.nodesize, clickY * GridData.nodesize, GridData.nodesize,GridData.nodesize);
            clicked.setType(Type.BARRIER);
            return;
        }
        if (rbtnEmpty.isSelected()){
            gc.setFill(Paint.valueOf("White"));
            gc.fillRect(clickX * GridData.nodesize, clickY * GridData.nodesize, GridData.nodesize,GridData.nodesize);
            clicked.setType(Type.EMPTY);
            return;
        }
    }
    }