package Tuan2;

import java.util.ArrayList;

public class QLsinhvien {

    private ArrayList<TTsinhvien> danhSach;

    public QLsinhvien() {
        danhSach = new ArrayList<TTsinhvien>();
    }

    public void themSinhVien(TTsinhvien sv) {
        danhSach.add(sv);
    }

    public void xuatDanhSach() {
        if (danhSach.size() == 0) {
            System.out.println("Danh sach rong!");
            return;
        }

        System.out.println("\n==========================================================");
        System.out.printf("%-10s %-25s %-10s %-10s %-10s%n",
                "Ma SV", "Ho ten", "Diem LT", "Diem TH", "Diem TB");
        System.out.println("==========================================================");

        for (TTsinhvien sv : danhSach) {
            sv.xuat();
        }
    }

    public TTsinhvien timTheoMa(int ma) {
        for (TTsinhvien sv : danhSach) {
            if (sv.getMaSinhVien() == ma) {
                return sv;
            }
        }

        return null;
    }

    public boolean xoaSinhVien(int ma) {
        TTsinhvien sv = timTheoMa(ma);

        if (sv != null) {
            danhSach.remove(sv);
            return true;
        }

        return false;
    }

    public boolean suaSinhVien(int ma, String hoTen, double diemLT, double diemTH) {
        TTsinhvien sv = timTheoMa(ma);

        if (sv != null) {
            sv.setHoTen(hoTen);
            sv.setDiemLT(diemLT);
            sv.setDiemTH(diemTH);
            return true;
        }

        return false;
    }

    public int soLuongSinhVien() {
        return danhSach.size();
    }

	public void sapXepDiemTangDan() {
		// TODO Auto-generated method stub
		
	}
}