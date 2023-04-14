package Test;

public class AnonymousClass {
    public static void main(String[] args) {
        goSwimming(() -> System.out.println("go swimming！"));                                           //匿名内部类作为函数参数
        goSwimming(() -> {
            System.out.println("go swimming！");
        });                                           //lambda表达式 ()->{}
    }

    public static void goSwimming(Swimming swimming) {
        swimming.swim();
    }
}

interface Swimming {
    void swim();
}
