public class MainLab3 {
    public static void main(String[] args) {
        HashTable<Integer, Student> studentsTable = new HashTable<>();

        Student student1 = new Student("Petya", "Petrov", 20, 5);
        Student student2 = new Student("Jakov", "Jakovlev", 30, 5);
        Student student3 = new Student("Kolya", "Nikolayev", 17, 2);
        Student student4 = new Student("Misha", "Mihailov", 18, 4);
        Student student5 = new Student("Anatoliy", "Anatoliev", 23, 3);

        // вставка студентов
        studentsTable.put(11111, student1);
        studentsTable.put(22822, student2);
        studentsTable.put(37737, student3);
        studentsTable.put(56765, student4);
        studentsTable.put(55555, student5);

        studentsTable.printTable();
        System.out.println();

        // замена старого ученика с номером зачетной книжки "11111" на нового
        Student student6 = new Student("Shamil", "Ismailov", 20, 5);
        studentsTable.put(11111, student6);

        studentsTable.printTable();
        System.out.println();

        // поиск существующего и несуществующего студента
        System.out.println(String.format("Student with gradebook №%s: %s.", 37737, studentsTable.get(37737)));
        System.out.println(String.format("Student with gradebook №%s: %s (doesn't exist).", 37738, studentsTable.get(37738)));
        System.out.println();

        // удаление существующего и несуществующего студента
        studentsTable.remove(22822);
        studentsTable.remove(22821);

        studentsTable.printTable();
    }
}
