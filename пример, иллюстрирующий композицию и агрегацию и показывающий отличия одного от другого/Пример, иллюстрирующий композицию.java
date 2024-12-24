class Chapter {
    private String title;

    public Chapter(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class Book {
    private String name;
    private Chapter[] chapters;

    public Book(String name, Chapter[] chapters) {
        this.name = name;
        this.chapters = chapters;
    }

    public void printChapters() {
        System.out.println("Книга: " + name);
        for (Chapter chapter : chapters) {
            System.out.println("Глава: " + chapter.getTitle());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Chapter[] chapters = {
            new Chapter("Введение"),
            new Chapter("Основы Java"),
            new Chapter("ООП в Java")
        };

        Book book = new Book("Учебник Java", chapters);
        book.printChapters();
    }
}
