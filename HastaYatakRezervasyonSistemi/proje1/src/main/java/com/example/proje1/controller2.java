
package com.example.proje1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import static com.example.proje1.HelloController.con;
import static com.example.proje1.HelloController.statement;

public class controller2 implements Initializable{
        @FXML
        private Label kalanGünSayisi;
        @FXML
        private AnchorPane hastaBilgileriSayfasi;
        @FXML
        private AnchorPane rezarvasyonDüzenleSayfasi;
        @FXML
        private Button rezarvasyonlarDuzenle;
        @FXML
        private TableView<hasta> tablo;
        @FXML
        private TableColumn<hasta,Integer> tableYatakNo;
        @FXML
        private TableColumn<hasta,String> tabloAd;
        @FXML
        private TableColumn<hasta,String> tabloAdres;
        @FXML
        private TableColumn<hasta,String> tabloCinsiyet;
        @FXML
        private TableColumn<hasta,String> tabloKanGrubu;
        @FXML
        private TableColumn<hasta,String> tabloKimlik;
        @FXML
        private TableColumn<hasta,Boolean> tabloSigorta;
        @FXML
        private TableColumn<hasta,String> tabloSoyad;
        @FXML
        private TableColumn<hasta,String> tabloTelefon;
        @FXML
        private TableColumn<hasta,String> tabloYatakKonum;
        @FXML
        private TableColumn<hasta,String> tabloAcilTelefonNo;
        @FXML
        private TableColumn<hasta,String> tabloYatakTürü;
        @FXML
        private TableColumn<hasta,String> tabloYaş;
        @FXML
        private TableColumn<hasta,String> tablobaşlangıçtarihi;
        @FXML
        private TableColumn<hasta,String> tablobitiştarihi;
        @FXML
        private AnchorPane yataklarSayfasi;
        @FXML
        private Button çıkışYap;
        @FXML
        private Button anaSayfa;
        @FXML
        private TextField DacilTelNo;
        @FXML
        private TextField Dad;
        @FXML
        private TextField Dadres;
        @FXML
        private TextField Dsoyad;
        @FXML
        private TextField DtelefonNo;
        @FXML
        private TextField DyatakNo;
        @FXML
        private TextField Dtc;
        @FXML
        private ComboBox<?> DcinsiyetSeçim;
        @FXML
        private ComboBox<?> DkanGrubuSeçim;
        @FXML
        private ComboBox<?> DsigortaSeçim;
        @FXML
        private ComboBox<?> Dyaşeçim;
        @FXML
        private Button buttonDüzenle;
        @FXML
        private Button buttonSil;
        @FXML
        private Button buttonTemizle;
        @FXML
        private DatePicker DbaşlangıçTarihi;
        @FXML
        private DatePicker DbitişTarihi;
        @FXML
        private Label yatakBilgisi;
        @FXML
        private Label doluYatakSayisi;
    public ObservableList<hasta> hastalarıListeyeEkle(){
        int yatakSayisi=0;
        ObservableList<hasta> hastalar= FXCollections.observableArrayList();
        String sorgu="select * from yatak";
        try {
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu);
            hasta hastalar1;
            while(rs.next()){
                hastalar1=new hasta(rs.getInt("yatakNo"),rs.getString("tc"),rs.getString("ad"),rs.getString("soyad")
                        ,rs.getInt("yaş"),rs.getString("cinsiyet"), rs.getString("kanGrubu"),rs.getString("adres"),
                        rs.getString("sigorta"),rs.getString("telefonNumarası"),rs.getString("acilTelefonNo"),rs.getString("yatakTürü"),
                        rs.getString("yatakKonum"),rs.getString("başlangıçTarihi"),rs.getString("bitişTarihi"));
                if(hastalar1.yatakDolumu()){
                }
                else {
                    yatakSayisi++;
                }
                hastalar.add(hastalar1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        doluYatakSayisi.setText(String.valueOf(yatakSayisi));
        return hastalar;
    }
    private ObservableList<hasta> ekleme;
    public void görüntüle(){
        ekleme=hastalarıListeyeEkle();
        tableYatakNo.setCellValueFactory(new PropertyValueFactory<>("yatakNo"));
        tabloKimlik.setCellValueFactory(new PropertyValueFactory<>("tc"));
        tabloAd.setCellValueFactory(new PropertyValueFactory<>("ad"));
        tabloSoyad.setCellValueFactory(new PropertyValueFactory<>("soyad"));
        tabloYaş.setCellValueFactory(new PropertyValueFactory<>("yaş"));
        tabloCinsiyet.setCellValueFactory(new PropertyValueFactory<>("cinsiyet"));
        tabloKanGrubu.setCellValueFactory(new PropertyValueFactory<>("kanGrubu"));
        tabloAdres.setCellValueFactory(new PropertyValueFactory<>("adres"));
        tabloSigorta.setCellValueFactory(new PropertyValueFactory<>("sigorta"));
        tabloTelefon.setCellValueFactory(new PropertyValueFactory<>("telefonNumarası"));
        tabloAcilTelefonNo.setCellValueFactory(new PropertyValueFactory<>("acilDurumTelefonNumarası"));
        tabloYatakTürü.setCellValueFactory(new PropertyValueFactory<>("yatakTürü"));
        tabloYatakKonum.setCellValueFactory(new PropertyValueFactory<>("yatakKonum"));
        tablobaşlangıçtarihi.setCellValueFactory(new PropertyValueFactory<>("başlangıçTarihi"));
        tablobitiştarihi.setCellValueFactory(new PropertyValueFactory<>("bitişTarihi"));
        tablo.setItems(ekleme);
    }
    public void cıkısYap(){
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Bilgilendirme mesajı");
        alert.setHeaderText(null);
        alert.setContentText("çıkış yapmak istediğinize eminmisiniz?");
        Optional<ButtonType> option =alert.showAndWait();
        try{
            if(option.get().equals(ButtonType.OK)){
                çıkışYap.getScene().getWindow().hide();
                Parent root=FXMLLoader.load(getClass().getResource("girişEkranı.fxml"));
                Stage stage=new Stage();
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void select(){
        hasta hastalar=tablo.getSelectionModel().getSelectedItem();
        int num=tablo.getSelectionModel().getSelectedIndex();
        if((num-1)<-1){
            return;
        }
        DyatakNo.setText((String.valueOf(hastalar.getYatakNo())));
        Dad.setText(hastalar.getAd());
        Dsoyad.setText(hastalar.getSoyad());
        DacilTelNo.setText(hastalar.getAcilDurumTelefonNumarası());
        DtelefonNo.setText(hastalar.getTelefonNumarası());
        Dtc.setText(hastalar.getTc());
        Dadres.setText(hastalar.getAdres());
        long gün=hastalar.kalanGünSayısı();
        String str = String.valueOf(gün);
        kalanGünSayisi.setText(str);
        yatakBilgisi.setText(hastalar.yatakTürBilgisi(hastalar.yatakTürü));
        if(hastalar.yatakDolumu()){
            tablo.setStyle("-fx-background-color: green;");
        }
        else {
            tablo.setStyle("-fx-background-color: red;");
        }
    }
    public void temizle(){
        Dad.setText("");
        Dadres.setText("");
        DacilTelNo.setText("");
        Dtc.setText("");
        Dsoyad.setText("");
        DtelefonNo.setText("");
        DyatakNo.setText("");
        Dyaşeçim.getSelectionModel().clearSelection();
        DcinsiyetSeçim.getSelectionModel().clearSelection();
        DsigortaSeçim.getSelectionModel().clearSelection();
        DkanGrubuSeçim.getSelectionModel().clearSelection();
        DbaşlangıçTarihi.setValue(null);
        DbitişTarihi.setValue(null);
    }
    public void düzenle(){
        String sorgu="Update yatak SET tc='"
                +Dtc.getText()+"',ad='"+Dad.getText()+"',soyad='"
                +Dsoyad.getText()+"',yaş='"
                +Dyaşeçim.getSelectionModel().getSelectedItem()+"'"
                +",cinsiyet='"+DcinsiyetSeçim.getSelectionModel().getSelectedItem()
                +"',telefonNumarası='"+DtelefonNo.getText()+"',kanGrubu='"
                +DkanGrubuSeçim.getSelectionModel().getSelectedItem()
                +"',adres='"+Dadres.getText()+"',sigorta='"
                +DsigortaSeçim.getSelectionModel().getSelectedItem()+"',acilTelefonNo='"
                +DtelefonNo.getText()+"',başlangıçTarihi='"+DbaşlangıçTarihi.getValue()
                +"',bitişTarihi='"+DbitişTarihi.getValue()+"' where yatakNo='"+DyatakNo.getText()+"'";
                Alert alert;
                if(Dtc.getText().isEmpty()||Dad.getText().isEmpty()
                || Dsoyad.getText().isEmpty()
                ||Dyaşeçim.getSelectionModel().getSelectedItem()==null
                ||DcinsiyetSeçim.getSelectionModel().getSelectedItem()==null
                ||DtelefonNo.getText().isEmpty()
                ||DkanGrubuSeçim.getSelectionModel().getSelectedItem()==null
                ||Dadres.getText().isEmpty()
                ||DsigortaSeçim.getSelectionModel().getSelectedItem()==null
                ||DtelefonNo.getText().isEmpty()
                ||DbitişTarihi.getValue()==null
                ||DbaşlangıçTarihi.getValue()==null){
                    alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("hata mesajı");
                    alert.setHeaderText(null);
                    alert.setContentText("lütfen bütün alanları doldurunuz");
                    alert.showAndWait();
                }
                else{
                    alert=new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("uyarı mesajı");
                    alert.setHeaderText(null);
                    alert.setContentText("rezervasyonu düzenlemek istediğinize eminmisiniz?");
                    Optional<ButtonType> option=alert.showAndWait();
                    if(option.get().equals(ButtonType.OK)){
                        try {
                            statement=con.createStatement();
                            statement.executeUpdate(sorgu);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    görüntüle();
                    temizle();
                }


    }
    public void sil(){
        String sorgu="Update yatak SET tc='',ad='',soyad='',yaş='',cinsiyet='',telefonNumarası='',kanGrubu='',adres='',sigorta='',acilTelefonNo='',başlangıçTarihi='',bitişTarihi='' where yatakNo='"+DyatakNo.getText()+"'";
        Alert alert;
            alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("uyarı mesajı");
            alert.setHeaderText(null);
            alert.setContentText("rezervasyonu silmek istediğinize eminmisiniz?");
            Optional<ButtonType> option=alert.showAndWait();
            if(option.get().equals(ButtonType.OK)){
                try {
                    statement=con.createStatement();
                    statement.executeUpdate(sorgu);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        görüntüle();
        temizle();
    }
    public void cinsiyet(){
        ArrayList<String> cinsiyetler=new ArrayList<>();
        cinsiyetler.add("erkek");
        cinsiyetler.add("kadın");
        ObservableList list=FXCollections.observableArrayList(cinsiyetler);
        DcinsiyetSeçim.setItems(list);
    }
    public void yaş(){
        ArrayList<Integer> yaşlar=new ArrayList<>();
        for(int i=1;i<100;i++){
            yaşlar.add(i);
        }
        ObservableList list=FXCollections.observableArrayList(yaşlar);
        Dyaşeçim.setItems(list);
    }
    public void kanGrubu(){
        ArrayList<String> kanGrubu=new ArrayList<>();
        String[] kanlar={"A Rh+","A Rh-","B Rh+","B Rh-","AB Rh+","AB Rh-","O Rh+","O Rh-"};
        for(String kan:kanlar){
            kanGrubu.add(kan);
        }
        ObservableList list=FXCollections.observableArrayList(kanGrubu);
        DkanGrubuSeçim.setItems(list);
    }
    public void sigorta(){
        ArrayList<String> sigorta=new ArrayList<>();
        sigorta.add("var");
        sigorta.add("yok");
        ObservableList list=FXCollections.observableArrayList(sigorta);
        DsigortaSeçim.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        görüntüle();
        kanGrubu();
        sigorta();
        yaş();
        cinsiyet();
    }
}
