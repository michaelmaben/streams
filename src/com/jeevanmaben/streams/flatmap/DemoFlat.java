package com.jeevanmaben.streams.flatmap;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoFlat {
    public static void main(String[] args){
        Book b1 = new Book(Arrays.asList(("Harry Potter killed Lord Voldemort").split(" ")));
        Book b2 = new Book(Arrays.asList(("Harry Potter becomes friends with Ronald Weasley").split(" ")));

        //using flatmap
        Set<String> words = Arrays.asList(b1, b2)
                .stream()
                .flatMap(b->b.getWords().stream())
                .collect(Collectors.toSet());
        System.out.println("List of unique words in books::");
        words.stream().sorted().forEach(System.out::println);

        //using map
        Arrays.asList(b1, b2)
                .stream()
                .map(Book::getWords)
                .forEach(wordList -> {
                    for (String word: wordList) {
                        words.add(word);
                    }
                });
        System.out.println("List of unique words in books::");
        words.stream().sorted().forEach(System.out::println);

    }
}

class Book{
    private List<String> words;

    public List<String> getWords() {
        return words;
    }

    Book(List<String> words){
        this.words = words;
    }
}