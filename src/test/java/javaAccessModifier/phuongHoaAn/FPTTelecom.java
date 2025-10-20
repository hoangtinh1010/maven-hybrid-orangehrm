package javaAccessModifier.phuongHoaAn;

public class FPTTelecom extends FPTCorporation {
    //Pham vi ngoai Class nhưng trong cùng package thong qua quan he ke thua (inheritance)
    public void showTVName() {
        setTvName();
        tvName = "FPTTelecom LED";
        setProtectedTvName();
        setDefaultTvName();
    }
}
