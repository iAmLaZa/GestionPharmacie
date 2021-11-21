package manipulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class outils {
    public outils() {
    }

    public static void showconfirmationmessage(String titre, String message){
        Alert a=new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle(titre);
        a.setContentText(message);

        a.showAndWait();
    }

    public static void showerroronmessage(String titre,String message){
        Alert a=new Alert(Alert.AlertType.ERROR);
        a.setTitle(titre);
        a.setContentText(message);

        a.showAndWait();
    }

    private  void loadwindow(ActionEvent event, String title, String url)throws IOException{


        FXMLLoader loader=new FXMLLoader(getClass().getResource(url));
        Parent root= loader.load();
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle(title);


        stage.show();
    }

    private  void loadpage(ActionEvent event, String title, String url) throws IOException{
        ((Node) event.getSource()).getScene().getWindow().hide();

        Parent root= FXMLLoader.load(getClass().getResource(url));
        Scene scene=new Scene(root);

        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle(title);

        stage.show();
    }

    public static void loadp(ActionEvent event, String title, String url) throws IOException{
        new outils().loadpage(event,title,url);
    }
    public static void loadw(ActionEvent event, String title, String url) throws IOException{
        new outils().loadwindow(event,title,url);
    }


}
