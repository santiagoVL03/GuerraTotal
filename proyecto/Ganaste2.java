import greenfoot.*;
/**
 * Crea un anuncio en mundo de Ganaste que al salirte te mostrara otro letrero de continuar, hace que suene 
 * una explosion.Este te manda al nivel 3
 */
public class Ganaste2 extends Ganaste
{

    /**
     * Constructor for objects of class Ganaste2.
     * 
     */
    public Ganaste2()
    {
        Continuar2 bp=new Continuar2();
        addObject(bp,400,650);
    }
}
