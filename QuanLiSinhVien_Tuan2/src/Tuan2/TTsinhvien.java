package Tuan2;

import java.util.Scanner;

public class TTsinhvien {
    private int maSinhVien;
    private String hoTen;
    private double diemLT;
    private double diemTH;

    public TTsinhvien() {
        this.maSinhVien = 0;
        this.hoTen = "Khong co du lieu";
        this.diemLT = 0;
        this.diemTH = 0;
    }

    public TTsinhvien(int maSinhVien, String hoTen, double diemLT, double diemTH) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.diemLT = diemLT;
        this.diemTH = diemTH;
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        if (maSinhVien > 0) {
            this.maSinhVien = maSinhVien;
        } else {
            throw new IllegalArgumentException("Ma sinh vien phai > 0");
        }
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getDiemLT() {
        return diemLT;
    }

    public void setDiemLT(double diemLT) {
        if (diemLT >= 0 && diemLT <= 10) {
            this.diemLT = diemLT;
        } else {
            System.out.println("Diem phai tu 0 den 10");
        }
    }

    public double getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(double diemTH) {
        if (diemTH >= 0 && diemTH <= 10) {
            this.diemTH = diemTH;
        } else {
            System.out.println("Diem phai tu 0 den 10");
        }
    }

    public double getDiemTB() {
        return (diemLT + diemTH) / 2;
    }

    public void nhap() {
        try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Nhap ma sinh vien: ");
			setMaSinhVien(sc.nextInt());
			sc.nextLine();

			System.out.print("Nhap ho ten: ");
			setHoTen(sc.nextLine());

			System.out.print("Nhap diem LT: ");
			setDiemLT(sc.nextDouble());

			System.out.print("Nhap diem TH: ");
			setDiemTH(sc.nextDouble());
		}
    }
    public void xuat() {
        System.out.printf("%-10d %-25s %-10.2f %-10.2f %-10.2f%n",
                maSinhVien, hoTen, diemLT, diemTH, getDiemTB());
    }
}