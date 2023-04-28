
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

class Person extends Individual {

    protected String nickname;

    //> main
    public static void main(String[] args) {
        Person p = new Person("John", "Johnny");
        System.out.println(p.toString());
        p.setName("John");
        p.setNickname("Johnny");
        System.out.println(p.toString());
        Person p_Again = new Person("John", "Johnny");
        System.out.println(p_Again.toString());
    }

    //> constructor
    public Person(String name, String nickname) {
        super(name);
        this.nickname = nickname;
    }

    //> getters
    public String getNickname() {
        return this.nickname;
    }

    //> setters
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    //> toString
    public String toString() {
        return this.name + " ( " + this.nickname + " ) ";
    }

}
