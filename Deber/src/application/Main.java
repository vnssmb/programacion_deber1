package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
      
            MenuBar menuBar = new MenuBar();

            
            Menu fileMenu = new Menu("ARCHIVO");
            Menu editMenu = new Menu("EDITAR");
            Menu helpMenu = new Menu("AYUDA");

           
            MenuItem newFile = new MenuItem("NUEVO");
            MenuItem openFile = new MenuItem("ABRIR");
            MenuItem saveFile = new MenuItem("GUARDAR");
            MenuItem exitApp = new MenuItem("SALIR");

            
            newFile.setOnAction(e -> System.out.println("NUEVO ARCHIVO"));
            openFile.setOnAction(e -> System.out.println("ABRIR ARCHIVO"));
            saveFile.setOnAction(e -> System.out.println("GUARDAR ARCHIVO"));
            exitApp.setOnAction(e -> {
                System.out.println("SALIR DE LA APLICACIÓN");
                primaryStage.close();
            });

            
            fileMenu.getItems().addAll(newFile, openFile, saveFile, new SeparatorMenuItem(), exitApp);

            
            MenuItem cut = new MenuItem("CORTAR");
            MenuItem copy = new MenuItem("COPIAR");
            MenuItem paste = new MenuItem("PEGAR");

            
            cut.setOnAction(e -> System.out.println("CORTAR"));
            copy.setOnAction(e -> System.out.println("COPIAR"));
            paste.setOnAction(e -> System.out.println("PEGAR"));

           
            editMenu.getItems().addAll(cut, copy, paste);

            
            MenuItem about = new MenuItem("ACERCA DE..");

           
            about.setOnAction(e -> System.out.println("ACERCA DE ESTA APLICACIÓN.."));

            
            helpMenu.getItems().addAll(about);

            
            menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

           
            Label dateLabel = new Label("SELECCIONE UNA FECHA: ");
            dateLabel.getStyleClass().add("label");
            Label colorLabel = new Label("SELECCIONE UN COLOR: ");
            colorLabel.getStyleClass().add("label");

            DatePicker datePicker = new DatePicker();
            ColorPicker colorPicker = new ColorPicker();

            Button btn = new Button("ACEPTAR");
            btn.getStyleClass().add("button");

            btn.setOnAction(e -> {
                String selectedDate = datePicker.getValue() != null ? datePicker.getValue().toString() : "NO SELECCIONADO";
                Color selectedColor = colorPicker.getValue() != null ? colorPicker.getValue() : Color.BLACK;

                Stage secondStage = new Stage();
                VBox secondaryLayout = new VBox(10);
                secondaryLayout.getStyleClass().add("secondary-root");

                Label dateInfoLabel = new Label("LA FECHA SELECCIONADA ES: " + selectedDate);
                dateInfoLabel.getStyleClass().add("secondary-label");
                Label colorInfoLabel = new Label("EL COLOR SELECCIONADO ES: ");
                colorInfoLabel.getStyleClass().add("secondary-label");

                Rectangle colorRectangle = new Rectangle(100, 100, selectedColor);
                colorRectangle.getStyleClass().add("rectangle");

                secondaryLayout.getChildren().addAll(dateInfoLabel, colorInfoLabel, colorRectangle);

                Scene secondScene = new Scene(secondaryLayout, 300, 200);
                String cssPath = getClass().getResource("/application/styles.css") != null ?
                        getClass().getResource("/application/styles.css").toExternalForm() : null;
                if (cssPath != null) {
                    secondScene.getStylesheets().add(cssPath);
                }
                secondStage.setScene(secondScene);
                secondStage.setTitle("Selección");
                secondStage.show();
            });

            VBox content = new VBox(10);
            content.getStyleClass().add("root");
            content.getChildren().addAll(dateLabel, datePicker, colorLabel, colorPicker, btn);

            
            BorderPane root = new BorderPane();
            root.setTop(menuBar);
            root.setCenter(content);

            
            Scene scene = new Scene(root, 400, 300);
            String cssPath = getClass().getResource("/application/styles.css") != null ?
                    getClass().getResource("/application/styles.css").toExternalForm() : null;
            if (cssPath != null) {
                scene.getStylesheets().add(cssPath);
            }
            primaryStage.setScene(scene);
            primaryStage.setTitle("Seleccionar Fecha y Color");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
