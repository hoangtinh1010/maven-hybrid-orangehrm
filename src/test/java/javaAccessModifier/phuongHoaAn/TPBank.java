package javaAccessModifier.phuongHoaAn;

public class TPBank {
    //Pham vi ngoai Class nhưng trong cùng package
    public void showTVName() {
        FPTCorporation fpt = new FPTCorporation();
        fpt.tvName = "TPBank LCD";

        fpt.setProtectedTvName();
        fpt.setDefaultTvName();
        fpt.setDefaultTvName();
//        fpt.setPrivateTvName(); private khong phai trong class -> khong truy cap duoc
    }
}
