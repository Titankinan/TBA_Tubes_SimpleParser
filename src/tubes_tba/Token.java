/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_tba;
import java.util.*;

public class Token {
    public String getToken (String s) {                                         //method yang parameternya menerima inputan lexic, dan akan merubahnya menjadi token2
        List<String> list = new ArrayList();                                    //list yang akan diisi oleh string dari inputan yang sudah dipisahkan dengan spasi
        String token = "";                                                      //buat nyimpen token2 dari inputan
        int i = 0;
        int j = 0;
        s = s + " ";                                                            //ini ditambahin spasi di ujungnya biar kepisah juga pas di ujung dari string inputan
        boolean notError = true;                                                //buat nge cek yang udah dipisahin tadi suatu lexic yang ato bukan
        String temp = "";                                                       //buat nampung string kalo belum nemu spasi yang nantinya di masukin ke list
        i = 0;
        while (i < s.length()) {                                                //perulangan dari awal string sampe akhir string
            if (s.charAt(i) == ' ') {                                           //kalo nemu spasi
                list.add(temp);                                                 //dimasukin ke list
                temp = "";                                                      //terus dikosongin lagi tempat buat nampungnya, soalnya udah dimasukin ke list
            } else {                                                            //kalo belum nemu spasi
                temp = temp + s.charAt(i);                                      //ya di tampung lah
            }
            i++;
        }

        i = 0;
        while (i < list.size() && notError) {                                   //ini listnya udah berisi inputan yang dipisahin sama spasi
            String cek = list.get(i);                                           //nge cek isi list ke - i
            if ("p".equals(cek) || "q".equals(cek) || "r".equals(cek) || "s".equals(cek)) {         //kalo cek nya (isi list ke - i) sama dengan p ato q ato r ato s // buat yang p q r s
                token = token + "1 ";                                           //berarti tokennya adalah 1, masukin ke string token
            } else if (cek.charAt(0) == 'n' && cek.length() == 3) {             //buat yang not
                if (cek.charAt(1) == 'o') {
                    if (cek.charAt(2) == 't') {
                        token = token + "2 ";                                   //kalo not tuh tokennya 2, masukin ke string token juga
                    } else {
                        notError = false;
                    }
                } else {
                    notError = false;
                }
            } else if (cek.charAt(0) == 'a' && cek.length() == 3) {             //buat yang and
                if (cek.charAt(1) == 'n') {
                    if (cek.charAt(2) == 'd') {
                        token = token + "3 ";
                    } else {
                        notError = false;
                    }
                } else {
                    notError = false;
                }
            } else if (cek.charAt(0) == 'o' && cek.length() == 2) {             //buat yang or
                if (cek.charAt(1) == 'r') {
                    token = token + "4 ";
                } else {
                    notError = false;
                }
            } else if (cek.charAt(0) == 'x' && cek.length() == 3) {             //buat yang xor
                if (cek.charAt(1) == 'o') {
                    if (cek.charAt(2) == 'r') {
                        token = token + "5 ";
                    } else {
                        notError = false;
                    }
                } else {
                    notError = false;
                }
            } else if (cek.charAt(0) == 'i' && cek.length() == 2) {             //buat yang if
                if (cek.charAt(1) == 'f') {
                    token = token + "6 ";
                } else {
                    notError = false;
                }
            } else if (cek.charAt(0) == 't' && cek.length() == 4) {             //buat yang then
                if (cek.charAt(1) == 'h') {
                    if (cek.charAt(2) == 'e') {
                        if (cek.charAt(3) == 'n') {
                            token = token + "7 ";
                        } else {
                            notError = false;
                        } 
                    } else {
                        notError = false;
                    }
                } else {
                    notError = false;
                }
            } else if (cek.charAt(0) == 'i' && cek.length() == 3) {             //buat yang iff
                if (cek.charAt(1) == 'f') {
                    if (cek.charAt(2) == 'f') {
                        token = token + "8 ";
                    } else {
                        notError = false;
                    }
                } else {
                    notError = false;
                }
            } else if ("(".equals(cek)) {                                       //buat yang (
                token = token + "9 ";
            } else if (")".equals(cek)) {                                       //buat yang )
                token = token + "10 ";
            } else {
                notError = false;
            }
            
            if (notError == false) {                                            //kalo nemu string selain yang di atas berarti masukin string error ke token buat nandain inputannya tidak sesuai lexic
                token = token + "error ";
            }
            i++;
        }
        return token;                                                           //kumpulan token2 tadi yang udah di masukin ke string token
    }
}
