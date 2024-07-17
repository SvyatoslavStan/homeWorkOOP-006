public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person john = new Person("John");
        Person mary = new Person("Mary");
        Person alice = new Person("Alice");
        Person bob = new Person("Bob");
        Person charlie = new Person("Charlie");

        john.setMother(mary);
        alice.setFather(john);
        bob.setFather(john);
        charlie.setFather(john);

        john.addChild(alice);
        john.addChild(bob);
        john.addChild(charlie);

        familyTree.addPerson(john);
        familyTree.addPerson(mary);
        familyTree.addPerson(alice);
        familyTree.addPerson(bob);
        familyTree.addPerson(charlie);

        Research research = new Research(familyTree);

        System.out.println("John's children: " + research.getChildren("John"));
        System.out.println("Alice's parents: " + java.util.Arrays.toString(research.getParents("Alice")));
        System.out.println("Bob's siblings: " + research.getSiblings("Bob"));
    }
}