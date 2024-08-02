package familytree;

import familytree.view.ConsoleFamilyTreeView;
import familytree.presenter.FamilyTreePresenter;
import familytree.service.FamilyTreeService;

public class Main {
    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        System.setProperty("console.encoding", "UTF-8");

        FamilyTreeService service = new FamilyTreeService();
        ConsoleFamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(service, view);

        presenter.run();
    }
}