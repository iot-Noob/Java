package game.powerup;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

interface  PopUpGameFunc{
void Chk_tf_cell(); //Check True and false in cell

}
interface PopFunc extends PopUpGameFunc {
    void GetInput();
    void ShowOutput();
    int ShowOutput(int loc);
    boolean Verify();
    void ChkCell();

}

 abstract class UserInput implements PopFunc  {
   protected  boolean []CelChk=new boolean[4];

    protected int[] key = new int[4];
    protected int[] userInp = new int[4];
    protected boolean isTrue = false;
    protected int top = 0;
    protected int not = 4;
    protected int sok = 0;
    static Scanner sc = new Scanner(System.in);
    static Random randgen = new Random();



    public UserInput() {
        key[0] = randgen.nextInt(9);
        key[0] = key[0]=randgen.nextInt(9);
        key[1] = randgen.nextInt(9);
        key[1] = key[1]=randgen.nextInt(9);
        key[2] = randgen.nextInt(9);
        key[2] = key[2]=randgen.nextInt(9);
        key[3] = randgen.nextInt(9);
        key[3] = key[3]=randgen.nextInt(9);

     //    System.out.print("Password= ");
        for (int k : key) {
        //    System.out.print(k);
            sok = sok + k;
        }
        System.out.println(" Welcome to DOOM2 RPG Vanding machine hack Add 4 number to get sum of total of total to get Password\nSum= " + sok);
    }

    @Override
    public void GetInput() { //get input for code;
        try {

        if(CelChk[top]==true){
        top++;
        }else{

            System.out.print( " Try= " + not + " Enter digit in cell " + top+" : ");
            userInp[top] = sc.nextInt();
            if(userInp[top]<0||userInp[top]>9){
                System.out.println("Number should be bw 0 and 9");
            }else{

                top++;
            }
        }
            System.out.println("");

        } catch (Exception e) {
            System.out.println("Error!! " + e.getMessage());

        }
    }

    @Override
    public void ShowOutput() { //Show full code
        for (int i=0;i<=3;i++) {
            try {
                System.out.print("You entered = " +userInp[i]+" At Slider "+i);

                if(userInp[i]==key[i]){
                    System.out.print(" == ");
                }else if(userInp[i]>key[i]){
                    System.out.print(" > ");
                }else if(userInp[i]<key[i]){
                    System.out.print(" < ");

                }
                System.out.println("");
            } catch (Exception e) {
                System.out.println("Error output entire code !! " + e.getMessage());
            }
        }

    }

    @Override
   public int ShowOutput(int loc){ //show specific location
       try {
           return  userInp[loc];
       } catch (Exception e){
           System.out.println("Output loc Error!! "+e.getMessage());
       }
       return -3 ;

    }

    @Override
    public boolean Verify() {
        ChkCell();
        if (key.length != userInp.length) {
            return false;
        }

        for (int i = 0; i < key.length-1 ; i++) {
            if (key[i] != userInp[i]) {
                return false;
            }
        }
        ChkCell();
        return true;
    }
@Override
    public void ChkCell(){ //check each cell wether it match orignal key or not booleam
    for(int i=0;i<=3;i++){
        if(key[i]==userInp[i]){
        CelChk[i]=true;
        }else {
        CelChk[i]=false;
        }
    }
    }
}



class PowerUp extends UserInput implements PopUpGameFunc  {
    private  int tc=0,fc=0;
@Override
    public  void Chk_tf_cell(){ //check nmber of True and false in cell;
    for(int i=0;i<=3;i++){
        if(CelChk[i]==true){
            tc++;
        }else{
            fc++;
        }
    }

    }
    public PowerUp() {
        super();
    }
public  void GetUserInput(){
     while (not>0||isTrue==false){
       if(not==0){
           System.out.println("Game over!! you are out of trys!!");
           break;
       }else if(isTrue==true&&tc==3&&fc==0){
           System.out.println("You are winer!!Vending Machine Hack sucessful!!");
           break;
       }else {
        //   System.out.println(" Welcome to DOOM2 RPG Vanding machine hack Add 4 number to get sum of total of total to get Password\nSum= " + sok);
               if(top==4){

                    ShowOutput();
                   if(Verify()==true){
                       isTrue=true;
                   }else{
                       isTrue=false;
                       top=0;
                       not--;
                   }

               }else{
                   GetInput();
               }

       }
     }
}
}

public class PowerUpGamesD2RPG   {
    public static void main(String[] args) {
        PowerUp pop = new PowerUp();
        pop.GetUserInput();
    }
}
