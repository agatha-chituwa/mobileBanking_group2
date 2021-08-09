import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.event.*;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.Line;

public class Main extends Application {

   Stage window ;
   Scene scene1, scene2, checkBalanceScene, moneyTransfersScene, makePaymentsScene, airTimeTopUpScene, changePinScene;
   
   int response ;
    Text topText = new Text("CHOOSE OPERATION");
    Text checkBalance = new Text("1. Check Balance");
    Text moneyTransfers = new Text("2. Money Transfers");
    Text makePayments = new Text("3. Make Payments");
    Text airTimeTopUp = new Text("4. Airtime TopUp");
    Text changePin = new Text("5. Change Pin");
    Text exit = new Text("6. Exit");
    TextField textField = new TextField();
    Button cancel = new Button("CANCEL");
    Button send = new Button("SEND");
    VBox home = new VBox(10);
    
    Button button = new Button("working");

 @Override // Override the start method in the Application class
 public void start(Stage primaryStage) {
    window = primaryStage;

     stylesForAll();
 
    VBox vbox = new VBox(25);
    VBox vbox2 = new VBox(10);
    HBox hbox = new HBox(20);
    VBox vbox3 = new VBox(20);
    

    hbox.getChildren().addAll(cancel, send);

    vbox2.getChildren().addAll(topText, checkBalance, moneyTransfers,
    makePayments, airTimeTopUp, changePin, exit
    );
    vbox3.getChildren().addAll(textField, hbox); 
    vbox.getChildren().addAll( vbox2, vbox3); 
    home.getChildren().addAll(vbox);
    

    GridPane grid = new GridPane();
    grid.setPadding(new Insets(20,20,20,20));
    
    grid.getChildren().addAll(home);
    scene1 = new Scene(grid, 300, 350);


    

    // Create and register the handler
    send.setOnAction(e -> {
      handleSend ();  
    });
    cancel.setOnAction(e -> {
       handleCancel();
    });
    
 

    
    scene1.getStylesheets().add("Main.css");
    window.setTitle("Our Bank SSD ");
    window.setScene(scene1);
    window.show();
 }




 private void stylesForAll() {
        topText.getStyleClass().add("toptext");
        functionStyles();
     
     }

    private void functionStyles() {

      //giving simillar css class for all textfields
       checkBalance.getStyleClass().add("functionstyle");
       moneyTransfers.getStyleClass().add("functionstyle");
       makePayments.getStyleClass().add("functionstyle");
       airTimeTopUp.getStyleClass().add("functionstyle");
       changePin.getStyleClass().add("functionstyle");
       exit.getStyleClass().add("functionstyle");
       cancel.getStyleClass().add("myCancelButton");
       send.getStyleClass().add("mySendButton");
       textField.getStyleClass().add("myTextField");
       home.getStyleClass().add("myAll");
 } 

 /*class SendHandler implements EventHandler<ActionEvent> {
 @Override // Override the handle method
 public void handle(ActionEvent e) {
 
 }
 }*/
 //Handle send Button
 public void handleSend () {
    String a = textField.getText();
       response= Integer.parseInt(a);
      
       if(response==1){
          goToCheckBalance();
          window.setScene(checkBalanceScene);
       }
       else if (response==2) {
           goToSendMoney();
           window.setScene(moneyTransfersScene);
       }
       else if (response==3) {
           goToMakePayments();
           window.setScene(makePaymentsScene);
       }
       else if (response==4) {
          goToAirtimeTopUp();
           window.setScene(airTimeTopUpScene);
       }
       else if (response==5) {
          goToChangePin();
           window.setScene(changePinScene);
       }
       else if (response==6){
          System.exit(0);
       }
 }

 //handle cancel button
 public void handleCancel(){
    System.exit(0);
 }

 //make Payments method for scene display
 public void goToMakePayments() {
    Text waterBoard = new Text("1. Water Board");
    Text escom = new Text("2. ESCOM");
    Text tuition= new Text("3. Tuition");
    Text mazim = new Text ("4. MAZIM");

   TextField makePaymentTextField = new TextField();
    Button makePaymentCancel = new Button("CANCEL");
    Button makePaymentSend = new Button("SEND");

    VBox makepaymentsVbox = new VBox(10);
    HBox makePaymentsHbox = new HBox(20);
    VBox makePaymentsVbox3 = new VBox(20);
    VBox makePaymentsVbox2 = new VBox(25);

    makepaymentsVbox.getChildren().addAll(waterBoard, escom, tuition, mazim);
    makePaymentsHbox.getChildren().addAll(makePaymentCancel, makePaymentSend);
    makePaymentsVbox3.getChildren().addAll(makePaymentTextField, makePaymentsHbox);
    makePaymentsVbox2.getChildren().addAll(makepaymentsVbox, makePaymentsVbox3);

    GridPane makePayments = new GridPane();
    makePayments.setPadding(new Insets(20,20,20,20));

    makePayments.getChildren().addAll(makePaymentsVbox2);

    //registering and handling send and cancel button
    makePaymentCancel.setOnAction(e -> handleCancel());

    makePaymentsScene = new Scene(makePayments, 300, 350);

    
 }
 //check balance scene method
 public void goToCheckBalance(){
    Text textBalance = new Text("Your balance is K20,000");

    GridPane checkBalanceScreen = new GridPane();
    checkBalanceScreen.setPadding(new Insets(20,20,20,20));

    checkBalanceScreen.getChildren().addAll(textBalance);

    checkBalanceScene = new Scene(checkBalanceScreen, 300, 350);
 }

 //change Pin scene method
 public void goToChangePin(){
    
    //old pin
    Text oldPinText = new Text("Old Pin");
    TextField oldPinTextField = new TextField();
    VBox oldPinVbox = new VBox(5);
    oldPinVbox.getChildren().addAll(oldPinText, oldPinTextField);

    //new pin
    Text newPinText = new Text("New Pin");
    TextField newPinTextField = new TextField();
    VBox newPinVbox = new VBox(5);
    newPinVbox.getChildren().addAll(newPinText, newPinTextField);

    //new pin confirm
    Text newPinConfirmText = new Text("Confirm New Pin");
    TextField newPinConfirmTextField = new TextField();
    VBox newPinConfirmVbox = new VBox(5);
    newPinConfirmVbox.getChildren().addAll(newPinConfirmText, newPinConfirmTextField);

   //send and cancel Buttons
    Button changePinCancel = new Button("CANCEL");
    Button changePinSend = new Button("SEND");
    HBox sendCancelHbox = new HBox(20);
    sendCancelHbox.getChildren().addAll(changePinCancel, changePinSend);

    VBox allPins = new VBox(10);
    allPins.getChildren().addAll(oldPinVbox, newPinVbox, newPinConfirmVbox, sendCancelHbox);

    GridPane changePinScreen = new GridPane();
    changePinScreen.setPadding(new Insets(20,20,20,20));

    //registering and handling send and cancel button
    changePinCancel.setOnAction(e -> handleCancel());



    changePinScreen.getChildren().addAll(allPins);

    changePinScene = new Scene(changePinScreen, 300, 350);
 }

 public void goToAirtimeTopUp(){
    
    //Mobile Number
    Text mobileNumberText = new Text("Enter Mobile Number");
    TextField mobileNumberTextField = new TextField();
    VBox mobileNumberVbox = new VBox(5);
    mobileNumberVbox.getChildren().addAll(mobileNumberText, mobileNumberTextField);


    //confirm Number
    Text mobileNumberConfirmText = new Text("Confirm Number");
    TextField mobileNumberConfirmTextField = new TextField();
    VBox mobileNumberConfirmVbox = new VBox(5);
    mobileNumberConfirmVbox.getChildren().addAll(mobileNumberConfirmText, mobileNumberConfirmTextField);

     // amount
    Text amountText = new Text("Amount");
    TextField amountTextField = new TextField();
    VBox amountVbox = new VBox(5);
    amountVbox.getChildren().addAll(amountText, amountTextField);

   //send and cancel Buttons
    Button airtimeCancel = new Button("CANCEL");
    Button airtimeSend = new Button("SEND");
    HBox airtimeSendCancelHbox = new HBox(20);
    airtimeSendCancelHbox.getChildren().addAll(airtimeCancel, airtimeSend);

    VBox airtime = new VBox(10);
    airtime.getChildren().addAll(mobileNumberVbox, mobileNumberConfirmVbox, amountVbox, airtimeSendCancelHbox);

    GridPane airtimeTopUpScreen = new GridPane();
    airtimeTopUpScreen.setPadding(new Insets(20,20,20,20));

    //registering and handling send and cancel button
    airtimeCancel.setOnAction(e -> handleCancel());



    airtimeTopUpScreen.getChildren().addAll(airtime);

    airTimeTopUpScene = new Scene(airtimeTopUpScreen, 300, 350);
 }

 public void goToSendMoney (){
    //Account Number
    Text accountNumberText = new Text("Enter Account Number");
    TextField accountNumberTextField = new TextField();
    VBox accountNumberVbox = new VBox(5);
    accountNumberVbox.getChildren().addAll(accountNumberText, accountNumberTextField);

    //send and cancel Buttons
    Button sendMoneyCancel = new Button("CANCEL");
    Button sendMoneySend = new Button("SEND");
    HBox sendMoneySendCancelHbox = new HBox(20);
    sendMoneySendCancelHbox.getChildren().addAll(sendMoneyCancel, sendMoneySend);

    VBox airtime = new VBox(10);
    airtime.getChildren().addAll(accountNumberVbox,sendMoneySendCancelHbox);

    GridPane sendMoneyScreen = new GridPane();
    sendMoneyScreen.setPadding(new Insets(20,20,20,20));

    //registering and handling send and cancel button
    sendMoneyCancel.setOnAction(e -> handleCancel());



    sendMoneyScreen.getChildren().addAll(airtime);

    moneyTransfersScene = new Scene(sendMoneyScreen, 300, 350);
 }
 }

 