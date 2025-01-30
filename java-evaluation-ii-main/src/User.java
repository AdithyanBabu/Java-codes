class User {
    private String username;
    private String password;
    private boolean isAdmin;

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String toFileFormat() {
        return username + "," + password + "," + isAdmin;
    }

    @Override
    public String toString() {
        return "User: " + username + (isAdmin ? " (Admin)" : "");
    }
}
