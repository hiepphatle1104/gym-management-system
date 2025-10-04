package com.learning;

public class MemberManager extends Manager<Member> {
    @Override
    public void addUser() {
        IO.print("Please enter username: ");
        String username = sc.nextLine();
        Member user = new Member(username);

        IO.println("- Subscription Plan -");
        SubscriptionService.listSubscriptions();
        IO.print("Choose your plan (name): ");
        String planName = sc.nextLine();

        Subscription sub = SubscriptionService.getSubscription(planName);
        user.setMembership(new Membership(user.getId(), sub));

        this.userList.add(user);
        IO.println("Success");
    }

    @Override
    public void updateUser() {

    }
}
