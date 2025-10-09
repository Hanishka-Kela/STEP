interface Printer { void connect(); }
interface Scanner { void connect(); }
class AllInOneMachine implements Printer, Scanner { public void connect() { System.out.println("Connected"); } }
public class AllInOneTest { public static void main(String[] args) { Printer p = new AllInOneMachine(); Scanner s = new AllInOneMachine(); p.connect(); s.connect(); } }