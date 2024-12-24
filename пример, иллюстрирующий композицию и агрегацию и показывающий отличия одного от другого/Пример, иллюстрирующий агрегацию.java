class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class University {
    private String name;
    private Faculty[] faculties;

    public University(String name, Faculty[] faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public void printFaculties() {
        System.out.println("Университет: " + name);
        for (Faculty faculty : faculties) {
            System.out.println("Факультет: " + faculty.getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Faculty csFaculty = new Faculty("Компьютерные науки");
        Faculty mathFaculty = new Faculty("Математика");

        Faculty[] faculties = {csFaculty, mathFaculty};

        University university = new University("Государственный университет", faculties);
        university.printFaculties();
    }
}
