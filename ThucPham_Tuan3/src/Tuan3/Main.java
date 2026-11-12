package Tuan3;
import java.time.LocalDate;
public class Main {
	public static void main(String[] args) {
		        HangThucPham h1 = new HangThucPham(
		                1,
		                "Gao",
		                LocalDate.of(2026, 8, 1),
		                LocalDate.of(2026, 9, 1),
		                100000
		        );

		        HangThucPham h2 = new HangThucPham(
		                2,
		                "Sua",
		                LocalDate.of(2026, 8, 10),
		                LocalDate.of(2026, 9, 10),
		                20000
		        );

		        HangThucPham h3 = new HangThucPham(
		                3,
		                "Banh",
		                LocalDate.of(2026, 8, 15),
		                LocalDate.of(2026, 8, 30),
		                15000
		        );
		        System.out.printf("%-10s %-15s %15s %15s %15s %15s%n",
		                "Ma hang", "Ten hang", "Don gia", "Ngay SX", "Han SD", "Ghi chú");
		        System.out.println("---------------------------------------------------------------------");
		        System.out.println(h1 + (h1.hethan() ? "      Het han" : ""));
		        System.out.println(h2 + (h2.hethan() ? "      Het han" : ""));
		        System.out.println(h3 + (h3.hethan() ? "      Het han" : ""));
		    } 
}

