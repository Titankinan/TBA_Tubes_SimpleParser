/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_tba;

public class Tubes_TBA {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Token t = new Token();                                                  //ini semua buat nge test doang, bisa pake gui juga
        Valid v = new Valid();
        String input = "if ( p or s ) then ( q and r )";
        System.out.println(t.getToken(input));
        System.out.println(v.getValid(t.getToken(input)));
    }
    
}
