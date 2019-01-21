public class Solider {
    private String soliderNickName;
    private String soliderSurname;

    public Solider (String soliderNickName, String soliderSurname) {
        this.soliderNickName = soliderNickName;
        this.soliderSurname = soliderSurname;
    }

    public String getSoliderNickName() {
        return soliderNickName;
    }

    public String getSoliderSurname() {
        return soliderSurname;
    }

    public static Solider createSolider(String  soliderNickName, String soliderSurname){
        return new Solider(soliderNickName, soliderSurname);
    }
}
