package frames;

import java.awt.Button;
import java.awt.Frame;

public class FrameGrafoDirecionado extends Frame {

	public FrameGrafoDirecionado() {

	      // creating a button   
	      Button b = new Button("Grafo Direcionado");  
	  
	      // setting button position on screen  
	      b.setBounds(30,100,80,30);  
	  
	      // adding button into frame    
	      add(b);  
	  
	      // frame size 300 width and 300 height    
	      setSize(300,300);  
	  
	      // setting the title of Frame  
	      setTitle("Grafo Direcionado");   
	          
	      // no layout manager   
	      setLayout(null);   
	  
	      // now frame will be visible, by default it is not visible    
	      setVisible(true);  
	}
}
