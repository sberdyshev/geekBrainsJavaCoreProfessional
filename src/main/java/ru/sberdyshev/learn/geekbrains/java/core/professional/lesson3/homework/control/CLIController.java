package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson3.homework.control;

import lombok.Getter;
import lombok.Setter;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson3.homework.processor.file.FileProcessor;

import java.util.Scanner;


public class CLIController {
    @Getter
    @Setter
    private String fileName;
    private int errorCount;
    private int maxTryCount;

    public CLIController(String fileName, int maxTryCount) {
        this.fileName = fileName;
        this.errorCount = 0;
        this.maxTryCount = maxTryCount;
    }

    public CLIController() {
        this.errorCount = 0;
        this.maxTryCount = 3;
    }

    public void startReading() {
        System.out.print("Введите имя файла с полным путем без кавычек: ");
        Scanner scanner = new Scanner(System.in);
        setFileName(scanner.nextLine());

        boolean isEnough = false;
        while (!isEnough) {
            if (errorCount >= maxTryCount) {
                System.out.println("\nВы слишком много ошибались. Возможно, вы устали. Отдохните и попробуйте завтра. До свидания.");
                break;
            }
            System.out.print("\nВведите номер страницы: ");
            int pageNumber;
            try {
                pageNumber = scanner.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неверный номер");
                errorCount += 1;
                continue;
            }
            System.out.print("Чтение из файла \"" + fileName + "\"\r\n cо страницы " + pageNumber + ": ");
            try {
                char[] page = FileProcessor.readHugeFileByPage(fileName, pageNumber);
                System.out.println(page != null ? new String(page) : "");
            } catch (IllegalArgumentException e) {
                System.out.print(e.getLocalizedMessage());
                errorCount += 1;
                continue;
            }
        }
    }

}
