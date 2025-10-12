package java8.lamda;

public class First {
    public static void main(String[] args) {
        // simple
        SecIml s = new SecIml();
        Sec s1 = new SecIml();// sec parent
        s.sayHello();
        s1.sayHello();

        Sec s3 = new Sec() {
            @Override
            public void sayHello() {
                System.out.println("all are done");
            }
        };
        s3.sayHello();
        // with lamda
        Sec s4 = () -> System.out.println("all are done");
        s4.sayHello();
        
    }

}
