interface FamilyMember extends PersonalDetails {
    String getNickname();
    void setNickname(String name);
}

interface PersonalDetails {
    String getName();
    int getAge();
}


class Individual {
    public String name;

    //> constructor
    public Individual(String name) {
        this.name = name;
    }

    //> getters
    public String getName() {
        return this.name;
    }

    //> setters
    public void setName(String name) {
        this.name = name;
    }

}

class Person extends Individual implements PersonalDetails, FamilyMember{

    protected String nickname;
    int age;

    //> main
    public static void main(String[] args) {
        Person p = new Person("John", "Johnny", 20);
        System.out.println(p.toString());
        p.setName("John");
        p.setNickname("Johnny");
        System.out.println(p.toString());
        Person p_Again = new Person("John", "Johnny", 20);
        System.out.println(p_Again.toString());
    }

    //> constructor
    public Person(String name, String nickname, int age) {
        super(name);
        this.nickname = nickname;
        this.age = age;
    }

    //> getters
    public String getNickname() {
        return this.nickname;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    //> setters
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age= age;
    }

    //> toString
    public String toString() {
        return this.name + " ( " + this.nickname + " ) " + this.age + " years old";
    }

}
