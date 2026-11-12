package Tuan3;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
public class HangThucPham {

	private int mahang;
	private String tenhang;
	private  LocalDate NXS;
	private LocalDate HSD;
	private int dongia;
	public int getDongia() {
		return dongia;
	}
	public void setDongia(int dongia) {
		this.dongia = dongia;
	}
	public int getMahang() {
		return mahang;
	}
	public void setMahang(int mahang) {
		this.mahang = mahang;
	}
	public String getTenhang() {
		return tenhang;
	}
	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}
	public LocalDate getNXS() {
		return NXS;
	}
	public void setNXS(LocalDate nXS) {
		NXS = nXS;
	}
	public LocalDate getHSD() {
		return HSD;
	}
	public void setHSD(LocalDate hSD) {
		HSD = hSD;
	}
	public HangThucPham(int mahang, String tenhang, LocalDate nXS, LocalDate hSD, int dongia) {
	    this.mahang = mahang;
	    this.tenhang = tenhang;
	    NXS = nXS;
	    HSD = hSD;
	    this.dongia = dongia;
	}
	public HangThucPham() {
	    this.mahang = 0;
	    this.tenhang = "xxx";
	    this.NXS = LocalDate.now();
	    this.HSD = this.NXS.plusDays(30);
	    this.dongia = 0;
	}
	public HangThucPham(int mahang) {
	    if (mahang <= 0) {
	        throw new IllegalArgumentException("Ma hang phai lon hon 0");
	    }
	    this.mahang = mahang;
	    this.tenhang = "xxx";
	    this.NXS = LocalDate.now();
	    this.HSD = this.NXS.plusDays(30);
	    this.dongia = 0;
	}
	public Boolean hethan()
	{
		 return HSD.isBefore(LocalDate.now());
	}
	public String toString() {
	    DecimalFormat df = new DecimalFormat("#,##0.00");
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    return String.format("%-10s %-15s %15sVND %15s %15s",
	            mahang,
	            tenhang,
	            df.format(dongia),
	            NXS.format(dtf),
	            HSD.format(dtf));
	}
	
}
