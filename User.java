public class User {
    private final String loginId;
    private final String password;
    private final String name;

    public User(String loginId, String password, String name) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
    }

    public boolean authenticate(String inputId, String inputPassword) {
        return this.loginId.equals(inputId) && this.password.equals(inputPassword);
    }

    public String getName() {
        return name;
    }
}
