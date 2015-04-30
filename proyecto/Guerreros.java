import greenfoot.*;
public class Guerreros extends Minibase
{
    private int band;
    private int x;
    private int y;
    private int band2;
    private int i;
    private int h;
    private GreenfootImage[] dragon=new GreenfootImage[4];
    private int cambio;
    public Guerreros()
    {
        band=0;
        band2=0;
        h=0;
        cambio=0;
        for(i=0;i<4;i++)
            dragon[i]=new GreenfootImage("dragon_"+i+".png");
     
        
    }
    public void act() 
    {
       MouseInfo mouse=Greenfoot.getMouseInfo();  
       elimina();
       if(Greenfoot.mouseClicked(this))
       {
           band=1;
           removeTouching(MiniSelecciones.class);
           removeTouching(Guerrero2.class);
       }
       if(band==1&&Greenfoot.mouseClicked(null))
       {
           x=mouse.getX();
           y=mouse.getY();
           band2=1;
           turnTowards(mouse.getX(),mouse.getY());
       }
       if(band2==1)
       {
            if(getX()>x-5&&getX()<x+5||getY()>y-5&&getY()<y+5)
            { setImage(dragon[3]);
                band2=0;
            }
            else
            {
               setImage(dragon[h]);//permite el cambio de imagenes
               h+=1;
               if(h==4)
               h=0;
               move(20); 
            }  
       }  
       if(Greenfoot.isKeyDown("q"))
          band=0;
    }    
    
    public void seleccionEjercito(int x,int y)
    {
        getWorld().addObject(new Bueno(),660+(x/10),10+(y/10));

    }

    public void elimina()//cuando toca a los enemigos
    {
        if(isTouching(BuldierEnemigo.class))
        {
            band=1;
            if(Greenfoot.getRandomNumber(50)==25)
            {
                removeTouching(BuldierEnemigo.class);
                band=0;
            }
            ataque();
        }else
        if(isTouching(MinibaseEnemiga.class))
        {
            band=1;
            if(Greenfoot.getRandomNumber(50)==25)
            {
                removeTouching(MinibaseEnemiga.class);
                band=0;
            }
            ataque();
        }
        else
        if(isTouching(Enemigo.class))
        {
            band=1;
            if(Greenfoot.getRandomNumber(50)==25)
            {
                removeTouching(Enemigo.class);
                band=0;
            }
            ataque();
        }
    }

    public void ataque()
    {
        setImage(dragon[cambio]);//permite el cambio de imagenes
        cambio+=1;
        if(cambio==2)
            cambio=0;
    }
}
