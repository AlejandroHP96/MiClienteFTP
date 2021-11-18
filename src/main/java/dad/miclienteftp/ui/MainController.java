package dad.miclienteftp.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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


    @FXML
    private MenuItem conectarMenu;

    @FXML
    private MenuItem desconectarMenu;

    @FXML
    private TableColumn<?, ?> nombreColumn;

    @FXML
    private MenuBar servidorMenu;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> tamanoColumn;

    @FXML
    private TableColumn<?, ?> tipoColumn;

    @FXML
    private BorderPane view;

    public BorderPane getView() {
        return view;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public MainController() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
        loader.setController(this);
        loader.load();
    }


    @FXML
    void onConectarMenuAction(ActionEvent event) {

        conexionController.show();

    }

    @FXML
    void onDesconectarMenuAction(ActionEvent event) {

    }
    
}
