package Bai9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong cong nhan: ");
        int n = sc.nextInt();
        sc.nextLine();

        DanhSachCongNhan ds = new DanhSachCongNhan(n);

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap cong nhan thu " + (i + 1));

            System.out.print("Ma cong nhan: ");
            int maCN = sc.nextInt();
            sc.nextLine();

            System.out.print("Ho: ");
            String mHo = sc.nextLine();

            System.out.print("Ten: ");
            String mTen = sc.nextLine();

            System.out.print("So san pham: ");
            int mSoSP = sc.nextInt();
            sc.nextLine();

            CongNhan cn = new CongNhan(maCN, mHo, mTen, mSoSP);
            ds.themCongNhan(cn);
        }

        System.out.println("\nDANH SACH CONG NHAN");
        ds.xuatDanhSach();

        System.out.println("\nSO LUONG CONG NHAN: " + ds.soLuongCongNhan());

        System.out.println("\nCONG NHAN LAM TREN 200 SAN PHAM");
        ds.xuatCongNhanTren200SP();

        ds.sapXepGiamDanTheoSoSP();

        System.out.println("\nDANH SACH SAU KHI SAP XEP GIAM DAN THEO SO SAN PHAM");
        ds.xuatDanhSach();

        sc.close();
    }
}