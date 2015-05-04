import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * @author aishuyu(asy5178@163.com)
 * @date 2015/05/04 16:02:39
 * @brief use newFixedThreadPool of ExecutorService
 **/
public class ExecutorServiceImpl {

    private int thread_num;
    private ExecutorService service_pool;

    public ExecutorServiceImpl (int thread_num) throws Exception {
        this.thread_num = thread_num;
        if (!init()) {
            throw new Exception();
        }
    }

    public boolean init() {
        service_pool =  Executors.newFixedThreadPool(thread_num);
        if (null == service_pool) {
            return false;
        }
        return true;
    }

    public boolean start() {
        if (null == service_pool) {
            return true;
        }
        int task_num = 20;
        for (int i = 0; i < task_num; ++i) {
            Runnable runner = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Start one thread! " );
                }
            };
            service_pool.execute(runner);
        }
        return true;
    }

    public boolean stop() {
        if (null == service_pool) {
            return false;
        }
        service_pool.shutdown();
        try {
            service_pool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("The service pool has been stopped!!");
        }
        return true;
    }
}
