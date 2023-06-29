import org.chr.interfaces.imprenta.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Curriculum curriculum = new Curriculum(new Persona("Chr","Bautista"),"Computer System engineer", "summary:");
        curriculum.addSkill("Java")
                .addSkill("Angular");
        print(curriculum);
        Report report = new Report(new Persona("Chr","Mendoza"),"Lisandro", "Un reporte mal escrito");
        print(report);

        Book book = new Book(new Persona("Miguel de Cervantes","Saavedra"));
        Printable firstsBookPage = new BookPage("El ingenioso hidalgo don Quijote de la Mancha narra las aventuras de ");
        Printable secondBookPage = new BookPage("Alonso Quijano, un hidalgo pobre que de tanto leer novelas de ");
        Printable thirdBookPage = new BookPage("caballería acaba enloqueciendo y creyendo ser un caballero andante, ");
        Printable fourthBookPage = new BookPage("nombrándose a sí mismo como don Quijote de la Mancha. ");


        book.addPage(firstsBookPage)
                .addPage(secondBookPage)
                .addPage(thirdBookPage)
                .addPage(new Printable() {
                    //clase anonima que implementa la interfaz Printable
                    //Otra forma de crear clases que implementen interfaces
                    //Es conveniente usarla cuando se requiere una clase que implemente la interfaz
                    //y no es necesario que se cree un archivo .java con una clase que sobreescriba los
                    //metodos.
                    //Cuando la interfaz solo tiene un metodo se puede reemplazar la clase anonima
                    //por una expresion lamda que viene a sobreescribir el unico metodo de la interfaz
                    @Override
                    public String print() {
                        return "nombrándose a sí mismo como don Quijote de la Mancha. ";
                    }
                });
        print(book);
    }

    public static void print(Printable printable){
        System.out.println(printable.print());
    }
}