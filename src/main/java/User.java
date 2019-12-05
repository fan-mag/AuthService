import java.io.Serializable;

public class User implements Serializable {
    private String login;
    private String password;
    private Long apiKey;
    private Integer privilege;

    public User withLogin(String login) {
        this.login = login;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public User withApiKey(Long apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public User withPrivilege(Integer privilege) {
        this.privilege = privilege;
        return this;
    }

    public String login() {
        return login;
    }

    public String password() {
        return password;
    }

    public Long apiKey() {
        return apiKey;
    }

    public Integer privilege() {
        return privilege;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", apiKey=" + apiKey +
                ", privilege=" + privilege +
                '}';
    }
}
