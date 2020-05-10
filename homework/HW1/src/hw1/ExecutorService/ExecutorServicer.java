package hw1.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServicer {
    static class classA{
        String getMethod(){
            return "A.getMethod";
        }
    }
    static class classB{
        String getMethod(){
            return "B.getMethod";
        }
    }
    public static void runSameTime(){
        ExecutorService service = Executors.newCachedThreadPool();
        try {
            Future<String> aFuture = service.submit(()-> new classA().getMethod());
            Future<String> bFutuer = service.submit(()-> new classB().getMethod());

            boolean allDone = false;
            while (!allDone){
                if (aFuture.isDone() && bFutuer.isDone()){
                    System.out.println(bFutuer.get() + " " + aFuture.get());
                    allDone = true;
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            service.shutdown();
        }
    }
    public static void main(String[] args){
        ExecutorServicer executorServicer = new ExecutorServicer();
        executorServicer.runSameTime();
    }
}
