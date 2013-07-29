
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class PanelPrincipal extends JPanel {
	JButton btnJ1, btnJ2, btnJ3, btnJ4, btnJ5, btnReglas,btnHistoria;
	JLabel jLabel1, jLabel2, jLabel3;
	VentanaReglas ventanaReglas;
	VentanaHistoria ventanaHistoria;
	TableroHnefatafl tableroHnefatafl;
	TableroTawlBwrdd tableroTawlBwrdd;
	TableroAleaEvangelii tableroAleaEvangelii;
	TableroTablut tableroTablut;
	TableroArdRi tableroArdRi;
	ManejadorTablero manejadorTablero;
	ManejadorRey manejadorRey;
	ManejadorFichas manejadorFichas;
	String[] ubicacion = {"/imagenes/fondo.jpg","/imagenes/fondo2.jpg"};
	int posFondo;
	
	public PanelPrincipal(VentanaReglas vR, VentanaHistoria vH,ManejadorTablero mT, ManejadorRey mR,ManejadorFichas mF) {
		posFondo = new Random().nextInt(2);
		initComponents();
		this.ventanaReglas = vR;
		this.ventanaHistoria = vH;
		this.manejadorTablero = mT;
		this.manejadorRey = mR;
		this.manejadorFichas = mF;
		this.setSize(795,458);
		setVisible(true);
	}


	private void initComponents() {
		btnJ1 = new JButton();
		btnJ2 = new JButton();
		btnJ3 = new JButton();
		btnJ4 = new JButton();
		btnJ5 = new JButton();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		btnReglas = new JButton();
		btnHistoria = new JButton();

		btnJ1.setFont(new java.awt.Font("Tahoma", 0, 12)); 
		btnJ1.setText("Hnefatafl");
		btnJ1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnClic(evt,1);
			}
		});

		btnJ2.setFont(new java.awt.Font("Tahoma", 0, 12)); 
		btnJ2.setText("Tawl Bwrdd");
		btnJ2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnClic(evt,2);
			}
		});

		btnJ3.setFont(new java.awt.Font("Tahoma", 0, 12)); 
		btnJ3.setText("Alea Evangelii");
		btnJ3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnClic(evt,3);
			}
		});

		btnJ4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		btnJ4.setText("Tablut");
		btnJ4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnClic(evt,4);
			}
		});

		btnJ5.setFont(new java.awt.Font("Tahoma", 0, 12)); 
		btnJ5.setText("Ard-Ri");
		btnJ5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnClic(evt,5);
			}
		});

		jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18));
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
		jLabel1.setText("\"Ajedrez Vikingo\"");

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel2.setForeground(new java.awt.Color(255, 255, 255));
		jLabel2.setText("Por favor elige una modalidad");

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel3.setForeground(new java.awt.Color(255, 255, 255));
		jLabel3.setText("de juego.");

		btnReglas.setText(" Reglas ");
		btnReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnReglasClic(evt);
			}
		});
		
		btnHistoria.setText("Historia");
		btnHistoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnHistoriaClic(evt);
			}
		});
		

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(btnJ1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnJ2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnJ3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnJ4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnJ5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(38, 38, 38))
																.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																		.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addContainerGap())
																		.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																				.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGap(77, 77, 77))))
																				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
																						.addComponent(btnReglas)
																						.addComponent(btnHistoria)
																						)))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(btnJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnJ2)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnJ3))
										.addGroup(layout.createSequentialGroup()
												.addGap(22, 22, 22)
												.addComponent(jLabel1)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jLabel2)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jLabel3)))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnJ4)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnJ5)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
												.addComponent(btnReglas)
												.addComponent(btnHistoria)
												.addGap(45, 45, 45))
				);
	}

	private void btnReglasClic(ActionEvent evt) {
		ventanaReglas.setVisible(true);
	}
	
	private void btnHistoriaClic(ActionEvent evt) {
		ventanaHistoria.setVisible(true);
	}

	private void btnClic(ActionEvent evt,int x) {//GEN-FIRST:event_jButton1ActionPerformed
		
		switch(x){
		case 1:
			tableroHnefatafl = new TableroHnefatafl(manejadorTablero,manejadorRey,manejadorFichas);
			break;
		case 2:
			tableroTawlBwrdd = new TableroTawlBwrdd(manejadorTablero,manejadorRey,manejadorFichas);
			break;
		case 3:
			tableroAleaEvangelii = new TableroAleaEvangelii(manejadorTablero,manejadorRey,manejadorFichas);
			break;
		case 4:
			tableroTablut = new TableroTablut(manejadorTablero,manejadorRey,manejadorFichas);
			break;
		case 5:
			tableroArdRi = new TableroArdRi(manejadorTablero,manejadorRey,manejadorFichas);
			break;
		}	
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		Dimension tamanio = getSize();
		ImageIcon imagenfondo = new ImageIcon(getClass().getResource(ubicacion[posFondo]));
		g.drawImage(imagenfondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}

}
