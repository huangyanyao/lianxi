package duotai;

public class Test {

    public static void main(String[] args) {
        //多态
        Animal an = new Cat();
        Girl girl = new Girl();
        girl.play(an);//这个an是Cat对象的;Animal an = new Cat();
    }

}
