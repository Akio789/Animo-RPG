import items;

public class Casilla{

private Item item;
private Heroe heroe;
private Enemigo enemigo;


public void setHeroe(Heroe heroe){
this.heroe=heroe	
}

public Heroe getHeroe(){
return heroe;	
}


public void setItem(Item item){
this.item=item;	
}//fin set item

public Item getItem(){
return item;
}//fin get item

public void setEnemigo(Enemigo enemigo){
this.enemigo=enemigo;	
}//fin set enemigo

public Enemigo getEnemigo(){
return enemigo;	
}//fin set

public void setRestauracion(){
this.restauracion=restauracion;	
}//fin set restauracion

public boolean getRestauracion(boolean restauracion){
return restauracion;	
}//fin get restauracion



}