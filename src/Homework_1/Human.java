package Homework_1;

public class Human {
    private int yearOfBirth;
    String name;
    private String town;
    String jobTitle;

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        if (yearOfBirth < 0) {
            this.yearOfBirth = 0;
        } else {
            this.yearOfBirth = yearOfBirth;
        }
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        if (town == null || town.trim().isEmpty()) {
            this.town = "Информация не указана";
        } else {
            this.town = town;
        }
    }

    public Human (String name, String town, int yearOfBirth, String jobTitle) {

        setTown(town);
        setYearOfBirth(yearOfBirth);

        if (name == null || name.trim().isEmpty()) {
            this.name = "Информация не указана";
        } else {
            this.name = name;
        }

        if (jobTitle == null || jobTitle.trim().isEmpty()) {
            this.jobTitle = "Информация не указана";
        } else {
            this.jobTitle = jobTitle;
        }
    }

    void printGreeting() {
        System.out.println("Привет! Меня зовут " + name + ". Я из города " + getTown() +
                ". Я родился в " + getYearOfBirth() + " году. Я работаю на должности " + jobTitle + ". Будем знакомы!");
    }
}

