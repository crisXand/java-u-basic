package org.chr.interfaces.imprenta;

abstract public class Page {
    protected String content;

    public Page(String content) {
        this.content = content;
    }

    abstract public String print();

}
