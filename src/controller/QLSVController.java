package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.ThiSinh;
import model.Tinh;
import view.QLSVView;

public class QLSVController implements ActionListener{
    QLSVView view;

    public QLSVController(QLSVView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
//        JOptionPane.showMessageDialog(view, "you have clicked the " + cm + " button");

        if (cm.equals("Insert")) {
            view.Delete_Form();
            this.view.model.setLuaChon("Insert");
        } else if (cm.equals("OK")) {
            try {
                this.view.ThucHienThemThiSinh();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (cm.equals("Update")) {
            this.view.hienThiThongTinThiSinhDaChon();
        }else if (cm.equals("Delete")) {
            this.view.thucHienXoa();
        }else if (cm.equals("Cancel")) {
            this.view.Delete_Form();
        }else if (cm.equals("Search")) {
            this.view.thucHienTim();
        }else if (cm.equals("Cancel Search")) {
            this.view.thucHienHuyTim();
        }else if (cm.equals("About me")) {
            this.view.hienThiAbout();
        }else if (cm.equals("Exit")) {
            this.view.thoatKhoiChuongTrinh();
        }
//        else if (cm.equals("Save")) {
//            this.view.thucHienLuu();
//        }else if (cm.equals("Open")) {
//            this.view.thucHienMo();
//        }
    }
}
