package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson3.homework.processor.file;

import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson3.homework.processor.file.exception.DestinationFileIsADirectoryException;

import java.io.*;

public class FileProcessor {
    private static int pageSize = 1800;

    public static void readFileIntoConsole(String fileName) {
        if (fileName == null) {
            System.out.println("Имя файла не определено");
        } else {
            try {
                FileInputStream fis = new FileInputStream(fileName);
                int byteArrayMaxLengh = 50;
                byte[] buffer = new byte[byteArrayMaxLengh];
                int actualLength = fis.read(buffer);
                byte[] resultArray = new byte[actualLength];
                for (int i = 0; i < actualLength; i++) {
                    resultArray[i] = buffer[i];
                }
                for (byte a : resultArray)
                    System.out.print((char) a);
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void combineFiveFilesIntoOne(String sourceFileName1, String sourceFileName2, String sourceFileName3, String sourceFileName4, String sourceFileName5, String destinationFile) throws IOException {
        if (destinationFile == null || destinationFile.trim().equals("")) {
            System.out.print("Имя конечного файла не определено");
            return;
        }
        appendFileToFile(sourceFileName1, "Первый исходный", destinationFile);
        appendFileToFile(sourceFileName2, "Второй исходный", destinationFile);
        appendFileToFile(sourceFileName3, "Третий исходный", destinationFile);
        appendFileToFile(sourceFileName4, "Четвертый исходный", destinationFile);
        appendFileToFile(sourceFileName5, "Пятый исходный", destinationFile);
    }

    private static void appendFileToFile(String sourceFilePath, String sourceFileDesc, String destinationFilePath) throws DestinationFileIsADirectoryException {
        byte[] resultArray = null;
        //проверки и подготовка чтения исходного файла
        if (isFileOkCheckBeforeReading(sourceFilePath)) {
            File sourceFile = new File(sourceFilePath);
            long sourceFileLength = sourceFile.length();
            resultArray = new byte[(sourceFileLength >= 100L) ? 100 : (int) sourceFileLength];
            //чтение исходного файла
            readBytesFromFile(sourceFilePath, sourceFileDesc, resultArray);
        }
        //проверки и подготовка чтения конечного файла
        if (isFileOkCheckBeforeWriting(destinationFilePath)) {
            //чтение конечного файла
            writeBytesToFile(destinationFilePath, resultArray);
        }
    }

    private static int readBytesFromFile(String sourceFilePath, String sourceFileDesc, byte[] resultArray) {
        int readBytes = 0;
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(sourceFilePath));
            readBytes = is.read(resultArray);
        } catch (FileNotFoundException e) {
            System.out.println(sourceFileDesc + " файл не найден");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Не удалось прочитать " + sourceFileDesc + " файл.");
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return readBytes;
    }

    private static void writeBytesToFile(String destinationFilePath, byte[] sourceArray) {
        if (sourceArray == null) {
            return;
        }
        OutputStream os = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(destinationFilePath, true));
            os.write(sourceArray);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isFileOkCheckBeforeReading(String sourceFilePath) {
        boolean isSuccessResult = true;
        if (sourceFilePath == null) {
            return false;
        }
        File sourceFile = new File(sourceFilePath);
        long sourceFileLength = sourceFile.length();
        if (!sourceFile.exists() || !sourceFile.isFile()) {
            isSuccessResult = false;
        }
        if (sourceFileLength <= 0) {
            return false;
        }
        return isSuccessResult;
    }

    private static boolean isFileOkCheckBeforeWriting(String destinationFilePath) throws DestinationFileIsADirectoryException {
        boolean isSuccessResult = true;
        File destinationFile = new File(destinationFilePath);
        if (!destinationFile.exists()) {
            try {
                if (!destinationFile.createNewFile()) {
                    System.out.println("Не удалось создать файл " + destinationFile.getAbsolutePath());
                    isSuccessResult = false;
                }
            } catch (IOException e) {
                System.out.println("Ошибка при создании файла " + destinationFile.getAbsolutePath());
                e.printStackTrace();
                isSuccessResult = false;
            }
        }
        if (!destinationFile.isFile()) {
            throw new DestinationFileIsADirectoryException(destinationFile.getAbsolutePath() + " является директорией");
        }
        return isSuccessResult;
    }

    public static char[] readHugeFileByPage(String fileName, int pageNumber) {
        checkArguments(fileName, pageNumber);
        char[] buffer = null;
        Reader reader = null;
        try {
            File file = new File(fileName);
            if (!file.exists() || !file.isFile()) {
                return buffer;
            }
            reader = new BufferedReader(new FileReader(fileName));
            buffer = new char[pageSize];
            long numberOfCharsToSkip = (pageNumber - 1) * pageSize;
            if (numberOfCharsToSkip >= file.length()) {
                throw new IllegalArgumentException("Слишком большой номер страницы");
            }
            reader.skip(numberOfCharsToSkip);
            reader.read(buffer, 0, pageSize);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer;
    }

    private static void checkArguments(String fileName, int pageNumber) {
        if (fileName == null) {
            throw new IllegalArgumentException("Имя файла не заполненно");
        }
        if (pageNumber <= 0) {
            throw new IllegalArgumentException("Номер страницы не может быть меньше 1");
        }
    }

}
