public class Client implements Name {
    private final NameAdapter jsAdapter = new NameAdapter("node","src/script.js");

    @Override
    public String showName() {
        return "DANILA";
    }

    public void run(){
        System.out.println(showName());

        System.out.println(jsAdapter.showName());

        jsAdapter.showCollected();
    }

}
