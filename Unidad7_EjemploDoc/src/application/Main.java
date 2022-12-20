package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Person;
import view.PersonOverviewController;

/**
 * Clase Main donde se inicia la aplicación
 * 
 * @author Alumno DAM
 * @version 1.0
 *
 */
public class Main extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	// Listado de personas de la aplicación
	private ObservableList<Person> personData = FXCollections.observableArrayList();

	/**
	 * Inicializa la tabla de la aplicación
	 */
	public Main() {
		personData.add(new Person("Hans", "Muster"));
		personData.add(new Person("Ruth", "Mueller"));
		personData.add(new Person("Heinz", "Kurz"));
		personData.add(new Person("Cornelia", "Meier"));
		personData.add(new Person("Werner", "Meyer"));
		personData.add(new Person("Lydia", "Kunz"));
		personData.add(new Person("Anna", "Best"));
		personData.add(new Person("Stefan", "Meier"));
		personData.add(new Person("Martin", "Mueller"));
	}
	
	/**
	 * @param primaryStage Objeto con la ventana principal
	 * 
	 * Método que carga la ventana de la aplicación
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");

		initRootLayout();

		showPersonOverview();
	}

	/**
	 * Inicializa el diseño de la pantalla principal.
	 */
	public void initRootLayout() {
		try {
			// Carga el XML con el diseño principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Se añade el diseño principal a la escena
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Muestra el diseño de PersonOverview dentro de la pantalla principal
	 */
	public void showPersonOverview() {
		try {
			// Cargamos el archivo PersonOverview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/PersonOverview.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(personOverview);
			
			// Damos al controlador acceso a la aplicaicón principal
	        PersonOverviewController controller = loader.getController();
	        controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Getter para que los controladores accedan al Stage con la ventana principal
	 * 
	 * @return El Stage con la ventana principal
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	/**
	 * Método automático para iniciar aplicación
	 * 
	 * @param args Argumentos de la MV de Java
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Método get para lista de personas
	 * 
	 * @return Listado de personas de la tabla
	 */
	public ObservableList<Person> getPersonData() {
		return personData;
	}
	
} 