import java.util.ArrayList;
import java.util.Scanner;

public class XuLy {

	public XuLy() {
		
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// DanhSachSinhVien ds = new DanhSachSinhVien();
		TruongHoc truong = new TruongHoc();
		truong.nhap();
		doMenu(truong);

	}

	private static void inMenu() {
		System.out.println("Vui long chon thuc hien: ");
		System.out.println("1.Them Sinh Vien");
		System.out.println("2. Xuat Danh sach SV");
		System.out.println("3. Liet ke DSSV có DTB cao nhat: ");
		System.out.println("4. Liet ke DSSV có DTB xep loai yeu: ");
		System.out.println("5. Tim SV theo Ten");
		System.out.println("6. Tim SV theo Ma");
		System.out.println("7. Xoa SV theo Ma");
		System.out.println("0. Thoat");
	}

	private static void doMenu(TruongHoc truong) {
		boolean flag = true;

		Scanner scan = new Scanner(System.in);
		do {
			inMenu();
			System.out.println("Moi Chon");
			int chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1:
				SinhVien sv = new SinhVien();
				sv.nhap(scan);
				truong.themSinhVien(sv);
				break;
			case 2:
				truong.tinhDTB();
				truong.xepLoai();
				//truong.xuat();
				truong.xuatFormat(truong.getDssvToanTruong().getListSV());
				break;
			case 3:
				ArrayList<SinhVien> list = truong.timDSSVCoDTBCaoNHat();
				//truong.xuatHelper(list);
				truong.xuatFormat(list);
//				for(SinhVien sv1 : list) {
//					sv1.xuat(); 
//				}
				break;
			case 4:
				ArrayList<SinhVien> listyeu = truong.timDSSVyeu();
				//truong.xuatHelper(listyeu);
				truong.xuatFormat(listyeu);
//				for(SinhVien sv1 : listyeu) {
//					sv1.xuat(); 
//				}
				break;
			case 5:
				System.out.println("Vui long nhap ten SV can tim");
				String ten = scan.nextLine();
				ArrayList<SinhVien> listTen = truong.timSVtheoTen(ten);
				//truong.xuatHelper(listTen);
				truong.xuatFormat(listTen);
				break;
			case 6:
				System.out.println("Vui long nhap ma SV can tim");
				int ma = Integer.parseInt(scan.nextLine());

				SinhVien sv2 = truong.timSvTheoMa(ma);
				if (sv2 != null) {
					sv2.xuat();
				} else {
					System.out.println("Khong co sinh vien co ma la: " + ma);
				}

				break;
			case 7:
				System.out.println("Vui long nhap ma SV can xoa");
				int ma1 = Integer.parseInt(scan.nextLine());
				boolean deleted = truong.xoaSVtheoMa(ma1);
				if (deleted) {
					System.out.println("Xoa thanh cong");
				} else {
					System.out.println("Xoa khong thanh cong/ ma " + ma1 + " khong co trong danh sach");
				}
				break;
			case 0:
				flag = false;
				break;
			}
		} while (flag);
	}

}
