package Objects.InputController;

public class Commend {

    private String input;

    public Commend(String inp){
        inp = inp.replaceAll("\s+"," ");
        this.input = inp;
    }

    public Inputs getType() {
        String first = input.split(" ")[0];
        return Inputs.getEnum(first);
    }

    public String[] getSplited(){
        String[] splt = input.split(" ");
        return splt;
    }
}
