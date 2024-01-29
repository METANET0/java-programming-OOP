package com.example.proje1;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class hasta extends yataklar implements rezervasyon{
    String tc;
    String ad;
    String soyad;
    int yaş;
    String cinsiyet;
    String kanGrubu;
    String adres;
    String sigorta;
    String telefonNumarası;
    String acilDurumTelefonNumarası;
    public hasta(int yatakNo,String tc, String ad, String soyad, int yaş, String cinsiyet, String kanGrubu, String adres,String sigorta,
                 String telefonNumarası, String acilDurumTelefonNumarası, String yatakTürü, String yatakKonum,String başlangıçTarihi,String bitişTarihi) {
        super(yatakNo,yatakKonum,yatakTürü,başlangıçTarihi,bitişTarihi);
        this.tc=tc;
        this.ad = ad;
        this.soyad = soyad;
        this.yaş = yaş;
        this.cinsiyet = cinsiyet;
        this.kanGrubu = kanGrubu;
        this.adres = adres;
        this.sigorta = sigorta;
        this.telefonNumarası = telefonNumarası;
        this.acilDurumTelefonNumarası = acilDurumTelefonNumarası;
    }
    public String getTelefonNumarası() {
        return telefonNumarası;
    }

    public void setTelefonNumarası(String telefonNumarası) {
        this.telefonNumarası = telefonNumarası;
    }
    public String getBaşlangıçTarihi() {
        return başlangıçTarihi;
    }

    public void setBaşlangıçTarihi(String başlangıçTarihi) {
        this.başlangıçTarihi = başlangıçTarihi;
    }

    public String getBitişTarihi() {
        return bitişTarihi;
    }

    public void setBitişTarihi(String bitişTarihi) {
        this.bitişTarihi = bitişTarihi;
    }

    public String getSigorta() {
        return sigorta;
    }

    public void setSigorta(String sigorta) {
        this.sigorta = sigorta;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public int getYatakNo() {
        return yatakNo;
    }

    public void setYatakNo(int yatakNo) {
        this.yatakNo = yatakNo;
    }

    public String getYatakKonum() {
        return yatakKonum;
    }

    public void setYatakKonum(String yatakKonum) {
        this.yatakKonum = yatakKonum;
    }

    public String getYatakTürü() {
        return yatakTürü;
    }

    public void setYatakTürü(String yatakTürü) {
        this.yatakTürü = yatakTürü;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getYaş() {
        return yaş;
    }

    public void setYaş(int yaş) {
        this.yaş = yaş;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getKanGrubu() {
        return kanGrubu;
    }

    public void setKanGrubu(String kanGrubu) {
        this.kanGrubu = kanGrubu;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getAcilDurumTelefonNumarası() {
        return acilDurumTelefonNumarası;
    }

    public void setAcilDurumTelefonNumarası(String acilDurumTelefonNumarası) {
        this.acilDurumTelefonNumarası = acilDurumTelefonNumarası;
    }
    @Override
    public long kalanGünSayısı() {
        if(this.bitişTarihi.isEmpty()){
            return 0;
        }
        else {
            LocalDate today = LocalDate.now();
            LocalDate startDate = LocalDate.parse(this.başlangıçTarihi);
            LocalDate endDate = LocalDate.parse(this.bitişTarihi);
            if(ChronoUnit.DAYS.between(today, endDate)<0||ChronoUnit.DAYS.between(startDate, today)<0){
                return 0;
            }
            return ChronoUnit.DAYS.between(today, endDate);
        }
    }
    public String yatakTürBilgisi(){
        String tür1="ev tipi hasta yatağı";
        String tür2="motorlu hasta yatağı";
        String tür3="yarı otomatik hasta yatağı";
        String tür4="otomatik hasta yatağı";
        String tür5="manuel hasta yatağı";
            if(this.yatakTürü.equals(tür1)){
                return "Ev tipi hasta yatakları, hasta bakımı ve konforu için özel olarak tasarlanmış yataklardır.";
            }
            else if(this.yatakTürü.equals(tür2)){
                return "Motorlu hasta yatakları, hasta bakımı için özel olarak tasarlanmış ve motorlarla donatılmış yataklardır.";
            }
            else if(this.yatakTürü.equals(tür3)){
                return "Yarı otomatik hasta yatakları, motorlu olmayan bazı özelliklere sahip olup, belirli fonksiyonları manuel olarak ayarlamak mümkün olan yataklardır.";
            }
            else if(this.yatakTürü.equals(tür4)){
                return "Otomatik hasta yatakları, genellikle elektrikli motorlarla çalışan ve çeşitli fonksiyonları otomatik olarak veya uzaktan kumanda ile kontrol edilebilen yataklardır.";
            }
            else if(this.yatakTürü.equals(tür5)){
                return "Manuel hasta yatakları, elektrikli motorlar yerine elle kontrol edilen mekanizmalarla çalışan yataklardır.";
            }
            else{
                return null;
            }
    }
    public String yatakTürBilgisi(String tür){
        if(tür.equals("ev tipi hasta yatağı")){
            return "Ev tipi hasta yatakları, hasta bakımı ve konforu için özel olarak tasarlanmış yataklardır.";
        }
        else if(tür.equals("motorlu hasta yatağı")){
            return "Motorlu hasta yatakları, hasta bakımı için özel olarak tasarlanmış ve motorlarla donatılmış yataklardır.";
        }
        else if(tür.equals("yarı otomatik hasta yatağı")){
            return "Yarı otomatik hasta yatakları, motorlu olmayan bazı özelliklere sahip olup, belirli fonksiyonları manuel olarak ayarlamak mümkün olan yataklardır.";
        }
        else if(tür.equals("otomatik hasta yatağı")){
            return "Otomatik hasta yatakları, genellikle elektrikli motorlarla çalışan ve çeşitli fonksiyonları otomatik olarak veya uzaktan kumanda ile kontrol edilebilen yataklardır.";
        }
        else if(tür.equals("manuel hasta yatağı")){
            return "Manuel hasta yatakları, elektrikli motorlar yerine elle kontrol edilen mekanizmalarla çalışan yataklardır.";
        }
        else{
            return null;
        }
    }
    public boolean yatakDolumu(){
        if(this.ad.equals("")){
            return true;
        }
        else {
            return false;
        }
    };
}
