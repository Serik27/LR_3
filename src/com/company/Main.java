package model;

import java.util.List;

public abstract class Human {
    protected String firstName;
    protected String lastName;
    protected String patronymic;
    protected Sex sex;

    public Human(String firstName, String lastName, String patronymic, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.sex = sex;
    }
}

public enum Sex {
    MALE,
    FEMALE
}

public class Student extends Human {
    private Group group;

    public Student(String firstName, String lastName, String patronymic, Sex sex, Group group) {
        super(firstName, lastName, patronymic, sex);
        this.group = group;
    }
}

public class University {
    private String name;
    private Faculty faculty;

    public University(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
    }
}

public class Faculty {
    private String name;
    private List<Department> departments;

    public Faculty(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }
}

public class Department {
    private String name;
    private List<Group> groups;

    public Department(String name, List<Group> groups) {
        this.name = name;
        this.groups = groups;
    }
}

public class Group {
    private String name;
    private List<Student> students;

    public Group(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }
}

public class Run {
    public static void main(String[] args) {
        createTypicalUniversity();
    }

    public static void createTypicalUniversity() {
        Department department = new Department("Department of Computer Science", createGroups());
        Faculty faculty = new Faculty("Faculty of Engineering", List.of(department));
        University university = new University("Example University", faculty);

        // Доступ до університету та його складових
        System.out.println("University Name: " + university.getName());
        System.out.println("Faculty Name: " + university.getFaculty().getName());
        System.out.println("Department Name: " + university.getFaculty().getDepartments().get(0).getName());
        System.out.println("Group Name: " + university.getFaculty().getDepartments().get(0).getGroups().get(0).getName());
    }

    public static List<Group> createGroups() {
        Group group1 = new Group("Group 1", createStudents());
        Group group2 = new Group("Group 2", createStudents());

        return List.of(group1, group2);
    }

    public static List<Student> createStudents() {
        Student student1 = new Student("John", "Doe", "Smith", Sex.MALE, null);
        Student student2 = new Student("Jane", "Doe", "Smith", Sex.FEMALE, null);

        return List.of(student1, student2);
    }
}