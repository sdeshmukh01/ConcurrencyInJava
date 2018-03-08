package com.basic.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by himu on 3/5/2018.
 */
public class ZooInfo {

    private static ExecutorService service;

    public static void main(String[] args) {
        try {
            service = Executors.newSingleThreadExecutor();

            System.out.println("begin");
            service.execute(() -> System.out.println("Printing zoo inventory"));
            service.execute(() -> {
                for (int i = 0; i < 3; i++) System.out.println("Printing record " + i);
            });
            service.execute(() -> {
                System.out.println("Printing zoo inventory");
            });
            System.out.println("end");

        } catch (Exception e) {
            if (service != null) service.shutdown();
        }
    }
}
