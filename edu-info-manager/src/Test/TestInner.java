package Test;

public class TestInner {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.show();
    }
}

class Outer {
    class Inner {
        int num = 10;
        public void show(){
            System.out.println("Inner...show");
        }
    }
}
