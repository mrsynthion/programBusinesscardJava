package wiz;

/**
 * Initializing class Bussiness_card and its variables then creating getters
 */
public class Business_card {
    private int id;
    private String firm_name;
    private String firm_adress;
    private int regon;
    private String first_name;
    private String last_name;
    private int phone_number;
    private String mail;

    public Business_card(int id, String firm_name, String firm_adress, int regon, String first_name, String last_name,
                         int phone_number, String mail) {
        this.id = id;
        this.firm_name = firm_name;
        this.firm_adress = firm_adress;
        this.regon = regon;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public String getFirm_name() {
        return firm_name;
    }

    public String getFirm_adress() {
        return firm_adress;
    }

    public int getRegon() {
        return regon;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public String getMail() {
        return mail;
    }
/**
* using method toString() which converts new object 'Business_card' to string so program is able to print it
**/
    @Override
    public String toString() {
        return "\n"+"My businesscard: " +
                "id = " + id + '\'' +
                ", firm_name='" + firm_name + '\'' +
                ", firm_adress='" + firm_adress + '\'' +
                ", regon=" + regon +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone_number=" + phone_number +
                ", mail='" + mail + '\'';
    }
}
