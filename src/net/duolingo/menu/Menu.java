package net.duolingo.menu;

public class Menu {
    final String MENU = """
            ****************DICCIONARIO DUOLINGO****************
            --- MENU DE USUARIO ---
                1.- Add word
                2.- Delete word
                3.- Does this word exist?
                4.- Show valid initials
                5.- Show words by initial
                0.- Close program
            -------------------------
                """;

    /**
     * The function prints the string MENU so user can interact with it.
     */
    public void showMenu() {
        System.out.println(MENU);
    }
}
