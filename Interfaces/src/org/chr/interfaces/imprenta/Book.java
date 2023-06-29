package org.chr.interfaces.imprenta;

import java.util.ArrayList;
import java.util.List;

public class Book implements Printable{
    private Persona author;
    List<Printable> content;

    public Book(Persona author) {
        this.author = author;
        this.content = new ArrayList<Printable>();
    }

    public Book addPage(Printable page){
        content.add(page);
        return this;
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder("Autor: ");
        stringBuilder.append(author)
                .append("\nContenido: \n");
        for (Printable page :
                content) {
            stringBuilder.append(page.print())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
