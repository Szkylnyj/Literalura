package com.Alura.Literalura.Model;

public enum Idioma {
    Español ("es"),
    Ingles ("en"),
    Frances ("fr"),
    Portugues ("pt");

    private String idiomaOmdb;
         Idioma (String idiomaOmdb){
             this.idiomaOmdb=idiomaOmdb;
    }

        public static Idioma fromString (String text){
             for (Idioma idioma: Idioma.values()){
                 if (idioma.idiomaOmdb.equalsIgnoreCase(text)){
                     return idioma;
                 }
             }
             throw new IllegalArgumentException("Ningun idioma encontrado: " + text);
        }


}
