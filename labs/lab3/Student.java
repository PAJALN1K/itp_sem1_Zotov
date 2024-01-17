public class Student {
    private String name;
    private String surname;
    private int age;
    private float averageMark;

    public Student(String inpName, String inpSurname, int inpAge, float inpAverageMark) {
        setName(inpName);
        setSurname(inpSurname);
        setAge(inpAge);
        setAverageMark(inpAverageMark);
    }

    public Student() {
        this("Ivan", "Ivanov", 21, 4);
    }

    public void setName(String inpName) {
        name = inpName;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String inpSurname) {
        surname = inpSurname;
    }

    public String getSurname() {
        return surname;
    }

    public void setAge(int inpAge) {
        if (inpAge >= 0) {
            age = inpAge;
        }
        else System.out.println("Age cannot be a negative number!");
    }

    public int getAge() {
        return age;
    }

    public void setAverageMark(float inpAverageMark) {
        if (inpAverageMark >= 0) {
            averageMark = inpAverageMark;
        }
        else System.out.println("Average mark cannot be a negative number!");
    }

    public float getAverageMark() {
        return averageMark;
    }

    @Override
    public String toString() {
        return String.format("Student %s %s", name, surname);
    }
}
