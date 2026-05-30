public class GenCube {
    
    public static void main(String[] args){
        Cube c1 = new Cube();
        Mover m1 = new Mover(c1);

        System.out.println(c1);
        System.out.println();
        m1.moveU(1);
        System.out.println(c1);
        System.out.println();

        m1.moveB(1);
        System.out.println(c1);
        System.out.println();

        System.out.println(c1.getPieceAt(1, 0, 0));
        System.out.println();
    }

}
