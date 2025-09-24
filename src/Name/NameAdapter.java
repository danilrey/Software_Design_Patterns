package Name;

import java.io.*;
import java.util.*;

public class NameAdapter implements Name {
    private final String runner;
    private final String fileName;

    private final String targetName;
    private final Map<Character, Integer> required = new HashMap<>();
    private final Map<Character, Integer> collected = new HashMap<>();

    public NameAdapter(String runner, String fileName, String name) {
        targetName = name;
        this.runner = runner;
        this.fileName = fileName;
        for (char c : targetName.toCharArray()) {
            required.put(c, required.getOrDefault(c, 0) + 1);
        }
    }

    @Override
    public String showName() {
        String result = "";
        Process process = null;
        try {
            process = new ProcessBuilder(runner, fileName)
                    .redirectErrorStream(true)
                    .start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.isEmpty()) continue;
                    char letter = line.charAt(0);
                    if (required.containsKey(letter)) {
                        collected.put(letter, collected.getOrDefault(letter, 0) + 1);
                        System.out.println(letter);
                    }

                    if (hasAll()) {
                        result = targetName;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (process != null && process.isAlive()) {
                process.destroy();
            }
        }
        showCollected();
        return result;
    }

    private boolean hasAll() {
        for (Map.Entry<Character, Integer> need : required.entrySet()) {
            int have = collected.getOrDefault(need.getKey(), 0);
            if (have < need.getValue()) return false;
        }
        return true;
    }

    public void showCollected() {
        for (Map.Entry<Character, Integer> need : collected.entrySet()) {
            System.out.println(need.getKey() + ": " + need.getValue());
        }
    }
}
