package com.sdsa.pardusmuzik.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.sdsa.pardusmuzik.model.TrackList;
import com.sdsa.pardusmuzik.util.EffectUtil;
import com.sdsa.pardusmuzik.util.TrackListUtil;
import java.io.File;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;

/**
 * Dialog to edit details of a tracklist or add new one.
 *
 * @author Adrián Barrio Andrés
 * @email sdsa@gmail.com
 * @web https://sdsa.com
 */
public class TrackListEditDialogController {

    @FXML
    private TextField nameField;
    
    @FXML
    private AnchorPane dialogAnchorPane;
    
    @FXML
    private Button deleteTrackListButton;

    private Stage dialogStage;
    private TrackList trackList;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Add drag listener to background
        EffectUtil.addDragListeners(dialogAnchorPane);
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the tracklist to be edited in the dialog.
     *
     * @param trackList
     */
    public void setTrackList(TrackList trackList) {
        this.trackList = trackList;
        nameField.setText(trackList.getName().getValue());
        if(trackList.getId().getValue() == 0) {
            deleteTrackListButton.setDisable(true);
        }
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    
    /**
     * Delete tracklist.
     */
    @FXML
    private void handleDeleteTrackList() {
        TrackListUtil.delete(trackList);
        dialogStage.close();
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleSelectFolder() {
        if (isInputValid()) {
            DirectoryChooser chooser = new DirectoryChooser();
            chooser.setTitle("Müziklerin bulunduğu klasörü seçiniz");
            File selectedDirectory = chooser.showDialog(dialogStage);
            trackList.setPath(new SimpleStringProperty(selectedDirectory.toString()));
            trackList.setName(new SimpleStringProperty(nameField.getText()));
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";
        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "Geçerli bir çalma listesi adı girin!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Veriler Eksik");
            alert.setHeaderText(null);
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
}