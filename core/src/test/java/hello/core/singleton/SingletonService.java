package hello.core.singleton;

public class SingletonService {

    //private 로 접근제어를 둔 뒤 static 으로 영역에 하나만 등록시켜 사용한다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    //생성자를 private 로 외부에서 접근이 불가하게 막아둔다.
    private SingletonService(){};

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }


}//class
