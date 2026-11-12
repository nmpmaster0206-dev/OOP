package Tuan1_HCN;

public class HinhChuNhat {
    //Khai bao thuoc tinh
    private double chieuDai;
    private double chieuRong;
    public double getChieuDai() {

        return chieuDai;
    }
    public void setChieuDai(double DoDai) throws Exception {
        if (DoDai>0) {
            this.chieuDai = DoDai;
        }else {
            throw new Exception("DoDai>0");
        }
    }
    public double getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(double chieuRong) {
        this.chieuRong = chieuRong;
    }
    //Tao ham khoi tao

    public HinhChuNhat(double DoDai, double chieuRong) throws Exception{
        if (DoDai>0) {
            this.chieuDai = DoDai;
        }else {
            throw new Exception("DoDai>0");
        }
        this.chieuRong = chieuRong;
    }
    public HinhChuNhat() {
    }
    public double getDT() {
        return this.chieuDai*getChieuRong();

    }
    public double getCV() {
        return (this.chieuDai+getChieuRong())/2;

    }
    public static void main (String[] args) throws Exception {
        HinhChuNhat h1=new HinhChuNhat(3,10);
        //In thong tin
        System.out.println("Chieu dai hinh chu nhat la: "+h1.chieuDai);
        System.out.println("Chieu rong hinh chu nhat la: "+h1.chieuRong);
        System.out.println("Dien tich HCN la: "+h1.getDT());
        System.out.println("Chu vi HCN la: "+h1.getCV());
    }
}
