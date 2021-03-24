package by.taskmanager.domain;
import java.util.Objects;
import java.io.Serializable;

public class User<T> implements Comparable<User>, Serializable {

    protected String name;
    protected String surname;
    protected String password;
    protected int age;
    protected T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public static class Builder<T> {
        private User<T> newUser;

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
        public Builder withPassword(String password) {
            newUser.password = password;
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
    @Override
    public int compareTo(User user) {
        int result = this.name.compareTo(user.getName());
        result = result == 0 ? (this.surname == user.getSurname() ? 0 : 1) : result;
        result = result == 0 ? this.password.compareTo(user.getPassword()) : result;
        return result;
    }
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || getClass() != that.getClass()) {
            return false;
        }
        User user = (User) that;
        return
                Objects.equals(name, user.name)
                && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,surname,password);
    }

}


