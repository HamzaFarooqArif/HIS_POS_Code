package command.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Test {

	public static void main(String[] args) {
		Callable<Integer> callable1 = new CallableImpl(1);
		Callable<Integer> callable2 = new CallableImpl(2);
		ExecutorService executor = new ScheduledThreadPoolExecutor(5);
		Future<Integer> future1 = executor.submit(callable1);
		Future<Integer> future2 = executor.submit(callable2);
		try {
			System.out.println("Future1 value: " + future1.get());
			System.out.println("Future2 value: " + future2.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}