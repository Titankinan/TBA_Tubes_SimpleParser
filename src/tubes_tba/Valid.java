/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_tba;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Valid {
    public String getValid (String s) {                                         //method yang parameternya string yang berisi token2 (hasil dari method getToken), nanti ngeluarin valid atau ngga sesuai bener ato ngga nya urutan si token
        List<String> list = new ArrayList();                                    //list yang akan diisi token2 yang udah dipisahin pake spasi
        String valid;                                                           //buat di outputin nanti
        String temp = "";
        String state;                                                           //formalitas biar kaya PDA
        boolean notError = true;
        int i = 0;
        while (i < s.length()) {                                                //perulangan dari awal string token sampe akhir
            if (s.charAt(i) == ' ') {                                           //kalo nemu spasi
                list.add(temp);                                                 //dimasukin ke list
                temp = "";                                                      //sama lah ya kaya yang di class token
            } else {
                temp = temp + s.charAt(i);
            }
            i++;
        }
        
        list.add("EOS");                                                        //ini buat nandain ujung kanan inputan itu udah mentok end of string
        i = 0;
        String token1;                                                          //ini buat ngebaca inputan
        String token2;                                                          //ini buat ngebaca inputan sebelah kanannya token1, jadi yang ngebaca inputan ada 2
        Stack stack = new Stack();                                              //stack buat proses PDA menurut CFG
//        int top = 0;                                                          //gakepake asli
        state = "q0";                                                           //mulai dari state q0
        stack.push("#");                                                        //pas mau ke state q1 kan push # dulu ea biar nandai stack paling bawah
//        top++;
        state = "q1";                                                           //pidah ke state q1
        stack.push("S");                                                        //masukin S ke list
//        top++;
        state = "q2";                                                           //pindah ke state q2
        token1 = list.get(i);                                                   //baca inputan ke i
        token2 = list.get(i+1);                                                 //baca inputan sebelah kanannya token1
        while (!"#".equals(stack.peek().toString()) && notError) {              //peek itu ngeliat isi top stack, kalo top stacknya belum # (belum habis) dan belum error lanjut perulangannya

            switch (stack.peek().toString()) {                                  //switch case dari top stack
                //buat yang top nya S
                case "S": if ("3".equals(token2) || "4".equals(token2) || "5".equals(token2) || "8".equals(token2) ||       //kalo top stacknya S, terus token2 nya ngebaca operator and, or, xor, iff
                        "1".equals(token1) || "2".equals(token1) || "6".equals(token1) || "9".equals(token1)) {             //atau si token1 nya ngebaca pqrs, not, if, (
                    stack.pop();                                                // S yang didalem stack di pop
                    stack.push("P");                                            // push dengan P
                } else {
                    notError = false;
                } break;
                //buat yang top nya P
                case "P": if ("1".equals(token1) && ("3".equals(token2) || "4".equals(token2) || "5".equals(token2) || "8".equals(token2))) {           //kalo top stacknya P, token1 baca pqrs, dan token2 nya baca operator and, or, xor, iff
                    stack.pop();                                                //P nya di pop
                    stack.push("P");                                            
                    stack.push("O");
                    stack.push("1");
                } else if ("1".equals(token1) && !"1".equals(token2) && !"2".equals(token2) && !"6".equals(token2) && !"9".equals(token2)) {            //kalo top stacknya P, token1 baca pqrs, dan token2 nya bukan operator and, or, xor, iff
                    stack.pop();
                    stack.push("1");
                } else if ("2".equals(token1) && !"2".equals(token2)) {         //buat yang token1 nya baca not
                    stack.pop();
                    stack.push("S");
                    stack.push("2");
                } else if ("6".equals(token1)) {                                //buat yang token1 nya baca if
                    stack.pop();
                    stack.push("S");
                    stack.push("7");
                    stack.push("S");
                    stack.push("6");
                } else if ("9".equals(token1)) {                                //buat yang token1 nya baca (
                    stack.pop();
                    stack.push("10");
                    stack.push("S");
                    stack.push("9");
                } else {
                    notError = false;                                           //selain itu, langsung error
                } break;
                //buat yang top nya O
                case "O": if ("3".equals(token1)) {                             //buat yang token1 nya baca and
                    stack.pop();
                    stack.push("3");
                } else if ("4".equals(token1)) {                                //buat yang token1 nya baca or
                    stack.pop();
                    stack.push("4");
                } else if ("5".equals(token1)) {                                //buat yang token1 nya baca xor
                    stack.pop();
                    stack.push("5");
                } else if ("8".equals(token1)) {                                //buat yang token1 nya baca iff
                    stack.pop();
                    stack.push("8");
                } else {
                    notError = false;
                } break;
                //buat yang top nya 1
                case "1": if ("1".equals(token1)) {
                    stack.pop();
                    i++;
                    token1 = list.get(i);
                } else {
                    notError = false;
                } break;
                //buat yang top nya 2
                case "2": if ("2".equals(token1)) {
                    stack.pop();
                    i++;
                    token1 = list.get(i);
                } else {
                    notError = false;
                } break;
                //buat yang top nya 3
                case "3": if ("3".equals(token1)) {
                    stack.pop();
                    i++;
                    token1 = list.get(i);
                } else {
                    notError = false;
                } break;
                //buat yang top nya 4
                case "4": if ("4".equals(token1)) {
                    stack.pop();
                    i++;
                    token1 = list.get(i);
                } else {
                    notError = false;
                } break;
                //buat yang top nya 5
                case "5": if ("5".equals(token1)) {
                    stack.pop();
                    i++;
                    token1 = list.get(i);
                } else {
                    notError = false;
                } break;
                //buat yang top nya 6
                case "6": if ("6".equals(token1)) {
                    stack.pop();
                    i++;
                    token1 = list.get(i);
                } else {
                    notError = false;
                } break;
                //buat yang top nya 7
                case "7": if ("7".equals(token1)) {
                    stack.pop();
                    i++;
                    token1 = list.get(i);
                } else {
                    notError = false;
                } break;
                //buat yang top nya 8
                case "8": if ("8".equals(token1)) {
                    stack.pop();
                    i++;
                    token1 = list.get(i);
                } else {
                    notError = false;
                } break;
                //buat yang top nya 9
                case "9": if ("9".equals(token1)) {
                    stack.pop();
                    i++;
                    token1 = list.get(i);
                } else {
                    notError = false;
                } break;
                //buat yang top nya 10
                case "10": if ("10".equals(token1) && ("3".equals(token2) || "4".equals(token2) || "5".equals(token2) || "8".equals(token2))) {
                    stack.pop();
                    i++;
                    token1 =list.get(i);
                    stack.push("P");
                    stack.push("O");
                } else if ("10".equals(token1)) {
                    stack.pop();
                    i++;
                    token1 = list.get(i);
                } else {
                    notError = false;
                } break;
            }
            if (!"EOS".equals(token1)) {                                        //kalo token1 nya belum baca sampe EOS tadi yang di ujung inputan
                token2 = list.get(i+1);                                         //token2 nya lanjut baca sebelah nya token1
            }
        }

        stack.pop();                                                            // kalo udah nyampe sini berarti pop #
        state = "q3";
        
        if ("q3".equals(state) && stack.isEmpty() && "EOS".equals(token1)) {    
            valid = "valid";
        } else {
            valid = "tidak valid";
        }
        
        return valid;
    }
}
