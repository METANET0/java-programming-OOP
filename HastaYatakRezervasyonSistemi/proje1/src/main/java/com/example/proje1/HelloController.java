package com.example.proje1;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
public class HelloController  implements Initializable{
  @FXML
  private TextField textfield;
  @FXML
  private Button button;
  @FXML
  private PasswordField passwordfield;
  @FXML
  private Label giris;
  public static Connection con=null;
  public static Statement statement=null;
  public void baglantı() {
      String url="jdbc:mysql://localhost:3306/kullanıcılar?useUnicode=true&characterEncoding=utf8";
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("driver bulundu");
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
      try {
        con= DriverManager.getConnection(url,"root","");
        System.out.println("bağlantı başarılı");
      } catch (SQLException e) {
        e.printStackTrace();
      }
  }
  public void onButtonClick() throws IOException {
      String sorgu="select * from kullanıcıbilgileri";
      String Username=textfield.getText();
      String password=passwordfield.getText();
    if (Username.isEmpty() || password.isEmpty()) {
      giris.setText("kullanıcı adı ve şifre giriniz");
    }
    else {
      try {
        statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sorgu);
        while (rs.next()) {
          if (password.equals(rs.getString("password")) && Username.equals(rs.getString("userName"))) {
            giris.setText("giriş başarılı");
            button.getScene().getWindow().hide();
            try {
              FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("dsa.fxml"));
              Scene scene = new Scene(fxmlLoader.load());
              Stage stage = new Stage();
              stage.setTitle("Hasta Yatak Rezervasyon Sistemi");
              stage.setScene(scene);
              stage.show();
            } catch (IOException e) {
              e.printStackTrace();
            }
            break;
          } else {
            giris.setText("kullanıcı adı veya şifre hatalı");
          }
        }
      }
      catch (SQLException e) {
        throw new RuntimeException(e);
      }
      }
  }
  @Override
  public void initialize(URL location,ResourceBundle resources){
  baglantı();
  }
}