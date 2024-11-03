package app;

import java.util.concurrent.atomic.AtomicInteger;

public class DataHandler {
    // Отримуємо дані з DataRepository
    private final String[] fruits = new DataRepository().getData();

    // Метод для форматованого виведення фруктів
    public synchronized void getOutput() {
        StringBuilder sb = new StringBuilder();
        AtomicInteger count = new AtomicInteger(1);

        for (String fruit : fruits) {
            sb.append(String.format("(%d) %s ", count.getAndIncrement(), fruit));
        }

        // Виводимо результат разом з назвою потоку
        System.out.println(Thread.currentThread().getName() + ": " + sb);
    }
}
