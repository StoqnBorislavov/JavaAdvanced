package JavaOOP.InterfacesAndAbstraction.Lab.SayHello_03;

public class European extends BasePerson {
    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
