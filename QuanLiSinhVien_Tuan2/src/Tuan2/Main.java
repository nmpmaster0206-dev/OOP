package Tuan2;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        QLsinhvien qlsv = new QLsinhvien();
        int chon;
        do {
            System.out.println("\n==========================================");
            System.out.println("       CHUONG TRINH QUAN LY SINH VIEN");
            System.out.println("==========================================");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Xuat danh sach sinh vien");
            System.out.println("3. Tim sinh vien theo ma");
            System.out.println("4. Sua thong tin sinh vien");
            System.out.println("5. Xoa sinh vien theo ma");
            System.out.println("0. Thoat");
            System.out.println("==========================================");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();
            switch (chon) {

                case 1:
                    TTsinhvien sv = new TTsinhvien();
                    sv.nhap();
                    qlsv.themSinhVien(sv);
                    break;

                case 2:
                    qlsv.xuatDanhSach();
                    break;

                case 3:
                    System.out.print("Nhap ma sinh vien can tim: ");
                    qlsv.soLuongSinhVien();
                    break;

                case 4:
                    System.out.print("Nhap ma sinh vien can sua: ");
                    qlsv.suaSinhVien(chon, null, chon, chon);
                    break;

                case 5:
                    System.out.print("Nhap ma sinh vien can xoa: ");
                    qlsv.xoaSinhVien(chon);
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);

        sc.close();
    }
}