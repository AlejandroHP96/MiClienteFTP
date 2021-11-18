package dad.miclienteftp.ui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.miclienteftp.ui.model.Fichero;
import dad.miclienteftp.ui.model.TipoFichero;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {

    IniciarConexionController conexionController = new IniciarConexionController();

    private ListProperty<Fichero> ficheros = new SimpleListProperty<>(FXCollections.observableArrayList());

    private StringProperty ruta = new SimpleStringProperty();

    @FXML
    private MenuItem conectarMenu;

    @FXML
    private MenuItem desconectarMenu;

    @FXML
    private TableColumn<Fichero, String> nombreColumn;

    @FXML
    private MenuBar servidorMenu;

    @FXML
    private TableView<Fichero> tableView;

    @FXML
    private TableColumn<Fichero, Number> tamanoColumn;

    @FXML
    private TableColumn<Fichero, TipoFichero> tipoColumn;

    @FXML
    private BorderPane view;

    public BorderPane getView() {
        return view;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // bindings
        tableView.itemsProperty().bind(ficheros);

        // cell value factories
        nombreColumn.setCellValueFactory((v -> v.getValue().nombreProperty()));
        tamanoColumn.setCellValueFactory((v -> v.getValue().tamanoProperty()));
        tipoColumn.setCellValueFactory((v -> v.getValue().tipoProperty()));

        // initializing properties

        ruta.set(new File(conexionController.getRuta()).getAbsolutePath());

    }

    public MainController() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
        loader.setController(this);
        loader.load();
    }

    @FXML
    void onConectarMenuAction(ActionEvent event) {

        conexionController.show();

    }

    @FXML
    void onDesconectarMenuAction(ActionEvent event) throws IOException {
        conexionController.getClient().disconnect();

    }

}
