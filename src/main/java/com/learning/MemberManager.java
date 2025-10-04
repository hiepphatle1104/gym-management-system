package com.learning;

public class MemberManager extends Manager<Member> {

    @Override
    public void addUser() {
        IO.print("Please enter username: ");
        String username = sc.nextLine();

        this.userList.add(new Member(username));
        IO.println("Success");
    }
    
    @Override
    public void updateUser() {

    }
}
