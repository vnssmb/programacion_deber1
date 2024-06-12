package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

       
        MenuBar menuBar = new MenuBar();

        
        Menu archivoMenu = new Menu("Archivo");
        Menu editarMenu = new Menu("Editar");
        Menu ayudaMenu = new Menu("Ayuda");

     
        MenuItem nuevoMenuItem = new MenuItem("Nuevo");
        MenuItem abrirMenuItem = new MenuItem("Abrir");
        MenuItem guardarMenuItem = new MenuItem("Guardar");
        MenuItem salirMenuItem = new MenuItem("Salir");

        MenuItem copiarMenuItem = new MenuItem("Copiar");
        MenuItem pegarMenuItem = new MenuItem("Pegar");

        MenuItem acercaDeMenuItem = new MenuItem("Acerca de");

        
        archivoMenu.getItems().addAll(nuevoMenuItem, abrirMenuItem, guardarMenuItem, new SeparatorMenuItem(), salirMenuItem);

        
        editarMenu.getItems().addAll(copiarMenuItem, pegarMenuItem);

       
        ayudaMenu.getItems().addAll(acercaDeMenuItem);

        
        nuevoMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Se seleccionó Nuevo");
            }
        });

        abrirMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Se seleccionó Abrir");
            }
        });

        guardarMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Se seleccionó Guardar");
            }
        });

        salirMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Se seleccionó Salir");
                primaryStage.close();
            }
        });

        copiarMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Se seleccionó Copiar");
            }
        });

        pegarMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Se seleccionó Pegar");
            }
        });

        acercaDeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Se seleccionó Acerca de");
            }
        });

        
        menuBar.getMenus().addAll(archivoMenu, editarMenu, ayudaMenu);

        
        root.setTop(menuBar);

        
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Deber");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
