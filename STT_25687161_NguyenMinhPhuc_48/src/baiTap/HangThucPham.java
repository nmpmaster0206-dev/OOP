package baiTap;

import java.time.LocalDate;

public class HangThucPham implements Comparable<HangThucPham> {

	private int id; 
	private final String maHang;
	private String tenHang;
	private LocalDate ngaySX;
	private LocalDate ngayHH;
	private float gia;
	
	private static int demSoLuong = 0;

	// Constructor mặc định (Không tham số)
	public HangThucPham() {
		this.id = ++demSoLuong;
		this.maHang = "MH" + this.id; 
		this.tenHang = "Hang_Mac_Dinh";
		this.ngaySX = LocalDate.now();
		this.ngayHH = LocalDate.now().plusDays(7); 
		this.gia = 1.0f;
	}
	
	// Constructor đầy đủ tham số (Đã bỏ id ra khỏi tham số vì id tự tăng)
	public HangThucPham(String maHang, String tenHang, LocalDate ngaySX, LocalDate ngayHH, float gia) {
		this.id = ++demSoLuong;
		if (maHang == null || maHang.trim().isEmpty())
			throw new IllegalArgumentException("Ma hang khong duoc de trong!");
		if (tenHang == null || tenHang.trim().isEmpty())
			throw new IllegalArgumentException("Ten hang khong duoc de trong!");
		if (gia <= 0) 
			throw new IllegalArgumentException("Gia phai lon hon 0!");
		if (!kiemTraNgaySX(ngaySX))
			throw new IllegalArgumentException("Ngay san xuat khong duoc la tuong lai!");
		if (!kiemTraNgayHH(ngaySX, ngayHH))
			throw new IllegalArgumentException("Ngay het han phai sau ngay san xuat!");
		this.maHang = maHang; 
		this.tenHang = tenHang;
		this.ngaySX = ngaySX;
		this.ngayHH = ngayHH;
		this.gia = gia;
	}

	public String getMaHang() {
		return maHang;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		if (tenHang == null || tenHang.trim().isEmpty())
			throw new IllegalArgumentException("Ten hang khong duoc de trong!");
		this.tenHang = tenHang;
	}
	public LocalDate getNgaySX() {
		return ngaySX;
	}
	public void setNgaySX(LocalDate ngaySX) {
		if (!kiemTraNgaySX(ngaySX))
			throw new IllegalArgumentException("Ngay san xuat khong duoc la tuong lai!");
		if (this.ngayHH != null && !kiemTraNgayHH(ngaySX, this.ngayHH))
			throw new IllegalArgumentException("Ngay het han phai sau ngay san xuat!");
		this.ngaySX = ngaySX;
	}
	public LocalDate getNgayHH() {
		return ngayHH;
	}
	public void setNgayHH(LocalDate ngayHH) {
		if (this.ngaySX == null)
			throw new IllegalArgumentException("Chua co ngay san xuat");
		if (!kiemTraNgayHH(this.ngaySX,ngayHH))
			throw new IllegalArgumentException("Ngay het han phai sau ngay san xuat!");
		this.ngayHH = ngayHH;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		if (gia <= 0) 
			throw new IllegalArgumentException("Gia phai lon hon 0!");
		this.gia = gia;
	}
	public static int getDemSoLuong() {
		return demSoLuong;
	}
	public static void setDemSoLuong(int demSoLuong) {
		HangThucPham.demSoLuong = demSoLuong;
	}
	
	//--Kiem tra ngay san xuat--
	private boolean kiemTraNgaySX(LocalDate ngaySX) {
		return ngaySX != null && !ngaySX.isAfter(LocalDate.now());
	}
	
	private boolean kiemTraNgayHH(LocalDate ngaySX, LocalDate ngayHH) {
		return ngaySX != null && ngayHH != null && ngayHH.isAfter(ngaySX);
	}
	
	//--Kiem tra het han--
	public boolean kiemTraHH() {
		return LocalDate.now().isAfter(this.ngayHH);
	}
	
	public String trangThaiChiTiet() {
		LocalDate homNay = LocalDate.now();
		if (homNay.isBefore(ngaySX)) return "Chua san xuat";
		if (homNay.isAfter(ngayHH)) return "Het han";
		if (homNay.isEqual(ngayHH)) return "Het han hom nay";
		long con = ngayHH.toEpochDay() - homNay.toEpochDay();
		return "Con " + con + "ngay"; 
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("khong the sao chep");
	}
	@Override
	public String toString() {
	    return String.format (
	            "| %-4d | %-10s | %-18s | %-12s | %-12s | %,-10.0f",
	            id, maHang, tenHang, ngaySX, ngayHH, gia);
	}
	public int compareTo(HangThucPham o ) {
		return Integer.compare(this.id, o.id);
	}


	
	
}