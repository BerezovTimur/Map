package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileOpenManagerTest {
    private FileOpenManager manager = new FileOpenManager();

    private String html = "html";
    private String xml = "xml";
    private String jpg = "jpg";
    private String doc = "doc";
    private String gif = "gif";
    private String chrome = "Chrome";
    private String xnview = "XNView";
    private String word = "Word";

    @BeforeEach
    void setup() {
        manager = new FileOpenManager();
        manager.newApplication(html, chrome);
        manager.newApplication(xml, chrome);
        manager.newApplication(jpg, xnview);
        manager.newApplication(doc, word);
        manager.newApplication(gif, xnview);
    }

    @Test
    void shouldGetApp() {
        assertEquals(chrome, manager.getApplication(html));
    }

    @Test
    void shouldAddAll() {
        HashMap<String, String> expected = new HashMap<>();
        expected.put(html, chrome);
        expected.put(xml, chrome);
        expected.put(jpg, xnview);
        expected.put(doc, word);
        expected.put(gif, xnview);
        assertEquals(expected, manager.getMaps());
    }

    @Test
    void shouldRemoveKey() {
        HashMap<String, String> expected = new HashMap<>();
        expected.put(html, chrome);
        expected.put(jpg, xnview);
        expected.put(doc, word);
        expected.put(gif, xnview);
        manager.removeKey(xml);
        assertEquals(expected, manager.getMaps());
    }

    @Test
    void shouldGetAllKeysSorted() {
        List<String> expected = new ArrayList<>();
        expected.addAll(List.of(doc, gif, html, jpg, xml));
        List<String> actual = manager.getAllKeys();
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetAllValuesSorted() {
        List<String> expected = new ArrayList<>();
        expected.addAll(List.of(chrome, word, xnview));
        List<String> actual = manager.getAllValues();
        assertEquals(expected, actual);
    }
}
