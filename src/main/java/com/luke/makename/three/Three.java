package com.luke.makename.three;

/**
 * Created by olivia on 2016/12/18.
 */
public class Three {
    private int people;
    private int ground;

    public Three(int people, int ground) {
        this.people = people;
        this.ground = ground;
    }

    public int getPeople() {
        return people;
    }

    public int getGround() {
        return ground;
    }

    @Override
    public String toString() {
        return "Three{" + people +
                ", " + ground +
                '}';
    }
}
