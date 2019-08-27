public class HeyJude{
    public static String HEY = "Hey Jude ";
    public static String DON = "don't ";
    public static String MAK = "make it bad.";
    public static String BEA = "be afraid.";
    public static String LET = "let me down.";
    public static String TAK = "Take a sad song and make it better.";
    public static String YOW = "You were made to go out and get her.";
    public static String YOH = "You have found her, now go and get her.";
    public static String REM = "Remember to ";
    public static String LEH = "let her into you heart.";
    public static String LES = "let her into your skin.";
    public static String THE = "Then you ";
    public static String CAN = "can start ";
    public static String BEG = "begin ";
    public static String TOM = "to make it better ";
    public static String BET = "better ";
    public static String NA  = "na ";
    public static String THM = "The minute";
    public static String AND = "And anytime you feel the pain, hey Jude, refrain,\n"
	                            + "Don’t carry the world upon your shoulders.\n"
                                    + "For well you know that it’s a fool who plays it cool\n"
	                            + "By making his world a little colder.";

    public static String SOL = "So let it out and let it in, hey Jude, begin,\n"
	                            + "You’re waiting for someone to perform with.\n"
	                            + "And don’t you know that it’s just you, hey jude, you’ll do,\n"
	                            + "The movement you need is on your shoulder.";
    public static String verso = "p";
    public static int repGen = 0;
    public static int estrofa;
    public static void main(String[] args){
	for (estrofa=1; estrofa<7 ; ++estrofa) {
    switch (estrofa) {
      //case 6: estos comentarios están como testigos de un método que no resultó para resumir el caso 1 y 2, que son casi el mismo.
      case 1: verso = HEY + DON + MAK + "\n" + TAK + "\n" + REM + LEH + "\n" + THE + CAN + TOM;
    //  if (repGen!=0) {
    //while (repGen<=23) {
    //verso = verso + BET;
      //}
          //}
      break;

      case 2: verso = HEY + DON + BEA + "\n" + YOW + "\n" + THM + LES + "\n" + THE + BEG + TOM;
      break;

      case 3: verso = AND + "\n";
      while (repGen<=8) {
        verso = verso + NA ;
        repGen++;
        if (repGen==5) {
          verso = verso + "\n";
        }
      }
      break;

      case 4: verso = HEY + DON + LET + "\n" + YOH + "\n" + REM + LEH + "\n" + THE + CAN + TOM;
      break;

      case 5: verso = SOL + "\n";
      while (repGen<=18) {
        verso = verso + NA ;
        repGen++;
        if (repGen==14) {
          verso = verso + "\n";
        }
      }
      break;

      case 6: verso = HEY + DON + MAK + "\n" + TAK + "\n" + REM + LEH + "\n" + THE + CAN + TOM ;
      while (repGen<=23) {
      verso = verso + BET;
      repGen++;
    }
      break;

    }
    System.out.println(verso + "\n");
    }
    estrofa=0;
    verso ="";
    while (estrofa<=10) {
      verso=verso+NA;
      estrofa++;
      if (estrofa==7) {
        verso=verso+"\n";
      } else if (estrofa==11) {
        verso=verso+HEY;
      }
    }
    while (estrofa<=29) {
      System.out.println("\n"+verso);
      estrofa++;
    }
    }
	}
