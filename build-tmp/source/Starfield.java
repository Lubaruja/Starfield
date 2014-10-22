import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

Particle [] literallyAllOfThem=new Particle[100];

public void setup()
{
	size(500,500);
	for(int a=2; a<100; a++)
	{
		literallyAllOfThem[a]=new NormalParticle();
	}
	literallyAllOfThem[0]= new OddballParticle();
	literallyAllOfThem[1]= new JumboParticle();
}
public void draw()
{
	fill(0,0,0,20);
	rect(-250,-250,1000,1000);
	translate(250, 250);
	for(int a=0;a<100;a++)
	{
		literallyAllOfThem[a].move();
		literallyAllOfThem[a].show();
	}
}
class NormalParticle implements Particle
{
	double x,y,speed,angle;
	int gerrard, radius;
	NormalParticle()
	{
		x=0;
		y=0;
		angle=Math.random()*2*Math.PI;
		speed=Math.random()*3;
		gerrard=color((int)(Math.random()*300),(int)(Math.random()*300),(int)(Math.random()*300));
		radius=5;
	}
	public void show()
	{
		noStroke();
		fill(gerrard);
		ellipse((float)x,(float)y,radius,radius);
	}

	public void move()
	{
		x=x+Math.cos(angle)*speed;
		y=y+Math.sin(angle)*speed;
		if(y>270 || y<-270 || x>270 || x<-270)
		{
			y=0;
			x=0;
			angle=Math.random()*2*Math.PI;
		}
	}
}
interface Particle
{
	public void show();
	public void move();
}
class OddballParticle implements Particle
{
	double x,y,speed,angle;
	int radius;
	OddballParticle()
	{
		x=0;
		y=0;
		angle=Math.random()*2*Math.PI;
		speed=Math.random()*3;
		radius=15;
	}
	public void show()
	{
		noStroke();
		fill(255);
		ellipse((float)x,(float)y,radius,radius);
	}

	public void move()
	{
		x=x+Math.cos(angle)*speed;
		y=y+Math.sin(angle)*speed;
		if(y>270 || y<-270 || x>270 || x<-270)
		{
			y=0;
			x=0;
			angle=Math.random()*2*Math.PI;
			speed=Math.random()*3;
		}
	}
}

class JumboParticle extends NormalParticle
{
	JumboParticle()
	{
		radius=50;
	}
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
