import java.util.Scanner;

/*
 * Muc Dich: Tao ra de quan ly danh sach sinh vien
 * Nguoi tao : Duyen Ngo 
 * Ngay tao: 29/05/2021
 * Version: 1.0
 * */
public class SinhVien {

	// 1. Attributes/ Data members/ Fields
	private String hoTen;
	private int maSV;
	private float diemToan;
	private float diemHoa;
	private float diemLy;
	private float diemTB;
	private String xepLoai;

	// 2. Get, set methods
	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String ten) {
		this.hoTen = ten;
	}

	public int getmaSV() {
		return this.maSV;
	}

	public void setmaSVEmail(String email) {
		this.maSV = maSV;
	}

	public float getDiemToan() {
		return this.diemToan;
	}

	public void setDiemToan(float toan) {
		this.diemToan = toan;
	}

	public float getDiemLy() {
		return this.diemLy;
	}

	public void setDiemLy(float ly) {
		this.diemLy = ly;
	}

	public float getDiemHoa() {
		return this.diemHoa;
	}

	public void setDiemHoa(float hoa) {
		this.diemHoa = hoa;
	}

	public float getDiemTB() {
		return this.diemTB;
	}

	public String getxepLoai() {
		return this.xepLoai;
	}

	// 3. Constructor methods

	public SinhVien() {

	}

	/**
	 * @param hoTen
	 * @param maSV
	 * @param diemToan
	 * @param diemHoa
	 * @param diemLy
	 */
	public SinhVien(String hoTen, int maSV, float diemToan, float diemHoa, float diemLy) {
		// super();
		this.hoTen = hoTen;
		this.maSV = maSV;
		this.diemToan = diemToan;
		this.diemHoa = diemHoa;
		this.diemLy = diemLy;
	}

//	
//	public SinhVien(String ten, int ma, float toan, float ly, float hoa) {
//		this.hoTen = ten;
//		this.maSV = ma;
//		this.diemHoa = hoa;
//		this.diemLy = ly;
//		this.diemToan = toan;
//	}
//	

	// 4. Input, Output methods
	public void nhap(Scanner scan) {
		System.out.println("Nhap ten: ");
		this.hoTen = scan.nextLine();

		System.out.println("Nhap ma SV: ");
		this.maSV = Integer.parseInt(scan.nextLine());

		System.out.println("Nhap diem toan: ");
		this.diemToan = Float.parseFloat(scan.nextLine());

		System.out.println("Nhap diem hoa: ");
		this.diemHoa = Float.parseFloat(scan.nextLine());

		System.out.println("Nhap diem ly: ");
		this.diemLy = Float.parseFloat(scan.nextLine());
	}

	public void xuat() {
		System.out.println(" Sinh Vien - Ma: " + this.maSV + "\t Ten: " + this.hoTen + "\t Toan: " + this.diemToan
				+ "\t Ly : " + this.diemLy + "\t Hoa : " + this.diemHoa + "\t DTB: " + this.diemTB + "\t Xep Loai: "
				+ this.xepLoai);
	}

	// 5. Business methods
	public void tinhDiemTB() {
		this.diemTB = (this.diemToan + this.diemLy + this.diemHoa) / 3;
	}

	public void xepLoai() {
		if (this.diemTB >= 9) {
			this.xepLoai = "Xuat Sac";
		} else if (this.diemTB >= 8) {
			this.xepLoai = "Gioi";
		} else if (this.diemTB >= 7) {
			this.xepLoai = "Kha";
		} else if (this.diemTB >= 6) {
			this.xepLoai = "TB - Kha";
		} else if (this.diemTB >= 5) {
			this.xepLoai = "TB";
		} else {
			this.xepLoai = "Yeu";
		}
	}

	private String formatNumcell(Number num) {
		String paddLeft = "%5s";
		String paddRight = "%-8s";
		return String.format(paddLeft, " ") + String.format(paddRight, num) + "|";
	}

	private String formatTextCell(String text) {
		String paddLeft = "%-15s";
		return String.format(paddLeft, " " + text);
	}

	public void xuatRowFormat() {
		String text;
		text = formatNumcell(this.maSV);
		text += formatTextCell(this.hoTen) + "|";
		text += formatNumcell(this.diemToan);
		text += formatNumcell(this.diemLy);
		text += formatNumcell(this.diemHoa);

		double dtb = Math.round(this.diemTB * 100.0) / 100.0; // Lam tron den 2 chu so phan thap phan
		
		text += formatNumcell(dtb);
		text += formatTextCell(this.xepLoai) + "||";
		
		System.out.println(text);
	}
}
