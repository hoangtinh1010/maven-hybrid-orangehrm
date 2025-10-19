package javaSDET;

//Class  kế thừa class: extends
//Class kế thừa Interface: implements

public interface Topic_02 {
  //default Method
    public default void showStudent() {
        System.out.println("This is a default method in the interface.");
    }

    //abstract Method
    public abstract void clearStudent();
}
