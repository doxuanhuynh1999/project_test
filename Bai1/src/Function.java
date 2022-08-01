import java.nio.channels.ScatteringByteChannel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Function {
    static ArrayList<CanBo> arrayList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    // Thêm danh sách vào trong arrayList
    public static void danhSachThemTruoc(){
        // Thêm Công Nhân
        CongNhan cn1 = new CongNhan("Nguyen","Nam",21,"Nam","HaNoi",9);
        CongNhan cn2 = new CongNhan("Xuan","Huynh",21,"Nam","HaNoi",9);
        CongNhan cn3 = new CongNhan("Do","Thanh",21,"Nam","HaNoi",9);
        arrayList.add(cn1);
        arrayList.add(cn2);
        arrayList.add(cn3);
        // Thêm kỹ sư
        KySu kn1 = new KySu("Do","Ha",21,"Nam","HaNoi","IT1");
        KySu kn2 = new KySu("Don","Hai",21,"Nam","HaNoi","IT1");
        KySu kn3 = new KySu("Dom","Han",21,"Nam","HaNoi","IT1");
        arrayList.add(kn1);
        arrayList.add(kn2);
        arrayList.add(kn3);
        // Them Nhan Vien
        NhanVien nv1 = new NhanVien("Di","Hanh",21,"Nam","HaNoi","IT");
        NhanVien nv2 = new NhanVien("Do","Hau",21,"Nam","HaNoi","IT");
        NhanVien nv3 = new NhanVien("Do","Ham",21,"Nam","HaNoi","IT");
        arrayList.add(nv1);
        arrayList.add(nv2);
        arrayList.add(nv3);
    }
    public static void themCongNhan(){
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bai1","root","huynh28011999");
            System.out.print("Ho : ");
            String ho = sc.next();
            System.out.print("Ten : ");
            String ten = sc.next();
            System.out.print("Tuoi : ");
            int tuoi = sc.nextInt();
            System.out.print("Gioi tinh : ");
            String gioiTinh = sc.next();
            System.out.print("Dia chi : ");
            String diaChi = sc.next();
            System.out.print("Bac : ");
            int bac = sc.nextInt();
            arrayList.add(new CongNhan(ho,ten,tuoi,gioiTinh,diaChi,bac));
            PreparedStatement preparedStatement = connection.prepareStatement("insert into staff(officer_id,staff_name,age,gender,address,specialized_att) values(?,?,?,?,?,?)");
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,ten);
            preparedStatement.setInt(3,tuoi);
            preparedStatement.setString(4,gioiTinh);
            preparedStatement.setString(5,diaChi);
            preparedStatement.setInt(6,bac);
            int i = preparedStatement.executeUpdate();
            if (i == 0){
                System.out.println("update sql fail");
            }else {
                System.out.println("update success");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void themKySu(){
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bai1","root","huynh28011999");
            System.out.print("Ho : ");
            String ho = sc.next();
            System.out.print("Ten : ");
            String ten = sc.next();
            System.out.print("Tuoi : ");
            int tuoi = sc.nextInt();
            System.out.print("Gioi tinh : ");
            String gioiTinh = sc.next();
            System.out.print("Dia chi : ");
            String diaChi = sc.next();
            System.out.print("Nganh dao tao : ");
            String nghanhDaoTao = sc.next();
            arrayList.add(new KySu(ho,ten,tuoi,gioiTinh,diaChi,nghanhDaoTao));
            PreparedStatement preparedStatement = connection.prepareStatement("insert into staff(officer_id,staff_name,age,gender,address,specialized_att) values(?,?,?,?,?,?)");
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2,ten);
            preparedStatement.setInt(3,tuoi);
            preparedStatement.setString(4,gioiTinh);
            preparedStatement.setString(5,diaChi);
            preparedStatement.setString(6,nghanhDaoTao);
            int i = preparedStatement.executeUpdate();
            if (i == 0){
                System.out.println("update sql fail");
            }else {
                System.out.println("update success");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void themNhanVien(){
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bai1","root","huynh28011999");
            System.out.print("Ho : ");
            String ho = sc.next();
            System.out.print("Ten : ");
            String ten = sc.next();
            System.out.print("Tuoi : ");
            int tuoi = sc.nextInt();
            System.out.print("Gioi tinh : ");
            String gioiTinh = sc.next();
            System.out.print("Dia chi : ");
            String diaChi = sc.next();
            System.out.print("Cong viec : ");
            String congViec = sc.next();
            arrayList.add(new NhanVien(ho,ten,tuoi,gioiTinh,diaChi,congViec));
            PreparedStatement preparedStatement = connection.prepareStatement("insert into staff(officer_id,staff_name,age,gender,address,specialized_att) values(?,?,?,?,?,?)");
            preparedStatement.setInt(1,3);
            preparedStatement.setString(2,ten);
            preparedStatement.setInt(3,tuoi);
            preparedStatement.setString(4,gioiTinh);
            preparedStatement.setString(5,diaChi);
            preparedStatement.setString(6,congViec);
            int i = preparedStatement.executeUpdate();
            if (i == 0){
                System.out.println("update sql fail");
            }else {
                System.out.println("update success");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    //1: them can bo
    public static void themCanBo(){
        int luaChon;
        System.out.println("1: Ban muon them Cong nhan");
        System.out.println("2: Ban muon them Ky Su");
        System.out.println("3: Ban muon them Nhan vien");
        do {
            System.out.print("Lua chon cua ban la: ");
            luaChon = sc.nextInt();
        }while (luaChon != 1 && luaChon != 2 && luaChon != 3);
        if (luaChon == 1){
            themCongNhan();
        }else if (luaChon == 2){
            themKySu();
        }else if (luaChon == 3){
            themNhanVien();
        }
    }
    // 2: Tim kiem theo ten
    public static void timKiem(){
        String tenTimKiem;
        boolean checked = false;
        System.out.print("Ten bban muon tim kiem: ");
        tenTimKiem = sc.next();
        // truong hop co ten trong danh sach
        for (CanBo canBo : arrayList){
            if (canBo.getTen().equalsIgnoreCase(tenTimKiem)){
                canBo.display();
                checked =true;
            }
        }
        // truong hop khong co ten trong danh sach
        if (checked == false){
            System.out.println("khong tim thay");
        }
    }
    // 3: Hien thi danh sach cac can bo
    public static void hienThiDanhSach(){
        for (CanBo canBo : arrayList){
                canBo.display();
        }
    }
}

