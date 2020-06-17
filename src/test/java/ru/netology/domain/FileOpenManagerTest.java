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
    private String caps = "HTML";

    @BeforeEach
    void setup() {
        manager = new FileOpenManager();
        manager.newApplication(html, "Chrome");
        manager.newApplication(xml, "Chrome");
        manager.newApplication(jpg, "XNView");
        manager.newApplication(doc, "Word");
        manager.newApplication(gif, "XNView");
    }

    @Test
    void shouldGetApp() {
        assertEquals("Chrome", manager.getApplication(html));
    }

    @Test
    void shouldAddAll() {
        HashMap<String, String> expected = new HashMap<>();
        expected.put(html, "Chrome");
        expected.put(xml, "Chrome");
        expected.put(jpg, "XNView");
        expected.put(doc, "Word");
        expected.put(gif, "XNView");
        assertEquals(expected, manager.getMaps());
    }

    @Test
    void shouldRemoveKey() {
        HashMap<String, String> expected = new HashMap<>();
        expected.put(html, "Chrome");
        expected.put(jpg, "XNView");
        expected.put(doc, "Word");
        expected.put(gif, "XNView");
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
        expected.addAll(List.of("Chrome", "Word", "XNView"));
        List<String> actual = manager.getAllValues();
        assertEquals(expected, actual);
    }
}
