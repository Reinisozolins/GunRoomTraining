import java.util.ArrayList;

public class GunRoomDataBase {
    private ArrayList<Solider> infantrySoldier;

    public GunRoomDataBase(){

        this.infantrySoldier =new ArrayList<Solider>();
    }

    public boolean addNewSolider(Solider solider){
        if (findSolider(solider.getSoliderNickName())>=0){
            return false;
        }
        infantrySoldier.add(solider);
        return true;
    }

    private  int findSolider(Solider solider){
        return this.infantrySoldier.indexOf(solider);
    }
    private int findSolider(String nickName){
        for(int i=0;i<this.infantrySoldier.size(); i++){
            Solider solider = this.infantrySoldier.get(i);
            if(solider.getSoliderNickName().equals(nickName)){
                return i;
            }
        }
        return -1;
    }
    public boolean updateSolider(Solider oldSolider, Solider newSolider){
        int foundPositions = findSolider(oldSolider);
        if (foundPositions < 0){
            System.out.println(oldSolider.getSoliderNickName()+ "was not found");
            return false;
        }
        this.infantrySoldier.set(foundPositions, newSolider);
        System.out.println(oldSolider.getSoliderNickName()+ "was replaced with "+newSolider.getSoliderNickName());
        return true;
    }

    public Solider querySoliders(String soliderNickName){
        int positions = findSolider(soliderNickName);
        if (positions >= 0) {
            return this.infantrySoldier.get(positions);
        }
        return null;
    }
    public boolean removeSolider(Solider solider){
        int foundPositions=findSolider(solider);
        if(foundPositions<0) {
            System.out.println(solider.getSoliderNickName() + " can't found");
            return false;
        }
        this.infantrySoldier.remove(foundPositions);
        System.out.println(solider.getSoliderNickName()+ " was deleted");
        return true;
    }
    public void printSoliders(){
        System.out.println("Solider List");
        for(int i=0;i<this.infantrySoldier.size();i++) {
            System.out.println((i + 1) + " " + this.infantrySoldier.get(i).getSoliderNickName() + "-->  " + this.infantrySoldier.get(i).getSoliderSurname());
        }
    }
}
