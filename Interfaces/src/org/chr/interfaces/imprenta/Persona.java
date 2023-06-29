package org.chr.interfaces.imprenta;

public class Persona {
    private String name, lastname;

    public Persona(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return name + " " + lastname;
    }
}
