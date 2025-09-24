import Name.*;

public class Client {
    private final Name jsAdapter = new NameAdapter("node","src/script.js", "DANILA");
    private final Name simpleName = new SimpleName("DANILA");

    public void run(){
        System.out.println(simpleName.showName());

        System.out.println(jsAdapter.showName());
    }

}
