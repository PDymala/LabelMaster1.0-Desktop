package view;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import lm.csvWriter;

public class LMController {

	@FXML
	TextField textPrefix;
	@FXML
	TextField textFrom;
	@FXML
	TextField textTo;
	@FXML
	Button buttonGenerateFile;

	@FXML
	Button buttonExit;

	@FXML
	CheckBox checkBoxTitle;

	DirectoryChooser directoryChooser = new DirectoryChooser();

	@FXML
	public void generateFile() {

		if (textFrom.getText().isEmpty() || textTo.getText().isEmpty()) {

			Optional<ButtonType> result = AlertBox.showAndWait(AlertType.ERROR, "Data",
					"Type range of numbers to create a database");

		} else if (Integer.parseInt(textFrom.getText()) > Integer.parseInt(textTo.getText())) {
			Optional<ButtonType> result = AlertBox.showAndWait(AlertType.ERROR, "Data",
					"TO has to be bigger than FROM");

		} else {

			File selectedDirectory = directoryChooser.showDialog(null);

			if (selectedDirectory.getAbsolutePath() != null) {

				csvWriter csv = new csvWriter(new File(selectedDirectory.getAbsolutePath() + "/LM_database.csv"),
						textPrefix.getText(), textFrom.getText(), textTo.getText(), checkBoxTitle.isSelected());

				try {
					csv.writeToFile();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	@FXML
	public void exit(ActionEvent ae) {

		Optional<ButtonType> result = AlertBox.showAndWait(AlertType.CONFIRMATION, "Quiting",
				"Do You want to quit the application?");
		if (result.orElse(ButtonType.CANCEL) == ButtonType.OK) {

			Platform.exit();
		}
	}

}
