public class EmailApp {
    public static void main(String[] args) {

        try {
            Email em1 = new Email("John", "Doe");
            System.out.println(em1.showInfo());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
