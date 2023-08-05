class Person {
    private String name;
    private String id;
    private String email;
    private String status;

    public Person() {
    }

    public Person(String name, String id, String email, String status) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.status = status;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", id='" + getId() + "'" +
                ", email='" + getEmail() + "'" +
                ", status='" + getStatus() + "'" +
                "}";
    }
}