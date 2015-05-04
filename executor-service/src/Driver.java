
/**
 * @author aishuyu(asy5178@163.com)
 * @date 2015/05/04 16:02:39
 * @brief ExecutorService Driver
 **/
public class Driver {

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
