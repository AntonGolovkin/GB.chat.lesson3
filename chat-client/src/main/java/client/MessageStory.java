package client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MessageStory {
    private static PrintWriter out;
    private static StringBuilder stringBuilder;

    private static String getHistoryFileNameByLogin(String login) {
        return "MessageStory/story" + login + ".txt";
    }

    public static void start(String login) {
        try {
            out = new PrintWriter(getHistoryFileNameByLogin(login));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void stop() {
        if (out != null) {
            out.close();
        }
    }
    public static void writeMessage(String message) {
        out.println(message);
    }

    public static String showStory(String login) {
        stringBuilder = new StringBuilder();
        try {
            List<String> storyLines = Files.readAllLines(Paths.get(getHistoryFileNameByLogin(login)));
            stringBuilder.append(storyLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}