package javaAccessModifier.phuongKhueTrung;

import javaAccessModifier.phuongHoaAn.FPTCorporation;

public class VinGroup {
    //Pham vi ngoai Class va trong khac package
    public void showTVName() {
        FPTCorporation fpt = new FPTCorporation();
        fpt.setTvName();
        fpt.tvName = "VinGroup LED";
//        fpt.protectedTvName = "VinGroup OLED";
//        fpt.setProtectedTvName(); protected không cùng package -> khong truy cap duoc
//        fpt.setDefaultTvName(); default không cùng package -> khong truy cap duoc
    }
}
