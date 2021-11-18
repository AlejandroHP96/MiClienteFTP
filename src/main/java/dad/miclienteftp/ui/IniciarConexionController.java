package dad.miclienteftp.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.net.ftp.FTPClient;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class IniciarConexionController implements Initializable{

    Stage stage;

    //model

    private StringProperty servidoProperty = new SimpleStringProperty();
    private StringProperty puertoProperty = new SimpleStringProperty();
    private StringProperty contrasenaProperty = new SimpleStringProperty();
    private StringProperty usuarioProperty = new SimpleStringProperty();
    
    //view

    @FXML
    private Button cancelarButton;

    @FXML
    private Button conectarButton;

    @FXML
    private TextField contrasenaTextField;

    @FXML
    private TextField puertoTextField;

    @FXML
    private TextField servidorTextField;

    @FXML
    private TextField usuarioTextField;

    @FXML
    private GridPane view;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // bindings

        servidorTextField.textProperty().bind(servidoProperty);
        puertoTextField.textProperty().bind(puertoProperty);
        contrasenaTextField.textProperty().bind(contrasenaProperty);
        usuarioTextField.textProperty().bind(usuarioProperty);

        // Stage

        stage = new Stage();
		stage.initOwner(MiClienteFTPApp.getPrimaryStage());
		stage.setScene(new Scene(getView()));
        
    }

    public void show(){
        stage.showAndWait();
    }

    public IniciarConexionController() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/IniciarConexionView.fxml"));
        loader.setController(this);
        loader.load();
    }
    
    @FXML
    void onConectarButtonAction(ActionEvent event) {

        FTPClient client = new FTPClient();
        client.connect(servidoProperty.get());


    }

    @FXML
    void onCancelarButtonAction(ActionEvent event) {

    }


    public GridPane getView() {
        return view;
    }


    
}
