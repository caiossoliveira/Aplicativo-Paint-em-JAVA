package primitivas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import util.JPanelGraphics;


public class Primitivas extends JPanelGraphics {
    
    Image background;
    public BufferedImage imagem =
			new BufferedImage(this.getPreferredSize().width, this.getPreferredSize().height,
                                BufferedImage.TYPE_INT_ARGB);
    public Primitivas(Dimension d) {
        super(d);
    }
    
    public void desenharPixel(int x, int y, Color rgb) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(rgb);
        g.drawLine(x, y, x, y);
        repaint();
    }
    
    public void lapis(int x, int y){
        desenharPixel(x, y, Color.BLACK);
    }
    
    public void backup(){
        background = this.copyImage(image);
    }
    
    private BufferedImage copyImage(Image img){
        BufferedImage copyOfImage = new BufferedImage(getSize().width, getSize().height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = copyOfImage.createGraphics();
       // g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        return copyOfImage;
    }
    
    public void returnup(){
        
     Graphics2D g = (Graphics2D) background.getGraphics();
     g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
     image = (BufferedImage) this.copyImage(background);
     repaint();
    }
    
    
    public void limpar() {
        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) image.getGraphics();
        g2d.setColor(Color.WHITE);
        repaint();
    }
    
    public void linha (int x1, int y1, int x2, int y2){
       
        returnup();
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
//        double a = (y2 - y1) / (x2 - x1);
//        for (int x = x1; x <= x2; x++) {
//            int y = (int) (y1 + a * (x - x1));
//            desenharPixel(x, y, Color.BLACK);
//        }
        
        g.drawLine(x1, y1, x2, y2);
        repaint();
        
    }
    
    public void Elipse(int x1, int y1, int x2, int y2){
        returnup();
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
        g.drawOval(x1, y1, x2-x1, y2-y1);
        repaint();
    }
    
    public void Retangulo(int x1, int y1, int x2, int y2){
        
        //limpar();
        returnup();
        
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
        g.drawRect(x1, y1, x2-x1, y2-y1);
        repaint();
    }
    
    public void Triangulo(int x1, int y1, int x2, int y2){
        
        returnup();
        
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
        //desenha as três linhas do triângulo
        g.drawLine(x1, y1, x2, y1);
        g.drawLine(x2, y1,(int) x1 + ((x2 - x1)/2), y2);
        g.drawLine((int) x1 + ((x2-x1)/2), y2, x1, y1);
        repaint();
    }
    
    public void Borracha(int x1, int y1, int x2, int y2){
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(x1, y1, x2, y2);
        repaint();
    }
    
    public void Pentagono(int x1, int y1, int x2, int y2){
        
        returnup();
        
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
        
        g.drawLine((int) x1+((x2-x1)/4), y1, (int)((3*x2) + x1) /4, y1);
        g.drawLine((int)((3*x2)+x1)/4, y1, x2, (int)(y2+y1)/2);
        g.drawLine(x2, (int)(y2+y1)/2, (int)(x2+x1)/2, y2);
        g.drawLine((int)(x2+x1)/2, y2, x1, (int)(y2+y1)/2);
        g.drawLine(x1, (int)(y2+y1)/2, (int) x1+((x2-x1)/4), y1);
        
        repaint();
    }
    
    public void Losango(int x1, int y1, int x2, int y2){
        
        returnup();
        
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
        
        g.drawLine((int)(x2+x1)/2, y1, x2, (int)(y2+y1)/2);
        g.drawLine(x2, (int)(y2+y1)/2, (int)(x2+x1)/2, y2);
        g.drawLine((int)(x2+x1)/2, y2, x1, (int)(y2+y1)/2);
        g.drawLine(x1, (int)(y2+y1)/2, (int)(x2+x1)/2, y1);
        
        repaint();
    }
    
    public void SetaVertical(int x1, int y1, int x2, int y2){
        
        returnup();
        
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
        
        g.drawLine((int) (x1+x2)/2, y2, x2,(int) (y1+y2)/2);
        g.drawLine(x2, (int)(y1+y2)/2,(int)(((x1+x2)/2)+x2)/2, (int)(y1+y2)/2);
        g.drawLine((int)(((x1+x2)/2)+x2)/2,(int) (y1+y2)/2, (int)(((x1+x2)/2)+x2)/2, y1);
        g.drawLine((int)(((x1+x2)/2)+x2)/2, y1,(int)(((x1+x2)/2)+x1)/2, y1);
        g.drawLine((int)(((x1+x2)/2)+x1)/2, y1, (int)(((x1+x2)/2)+x1)/2, (int)(y2+y1)/2);
        g.drawLine((int)(((x1+x2)/2)+x1)/2, (int)(y2+y1)/2,x1, (int)(y1+y2)/2);
        g.drawLine(x1, (int)(y1+y2)/2, (int)((x2+x1)/2), y2);
        
        repaint();
        
    }
    
    public void SetaHorizontal(int x1, int y1, int x2, int y2){
        
        returnup();
        
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
             
        g.drawLine(x2 ,(int) (y1+y2)/2, (int)(x2+x1)/2,y2);
        g.drawLine((int)(x2+x1)/2,y2,(int)(x2+x1)/2,(int)(((y1+y2)/2)+y2)/2);
        g.drawLine((int)(x2+x1)/2,(int)(((y1+y2)/2)+y2)/2, x1, (int)(((y1+y2)/2)+y2)/2);
        g.drawLine(x1, (int)(((y1+y2)/2)+y2)/2, x1, (int)(((y1+y2)/2)+y1)/2);
        g.drawLine(x1, (int)(((y1+y2)/2)+y1)/2,(int)(x2+x1)/2,(int)(((y1+y2)/2)+y1)/2);
        g.drawLine((int)(x2+x1)/2,(int)(((y1+y2)/2)+y1)/2,(int)(x1+x2)/2,y1);
        g.drawLine((int)(x1+x2)/2,y1 ,x2 ,(int) (y1+y2)/2);

        repaint();
    }
    
    public void Hexagono(int x1, int y1, int x2, int y2){
        
        returnup();
        
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
      
        g.drawLine((int)x1+((x2-x1)/4),y1,(int)((3*x2)+x1)/4, y1);
        g.drawLine((int)((3*x2)+x1)/4,y1,x2,(int)(y2+y1)/2);
        g.drawLine(x2,(int)(y2+y1)/2,(int)((3*x2)+x1)/4 ,y2);
        g.drawLine((int)((3*x2)+x1)/4 ,y2, (int)x1+((x2-x1)/4), y2);
        g.drawLine((int)x1+((x2-x1)/4), y2,x1,(int)(y2+y1)/2);
        g.drawLine(x1,(y2+y1)/2,(int)x1+((x2-x1)/4),y1);
        
        repaint();
    }
    
    public void Estrela4(int x1, int y1, int x2, int y2){
        
        returnup();
        
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
           
        
            g.drawLine(x1+((x2-x1)/2), y1, x1+(((x2-x1)/2) - ((x2-x1)/8)), y1+(((y2-y1)/2) - ((y2-y1)/8)));
            g.drawLine(x1+((x2-x1)/2), y1, x1+(((x2-x1)/2) + ((x2-x1)/8)), y1+(((y2-y1)/2) - ((y2-y1)/8)));
            g.drawLine(x1+(((x2-x1)/2) - ((x2-x1)/8)), y1+(((y2-y1)/2) - ((y2-y1)/8)), x1, y1+((y2-y1)/2));
            g.drawLine(x1+(((x2-x1)/2) + ((x2-x1)/8)), y1+(((y2-y1)/2) - ((y2-y1)/8)), x2, y1+((y2-y1)/2));
            g.drawLine(x1, y1+((y2-y1)/2), x1+(((x2-x1)/2) - ((x2-x1)/8)), y1+(((y2-y1)/2) + ((y2-y1)/8)));
            g.drawLine(x2, y1+((y2-y1)/2), x1+(((x2-x1)/2) + ((x2-x1)/8)), y1+(((y2-y1)/2) + ((y2-y1)/8)));
            g.drawLine(x1+(((x2-x1)/2) - ((x2-x1)/8)), y1+(((y2-y1)/2) + ((y2-y1)/8)), x1+((x2-x1)/2), y2);
            g.drawLine(x1+(((x2-x1)/2) + ((x2-x1)/8)), y1+(((y2-y1)/2) + ((y2-y1)/8)), x1+((x2-x1)/2), y2);
        
        repaint();
    }
    
     public void Estrela5(int x1, int y1, int x2, int y2){
        
        returnup();
        
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
           
            
            g.drawLine(x1+((x2-x1)/2), y1, x1+((x2-x1)/2) - (x2-x1)/8, y1+((y2-y1)/2) - (y2-y1)/8);
            g.drawLine(x1+((x2-x1)/2), y1, x1+((x2-x1)/2) + (x2-x1)/8, y1+((y2-y1)/2) - (y2-y1)/8);
            g.drawLine(x1+((x2-x1)/2) - (x2-x1)/8, y1+((y2-y1)/2) - (y2-y1)/8, x1, y1+((y2-y1)/2) - (y2-y1)/8);
            g.drawLine(x1+((x2-x1)/2) + (x2-x1)/8, y1+((y2-y1)/2) - (y2-y1)/8, x2, y1+((y2-y1)/2) - (y2-y1)/8);
            g.drawLine(x1, y1+((y2-y1)/2) - (y2-y1)/8, x1+((x2-x1)/2) - (x2-x1)/4, y1+((y2-y1)/2) + (y2-y1)/8);
            g.drawLine(x2, y1+((y2-y1)/2) - (y2-y1)/8, x1+((x2-x1)/2) + (x2-x1)/4, y1+((y2-y1)/2) + (y2-y1)/8);
            g.drawLine(x1+((x2-x1)/2) - (x2-x1)/4, y1+((y2-y1)/2) + (y2-y1)/8, x1+(x2-x1)/8, y2);
            g.drawLine(x1+((x2-x1)/2) + (x2-x1)/4, y1+((y2-y1)/2) + (y2-y1)/8, x2-(x2-x1)/8, y2);
            g.drawLine(x1+(x2-x1)/8, y2, x1+((x2-x1)/2), y1+((y2-y1)/2) + (y2-y1)/4);
            g.drawLine(x2-(x2-x1)/8, y2, x1+((x2-x1)/2), y1+((y2-y1)/2) + (y2-y1)/4);
        
        repaint();
    }
    
    public void LetraC(int x1, int y1, int x2, int y2){
        
        returnup();
        
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
        
        g.drawLine(x1, y2, x2, y2);
        g.drawLine(x1, y2, x1, y1);
        g.drawLine(x1, y1, x2, y1);
        
        g.drawLine(x2, y1, x2, (int) ((y2 - y1) * 0.20) + y1);
        g.drawLine(x2, y2, x2, y2 - (int) ((y2 - y1) * 0.20));
        g.drawLine(x2, (int) ((y2 - y1) * 0.20) + y1, (int) (x1 + ((x2 - x1) * 0.20)), (int) ((y2 - y1) * 0.20) + y1);
        g.drawLine(x2, (int) (y2 - ((y2 - y1) * 0.20)), (int) (x1 + ((x2 - x1) * 0.20)), (int) (y2 - ((y2 - y1) * 0.20)));
        g.drawLine((int) (x1 + ((x2 - x1) * 0.20)), (int) ((y2 - y1) * 0.20) + y1, (int) (x1 + ((x2 - x1) * 0.20)), (int) (y2 - ((y2 - y1) * 0.20)));

    }
    
    public void LetraG(int x1, int y1, int x2, int y2){
        
        limpar();
        
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
                
        g.drawLine(x1, y1, x2, y1);
        g.drawLine(x1, y1, x1, y2);
        g.drawLine(x1, y2, x2, y2);
        g.drawLine(x2, y2, x2,(int) (y2+y1)/2);        
        g.drawLine((int)(x1+x2)/2, (int)(y1+y2)/2, x2,(int)(y2+y1)/2);
        g.drawLine(x2, y1 ,x2,(int)((y2+y1)*0.25));
        g.drawLine((int)((x1+x2)*0.3), (int)((y2+y1)*0.25), x2, (int)((y2+y1)*0.25));
        g.drawLine((int)((x1+x2)*0.3),(int)((y2+y1)*0.25), (int)((x1+x2)*0.3), (int)((y2+y1) -((y2+y1)*0.25)));
        g.drawLine((int)((x1+x2)*0.3), (int)((y2+y1) -((y2+y1)*0.25)), (int)((x1+x2)-((x1+x2)*0.3)) , (int)((y2+y1) -((y2+y1)*0.25)));    
        g.drawLine((int)((x1+x2)-((x1+x2)*0.3)),(int)(((y2+y1)-((y2+y1)*0.25))),(int)((x1+x2)-((x1+x2)*0.3)),              
              (int) ( (-((y2+y1)*0.25)+(((y2+y1)-((y2+y1)*0.25)))) *1.25 )); 
        g.drawLine((int)((x1+x2)/2), (int)(((y1+y2)/2)*1.25), (int)(int)((x1+x2)-((x1+x2)*0.3)), (int) (((y1+y2)/2)*1.25));
        g.drawLine(((x1+x2)/2),((y1+y2)/2),((x1+x2)/2),(int) (((y1+y2)/2)*1.25));
        
        
        repaint();
    }
    
    public void Casa(int x1, int y1, int x2, int y2){
        
        returnup();
        
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
        
       int ix = Math.min(x1, x2);
        int fx = Math.max(x1, x2);
        int iy = Math.min(y1, y2);
        int fy = Math.max(y1, y2);
        int ponto_mx = ix+(fx-ix)/2;
        int ponto_my = iy+(fy-iy)/2;
        int largura = (fx-ix);
        int altura = (fy-iy);
        
            g.drawLine(ix,fy, ix, ponto_my);
            g.drawLine(ix, ponto_my, ponto_mx, iy);
            g.drawLine(ponto_mx, iy, fx, ponto_my);
            g.drawLine(fx, ponto_my, ix, ponto_my);
            g.drawLine(fx, ponto_my, fx, fy);
            g.drawLine(fx, fy, fx-3*largura/8, fy);
            g.drawLine(fx-3*largura/8, fy, fx-3*largura/8, fy-altura/4);
            g.drawLine(fx-3*largura/8, fy-altura/4, ponto_mx-1*largura/8, fy-altura/4);
            g.drawLine(ponto_mx-1*largura/8, fy-altura/4, ponto_mx-1*largura/8, fy);
            g.drawLine(ponto_mx-1*largura/8, fy, ix, fy);
            g.drawOval(fx-15*largura/32, fy-altura/8, largura/16, altura/16);
            g.drawRect(ix + 1*largura/32, ponto_my + 5*altura/32, largura/8, altura/8);
            g.drawRect(fx - 5*largura/32, ponto_my + 5*altura/32, largura/8, altura/8);
            g.drawLine(ix + 3*largura/32, ponto_my + 5*altura/32,
                    ix + 3*largura/32, ponto_my + 9*altura/32-1);
            g.drawLine(fx - 3*largura/32, ponto_my + 5*altura/32,
                    fx - 3*largura/32, ponto_my + 9*altura/32-1);
            g.drawLine(ix + 1*largura/32, ponto_my + 7*altura/32,
                    ix + 5*largura/32-1, ponto_my + 7*altura/32);
            g.drawLine(fx - 5*largura/32, ponto_my + 7*altura/32,
                    fx - 1*largura/32-1, ponto_my + 7*altura/32);
            
    }

    public void Carro(int x1, int y1, int x2, int y2) {
        
        returnup();
        
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
        int ix = Math.min(x1, x2);
        int fx = Math.max(x1, x2);
        int iy = Math.min(y1, y2);
        int fy = Math.max(y1, y2);
        int ponto_mx = ix+(fx-ix)/2;
        int ponto_my = iy+(fy-iy)/2;
        int largura = (fx-ix);
        int altura = (fy-iy);
        
            g.drawLine(ix, fy-altura/8, ix, iy + altura/2);
            g.drawLine(ix, iy+altura/2, ponto_mx-largura/4, iy+altura/2);
            g.drawLine(ponto_mx-largura/4, iy+altura/2, ponto_mx-largura/8, iy);
            g.drawLine(ponto_mx-largura/8, iy, ponto_mx+largura/8, iy);
            g.drawLine(ponto_mx+largura/8, iy, ponto_mx+largura/4, iy+altura/2);
            g.drawLine(ponto_mx+largura/4, iy+altura/2, fx, iy+altura/2);
            g.drawLine(fx, iy+altura/2, fx, fy-altura/8);
            g.drawLine(fx, fy-altura/8, fx-largura/8, fy-altura/8);
            g.drawOval(fx-3*largura/8, fy - 2*altura/8, largura/4, altura/4);
            g.drawLine(fx-3*largura/8, fy-altura/8,fx-4*largura/8, fy-altura/8);
            g.drawOval(fx-6*largura/8, fy - 2*altura/8, largura/4, altura/4);
            g.drawLine(fx-6*largura/8, fy-altura/8,ix, fy-altura/8);
            g.drawLine(ponto_mx-largura/4, iy+altura/2,ponto_mx+largura/4, iy+altura/2);
            g.drawLine(ponto_mx-largura/8, iy, ponto_mx-largura/8, iy+altura/2);
            g.drawLine(ponto_mx+largura/8, iy, ponto_mx+largura/8, iy+altura/2);
        
    }
    
    
           
    
}
