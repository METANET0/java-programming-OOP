package com.example.proje1;
public abstract class yataklar {
    int yatakNo;
    String yatakKonum;
    String yatakTürü;
    String başlangıçTarihi;
    String bitişTarihi;
    public yataklar(int yatakNo, String yatakKonum, String yatakTürü,String başlangıçTarihi,String bitişTarihi) {
        this.yatakNo = yatakNo;
        this.yatakKonum = yatakKonum;
        this.yatakTürü = yatakTürü;
        this.başlangıçTarihi=başlangıçTarihi;
        this.bitişTarihi=bitişTarihi;
    }
    public abstract String yatakTürBilgisi();
    public boolean yatakDolumu(){
        String name="";
        if(name.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    };
}