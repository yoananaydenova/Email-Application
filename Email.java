import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);

        // Call a method asking for the department - return the department
        this.department = setDepartment();

        // Call the method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        this.email = generateEmail();
    }

    private void setFirstName(String firstName) {
        if(firstName.trim().equals("")){
            throw  new IllegalArgumentException("First name should not be empty!");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if(lastName.trim().equals("")){
            throw  new IllegalArgumentException("Last name should not be empty!");
        }
        this.lastName = lastName;
    }

    private String generateEmail(){
       String departmentResult = this.department;
        if(!departmentResult.equals("")){
            departmentResult += ".";
        }
        return this.firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + departmentResult + companySuffix;
    }

    //Ask for the department
    private String setDepartment() {
        System.out.print("New worker: " + firstName + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }

        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return this.mailboxCapacity;
    }

    public String getAlternateEmail() {
        return this.alternateEmail;
    }

    public String getPassword() {
        return this.password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
