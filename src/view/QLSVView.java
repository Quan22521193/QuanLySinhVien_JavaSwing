package view;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.ScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.TreeSet;

public class QLSVView extends JFrame {

    private static final long serialVersionUID = 1L;
    public JComboBox comboBox_Birthplace_Search;
    private JPanel contentPane;
    public QLSVModel model;
    public JTextField textField_StudenID_Search;
    public JTable table_1;
    public JTextField textField_ID;
    public JTextField textField_Name;
    public JTextField textField_Date;
    public JTextField textField_Math;
    public JTextField textField_Physical;
    public JTextField textField_Chemistry;
    public JComboBox comboBox_BirthPlace;
    public ButtonGroup btn_gioiTinh;
    public JRadioButton button_Man;
    public JRadioButton button_Woman;

    /**
     * Create the frame.
     */
    public QLSVView() {
        this.model = new QLSVModel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1006, 672);

        // tạo action
        ActionListener action = new QLSVController(this);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuFile = new JMenu("File");
        menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        menuBar.add(menuFile);

        JMenuItem menuOpen = new JMenuItem("Open");
        menuOpen.addActionListener(action);
        menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        menuFile.add(menuOpen);

        JSeparator separator_1 = new JSeparator();
        menuFile.add(separator_1);

        JMenuItem menuSave = new JMenuItem("Save");
        menuSave.addActionListener(action);
        menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        menuFile.add(menuSave);

        JSeparator separator = new JSeparator();
        menuFile.add(separator);

        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.addActionListener(action);
        menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        menuFile.add(menuExit);

        JMenu menuAbout = new JMenu("About");
        menuAbout.addActionListener(action);
        menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        menuBar.add(menuAbout);

        JMenuItem menuAboutME = new JMenuItem("About me");
        menuAboutME.addActionListener(action);
        menuAboutME.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        menuAbout.add(menuAboutME);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.setBounds(464, 181, 1, 1);
        contentPane.add(horizontalBox);

        Box verticalBox_1 = Box.createVerticalBox();
        verticalBox_1.setBounds(120, 214, 1, 1);
        contentPane.add(verticalBox_1);

        JLabel label_Birthplace_Search = new JLabel("BirthPlace");
        label_Birthplace_Search.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_Birthplace_Search.setBounds(32, 30, 89, 41);
        contentPane.add(label_Birthplace_Search);

        JLabel label_StudentID_Search = new JLabel("Student ID");
        label_StudentID_Search.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_StudentID_Search.setBounds(484, 30, 89, 41);
        contentPane.add(label_StudentID_Search);

        textField_StudenID_Search = new JTextField();
        textField_StudenID_Search.setBounds(583, 30, 255, 41);
        contentPane.add(textField_StudenID_Search);
        textField_StudenID_Search.setColumns(10);

        JButton button_Search = new JButton("Search");
        button_Search.addActionListener(action);
        button_Search.setFont(new Font("Tahoma", Font.PLAIN, 15));
        button_Search.setBounds(863, 30, 89, 41);
        contentPane.add(button_Search);

        JButton button_CancelSearch = new JButton("Cancel Search");
        button_CancelSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        button_CancelSearch.addActionListener(action);
        button_CancelSearch.setBounds(813, 82, 139, 32);
        contentPane.add(button_CancelSearch);

        comboBox_Birthplace_Search = new JComboBox();
        comboBox_Birthplace_Search.addItem(""); // Thêm mục mặc định
        // thêm tỉnh vào
        ArrayList<Tinh> listTinh = Tinh.getDSTinh();
        for (Tinh tinh : listTinh) {
            comboBox_Birthplace_Search.addItem(tinh.getTenTinh());
        }
        comboBox_Birthplace_Search.setSelectedIndex(0); // Đặt mục mặc định là mục đầu tiên
        comboBox_Birthplace_Search.setBounds(128, 30, 287, 41);
        contentPane.add(comboBox_Birthplace_Search);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(32, 82, 920, 2);
        contentPane.add(separator_2);

        JLabel label_ListStudent = new JLabel("List Student");
        label_ListStudent.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_ListStudent.setBounds(32, 82, 233, 41);
        contentPane.add(label_ListStudent);

        table_1 = new JTable();
        table_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        table_1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "ID", "Name", "Place", "Date", "Sex", "Math", "Physical", "Chemistry"
                }
        ));
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBounds(32, 122, 920, 205);
        contentPane.add(scrollPane);

        JSeparator separator_2_1 = new JSeparator();
        separator_2_1.setBounds(32, 338, 920, 2);
        contentPane.add(separator_2_1);

        JLabel label_StudentInformation = new JLabel("Student information");
        label_StudentInformation.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_StudentInformation.setBounds(32, 337, 255, 32);
        contentPane.add(label_StudentInformation);

        JLabel label_ID = new JLabel("ID");
        label_ID.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_ID.setBounds(32, 365, 119, 30);
        contentPane.add(label_ID);

        textField_ID = new JTextField();
        textField_ID.setBounds(151, 365, 233, 32);
        contentPane.add(textField_ID);
        textField_ID.setColumns(10);

        textField_Name = new JTextField();
        textField_Name.setColumns(10);
        textField_Name.setBounds(151, 400, 233, 32);
        contentPane.add(textField_Name);

        textField_Date = new JTextField();
        textField_Date.setColumns(10);
        textField_Date.setBounds(151, 471, 233, 32);
        contentPane.add(textField_Date);

        JLabel label_Name = new JLabel("Name");
        label_Name.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_Name.setBounds(32, 400, 119, 30);
        contentPane.add(label_Name);

        JLabel label_BirthPlace = new JLabel("BirthPlace");
        label_BirthPlace.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_BirthPlace.setBounds(32, 435, 119, 30);
        contentPane.add(label_BirthPlace);

        JLabel label_Date = new JLabel("Date");
        label_Date.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_Date.setBounds(32, 473, 119, 30);
        contentPane.add(label_Date);

        JLabel label_Sex = new JLabel("Sex");
        label_Sex.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_Sex.setBounds(32, 510, 119, 30);
        contentPane.add(label_Sex);

        textField_Math = new JTextField();
        textField_Math.setColumns(10);
        textField_Math.setBounds(719, 366, 233, 32);
        contentPane.add(textField_Math);

        textField_Physical = new JTextField();
        textField_Physical.setColumns(10);
        textField_Physical.setBounds(719, 400, 233, 32);
        contentPane.add(textField_Physical);

        textField_Chemistry = new JTextField();
        textField_Chemistry.setColumns(10);
        textField_Chemistry.setBounds(719, 435, 233, 32);
        contentPane.add(textField_Chemistry);

        JLabel label_Math = new JLabel("Math");
        label_Math.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_Math.setBounds(533, 365, 119, 30);
        contentPane.add(label_Math);

        JLabel label_Physical = new JLabel("Physical");
        label_Physical.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_Physical.setBounds(533, 400, 119, 30);
        contentPane.add(label_Physical);

        JLabel label_Chemistry = new JLabel("Chemistry");
        label_Chemistry.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_Chemistry.setBounds(533, 435, 119, 30);
        contentPane.add(label_Chemistry);

        comboBox_BirthPlace = new JComboBox();
        comboBox_BirthPlace.addItem("Choose BirthPlace"); // Thêm mục mặc định
        ArrayList<Tinh> listTinh1 = Tinh.getDSTinh();
        for (Tinh tinh : listTinh1) {
            comboBox_BirthPlace.addItem(tinh.getTenTinh());
        }
        comboBox_BirthPlace.setSelectedIndex(0); // Đặt mục mặc định là mục đầu tiên
        comboBox_BirthPlace.setBounds(151, 435, 233, 30);
        contentPane.add(comboBox_BirthPlace);


        button_Man = new JRadioButton("Man");
        button_Man.setBounds(151, 516, 109, 23);
        contentPane.add(button_Man);

        button_Woman = new JRadioButton("Woman");
        button_Woman.setBounds(275, 516, 109, 23);
        contentPane.add(button_Woman);

        // xử lý chọn button giới tính
        btn_gioiTinh = new ButtonGroup();
        btn_gioiTinh.add(button_Man);
        btn_gioiTinh.add(button_Woman);


        JButton button_Insert = new JButton("Insert");
        button_Insert.addActionListener(action);
        button_Insert.setBounds(32, 548, 109, 47);
        contentPane.add(button_Insert);

        JButton button_Delete = new JButton("Delete");
        button_Delete.addActionListener(action);
        button_Delete.setBounds(211, 548, 109, 47);
        contentPane.add(button_Delete);

        JButton button_Update = new JButton("Update");
        button_Update.addActionListener(action);
        button_Update.setBounds(394, 548, 109, 47);
        contentPane.add(button_Update);

        JButton button_OK = new JButton("OK");
        button_OK.addActionListener(action);
        button_OK.setBounds(583, 548, 109, 47);
        contentPane.add(button_OK);

        JButton button_Cancel = new JButton("Cancel");
        button_Cancel.addActionListener(action);
        button_Cancel.setBounds(758, 548, 109, 47);
        contentPane.add(button_Cancel);

        this.setVisible(true);
    }
    public void Delete_Form() {
        textField_ID.setText("");
        textField_Name.setText("");
        textField_Chemistry.setText("");
        textField_Math.setText("");
        textField_Physical.setText("");
        textField_Date.setText("");
        comboBox_BirthPlace.setSelectedItem(-1);
        btn_gioiTinh.clearSelection();
    }
    public void themThiSinhVaoTable(ThiSinh ts) {
        DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
        // Chuyển đổi đối tượng Date thành chuỗi với định dạng dd/MM/yyyy
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String ngaySinhStr = sdf.format(ts.getNgaySinh());
        model_table.addRow(new Object[] {
                ts.getMaThiSinh()+"",
                ts.getTenThiSinh()+"",
                ts.getQueQuan().getTenTinh(),
                ngaySinhStr,
                (ts.isGioiTinh() ? "Man" : "Woman"),
                ts.getDiemMon1()+"",
                ts.getDiemMon2()+"",
                ts.getDiemMon3()+""});
    }

    public void themHoacCapNhatThiSinh(ThiSinh ts) {
        DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
        // Chuyển đổi đối tượng Date thành chuỗi với định dạng dd/MM/yyyy
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String ngaySinhStr = sdf.format(ts.getNgaySinh());
        if(!this.model.kiemTraTonTai(ts)) { // nếu thí sinh chưa tồn tại thì thêm thí sinh

            // Thêm thông tin thí sinh vào model
            this.model.insert(ts);
            this.themThiSinhVaoTable(ts);
        }else { // nếu thí sinh đã tồn tại thì cập nhật
            this.model.update(ts);
            int soLuongDong = model_table.getRowCount();
            for (int i = 0; i < soLuongDong; i++) {
                String id = model_table.getValueAt(i, 0)+"";
                if(id.equals(ts.getMaThiSinh()+"")) {
                    model_table.setValueAt(ts.getMaThiSinh()+"", i, 0);
                    model_table.setValueAt(ts.getTenThiSinh()+"", i, 1);
                    model_table.setValueAt(ts.getQueQuan().getTenTinh(), i, 2);
                    model_table.setValueAt(ngaySinhStr, i, 3);
                    model_table.setValueAt((ts.isGioiTinh() ? "Man" : "Woman"), i, 4);
                    model_table.setValueAt(ts.getDiemMon1()+"", i, 5);
                    model_table.setValueAt(ts.getDiemMon2()+"", i, 6);
                    model_table.setValueAt(ts.getDiemMon3()+"", i, 7);
                    break;
                }
            }
        }

    }
    public void hienThiThongTinThiSinhDaChon() {
        ThiSinh ts = getThiSinhDangChon();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String ngaySinhStr = sdf.format(ts.getNgaySinh());

        this.textField_ID.setText(ts.getMaThiSinh() + "");
        this.textField_Name.setText(ts.getTenThiSinh() + "");
        this.comboBox_BirthPlace.setSelectedItem(ts.getQueQuan().getTenTinh());
        this.textField_Date.setText(ngaySinhStr); // Hiển thị ngày sinh đã định dạng
        if (ts.isGioiTinh()) {
            button_Man.setSelected(true);
        } else {
            button_Woman.setSelected(false);
        }

        this.textField_Math.setText(ts.getDiemMon1() + "");
        this.textField_Physical.setText(ts.getDiemMon2() + "");
        this.textField_Chemistry.setText(ts.getDiemMon3() + "");
    }
    // Hàm lấy ra thí sinh từ bảng đã chọn
    public ThiSinh getThiSinhDangChon() {
        DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();  // tạo ra default model table
        int i_row = table_1.getSelectedRow(); // lấy ra hàng đã chọn

        int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
        String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
        Tinh tinh = Tinh.getTinhByName(model_table.getValueAt(i_row, 2) + ""); // hàm viết tỉnh đã có sẵn ở Tinh model

        // Chuyển đổi chuỗi ngày sinh thành đối tượng Date
        String ngaySinhStr = model_table.getValueAt(i_row, 3) + "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaySinh = null;
        try {
            ngaySinh = sdf.parse(ngaySinhStr);
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid date of birth. Please re-enter in dd/MM/yyyy format.", "Error: ", JOptionPane.ERROR_MESSAGE);
        }
        String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
        boolean gioiTinh = textGioiTinh.endsWith("Man");

        float Math = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
        float Physical = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
        float Chemistry = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

        ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, Math, Physical, Chemistry);
        return ts;
    }



    public void thucHienXoa() {
        DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();  // tạo ra default model table
        int i_row = table_1.getSelectedRow(); // lấy ra hàng đã chọn

        int luaChon = JOptionPane.showConfirmDialog(this, "Confirm Delete?");
        if (luaChon == JOptionPane.YES_OPTION) {
            ThiSinh ts = getThiSinhDangChon();
            this.model.delete(ts);
            model_table.removeRow(i_row);
        }
    }

    public void ThucHienThemThiSinh() {
        // get data
        int maThiSinh = Integer.valueOf(this.textField_ID.getText());
        String tenThiSinh = this.textField_Name.getText();
        int queQuan_id = this.comboBox_BirthPlace.getSelectedIndex() - 1; // -1 để bỏ qua mục mặc định
        Tinh tinh = Tinh.getTinhById(queQuan_id);

        // Chuyển đổi chuỗi ngày sinh thành đối tượng Date
        String ngaySinhStr = this.textField_Date.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaySinh = null;
        try {
            ngaySinh = sdf.parse(ngaySinhStr);
        } catch (ParseException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ. Vui lòng nhập lại theo định dạng dd/MM/yyyy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean gioiTinh = true;
        if (this.button_Man.isSelected()) {
            gioiTinh = true;
        } else if (this.button_Woman.isSelected()) {
            gioiTinh = false;
        }
        float Math = Float.valueOf(this.textField_Math.getText());
        float Physical = Float.valueOf(this.textField_Physical.getText());
        float Chemistry = Float.valueOf(this.textField_Chemistry.getText());

        ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, Math, Physical, Chemistry);
        this.themHoacCapNhatThiSinh(ts);
    }
    public void thucHienTim() {
        // gọi hàm hủy tìm để reset lại danh sách rồi mới tìm lại
        this.thucHienHuyTim();
        // Tạo tập hợp để lưu ID của các thí sinh cần xóa
        Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();

        // Lấy từ khóa tìm kiếm ID thí sinh
        String idTS_Search = this.textField_StudenID_Search.getText();
        // Lấy chỉ số quê quán từ combobox
        int queQuan = this.comboBox_Birthplace_Search.getSelectedIndex() - 1; // -1 để bỏ qua mục mặc định

        // Lấy mô hình bảng và số lượng dòng hiện tại
        DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
        int soLuongDong = model_table.getRowCount();

        // Kiểm tra quê quán nếu đã chọn
        if (queQuan >= 0) {
            Tinh tinhDaChon = Tinh.getTinhById(queQuan);
            for (int i = 0; i < soLuongDong; i++) {
                String tenTinh = model_table.getValueAt(i, 2) + "";
                String id = model_table.getValueAt(i, 0) + "";
                if (!tenTinh.equals(tinhDaChon.getTenTinh())) { // So sánh tên tỉnh
                    try {
                        idCuaThiSinhCanXoa.add(Integer.valueOf(id));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // Kiểm tra từ khóa ID thí sinh nếu đã nhập
        if (idTS_Search.length() > 0) {
            for (int i = 0; i < soLuongDong; i++) {
                String idThiSinhTrongTable = model_table.getValueAt(i, 0) + "";
                if (!idTS_Search.equals(idThiSinhTrongTable)) {
                    try {
                        idCuaThiSinhCanXoa.add(Integer.valueOf(idThiSinhTrongTable));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        // Xóa các hàng tương ứng với ID trong tập hợp
        for (Integer idCanXoa : idCuaThiSinhCanXoa) {
            for (int i = 0; i < soLuongDong; i++) {
                String idTrongTable = model_table.getValueAt(i, 0) + "";
                if (idTrongTable.equals(idCanXoa.toString())) {
                    model_table.removeRow(i);
                    soLuongDong--; // Giảm số lượng dòng sau khi xóa
                    break; // Thoát khỏi vòng lặp sau khi xóa
                }
            }
        }
    }

    public void thucHienHuyTim() {
        DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
        model_table.setRowCount(0); // Xóa tất cả các hàng

        // Thêm lại tất cả thí sinh từ model
        for (Object ts : this.model.getDsThiSinh()) {
            this.themThiSinhVaoTable((ThiSinh) ts);
        }
    }

    public void hienThiAbout() {
        JOptionPane.showMessageDialog(this, "This is an application to manage exam scores\n" +
                "Please select the function you want to perform\n" +
                "Thank you!", "About", JOptionPane.INFORMATION_MESSAGE);
    }

    public void thoatKhoiChuongTrinh() {
        int luaChon = JOptionPane.showConfirmDialog(this, "Confirm Exit?", "Exit", JOptionPane.YES_NO_OPTION);
        if (luaChon == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

//    public void thucHienLuu() {
//        if (this.model.getTenFile().length() > 0) {
//            saveFile(this.model.getTenFile())
//        }else {
//
//        }
//    }
//
//    public void thucHienMo() {
//    }
}
