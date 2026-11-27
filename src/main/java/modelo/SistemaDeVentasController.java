package modelo;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaDeVentasController {
    @FXML
    private TableView<Producto> tblProductos;

    @FXML
    private TableColumn<Producto,String> colNombre;

    @FXML
    private TableColumn<Producto,Double> colPrecio;

    @FXML
    private TableColumn<Producto,Integer> colStock;

    @FXML
    private TextField filCantidad;

    @FXML
    private Label lblmesaje;

    @FXML
    private ListView<ObjetosCarrito> listaCarito;

    private List<Producto> listProducto = new ArrayList<>();
    private List<ObjetosCarrito> listCarrito = new ArrayList<>();
    private final String ARCHIVO =  "contactos.dat";

    @FXML
    public void initialize(){
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        listaCarito.setItems(listCarrito);
        cargarProducto();

    }


    private void cargarProducto(){
        File archivo = new File(ARCHIVO);

        if(!archivo.exists()){
            return;
        }

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))){
            List<Producto> productos = (List<Producto>) entrada.readObject();

            listProducto = productos;
        } catch (IOException |  ClassNotFoundException e){
            mostrarAlerta ("Error", "No se pudieron cargar los productos.");
            e.printStackTrace();
        }
    }

    private void cargarCrrito(){
        Producto seleccioAgregar=tblProductos.getSelectionModel().getSelectedItem();
        if(seleccioAgregar == null){
            mostrarAlerta ("Error", "No se pudieron cargar carito.");
            return;
        }
        int cantidad;

        try{
            cantidad= Integer.parseInt(filCantidad.getText().trim());

        }catch (NumberFormatException e){
            mostrarAlerta ("Error", "No se pudieron cargar carito.");
            return;
        }
        ItemCarrito existente =

    }

    @FXML
    private void AgregarCabtidad(){


    }

    @FXML
    private void ConfirmarCompra(){}

    private void mostrarAlerta(String titulo, String mensaje) {

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }
    private void mostrarContactos(ArrayList<ObjetosCarrito> lista){


    }


}
