import java.util.Scanner;

public class MainGunRoom {
    private static Scanner scanner = new Scanner(System.in);
    private static GunRoomDataBase gunRoomDataBase= new GunRoomDataBase();

    public static void main(String[] args) {

        boolean quit = false;
        startProgram();
        whatYouWantToDo();

        while(!quit){
            System.out.println("General! What Information you want know or add in gun room database?");

            int whatToDO = scanner.nextInt();
            scanner.nextLine();

            switch (whatToDO){
                case 0:
                    System.out.println("Exit");
                    quit=true;
                    break;
                case 1:
                    gunRoomDataBase.printSoliders();
                    break;
                case 2:
                    addNewSolider();
                    break;
                case 3:
                    updateSolider();
                    break;
                case 4:
                    removeSolider();
                    break;
                case 5:
                    querySolider();
                    break;
                case 6:
                    whatYouWantToDo();
                    break;
            }
        }
    }

    private static void addNewSolider(){
        System.out.println("Enter solider nick name: ");
        String soliderNickName = scanner.nextLine();
        System.out.println("Enter solider surname: ");
        String soliderSurName = scanner.nextLine();
        Solider newSolider = Solider.createSolider(soliderNickName,soliderSurName);
        if(gunRoomDataBase.addNewSolider(newSolider)){
            System.out.println("New solider added: nick name = "+soliderNickName+ ", surname+ "+soliderSurName);
        }else {
            System.out.println("Cannot add, "+soliderNickName+" already on file");
        }
    }

    private static void updateSolider(){
        System.out.println("Enter existing solider nickname: ");
        String soliderNickname = scanner.nextLine();
        Solider exisitingSoliderRecord = gunRoomDataBase.querySoliders(soliderNickname);
        if(exisitingSoliderRecord == null){
            System.out.println("Solider not found");
            return;
        }
        System.out.print("Add new solider nick name: ");
        String newSoliderNickName = scanner.nextLine();
        System.out.print("Add new solider surname: ");
        String newSoliderSurName = scanner.nextLine();
        Solider newSolider = Solider.createSolider(newSoliderNickName, newSoliderSurName);
        if(gunRoomDataBase.updateSolider(exisitingSoliderRecord, newSolider)){
            System.out.println("Successfully updated solider list");
        }else {
            System.out.println("Error with update solider");
        }
    }

    private static void removeSolider(){
        System.out.println("Enter existing solider nickname: ");
        String soliderNickName = scanner.nextLine();
        Solider existingSoliderRecord = gunRoomDataBase.querySoliders(soliderNickName);
        if(existingSoliderRecord == null){
            System.out.println("Solider not found");
            return;
        }
        if(gunRoomDataBase.removeSolider(existingSoliderRecord)){
            System.out.println("Successfully deleted solider");
        }else {
            System.out.println("Error with deleting solider");
        }
    }

    private static void querySolider(){
        System.out.println("Enter existing solider nickname: ");
        String soliderNickName = scanner.nextLine();
        Solider existingSoliderRecord = gunRoomDataBase.querySoliders(soliderNickName);
        if(existingSoliderRecord == null){
            System.out.println("Solider not found");
            return;
        }
        System.out.println("Nickname: "+existingSoliderRecord.getSoliderNickName()+"\n Surname: "+existingSoliderRecord.getSoliderSurname());
    }
    private static void startProgram(){
        System.out.println("Hi, I am drill sergeant. What you want see?");
    }
    private static void whatYouWantToDo(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shutdown\n"+
                "1 - to print all solders\n" +
                "2 - to add a new solder\n"+
                "3 - to update an existing solder\n"+
                "4 - to remove an existing solider\n"+
                "5 - query if an existing solider exists\n"+
                "6 - to print a list of available actions.");
        System.out.println("Choose your action:");
    }
}
