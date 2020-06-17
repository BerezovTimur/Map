package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor

public class FileOpenManager {
    HashMap<String, String> maps = new HashMap<>();

    public HashMap<String, String> getMaps() {
        return maps;
    }

    public void newApplication(String extension, String application) {
        maps.put(extension, application);
    }

    public String getApplication(String application) {
        return maps.get(application);
    }

    public void removeKey(String application) {
        maps.remove(application);
    }

    public List<String> getAllKeys() {
        Set<String> application = new HashSet<>();
        application.addAll(maps.keySet());
        ArrayList<String> list = new ArrayList<>(application);
        list.sort(Comparator.naturalOrder());
        return list;
    }

    public List<String> getAllValues() {
        Set<String> app = new HashSet<>();
        app.addAll(maps.values());
        ArrayList<String> list = new ArrayList<>(app);
        list.sort(Comparator.naturalOrder());
        return list;
    }
}
