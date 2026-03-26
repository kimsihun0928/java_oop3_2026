package generic.ch01;

public class ThreeDPrinter2 {

    // 재료
    Powder material;

    // 재료를 꺼낼 수 있는 기능
    public Powder getMaterial() {
        return material ;
    }

    public void setMaterial(Powder material) {
        this.material = material;
    }

    // 재료를 넣을 수 있는 기능

    // 테스트 코드
    public static void main(String[] args) {

        Powder powder = new Powder();
        ThreeDPrinter2 threeDPrinter2 = new ThreeDPrinter2();
        threeDPrinter2.setMaterial(powder);
        System.out.println(threeDPrinter2.getMaterial());

    }

}
