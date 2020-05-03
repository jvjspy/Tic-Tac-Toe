import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class IconFactory {
	private static ImageIcon X,O,restart;
	private static ImageIcon load(String name){
		ImageIcon icon=null;
		try {
			icon = new ImageIcon(ImageIO.read(IconFactory.class.getResource(name)));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Can't load "+name,"Error!",JOptionPane.ERROR_MESSAGE);
		}
		return icon;
	}
	public static ImageIcon getIcon(Icon icon){
		if(icon==Icon.X){
			if(X==null){
				X=load("x.png");
			}
			return X;
		}
		if(icon==Icon.O){
			if(O==null){
				O=load("o.png");
			}
			return O;
		}
		if(icon==Icon.RESTART){
			if(restart==null){
				restart=load("restart.png");
			}
			return restart;
		}
		return null;
	}
}
//end
























//end
