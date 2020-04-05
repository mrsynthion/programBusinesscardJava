package wiz;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
       App app = new App();
        menu(app);
    }

    /**
     * method menu takes
     * @param app - which has been initialized earlier, then checks what user have chosen
     * and runs equal functions in a do while loop
     */
    private static void menu(App app) {
        String oper;
        do
        {
            System.out.println("Co chcesz zrobić?");
            oper = setVar("czynność");
            if("1".equalsIgnoreCase(oper)){
               add_business_card();
            } else if("2".equalsIgnoreCase(oper)){
              readCard();
            }
        }
        while(!"end".equalsIgnoreCase(oper));
    }

    /**
     * creating hashmap cards, objects added to this hashmap will be identified by 'id'
     */
    private static HashMap<Integer, Business_card> cards = new HashMap<>();

    /**
     * method add_business_card set values of variables of class Business_card and creates and object
     * of this class which name is 'card' then program puts that object into 'cards' hashmap
     * and using save_card method it saves it to the file.
     */
    public static void add_business_card() {
        String id = setVar("id wizytówki");
        String firm_name = setVar("nazwę firmy");
        String firm_adress = setVar("adres firmy");
        String regon = setVar("regon");
        String first_name = setVar("imię właściciela");
        String last_name = setVar("nazwisko właściciela");
        String phone_number = setVar("numer telefonu");
        String mail = setVar("mail");
        Business_card card = new Business_card(Integer.valueOf(id), firm_name, firm_adress, Integer.valueOf(regon),
                first_name, last_name, Integer.valueOf(phone_number), mail);
        cards.put(Integer.valueOf(id), card);
        save_card(card);
    }

    /**
     * method returnAllCards takes
     * @param wiz and using
     * @return - returns hashmap cards and its values
     */
    public static Collection<Business_card> returnAllCards(Business_card wiz){
        return cards.values();
    }

    /**
     * method save_card() firstly tries to create a file "wizytowka.txt",
     * in case it isn't created already it creates file and prints that program succeeded
     * then takes all parameters of 'Business_card' object that user has earlier initialized
     * and saves it to file using try(to save) and catch(if something is wrong).
     * Otherwise if it is created already it prints that file already exists
     * then as earlier by try(to save) and catch(if something is wrong)
     * tries to append new 'Business_card' object and its parameters to new file of the file
     * @param wiz - relates to 'Business_card' object that program created earlier
     */
    public static void save_card(Business_card wiz){
        String fileName = "wizytowka.txt";
        try{
            File myObj = new File(fileName);
            if (myObj.createNewFile()){
                System.out.println("Wizytowka " + myObj.getName() + " została zapisana");
                try{
                    FileWriter myWriter = new FileWriter(fileName);
                    myWriter.write(String.valueOf(returnAllCards(wiz)) + "\n");
                    myWriter.close();
                    System.out.println("Zapisano");
                } catch (IOException e){
                    System.out.println("Wystąpił błąd");
                    e.printStackTrace();
                }
            } else {
                System.out.println("Plik już istnieje");
                try{
                    FileWriter myWriter = new FileWriter(fileName, true);
                    BufferedWriter out = new BufferedWriter(myWriter);
                    out.write("\n"+String.valueOf(returnAllCards(wiz)));
                    out.close();
                    System.out.println("Zapisano");
                } catch (IOException e){
                    System.out.println("Wystąpił błąd");
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Wystąpił błąd");
            e.printStackTrace();
        }
    }

    /**
     * method readCard() tries to read and return all saved earlier 'Business_card' objects in file "wizytowka.txt"
     * using try we initialize new 'fileReader' object and variable 'read' then in loop 'while' we read
     * one char at the time. It ends when there is no char left and prints it all, using catch program is able to
     * show statement if something is wrong
     */
    public static void readCard(){
        String fileName = "wizytowka.txt";
        try (FileReader reader = new FileReader(fileName)) {
            int read;
            while ((read = reader.read()) != -1) {
                System.out.print((char) read);
            }
            System.out.println("");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    /**
     * method setVar scans variable value and prints what
     * @param value user wrote, cause of that it can be used many times to initialize all values of variables
     * for instance in constructors of objects, then using
     * @return it returns variable val as string
     */
    public static String setVar(String value) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz " + value + ": ");
        String val = scanner.nextLine();
        System.out.println("Wpisales " + value + ": " + val);
        return val;
    }

}
