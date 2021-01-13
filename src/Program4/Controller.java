package Program4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.*;

public class Controller implements Initializable {


    @FXML
    Button startButton, endButton;

    @FXML
    TextField numThread;

    @FXML
    TextArea thread1TxtArea, thread2TxtArea, thread3TxtArea, thread4TxtArea, thread5TxtArea, thread6TxtArea, thread7TxtArea, thread8TxtArea, thread9TxtArea, thread10TxtArea;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public TextArea getTextArea(int threadNumber) {

        switch (threadNumber) {
            case 1:
                return thread1TxtArea;
            case 2:
                return thread2TxtArea;
            case 3:
                return thread3TxtArea;
            case 4:
                return thread4TxtArea;
            case 5:
                return thread5TxtArea;
            case 6:
                return thread6TxtArea;
            case 7:
                return thread7TxtArea;
            case 8:
                return thread8TxtArea;
            case 9:
                return thread9TxtArea;
            case 10:
                return thread10TxtArea;
            default:
                return new TextArea();
        }

    }

    @FXML
    private void setStartButton() {

        boolean numeric = true;

        try {
            int nThread = Integer.parseInt(numThread.getText().toString());
        } catch (NumberFormatException e) {
            numeric = false;
        }

        if (numThread.getText().toString().isEmpty()) {
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setContentText("To pole nie może być puste!");
            alert.setHeaderText("Błąd!");
            alert.showAndWait();
        } else if (!numeric) {
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setContentText("Nalezy wpisac liczbe od 1 do 10");
            alert.setHeaderText("Błąd!");
            alert.showAndWait();
        } else if (Integer.parseInt(numThread.getText().toString()) > 10 || Integer.parseInt(numThread.getText().toString()) < 1) {
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setContentText("Dozwolony przedzial to od 1 do 10");
            alert.setHeaderText("Błąd!");
            alert.showAndWait();
        } else {

            int numThreads = Integer.parseInt(numThread.getText().toString());
            ExecutorService pool = Executors.newFixedThreadPool(1);

            CompletableFuture.runAsync(getTask(numThreads), pool);

        }
    }

    public Runnable getTask(int numThreads){

        Runnable task = ()->{
            for(char j = 'A';j<='Z';j++){
                if(numThreads!=10){
                    getTextArea(numThreads).setText(getTextArea(numThreads).getText()+ " "+j+numThreads );
                }else
                    getTextArea(numThreads).setText(getTextArea(numThreads).getText()+ " "+j+'0');

                try {
                    Thread.sleep(1000);
                }
                catch(InterruptedException exc) {
                    System.out.println("Wątek został przerwany.");
                }
            }

        };
        return task;
    }

    @FXML
    public void setStopButton(){

        Stage stage = (Stage) endButton.getScene().getWindow();
        stage.close();

    }
}
