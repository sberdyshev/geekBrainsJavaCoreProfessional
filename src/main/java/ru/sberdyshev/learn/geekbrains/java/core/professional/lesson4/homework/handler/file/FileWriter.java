package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson4.homework.handler.file;

import java.io.*;

public class FileWriter implements Runnable {
    private MyFile file;
    private String writerName;
    private String dataToWrite;
    private int amountOfLinesToWrite;
    private int maxNumberOfLinesToWriteInARow;

    public FileWriter(String writerName, String dataToWrite, int amountOfLinesToWrite, int maxNumberOfLinesToWriteInARow, MyFile file) {
        this.writerName = writerName;
        this.dataToWrite = dataToWrite;
        this.amountOfLinesToWrite = amountOfLinesToWrite;
        this.maxNumberOfLinesToWriteInARow = maxNumberOfLinesToWriteInARow;
        this.file = file;
    }

    public void writeToAFile() {
        for (int k = 0; k < amountOfLinesToWrite; ) {
            synchronized (file) {
                file.setLockedBy(writerName);
                while (!writerName.equals(file.getLockedBy()) && file.getLockedBy() != null) {
                    try {
                        file.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <= maxNumberOfLinesToWriteInARow; i++) {
                    printLine(dataToWrite + " " + k + "\r\n");
                    k++;
                }
                file.setLockedBy(null);
                file.notifyAll();
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void printLine(String line) {
        try {
            OutputStream os = new BufferedOutputStream(new FileOutputStream(file, true));
            os.write(line.getBytes());
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        writeToAFile();
    }
}
