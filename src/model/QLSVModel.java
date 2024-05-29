package model;

import java.util.ArrayList;

public class QLSVModel {
    private ArrayList<ThiSinh> dsThiSinh;
    private String luaChon;
    private String tenFile;

    public QLSVModel() {
        this.dsThiSinh = new ArrayList();
        this.luaChon = "";
        this.tenFile="";
    }

    public QLSVModel(ArrayList dsThiSinh) {
        this.dsThiSinh = dsThiSinh;
    }

    public ArrayList getDsThiSinh() {
        return dsThiSinh;
    }

    public void setDsThiSinh(ArrayList dsThiSinh) {
        this.dsThiSinh = dsThiSinh;
    }

    public void insert(ThiSinh thiSinh) {
        this.dsThiSinh.add(thiSinh);
    }

    public void delete(ThiSinh thiSinh) {
        this.dsThiSinh.remove(thiSinh);
    }

    public void update(ThiSinh thiSinh) {
        this.dsThiSinh.remove(thiSinh);
        this.dsThiSinh.add(thiSinh);
    }

    public String getLuaChon() {
        return luaChon;
    }

    public void setLuaChon(String luaChon) {
        this.luaChon = luaChon;
    }

    public String getTenFile() {
        return tenFile;
    }

    public void setTenFile(String tenFile) {
        this.tenFile = tenFile;
    }

    public boolean kiemTraTonTai(ThiSinh ts) {
        for(ThiSinh thiSinh: dsThiSinh) {
            if(thiSinh.getMaThiSinh() == ts.getMaThiSinh())
                return true;
        }
        return false;
    }


}