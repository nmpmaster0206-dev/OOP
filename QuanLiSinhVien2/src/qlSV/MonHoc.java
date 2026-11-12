package qlSV;

public enum MonHoc {
    LAP_TRINH_JAVA("Lập trình Java", 450_000f),
    CO_SO_DU_LIEU("Cơ sở dữ liệu", 450_000f),
    TOAN_ROI_RAC("Toán rời rạc", 400_000f),
    MANG_MAY_TINH("Mạng máy tính", 500_000f),
    TRI_TUE_NHAN_TAO("Trí tuệ nhân tạo", 600_000f),
    KY_THUAT_PHAN_MEM("Kỹ thuật phần mềm", 480_000f),
    LAP_TRINH_WEB("Lập trình Web", 500_000f),
    HE_DIEU_HANH("Hệ điều hành", 420_000f);

    private final String tenMon;
    private final float donGia;

    MonHoc(String tenMon, float donGia) {
        this.tenMon = tenMon;
        this.donGia = donGia;
    }

    public String getTenMon() { return tenMon; }
    public float getDonGia() { return donGia; }

    public static MonHoc fromTenMon(String tenMon) {
        for (MonHoc mh : values()) {
            if (mh.tenMon.equalsIgnoreCase(tenMon)) return mh;
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("%s (%,.0f VNĐ/tín chỉ)", tenMon, donGia);
    }
}