package org.chr.interfaces.imprenta;

import java.util.ArrayList;
import java.util.List;

public class Curriculum extends Page implements Printable{
    private List<String> skills;
    private Persona persona;
    private String universityDegree;

    public Curriculum(Persona persona, String universityDegree, String content) {
        super(content);
        this.skills = new ArrayList<String>();
        this.persona = persona;
        this.universityDegree = universityDegree;
    }

    public Curriculum addSkill(String skill){
        skills.add(skill);
        return this;
    }
    @Override
    public String print(){
        StringBuilder builder = new StringBuilder("Name: ");
        builder.append(persona)
                .append("\n")
                .append("University Degree: ")
                .append(universityDegree)
                .append("\n")
                .append(content)
                .append("\n")
                .append("Skills \n");
        for (String skill:
             skills) {
            builder.append(skill).append("\n");
        }
        return builder.toString();

    }

}
