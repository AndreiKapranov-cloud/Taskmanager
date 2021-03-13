package by.taskmanager.domain;

public class User<T> {

    private String name;
    private String surname;
    private int age;
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.name = name;

    }

    public static class Builder<T> {
        private User newUser;

        public Builder() {
            newUser = new User();
        }

        public Builder withName(String name) {
            newUser.name = name;
            return this;

        }

        public Builder withSurname(String surname) {
            newUser.surname = surname;
            return this;
        }

        public Builder withAge(int age) {
            newUser.age = age;
            return this;

        }


        public Builder withId(T id) {
            newUser.id = id;
            return this;
        }

        public User build() {
            return newUser;
        }

    }

    public void printId() {
        System.out.println("id = " + id);
    }
}


