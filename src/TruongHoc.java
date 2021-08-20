import java.util.ArrayList;

/*
 * Muc Dich: Quan ly toan bo nghiep vu cho truong hoc
 * Nguoi Tao: Duyen Ngo
 * Ngay tao: 29/05/2021
 * Version : 1.0
 * */
public class TruongHoc {

	// 1. Attributes
	private DanhSachSinhVien dssvToanTruong;

	// 2. Get, Set methods
	public DanhSachSinhVien getDssvToanTruong() {
		return dssvToanTruong;
	}

	public void setDssvToanTruong(DanhSachSinhVien dssvToanTruong) {
		this.dssvToanTruong = dssvToanTruong;
	}

	// 3. Constructor methods
	public TruongHoc() {
		this.dssvToanTruong = new DanhSachSinhVien();

	}

	// 4. Input, Output
	public void nhap() {
		// dummy data, giu lieu gia
		SinhVien sv = new SinhVien("Lan", 1, 9.2f, 9, 9);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Hung", 2, 4.2f, 4, 5.3f);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Lan", 3, 7.2f, 4, 9);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Yen", 4, 3.2f, 4, 4);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Toan", 5, 9.2f, 9, 10);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Huu", 6, 7.2f, 7, 6);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Ly", 7, 3.2f, 3, 3);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Trung", 8, 9.2f, 10, 10);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Quyen", 9, 9.2f, 10, 10);
		this.dssvToanTruong.themSinhVien(sv);

		sv = new SinhVien("Linh", 10, 5.2f, 5, 6);
		this.dssvToanTruong.themSinhVien(sv);
	}

	public void xuat() {
		this.dssvToanTruong.xuat();
	}

	// 5. Business method

	public void themSinhVien(SinhVien sv) {
		this.dssvToanTruong.themSinhVien(sv);
	}

	public void tinhDTB() {
		this.dssvToanTruong.tinhDTB();
	}

	public void xepLoai() {
		this.dssvToanTruong.xepLoai();
	}

	public ArrayList<SinhVien> timDSSVCoDTBCaoNHat() {
		return this.dssvToanTruong.timDSSVCoDTBCaoNHat();
	}
	
	

	public ArrayList<SinhVien> timDSSVyeu() {
		return this.dssvToanTruong.timDSSVyeu();
	}

	public ArrayList<SinhVien> timSVtheoTen(String tenSV) {
//		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
//		for(SinhVien sv: dssvToanTruong.getListSV()) {
//			//String la object
//			if(sv.getHoTen().equalsIgnoreCase(tenSV)) {
//				list.add(sv);
//				
//			}
//		}
		return this.dssvToanTruong.timSVtheoTen(tenSV);
	}
//	public ArrayList<SinhVien> timSVtheoMa(int maSV){
//		return this.dssvToanTruong.timSVtheoMa(maSV);
//	}

	public SinhVien timSvTheoMa(int ma) {
		return dssvToanTruong.timSVtheoMa(ma);
	}

	public boolean xoaSVtheoMa(int ma) {
		return dssvToanTruong.xoaSvtheoMa(ma);
	}

	public void xuatHelper(ArrayList<SinhVien> list) {
		for (SinhVien sv : list) {
			sv.xuat();
		}
	}

	private void xuatLine() {
		System.out.println(
				"=========================================================================================================================");
	}

	private String formatCell(String paddLeft, String title, String paddRight) {
		return String.format(paddLeft, " ") + title + String.format(paddRight, " ");
	}

	private void xuatRowHeader() {
		String paddString1 = "%3s";
		String paddString2 = "%4s";
		String paddString3 = "%5s";
		String paddString4 = "%6s";

		xuatLine();
		String text;
		text = "||" + formatCell(paddString1, "STT", paddString1) + "|";
		text += formatCell(paddString2, "Ma SV", paddString2) + "|";
		text += formatCell(paddString3, "Ten SV", paddString2) + "|";
		text += formatCell(paddString3, "Toan", paddString2) + "|";
		text += formatCell(paddString3, "Ly", paddString4) + "|";
		text += formatCell(paddString3, "Hoa", paddString3) + "|";
		text += formatCell(paddString3, "DTB", paddString3) + "|";
		text += formatCell(paddString2, "Xep Loai", paddString1) + "||";

		System.out.println(text);
		xuatLine();
	}

	private void xuatCellThuTu(int i) {
		String paddLeft = "%3s";
		String paddRight = "%-6s";
		String text = "||" + String.format(paddLeft, " ") + String.format(paddRight, "" + i) + "|";
		System.out.print(text);
	}

	public void xuatFormat(ArrayList<SinhVien> list) {
		xuatRowHeader();
		int i = 0;
		for (SinhVien sv : list) {
			xuatCellThuTu(i);
			sv.xuatRowFormat();
			i++;
		}
		xuatLine();
	}

}
