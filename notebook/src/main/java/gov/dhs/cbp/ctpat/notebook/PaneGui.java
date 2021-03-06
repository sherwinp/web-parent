package gov.dhs.cbp.ctpat.notebook;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.jar.JarFile;

import com.sun.javafx.scene.control.skin.modena.Style;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
 
public class PaneGui extends Application {
    
    public static void main(String[] args) {
        launch(PaneGui.class, args);
    }
 
    @Override public void start(final Stage stage) throws IOException {
        stage.setTitle("GUI Pane");
        
        URL url = new URL(this.getClass().getResource("layout.fxml").toExternalForm());
        FXMLLoader loader = new FXMLLoader(url);
        Scene scene = new Scene( loader.load(), 900, 350 );
        scene.getStylesheets().add(Style.class.getResource("modena.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}