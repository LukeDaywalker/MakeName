package com.luke.makename;

/**
 * Created by olivia on 2016/12/16.
 */
public class Name {
    private final int midName;
    private final int lastName;

    public Name(int midName, int lastName) {
        this.midName = midName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Name{" + midName + "," + lastName + '}';
    }
}
