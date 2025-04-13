package Library;

public abstract class User {
    private String userId;
    private String name;
    private String contactInfo;
    private static int totalUsers;
    private static int maxUserId;

    public User() {
        userId = generateUniqueId();
    }

    public User(String name, String contactInfo) {
        this();
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public User(User user) {
        this(user.name, user.contactInfo);
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalUsers() {
        return totalUsers;
    }

    final String generateUniqueId() {
        maxUserId++;
        return "Library.User-" + maxUserId;
    }

    public abstract void displayDashboard();

    public abstract boolean canBorrowBooks();

    public abstract void returnBook();
}
