package se.lexicon;

public class EmailValidation {
    public static void main (String[] args){
        try {
            validateEmail("example@domain.com");
            validateEmail("invalid-email");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static void validateEmail(String email){
        if (!email.contains("@") || !email.contains(".")){
            throw new IllegalArgumentException("Invalid email addres:" + email);
        }
        System.out.println("Valid email: " + email);
    }

}
