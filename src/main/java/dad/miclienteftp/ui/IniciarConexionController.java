package dad.miclienteftp.ui;

import java.io.IOException;
import java.net.SocketException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class IniciarConexionController implements Initializable {

    Stage stage;
    FTPClient client = new FTPClient();

    // model


    private StringProperty servidoProperty = new SimpleStringProperty();
    private StringProperty puertoProperty = new SimpleStringProperty();
    private StringProperty contrasenaProperty = new SimpleStringProperty();
    private StringProperty usuarioProperty = new SimpleStringProperty();

    private String ruta = new String();

    // view

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

        servidoProperty.bind(servidorTextField.textProperty());
        puertoProperty.bind(puertoTextField.textProperty());
        usuarioProperty.bind(usuarioTextField.textProperty());
        contrasenaProperty.bind(contrasenaTextField.textProperty());

        // Stage

        stage = new Stage();
        stage.initOwner(MiClienteFTPApp.getPrimaryStage());
        stage.setScene(new Scene(getView()));

    }

    public void show() {
        stage.showAndWait();
    }

    public IniciarConexionController() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/IniciarConexionView.fxml"));
        loader.setController(this);
        loader.load();
    }

    @FXML
    void onConectarButtonAction(ActionEvent event) throws SocketException, IOException {

        try {
            int puerto = Integer.parseInt(puertoProperty.get());
            

            client.connect(servidoProperty.get(), puerto);
            client.login(usuarioProperty.get(), contrasenaProperty.get());
            ruta = client.printWorkingDirectory();

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Conexión");
            alert.setContentText("Conexión establecida con éxito");
            alert.showAndWait();

            stage.close();

        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Hubo un error en la conexión");
            alert.setContentText("Connection error");
            alert.showAndWait();

        }

    }

    @FXML
    void onCancelarButtonAction(ActionEvent event) {

        stage.close();

    }

    public GridPane getView() {
        return view;
    }

    public FTPClient getClient() {
        return client;
    }
    public String getRuta() {
        return ruta;
    }

}
