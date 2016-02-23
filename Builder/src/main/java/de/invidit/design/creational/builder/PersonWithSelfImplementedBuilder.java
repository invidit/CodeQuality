package de.invidit.design.creational.builder;

/**
 * @author Michael Weber
 * @since 23.02.2016.
 */
public class PersonWithSelfImplementedBuilder {
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public PersonWithSelfImplementedBuilder(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
    }

    public static class Builder {
        private String name;
        private String surname;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public PersonWithSelfImplementedBuilder build() {
            return new PersonWithSelfImplementedBuilder(this);
        }
    }
}
