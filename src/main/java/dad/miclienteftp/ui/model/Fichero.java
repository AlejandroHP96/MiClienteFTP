package dad.miclienteftp.ui.model;

import java.io.File;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fichero {

    private ObjectProperty<File> fichero = new SimpleObjectProperty<>();
    private StringProperty nombre = new SimpleStringProperty();
    private LongProperty tamano = new SimpleLongProperty();
    private ObjectProperty<TipoFichero> tipo = new SimpleObjectProperty<>();


    public Fichero(File f) {

        setFichero(f);
        setNombre(f.getName());
        setTamano(f.length());
        setTipo(f.isDirectory() ? TipoFichero.DIRECTORIO : TipoFichero.FICHERO);
    }

    public final ObjectProperty<File> ficheroProperty() {
        return this.fichero;
    }

    public final File getfichero() {
        return this.ficheroProperty().get();
    }

    public final void setFichero(final File f) {
        this.ficheroProperty().set(f);
    }

    public final StringProperty nombreProperty() {
        return this.nombre;
    }

    public final String getNombre() {
        return this.nombreProperty().get();
    }

    public final void setNombre(final String nombre) {
        this.nombreProperty().set(nombre);
    }

    public final LongProperty tamanoProperty() {
        return this.tamano;
    }

    public final long getTamano() {
        return this.tamanoProperty().get();
    }

    public final void setTamano(final long tamano) {
        this.tamanoProperty().set(tamano);
    }

    public final ObjectProperty<TipoFichero> tipoProperty() {
        return this.tipo;
    }

    public final TipoFichero getTipo() {
        return this.tipoProperty().get();
    }

    public final void setTipo(final TipoFichero tipo) {
        this.tipoProperty().set(tipo);
    }
    
}
