public class Room{
    Room forward = null;
    Room backward = null;
    Room left = null;
    Room right = null;
    String desc = null;
    String[] possibleDesc = {
                            "desc0",
                            "desc1", 
                            "desc2",
                            "desc3",
                            "desc4",
                            "desc5",
                            "desc6",
                            "desc7",
                            "desc8",
                            "desc9"
                            };
    
    public void assignDesc(){
        desc = possibleDesc[(int)(Math.random()*10)];
    }
    
    public void assignSpawn(){
        desc = "welcome, rabbit. i assume you already know what to do, so i shall leave you to it.";
    }

    public void assignPage(){
        // add code
    }
}
