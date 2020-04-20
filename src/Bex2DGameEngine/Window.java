package Bex2DGameEngine;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.VolatileImage;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Window extends JFrame {
	
	private static final long serialVersionUID = -3894555734773211930L;

	private Canvas canvas;
	
	private static int screenWidth;
	private static int screenHeight;
	
	private static int oldWidth;
	private static int oldHeight;
	
	private GraphicsConfiguration config;
	
	private static final int NUMBER_OF_BUFFERS = 3;
	
	public Window(String name, GraphicsConfiguration config, int x, int y, int width, int height) {
		super(name, config);
		
		this.config = config;
		
		screenWidth = width;
		screenHeight = height;
		
		setLocation(x, y);
		setMinimumSize(new Dimension(1600,900));
		setSize(width, height);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		updateLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		setVisible(true);
		
		initComponents();
		addComponents();
		addEventListeners();
		
	}
	
	private void updateLookAndFeel(String laf) {
		try {
			UIManager.setLookAndFeel(laf);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
	private void initComponents() {
		canvas = new Canvas(config);
	}
	
	private void addComponents() {
		add(canvas);
		canvas.createBufferStrategy(NUMBER_OF_BUFFERS);
	}
	
	/**
	 * Adds component resize listener that updates the screen width and height variables.
	 * This is done instead of getWidth() or getHeight() because other objects might need
	 * access to the screen width and height without using a window object.
	 */
	private void addEventListeners() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				oldWidth = screenWidth;
				oldHeight = screenHeight;
				screenWidth = getWidth();
				screenHeight = getHeight();
				Game.resize();
			}
		});
		
		Mouse mouse = new Mouse();
		
		canvas.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					mouse.pressLeft();
				}
				if(e.getButton() == MouseEvent.BUTTON3) {
					mouse.pressRight();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					mouse.releaseLeft();
				}
				if(e.getButton() == MouseEvent.BUTTON3) {
					mouse.releaseRight();
				}
			}
			
		});
		
		canvas.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
					mouse.setX(e.getX());
					mouse.setY(e.getY());
			}
			
		});
	}
	
	public static int getScreenWidth() {
		return screenWidth;
	}
	
	public static int getScreenHeight() {
		return screenHeight;
	}
	
	public static int getOldScreenWidth() {
		return oldWidth;
	}
	
	public static int getOldScreenHeight() {
		return oldHeight;
	}
	
	public BufferStrategy getBufferStrat() {
		return canvas.getBufferStrategy();
	}
	
	public VolatileImage getVolatileImage() {
		return config.createCompatibleVolatileImage(getScreenWidth(), getScreenHeight());
	}
	
	public GraphicsConfiguration getGraphicsConfig() {
		return canvas.getGraphicsConfiguration();
	}
	
}