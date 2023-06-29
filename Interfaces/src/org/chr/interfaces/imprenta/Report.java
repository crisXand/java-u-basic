package org.chr.interfaces.imprenta;

public class Report extends Page implements Printable{
    private String  reviewer;
    private Persona author;
    public Report(Persona author, String reviewer, String content) {
        super(content);
        this.author = author;
        this.reviewer = reviewer;
    }

    @Override
    public String print() {
        return "report written by " + author + " \nreviewed by" + reviewer + "\n" + content + "\n";
    }
}
