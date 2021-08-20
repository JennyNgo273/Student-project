import java.util.ArrayList;

import java.util.Scanner;

/*
 * Muc Dich: Tao ra de quan ly danh sach nhieu sinh vien
 * Nguoi tao : Duyen Ngo 
 * Ngay tao: 29/05/2021
 * Version: 1.0
 * */
public class DanhSachSinhVien {

	// 1. Attributes/ Data members/ Fields

	private ArrayList<SinhVien> listSV;

	// 2. Get, set methods

	public ArrayList<SinhVien> getListSV() {
		return listSV;
	}

	public void setListSV(ArrayList<SinhVien> listSV) {
		this.listSV = listSV;
	}

	// 3. Constructor methods

	public DanhSachSinhVien() {
		thietLapDefault();
	}

	// hàm này dùng để khởi động các list và các giá trị mặc định cho lớp
	private void thietLapDefault() {
		this.listSV = new ArrayList<SinhVien>();
	}

	// 4. Input, Output methods
	public void nhap(Scanner scan) {
		for (SinhVien sv : this.listSV) {
			sv.nhap(scan);
		}
	}

	public void themSinhVien(SinhVien sv) {
		this.listSV.add(sv);
	}

	public void xuat() {
		for (SinhVien sv : this.listSV) {
			sv.xuat();
		}
	}

	// 5. Business methods
	public void tinhDTB() {
		for (SinhVien sv : this.listSV) {
			sv.tinhDiemTB();
		}
	}

	public void xepLoai() {
		for (SinhVien sv : this.listSV) {
			sv.xepLoai();
		}
	}

	// Tim danh sach co diem TB cao Nhat.
	public ArrayList<SinhVien> timDSSVCoDTBCaoNHat() {

		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		// loi 1
		if (this.listSV.size() > 0) {
			SinhVien svMax = this.listSV.get(0);
			// int i = 0;
			int viTriMaxDAuTien = 0;
			for (int i = 0; i < this.listSV.size(); i++) {
				SinhVien svCurrent = this.listSV.get(i);
				if (svCurrent.getDiemTB() > svMax.getDiemTB()) {
					svMax = svCurrent;
					viTriMaxDAuTien = i;
				}
			}
			// Them svMax vao list
			list.add(svMax);

			// Da tim thay diem TB Max (svMax)
			for (int i = viTriMaxDAuTien + 1; i < this.listSV.size(); i++) {
				SinhVien svCurrent = this.listSV.get(i);
				if (svCurrent.getDiemTB() == svMax.getDiemTB()) {
					list.add(svCurrent);
				}
			}
		}
		return list;
	}
	//Tim danh sach cac sv yeu
	public ArrayList<SinhVien> timDSSVyeu(){
		ArrayList<SinhVien> listYeu = new ArrayList<SinhVien>();
		for(SinhVien sv : this.listSV) {
			if(sv.getDiemTB() < 5) {
				listYeu.add(sv);
			}
		}
		
		return listYeu;
	}
	//Tim DSSV theo Ten
	public ArrayList<SinhVien> timSVtheoTen(String ten){
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		for(SinhVien sv: this.listSV) {
			if(sv.getHoTen().equalsIgnoreCase(ten)) {
				list.add(sv);
			}
		}
		return list;
	}
	//Tim DSSV theo maSV
//	public ArrayList<SinhVien> timSVtheoMa(int maSV){
//		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
//		for(SinhVien sv: this.listSV) {
//			if(sv.getmaSV() == maSV) {
//				list.add(sv);
//			}
//		}
//		
//		return list;
//	}
	
	public SinhVien timSVtheoMa(int ma) {
		SinhVien sv = null; //chua tim thay
		for(SinhVien sv1: this.listSV) {
			if(sv1.getmaSV() == ma) {
				sv = sv1;//Da tim thay
				break;//thoat khoi vong lap
			}
		}
		
		return sv;
	}
	
	public boolean xoaSvtheoMa(int ma) {
		boolean deleted = false;
		for(SinhVien sv: this.listSV) {
			if(sv.getmaSV() == ma) {
				this.listSV.remove(sv);
				deleted = true;
				break;//thoat khoi vong lap
			}
		}
		return deleted;
	}

}
