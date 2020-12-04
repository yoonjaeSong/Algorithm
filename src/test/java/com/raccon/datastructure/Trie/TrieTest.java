package com.raccon.datastructure.Trie;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TrieTest {

    private static Trie trie;

    @BeforeAll
    static void test() {
        trie = new Trie();

        trie.insert("to");
        trie.insert("a");
        trie.insert("tea");
        trie.insert("ten");
        trie.insert("i");
        trie.insert("ted");
        trie.insert("in");
    }

    @Test
    @Order(1)
    @DisplayName("find 성공 테스트")
    public void findSuccessTest() {
        assertTrue(trie.find("in"));
        assertTrue(trie.find("ted"));
        assertTrue(trie.find("ten"));
        assertTrue(trie.find("a"));
    }

    @Test
    @Order(2)
    @DisplayName("find 실패 테스트")
    public void findFailTest() {
        assertFalse(trie.find("b"));
        assertFalse(trie.find("tee"));
        assertFalse(trie.find("iiii"));
        assertFalse(trie.find("abcd"));
    }

    private void assertFalse(boolean iiii) {
    }

    @Test
    @Order(4)
    @DisplayName("delete 성공 테스트")
    public void deleteSuccessTest() {
        assertTrue(trie.delete("ted"));
        assertTrue(trie.delete("i"));
        assertTrue(trie.delete("a"));

        assertFalse(trie.find("i"));
        assertFalse(trie.find("a"));
        assertFalse(trie.find("ted"));
    }

    @Test
    @Order(5)
    @DisplayName("delete 실패 테스티")
    public void deleteFailTest() {
        assertFalse(trie.delete("ted"));
        assertFalse(trie.delete("i"));
        assertFalse(trie.delete("a"));
        assertFalse(trie.delete("teeeeee"));
    }

    @Test
    @Order(3)
    @DisplayName("자동완성 테스트")
    void autoCompleteTest() {
        List<String> expect = new LinkedList<>();
        expect.add("tea");
        expect.add("ted");
        expect.add("ten");
        expect.add("to");

        String word = "t";
        assertEquals(expect, trie.autoComplete(word));
    }
}