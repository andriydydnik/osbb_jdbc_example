package org.example.data;

public class Member {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    Member setId(final int newValue) {
        id = newValue;
        return this;
    }

    public String getName() {
        return name;
    }

    Member setName(final String newValue) {
        name = newValue;
        return this;
    }

    @Override
    public String toString(){
        return String.format("{%d -- %s}", id, name);
    }
}
