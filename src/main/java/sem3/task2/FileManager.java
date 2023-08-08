package sem3.task2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.Scanner;

public class FileManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите комманду (edit/read/copy): ");
        String command = sc.nextLine();

        if (Objects.equals(command, "edit")) {

            System.out.print("Введите назване файла: ");
            File file = new File(sc.nextLine());

            try {
                checkFile(file);
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

            System.out.print("Введите текст: ");
            String text = sc.nextLine();

            editFile(file, text);

        } else if (Objects.equals(command, "read")) {

            System.out.print("Введите назване файла: ");
            File file = new File(sc.nextLine());

            try {
                checkFile(file);
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

            readFile(file);

        } else if (Objects.equals(command, "copy")) {

            System.out.print("Введите назване файла: ");
            File file1 = new File(sc.nextLine());

            try {
                checkFile(file1);
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

            System.out.print("Введите назване нового файла: ");
            File file2 = new File(sc.nextLine());

            try {
                checkFile(file2);
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

            copyFile(file1, file2);
        }
    }

    public static void editFile(File file, String text) {
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readFile(File file) {
        try (FileReader reader = new FileReader(file)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void copyFile(File src, File dest) {
        try {
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void checkFile(File file) throws FileNotFoundException {
        if (!file.exists())
            throw new FileNotFoundException("Файл не найден");
    }
}
