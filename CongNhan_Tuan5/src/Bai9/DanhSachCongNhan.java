package Bai9;

public class DanhSachCongNhan {
    private CongNhan[] ds;
    private int count;

    public DanhSachCongNhan(int n) {
        ds = new CongNhan[n];
        count = 0;
    }

    public boolean themCongNhan(CongNhan cn) {
        if (count < ds.length) {
            ds[count] = cn;
            count++;
            return true;
        }
        return false;
    }

    public void xuatDanhSach() {
        for (int i = 0; i < count; i++) {
            System.out.println(ds[i]);
        }
    }

    public int soLuongCongNhan() {
        return count;
    }

    public void xuatCongNhanTren200SP() {
        for (int i = 0; i < count; i++) {
            if (ds[i].getmSoSP() > 200) {
                System.out.println(ds[i]);
            }
        }
    }

    public void sapXepGiamDanTheoSoSP() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (ds[i].getmSoSP() < ds[j].getmSoSP()) {
                    CongNhan temp = ds[i];
                    ds[i] = ds[j];
                    ds[j] = temp;
                }
            }
        }
    }
}