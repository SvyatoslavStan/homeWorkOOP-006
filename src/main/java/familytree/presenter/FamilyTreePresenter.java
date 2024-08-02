package familytree.presenter;

import familytree.view.FamilyTreeView;
import familytree.service.FamilyTreeService;

public class FamilyTreePresenter {
    private FamilyTreeService service;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTreeService service, FamilyTreeView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        while (true) {
            view.displayMenu();
            int choice = view.getMenuChoice();

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    findPerson();
                    break;
                case 3:
                    showAllMembers();
                    break;
                case 4:
                    service.sortByName();
                    view.displayMessage("Отсортировано по имени");
                    break;
                case 5:
                    service.sortByBirthDate();
                    view.displayMessage("Отсортировано по дате рождения");
                    break;
                case 6:
                    saveToFile();
                    break;
                case 7:
                    loadFromFile();
                    break;
                case 0:
                    return;
                default:
                    view.displayMessage("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void addPerson() {
        String name = view.getInput("Введите имя: ");
        String gender = view.getInput("Введите пол (М/Ж): ");
        String birthDateInput = view.getInput("Введите дату рождения (ГГГГ-ММ-ДД): ");
        
        service.addPerson(name, gender, birthDateInput);
        view.displayMessage("Человек добавлен в семейное дерево.");
    }

    private void findPerson() {
        String name = view.getInput("Введите имя для поиска: ");
        var person = service.findPerson(name);
        if (person != null) {
            view.displayMessage("Найдено:");
            view.displayPerson(person);
        } else {
            view.displayMessage("Человек не найден.");
        }
    }

    private void showAllMembers() {
        view.displayMessage("Все члены семьи:");
        view.displayPersonList(service.getAllMembers());
    }

    private void saveToFile() {
        String fileName = view.getInput("Введите имя файла для сохранения: ");
        try {
            service.saveToFile(fileName);
            view.displayMessage("Семейное дерево сохранено в файл.");
        } catch (Exception e) {
            view.displayMessage("Ошибка при сохранении: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        String fileName = view.getInput("Введите имя файла для загрузки: ");
        try {
            service.loadFromFile(fileName);
            view.displayMessage("Семейное дерево загружено из файла.");
        } catch (Exception e) {
            view.displayMessage("Ошибка при загрузке: " + e.getMessage());
        }
    }
}