public class Main {

    public static void main(String[] args) {
        try {
            ExecutorServiceImpl service = new ExecutorServiceImpl(5);
            service.start();
            System.out.println("****************Service Start****************");
            service.stop();
            System.out.println("****************Service Stop****************");
        } catch (Exception e) {
            System.err.println("New service thow exception!");
        }
    }
}
