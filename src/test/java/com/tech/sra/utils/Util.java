package com.tech.sra.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Util {

    public static List<String> getRegistrationNumbers(){
        Pattern p = Pattern.compile("([A-Z]{2}[0-9]{2}[ ]{0,1}[A-Z]{3})");
        Matcher matcher = p.matcher(getFileContentAsString());
        List<String> registrationNumbers = new ArrayList<>();
        while (matcher.find()) {
            registrationNumbers.add(matcher.group());
        }
        return registrationNumbers;
    }

    public static String getFileContentAsString(){
        Path path = Paths.get("src/test/resources/input_data.txt");
        String out = null;
        try {
            out = String.join("\n", Files.readAllLines(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }

    public static List<String> getSortedRegistrationNumbers(){
        return removeAllSpacesFromRegNumbers().stream().sorted().collect(Collectors.toList());
    }

    public static List<String> removeAllSpacesFromRegNumbers(){
        return  getRegistrationNumbers().stream()
                .map(s -> s.replace(" ", ""))
                .collect(Collectors.toList());
    }

    public static void writeToFile() throws IOException {
        FileWriter fileWriter = new FileWriter("src/test/resources/input_test_data.txt");
        PrintWriter out = new PrintWriter(fileWriter);
        for (String outputLine : getSortedRegistrationNumbers()) {
            out.println(outputLine);
        }
        out.flush();
        out.close();
        fileWriter.close();
    }
}
