import java.util.Scanner;

public class Main {

    static PhoneContacts contacts;
    static Scanner scanner;

    public static void main(String[] args) {
        contacts = new PhoneContacts();
        scanner = new Scanner(System.in);

        addGroups();
        addContacts();
        contacts.showContacts();

        scanner.close();
    }

    private static void addGroups() {

        System.out.println("Введите название группы контактов:");
        String groupName = scanner.nextLine();
        contacts.addGroup(groupName);

        while (true) {
            System.out.println("Создать еще одну группу? (введите название или введите нет)");
            groupName = scanner.nextLine();
            if ("нет".equals(groupName)) break;
            contacts.addGroup(groupName);
        }
    }

    private static void addContacts() {
        String contact;
        String name;
        String phone;
        String groups;
        String[] groupsArray;

        while (true) {
            System.out.println("Создать контакт? (введите наименование и его номер или введите нет)");
            contact = scanner.nextLine();
            if ("нет".equals(contact)) break;

            int indexDelimeter = contact.lastIndexOf(" ");
            if (indexDelimeter == -1) continue;
            name = contact.substring(0, indexDelimeter);
            phone = contact.substring(indexDelimeter + 1);

            System.out.println("Укажите группы контакта через пробел");
            groups = scanner.nextLine();
            groupsArray = groups.split(" ");
            contacts.addContact(new Contact(name, phone), groupsArray);
        }
    }

}
