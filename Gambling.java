import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
//import javafx.fxml.FXMLLoader;

public class Gambling extends Application {
    private Balance gamble = new Balance(0,0);

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();

        VBox topPane = new VBox();
        Label welcomeTxt = new Label("Please enter how much money you will gain/lose to Yui.");
        welcomeTxt.setFont(Font.font("Calibri", 16));
        Label instruct = new Label("The \"Predict\" button allows you to see potential change without changing your balance.");
        instruct.setFont(Font.font("Calibri", 16));
        Label balanceLabel = new Label("Balance: 0");
        balanceLabel.setFont(Font.font("Calibri", 16));
        Label predictLabel = new Label("Predicted balance: 0");
        predictLabel.setFont(Font.font("Calibri", 16));
        Label netLabel = new Label("Net gain/loss: 0");
        netLabel.setFont(Font.font("Calibri", 16));
        
        topPane.getChildren().addAll(welcomeTxt, instruct);
        topPane.getChildren().addAll(balanceLabel, predictLabel, netLabel);
        topPane.setAlignment(Pos.CENTER);

        FlowPane centerPane = new FlowPane();
        Label prompt = new Label("Enter amount:  ");
        prompt.setFont(Font.font("Calibri", 16));
        TextField amt = new TextField();
        amt.setPrefWidth(150);

        centerPane.getChildren().add(prompt);
        centerPane.getChildren().add(amt);
        centerPane.setAlignment(Pos.CENTER);

        FlowPane botPane = new FlowPane();
        Button gainEvent = new Button("Gain");
        Button lossEvent = new Button("Loss");
        Button predictEvent = new Button("Predict");
        Button startEvent = new Button("Set start balance");
        botPane.getChildren().add(startEvent);
        botPane.getChildren().add(gainEvent);
        botPane.getChildren().add(lossEvent);
        botPane.getChildren().add(predictEvent);
        botPane.setAlignment(Pos.CENTER);

        root.setTop(topPane);
        root.setCenter(centerPane);
        root.setBottom(botPane);

        startEvent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int start = Integer.parseInt(amt.getText());
                gamble.setStartBalance(start);
                balanceLabel.setText("Balance: " + gamble.getBalance());
                gamble.setCount();
            }
        });

        gainEvent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int gain = Integer.parseInt(amt.getText());
                gamble.gain(gain);
                balanceLabel.setText("Balance: " + gamble.getBalance());
                netLabel.setText("Net: " + gamble.getNet());
                gamble.setCount();
            }
        });

        lossEvent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                int loss = Integer.parseInt(amt.getText());
                gamble.loss(loss);
                balanceLabel.setText("Balance: " + gamble.getBalance());
                netLabel.setText("Net: " + gamble.getNet());
                gamble.setCount();
            }
        });

        predictEvent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                int predict = Integer.parseInt(amt.getText());
                gamble.predict(predict);
                predictLabel.setText("Predicted balance: " + gamble.getProxyBalance());
            }
        });        

        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("Gambling with Yui");
        primaryStage.setScene(scene);
        primaryStage.show();

        /* welcomeTxt.setPadding(new Insets(10,175,10,165)); */
        /* balanceLabel.setPadding(new Insets(30,175,10,210)); */
        /* predictLabel.setPadding(new Insets(30,175,10,210)); */
        /* centerPane.setPadding(new Insets(40,100,10,125)); */
        /* botPane.setPadding(new Insets(10,175,10,188)); */
    }
}