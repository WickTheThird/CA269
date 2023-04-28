class Person {
    private String name;
}
class Employee extends Person {
    private String empoyeeID;
}
interface VIP {
    String VIPStatus();
}

class CompanyGathering {

    //> admit persons if they are VIP or employee
    public boolean admit(Person p) {
        if (p instanceof VIP || p instanceof Employee) {
            return true;
        } else {
            return false;
        }
    }
}
