package Tuan1_HinhTron;

import java.sql.SQLOutput;

public class HinhTron {
    private double bankinh;
    private ToaDo tam;
    private final double PI = 3.1416;
    public double getBankinh() {
        return bankinh;
    }
    public void setBankinh(double bankinh) {
        this.bankinh = bankinh;
    }
    public ToaDo getTam() {
        return tam;
    }
    public void setTam(ToaDo tam) {
        this.tam = tam;
    }

    public HinhTron(double bankinh, ToaDo tam) {
        super();
        this.bankinh = bankinh;
        this.tam = tam;
    }
    public double getCV() {
        return getBankinh()*2*PI;

    }
    public double getDT() {
        return getBankinh()*getBankinh()*PI;
    }
    public static void main(String[] args) {
        HinhTron h1 = new HinhTron(5,new ToaDo("O", 4, 10));
        System.out.println("Hinh Tron: "+h1.getTam().getTen());
        System.out.println("Chu vi hình tron:"+h1.getCV());
        System.out.println("Diện tích hình tròn là:"+ h1.getDT());
    }
}