import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int luaChon;
        String tiepTuc;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("---Menu--");
            System.out.print("1: Thêm \n" +
                    "2:Xóa thẻ theo mã \n" +
                    "3: Hiện thị \n" +
                    "4: Tính tiền điện \n"
            );
            System.out.print("Nhập giá trị bạn muốn xem: ");
            luaChon = sc.nextInt();
            if (luaChon > 4 || luaChon < 0) {
                System.out.print("Nhập lại giá trị bạn muốn xem: ");
                luaChon = sc.nextInt();
            }
            switch (luaChon) {
                case 1:
                    Function.them();
                    break;
                case 2:
                    Function.xoa();
                    break;
                case 3:
                    Function.hienThi();
                    break;
                case 4:
                    Function.tinhTienDien();
                    break;
            }
            System.out.print("Bạn có muốn tiếp tục không nếu muốn hãy ấn yes,y, nếu không hay ấn no: ");
            tiepTuc = sc.next();
        } while (tiepTuc.equalsIgnoreCase("y") || tiepTuc.equalsIgnoreCase("yes"));
    }
}
