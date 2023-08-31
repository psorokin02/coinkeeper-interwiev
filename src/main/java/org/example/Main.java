package org.example;

import org.example.brace.BracketService;

public class Main {
    public static void main(String[] args) {
        var service = new BracketService();
        var res = service.searchBrackets("([{}])");
        System.out.println(res);
    }
}