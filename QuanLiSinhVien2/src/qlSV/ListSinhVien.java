package qlSV;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class ListSinhVien implements IFSinhVien {

    private ArrayList<SinhVien> danhSach;

    public ListSinhVien() {
        this.danhSach = new ArrayList<>();
    }

    public ListSinhVien(ArrayList<SinhVien> ds) {
        this.danhSach = ds;
    }

    @Override
    public boolean them(SinhVien sv) {
        if (sv == null) return false;
        if (timTheoMa(sv.getMaSV()) != null) return false;
        return danhSach.add(sv);
    }

    @Override
    public boolean sua(String maSV, SinhVien svMoi) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaSV().equals(maSV)) {
                danhSach.set(i, svMoi);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean xoa(String maSV) {
        return danhSach.removeIf(sv -> sv.getMaSV().equals(maSV));
    }

    @Override
    public boolean xoaTatCa() {
        if (danhSach.isEmpty()) return false;
        danhSach.clear();
        return true;
    }

    @Override
    public List<SinhVien> layTatCa() {
        return new ArrayList<>(danhSach);
    }

    @Override
    public SinhVien timTheoMa(String maSV) {
        for (SinhVien sv : danhSach) {
            if (sv.getMaSV().equalsIgnoreCase(maSV)) return sv;
        }
        return null;
    }

    public List<SinhVien> tim(Predicate<SinhVien> dieuKien) {
        List<SinhVien> kq = new ArrayList<>();
        for (SinhVien sv : danhSach) {
            if (dieuKien.test(sv)) kq.add(sv);
        }
        return kq;
    }

    @Override
    public List<SinhVien> timTheoTen(String tuKhoa) {
        List<SinhVien> kq = new ArrayList<>();
        for (SinhVien sv : danhSach) {
            if (sv.getHoTen().toLowerCase().contains(tuKhoa.toLowerCase())) {
                kq.add(sv);
            }
        }
        return kq;
    }

    @Override
    public List<SinhVien> timTheoLop(String lop) {
        List<SinhVien> kq = new ArrayList<>();
        for (SinhVien sv : danhSach) {
            if (sv.getLop().equalsIgnoreCase(lop)) kq.add(sv);
        }
        return kq;
    }

    @Override
    public List<SinhVien> timTheoLoai(String loai) {
        List<SinhVien> kq = new ArrayList<>();
        for (SinhVien sv : danhSach) {
            if (sv.getLoai().equalsIgnoreCase(loai)) kq.add(sv);
        }
        return kq;
    }

    @Override
    public List<SinhVien> timTheoMon(MonHoc monHoc) {
        List<SinhVien> kq = new ArrayList<>();
        for (SinhVien sv : danhSach) {
            if (sv.getMonHoc() == monHoc) kq.add(sv);
        }
        return kq;
    }

    @Override
    public int tongSoLuong() {
        return danhSach.size();
    }

    @Override
    public double tongThanhTien() {
        double tong = 0;
        for (SinhVien sv : danhSach) tong += sv.thanhTien();
        return tong;
    }

    public void sapXep(Comparator<SinhVien> cmp) {
        danhSach.sort(cmp);
    }

    public void sapXepGiamDan(Comparator<SinhVien> cmp) {
        danhSach.sort(cmp.reversed());
    }

    @Override
    public List<SinhVien> sapXepTheoTen() {
        List<SinhVien> kq = new ArrayList<>(danhSach);
        kq.sort(Comparator.comparing(SinhVien::getHoTen));
        return kq;
    }

    @Override
    public List<SinhVien> sapXepTheoThanhTienGiamDan() {
        List<SinhVien> kq = new ArrayList<>(danhSach);
        kq.sort(Comparator.comparingDouble(SinhVien::thanhTien).reversed());
        return kq;
    }

    public <K> Map<K, List<SinhVien>> nhomTheo(Function<SinhVien, K> layKey) {
        Map<K, List<SinhVien>> kq = new LinkedHashMap<>();
        for (SinhVien sv : danhSach) {
            K key = layKey.apply(sv);
            kq.computeIfAbsent(key, k -> new ArrayList<>()).add(sv);
        }
        return kq;
    }

    public <K> Map<K, Integer> demTheoNhom(Function<SinhVien, K> layKey) {
        Map<K, Integer> kq = new LinkedHashMap<>();
        for (SinhVien sv : danhSach) {
            kq.merge(layKey.apply(sv), 1, Integer::sum);
        }
        return kq;
    }

    public <K> Map<K, Double> tongTheoNhom(Function<SinhVien, K> layKey,
                                          ToDoubleFunction<SinhVien> layGiaTri) {
        Map<K, Double> kq = new LinkedHashMap<>();
        for (SinhVien sv : danhSach) {
            K key = layKey.apply(sv);
            double val = layGiaTri.applyAsDouble(sv);
            kq.merge(key, val, Double::sum);
        }
        return kq;
    }

    public <K> Map<K, Double> tongTheoNhom_Having(Function<SinhVien, K> layKey,
                                                 ToDoubleFunction<SinhVien> layGiaTri,
                                                 double minTong) {
        Map<K, Double> kq = new LinkedHashMap<>();
        for (Map.Entry<K, Double> e : tongTheoNhom(layKey, layGiaTri).entrySet()) {
            if (e.getValue() >= minTong) kq.put(e.getKey(), e.getValue());
        }
        return kq;
    }

    public <K> Map<K, Integer> demTheoNhom_Having(Function<SinhVien, K> layKey, int minDem) {
        Map<K, Integer> kq = new LinkedHashMap<>();
        for (Map.Entry<K, Integer> e : demTheoNhom(layKey).entrySet()) {
            if (e.getValue() >= minDem) kq.put(e.getKey(), e.getValue());
        }
        return kq;
    }
}