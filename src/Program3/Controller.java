package Program3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Button startButton,stopButton,endButton;

    @FXML
    TextField numThread;

    @FXML
    TextArea thread1TxtArea,thread2TxtArea,thread3TxtArea,thread4TxtArea,thread5TxtArea,thread6TxtArea,thread7TxtArea,thread8TxtArea,thread9TxtArea,thread10TxtArea;

    List<Thread> list = new LinkedList<Thread>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for(int i=1;i<=10;i++){
            int finalI = i;
            list.add(new Thread(() -> {
                print(finalI);
            }));

        }

        for(int x=0;x<list.size();x++){
            list.get(x).start();
        }


       // for(int x=0;x<list.size();x++){
        //    System.out.println(list.get(x).getState());
       // }

    }

    synchronized void print(int numThread){
        for(char j = 'A';j<='Z';j++){
            if(numThread!=10){
                getTextArea(numThread).setText(getTextArea(numThread).getText()+ " "+j+numThread );
            }else
                getTextArea(numThread).setText(getTextArea(numThread).getText()+ " "+j+'0');

            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException exc) {
                System.out.println("Wątek został przerwany.");
            }
        }
    }

    public TextArea getTextArea(int threadNumber){

        switch (threadNumber){
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
    private void setEndButton(){
        for(int i=0;i<list.size();i++){
                list.get(i).stop();
            }

        Stage stage = (Stage) endButton.getScene().getWindow();
        stage.close();

    }

}
