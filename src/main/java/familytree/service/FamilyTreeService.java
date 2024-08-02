package familytree.service;

import familytree.model.FamilyTree;
import familytree.model.Person;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreeService {
    private FamilyTree<Person> familyTree;
    private FamilyResearch research;
    private FileOperations fileOps;

    public FamilyTreeService() {
        this.familyTree = new FamilyTree<>();
        this.research = new FamilyResearch(familyTree);
        this.fileOps = new FileOperations();
    }

    public void addPerson(String name, String gender, String birthDateInput) {
        String normalizedGender = gender.trim().equalsIgnoreCase("М") ? "Мужской" : "Женский";
        LocalDate birthDate = LocalDate.parse(birthDateInput);
        Person person = new Person(name, normalizedGender, birthDate);
        familyTree.addMember(person);
    }

    public Person findPerson(String name) {
        return familyTree.findPerson(name);
    }

    public List<Person> getAllMembers() {
        return familyTree.getMembers();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void saveToFile(String fileName) throws Exception {
        fileOps.saveToFile(fileName, familyTree);
    }

    public void loadFromFile(String fileName) throws Exception {
        familyTree = (FamilyTree<Person>) fileOps.loadFromFile(fileName);
        research = new FamilyResearch(familyTree);
    }

    // Другие методы для работы с FamilyResearch, если необходимо
}