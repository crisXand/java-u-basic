package org.chr.interfaces.imprenta;

public class BookPage extends Page implements Printable{
    public BookPage(String content) {
        super(content);
    }

    @Override
    public String print() {
        return this.content;
    }
}
