package lm;

import javafx.application.Application;
import javafx.stage.Stage;
import view.LMController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
/**
 * Desktop application. Part of Label Master 1.0. Creates a CSV data base of numbers and their hashes that can be printed and than verified with mobile LM app.
 *
 * @author Piotr Dymala p.dymala@gmail.com
 * @version 1.0
 * @since 2020-07-03
 */

public class Main extends Application {

	@Override 
	public void start(Stage primaryStage) {

		ViewLoader<AnchorPane, LMController> viewLoader = new ViewLoader<AnchorPane, LMController>(
				"/view/LMView.fxml");
		AnchorPane anchorPaneEmp = viewLoader.getLayout();

		Scene scene = new Scene(anchorPaneEmp);
		primaryStage.setScene(scene);
		primaryStage.setTitle("		Label Master 1.0 - desktop		");

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}