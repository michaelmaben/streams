package com.jeevanmaben.streams.optionals;

import java.util.Optional;

public class EmployeeOptional {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Optional<String> getOptionalLastName() {
        return Optional.ofNullable(getLastName());
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmployeeOptional(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullNameWithoutOptional(){
        //null check is required
        if (getLastName() != null){
            return getLastName()  + " "  + getFirstName();
        }else{
            throw new RuntimeException("Last name is null");
        }
    }

    public String getOptionalFullName(){
        //warps the value such that the need for null check is not required
        //code is cleaner and easy to follow
        return getOptionalLastName().orElseThrow(() -> {
            throw new RuntimeException("Last name was optional and is null");
        });
        //code will be simpler if message was not required - use
        //return getOptionalLastName().orElseThrow(RuntimeException::new)
    }


    public static void main(String[] args){
        EmployeeOptional e1 = new EmployeeOptional("Jeevan", "Maben");
        EmployeeOptional e2 = new EmployeeOptional("Jeevan", null);

        System.out.println(e1.getFullNameWithoutOptional());
        //full name when last name is null
        try {
            System.out.println(e2.getFullNameWithoutOptional());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(e2.getOptionalFullName());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

