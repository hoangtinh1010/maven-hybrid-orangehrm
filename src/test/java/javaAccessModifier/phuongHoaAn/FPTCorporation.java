package javaAccessModifier.phuongHoaAn;

public class FPTCorporation {
    //Thuộc tính
    public String tvName;
    protected String protectedTvName;
    String defaultTvName; //default



    //Phương thức
    public void setTvName() {
        System.out.println(tvName);;
    }

    protected void setProtectedTvName() {
        System.out.println(protectedTvName);;
    }

    void setDefaultTvName() {
        System.out.println(defaultTvName);;
    }

    private void setPrivateTvName() {
        System.out.println("Private TV Name");
    }
}
