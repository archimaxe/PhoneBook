import java.util.*;

public class PhoneContacts {

    private Map<String, List<Contact>> contacts;

    public PhoneContacts() {
        this.contacts = new HashMap<>();
    }

    public void addGroup(String groupName) {
        contacts.put(groupName, new ArrayList<>());
    }

    public void addContact(Contact contact, String[] groupNames) {
        for (String groupName : groupNames) {
            try {
                int index = Collections.binarySearch(contacts.get(groupName), contact.toString());
                contacts.get(groupName).add(Math.abs(index) - 1, contact);
                System.out.printf("Контакт %s добавлен в группу %s\n",
                        contact.getName() ,groupName);
            } catch (NullPointerException e) {
                System.out.printf("Группы %s не существует\n", groupName);
            }
        }
    }

    public void showContacts() {
        for (Map.Entry<String, List<Contact>> group : contacts.entrySet()) {
            System.out.printf("- %s:\n", group.getKey());
            for (Contact contact : group.getValue()) {
                System.out.printf("\tИмя: %s, Телефон: %s\n",
                        contact.getName(), contact.getPhone());
            }
        }
    }

}
