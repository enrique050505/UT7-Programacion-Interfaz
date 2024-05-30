package proyecto;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class InterfazApp extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Document pokemonInfo = null;
    private Document usuario = null;
    static JLabel lblCantidadMonedas = new JLabel();
    static JLabel lblText_InformacionGeneral = new JLabel("Información General");
    static JLabel lblMostrarNombre = new JLabel();
    static JLabel lblMostrarNumero = new JLabel();
    static JLabel lblImagenPokemon = new JLabel();
    static JLabel lblTipos = new JLabel("Tipo");
    static JLabel lblTipo1 = new JLabel();
    static JLabel lblTipo2 = new JLabel();
    static JTextArea textAreaDescripcion = new JTextArea();
    static JLabel lblText_Estadisticas = new JLabel("Estadísticas");
    static JLabel lbPS = new JLabel("PS");
    static JLabel lblMostrarPS = new JLabel();
    static JLabel lblAtaque = new JLabel("Ataque");
    static JLabel lblMostrarAtaque = new JLabel();
    static JLabel lblDefensa = new JLabel("Defensa");
    static JLabel lblMostrarDefensa = new JLabel();
    static JLabel lblATEsp = new JLabel("AT. ESP");
    static JLabel lblMostrarAtaqueEspecial = new JLabel();
    static JLabel lblDefEsp = new JLabel("DEF. ESP");
    static JLabel lblMostrarDefensaEspecial = new JLabel();
    static JLabel lblVelocidad = new JLabel("Velocidad");
    static JLabel lblMostrarVelocidad = new JLabel();
    static JLabel lblAltura = new JLabel("Altura");
    static JLabel lblMostrarAltura = new JLabel();
    static JLabel lblPeso = new JLabel("Peso");
    static JLabel lblMostrarPeso = new JLabel();
    static JLabel lblMensajeAlUsuario = new JLabel();
    static JLabel lblImgMonedas = new JLabel("");
    static JLabel lblIMG_Personaje = new JLabel("Bienvenido a la Pokédex. Elige bien con las monedas que tienes");
    static JLabel lblIMG_Pokemon = new JLabel("");
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfazApp frame = new InterfazApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public InterfazApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1421, 900);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        lblCantidadMonedas.setHorizontalAlignment(SwingConstants.CENTER);

        lblCantidadMonedas.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblCantidadMonedas.setForeground(new Color(0, 0, 0));
        lblCantidadMonedas.setBounds(52, 264, 70, 40);
        contentPane.add(lblCantidadMonedas);
        
        JPanel panelSeleccionPokemons = new JPanel();
        panelSeleccionPokemons.setBackground(Color.WHITE);
        panelSeleccionPokemons.setBounds(53, 330, 551, 459);
        contentPane.add(panelSeleccionPokemons);
        panelSeleccionPokemons.setLayout(null);
        
        JButton btnPokemon1 = new JButton();
        btnPokemon1.setBackground(new Color(220, 20, 60));
        btnPokemon1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ConectorMongo nuevoConector = new ConectorMongo();
        		Document infoPokemon = nuevoConector.mostrarInfo("Gyarados");
        		updateLabels(infoPokemon);
        	}
        });
        btnPokemon1.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnPokemon1.setBounds(57, 57, 213, 38);
        panelSeleccionPokemons.add(btnPokemon1);
        
        JButton btnPokemon2 = new JButton();
        btnPokemon2.setBackground(new Color(51, 204, 255));
        btnPokemon2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ConectorMongo nuevoConector = new ConectorMongo();
        		Document infoPokemon = nuevoConector.mostrarInfo("Squirtle");
        		updateLabels(infoPokemon);
        	}
        });
        btnPokemon2.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnPokemon2.setBounds(57, 213, 213, 38);
        panelSeleccionPokemons.add(btnPokemon2);
      
        JButton btnPokemon3 = new JButton();
        btnPokemon3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ConectorMongo nuevoConector = new ConectorMongo();
        		Document infoPokemon = nuevoConector.mostrarInfo("Lucario");
        		updateLabels(infoPokemon);
        	}
        });
        btnPokemon3.setBackground(new Color(0, 123, 167));
        btnPokemon3.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnPokemon3.setBounds(57, 380, 213, 38);
        panelSeleccionPokemons.add(btnPokemon3);
        
        //MOSTRAR NOMBRE Y PRECIO EN BOTON
        ConectorMongo nuevoConector = new ConectorMongo();
        Document infoPokemon1 = nuevoConector.mostrarInfo("Gyarados");
        btnPokemon1.setText(infoPokemon1.getString("nombre") + " - " + infoPokemon1.getString("precio") + "€");
        
        Document infoPokemon2 = nuevoConector.mostrarInfo("Squirtle");
        btnPokemon2.setText(infoPokemon2.getString("nombre") + " - " + infoPokemon2.getString("precio") + "€");
        
        Document infoPokemon3 = nuevoConector.mostrarInfo("Lucario");
        btnPokemon3.setText(infoPokemon3.getString("nombre") + " - " + infoPokemon3.getString("precio") + "€");
        
        //CHECKBOX PARA COMPROBAR SI EL USUARIO TIENE O NO AL POKEMON
        JCheckBox chckbx_Pokemon1 = new JCheckBox("");
        chckbx_Pokemon1.setEnabled(false);
        chckbx_Pokemon1.setSelected(false);
        chckbx_Pokemon1.setHorizontalAlignment(SwingConstants.CENTER);
        chckbx_Pokemon1.setBackground(new Color(255, 255, 255));
        chckbx_Pokemon1.setBounds(6, 57, 45, 38);
        panelSeleccionPokemons.add(chckbx_Pokemon1);
        
        JCheckBox chckbx_Pokemon2 = new JCheckBox("");
        chckbx_Pokemon2.setEnabled(false);
        chckbx_Pokemon2.setSelected(false);
        chckbx_Pokemon2.setHorizontalAlignment(SwingConstants.CENTER);
        chckbx_Pokemon2.setBackground(Color.WHITE);
        chckbx_Pokemon2.setBounds(6, 213, 45, 38);
        panelSeleccionPokemons.add(chckbx_Pokemon2);
        
        JCheckBox chckbx_Pokemon3 = new JCheckBox("");
        chckbx_Pokemon3.setEnabled(false);
        chckbx_Pokemon3.setSelected(false);
        chckbx_Pokemon3.setFont(new Font("Tahoma", Font.PLAIN, 10));
        chckbx_Pokemon3.setHorizontalAlignment(SwingConstants.CENTER);
        chckbx_Pokemon3.setBackground(new Color(255, 255, 255));
        chckbx_Pokemon3.setBounds(6, 380, 45, 38);
        panelSeleccionPokemons.add(chckbx_Pokemon3);
        
        
        //BOTONES COMPRAR Y VENDER PRIMER POKEMON
        JButton btnComprarPokemon1 = new JButton("Comprar");
        btnComprarPokemon1.setBounds(340, 20, 138, 38);
        panelSeleccionPokemons.add(btnComprarPokemon1);
        btnComprarPokemon1.setBackground(new Color(0, 255, 128));
        btnComprarPokemon1.setForeground(new Color(0, 0, 0));
        btnComprarPokemon1.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnComprarPokemon1.setEnabled(false);
        
        JButton btnVenderPokemon1 = new JButton("Vender");
        btnVenderPokemon1.setBounds(340, 93, 138, 38);
        panelSeleccionPokemons.add(btnVenderPokemon1);
        btnVenderPokemon1.setForeground(new Color(0, 0, 0));
        btnVenderPokemon1.setBackground(new Color(255, 0, 0));
        btnVenderPokemon1.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnVenderPokemon1.setEnabled(false);
        
        //ACCIONES PARA BOTONES DEL POKEMON 1
        btnComprarPokemon1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprarPokemon(infoPokemon1.getString("nombre"), btnVenderPokemon1, btnComprarPokemon1, chckbx_Pokemon1);
            }
        });

        btnVenderPokemon1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                venderPokemon(infoPokemon1.getString("nombre"), btnVenderPokemon1, btnComprarPokemon1, chckbx_Pokemon1);
            }
        });
        
        //BOTONES COMPRAR Y VENDER SEGUNDO POKEMON
        JButton btnComprarPokemon2 = new JButton("Comprar");
        btnComprarPokemon2.setForeground(Color.BLACK);
        btnComprarPokemon2.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnComprarPokemon2.setBackground(new Color(0, 255, 128));
        btnComprarPokemon2.setBounds(340, 179, 138, 38);
        btnComprarPokemon2.setEnabled(false);
        panelSeleccionPokemons.add(btnComprarPokemon2);
        
        JButton btnVenderPokemon2 = new JButton("Vender");
        btnVenderPokemon2.setForeground(Color.BLACK);
        btnVenderPokemon2.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnVenderPokemon2.setBackground(Color.RED);
        btnVenderPokemon2.setBounds(340, 249, 138, 38);
        panelSeleccionPokemons.add(btnVenderPokemon2);
        btnVenderPokemon2.setEnabled(false);
        
        
        //ACCIONES PARA BOTONES DEL POKEMON 2
        btnComprarPokemon2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprarPokemon(infoPokemon2.getString("nombre"), btnVenderPokemon2, btnComprarPokemon2, chckbx_Pokemon2);
            }
        });

        btnVenderPokemon2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                venderPokemon(infoPokemon2.getString("nombre"), btnVenderPokemon2, btnComprarPokemon2, chckbx_Pokemon2);
            }
        });
        
        //BOTONES COMPRAR Y VENDER TERCER POKEMON
        JButton btnComprarPokemon3 = new JButton("Comprar");
        btnComprarPokemon3.setForeground(Color.BLACK);
        btnComprarPokemon3.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnComprarPokemon3.setBackground(new Color(0, 255, 128));
        btnComprarPokemon3.setBounds(340, 340, 138, 38);
        btnComprarPokemon3.setEnabled(false);
        panelSeleccionPokemons.add(btnComprarPokemon3);
        
        JButton btnVenderPokemon3 = new JButton("Vender");
        btnVenderPokemon3.setForeground(Color.BLACK);
        btnVenderPokemon3.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnVenderPokemon3.setBackground(Color.RED);
        btnVenderPokemon3.setBounds(340, 411, 138, 38);
        panelSeleccionPokemons.add(btnVenderPokemon3);
        btnVenderPokemon3.setEnabled(false); 
    
        //ACCIONES PARA BOTONES DEL POKEMON 3
        btnComprarPokemon3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprarPokemon(infoPokemon3.getString("nombre"), btnVenderPokemon3, btnComprarPokemon3, chckbx_Pokemon3);
            }
        });

        btnVenderPokemon3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                venderPokemon(infoPokemon3.getString("nombre"), btnVenderPokemon3, btnComprarPokemon3, chckbx_Pokemon3);
            }
        });
        
        JLabel lblPokedex = new JLabel("PÓKEDEX");
        lblPokedex.setForeground(new Color(0, 64, 128));
        lblPokedex.setHorizontalAlignment(SwingConstants.CENTER);
        lblPokedex.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblPokedex.setBounds(259, 280, 154, 40);
        contentPane.add(lblPokedex);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(727, 299, 643, 490);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBackground(new Color(255, 255, 255));
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 20));
        lblNombre.setBounds(10, 10, 102, 22);
        panel.add(lblNombre);
        
        lblMostrarNombre.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarNombre.setBounds(104, 10, 187, 22);
        panel.add(lblMostrarNombre);
        
        JLabel lblNumeroPokedex = new JLabel("Nº");
        lblNumeroPokedex.setFont(new Font("Arial", Font.BOLD, 20));
        lblNumeroPokedex.setBounds(320, 10, 29, 22);
        panel.add(lblNumeroPokedex);
        
        lblMostrarNumero.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarNumero.setBounds(359, 10, 67, 22);
        panel.add(lblMostrarNumero);
        
        lblImagenPokemon.setFont(new Font("Arial", Font.BOLD, 13));
        lblImagenPokemon.setBounds(10, 37, 216, 169);
        panel.add(lblImagenPokemon);
        lblTipos.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblTipos.setFont(new Font("Arial", Font.BOLD, 20));
        lblTipos.setBounds(541, 11, 73, 22);
        panel.add(lblTipos);
        lblTipo1.setHorizontalAlignment(SwingConstants.CENTER);

        lblTipo1.setFont(new Font("Arial", Font.BOLD, 18));
        lblTipo1.setBounds(531, 43, 102, 26);
        panel.add(lblTipo1);
        lblTipo2.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblTipo2.setFont(new Font("Arial", Font.BOLD, 18));
        lblTipo2.setBounds(531, 79, 102, 26);
        panel.add(lblTipo2);
        
        textAreaDescripcion.setForeground(new Color(255, 255, 255));
        textAreaDescripcion.setBackground(new Color(0, 0, 0));
        textAreaDescripcion.setFont(new Font("Verdana", Font.PLAIN, 14));
        textAreaDescripcion.setEditable(false); 
        textAreaDescripcion.setLineWrap(true); 
        textAreaDescripcion.setWrapStyleWord(true);
        textAreaDescripcion.setBounds(267, 60, 205, 140);
        panel.add(textAreaDescripcion);
        
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(0, 0, 0));
        separator.setBackground(new Color(0, 0, 0));
        separator.setBounds(0, 210, 643, 2);
        panel.add(separator);
        
        lbPS.setHorizontalAlignment(SwingConstants.LEFT);
        lbPS.setFont(new Font("Arial", Font.BOLD, 20));
        lbPS.setBounds(43, 310, 37, 32);
        panel.add(lbPS);
        
        lblMostrarPS.setHorizontalAlignment(SwingConstants.CENTER);
        lblMostrarPS.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarPS.setBounds(139, 310, 44, 36);
        panel.add(lblMostrarPS);
        
        lblAtaque.setHorizontalAlignment(SwingConstants.CENTER);
        lblAtaque.setFont(new Font("Arial", Font.BOLD, 20));
        lblAtaque.setBounds(29, 376, 83, 31);
        panel.add(lblAtaque);
        
        lblMostrarAtaque.setHorizontalAlignment(SwingConstants.CENTER);
        lblMostrarAtaque.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarAtaque.setBounds(139, 376, 44, 41);
        panel.add(lblMostrarAtaque);
        
        lblDefensa.setHorizontalAlignment(SwingConstants.CENTER);
        lblDefensa.setFont(new Font("Arial", Font.BOLD, 20));
        lblDefensa.setBounds(29, 443, 83, 22);
        panel.add(lblDefensa);
        
        lblMostrarDefensa.setHorizontalAlignment(SwingConstants.CENTER);
        lblMostrarDefensa.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarDefensa.setBounds(139, 436, 44, 41);
        panel.add(lblMostrarDefensa);
        
        lblATEsp.setHorizontalAlignment(SwingConstants.CENTER);
        lblATEsp.setFont(new Font("Arial", Font.BOLD, 20));
        lblATEsp.setBounds(402, 255, 91, 22);
        panel.add(lblATEsp);
        
        lblMostrarAtaqueEspecial.setHorizontalAlignment(SwingConstants.CENTER);
        lblMostrarAtaqueEspecial.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarAtaqueEspecial.setBounds(541, 252, 44, 32);
        panel.add(lblMostrarAtaqueEspecial);
        
        lblDefEsp.setHorizontalAlignment(SwingConstants.CENTER);
        lblDefEsp.setFont(new Font("Arial", Font.BOLD, 20));
        lblDefEsp.setBounds(401, 317, 105, 18);
        panel.add(lblDefEsp);
        
        lblMostrarDefensaEspecial.setHorizontalAlignment(SwingConstants.CENTER);
        lblMostrarDefensaEspecial.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarDefensaEspecial.setBounds(541, 305, 44, 41);
        panel.add(lblMostrarDefensaEspecial);
     
        lblVelocidad.setHorizontalAlignment(SwingConstants.CENTER);
        lblVelocidad.setFont(new Font("Arial", Font.BOLD, 20));
        lblVelocidad.setBounds(401, 380, 105, 23);
        panel.add(lblVelocidad);
        
        lblMostrarVelocidad.setHorizontalAlignment(SwingConstants.CENTER);
        lblMostrarVelocidad.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarVelocidad.setBounds(541, 371, 44, 41);
        panel.add(lblMostrarVelocidad);
        
        lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
        lblAltura.setFont(new Font("Arial", Font.BOLD, 20));
        lblAltura.setBounds(29, 255, 83, 22);
        panel.add(lblAltura);
        
        lblMostrarAltura.setHorizontalAlignment(SwingConstants.CENTER);
        lblMostrarAltura.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarAltura.setBounds(139, 248, 44, 36);
        panel.add(lblMostrarAltura);
        
        lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
        lblPeso.setFont(new Font("Arial", Font.BOLD, 20));
        lblPeso.setBounds(420, 445, 73, 18);
        panel.add(lblPeso);
        
        lblMostrarPeso.setHorizontalAlignment(SwingConstants.CENTER);
        lblMostrarPeso.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarPeso.setBounds(541, 436, 44, 41);
        panel.add(lblMostrarPeso);
        
        lblText_Estadisticas.setForeground(new Color(255, 0, 128));
        lblText_Estadisticas.setHorizontalAlignment(SwingConstants.CENTER);
        lblText_Estadisticas.setBounds(200, 216, 187, 32);
        lblText_Estadisticas.setFont(new Font("Verdana", Font.BOLD, 24));
        panel.add(lblText_Estadisticas);
        
        lblIMG_Personaje.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
        lblIMG_Personaje.setHorizontalAlignment(SwingConstants.LEFT);
        lblIMG_Personaje.setIcon((new ImageIcon(getClass().getClassLoader().getResource(("img/personaje.png")))));
        lblIMG_Personaje.setBounds(10, 10, 733, 150);
        contentPane.add(lblIMG_Personaje);
        
        lblImgMonedas.setIcon(new ImageIcon(getClass().getClassLoader().getResource(("img/monedas.jpg"))));
        lblImgMonedas.setBounds(113, 264, 79, 56);
        contentPane.add(lblImgMonedas);
        
        lblText_InformacionGeneral.setHorizontalAlignment(SwingConstants.CENTER);
        lblText_InformacionGeneral.setForeground(new Color(128, 0, 128));
        lblText_InformacionGeneral.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblText_InformacionGeneral.setBounds(923, 249, 327, 40);
        contentPane.add(lblText_InformacionGeneral);
        
        lblMensajeAlUsuario.setBackground(new Color(255, 255, 128));
        lblMensajeAlUsuario.setForeground(new Color(255, 255, 255));
        lblMensajeAlUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        lblMensajeAlUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        lblMensajeAlUsuario.setBounds(441, 229, 405, 41);
        contentPane.add(lblMensajeAlUsuario);
        
        //USUARIOS: COMBOBOX Y BOTON
        JComboBox comboBox_Usuario = new JComboBox();
        comboBox_Usuario.setFont(new Font("Arial", Font.BOLD, 16));
        comboBox_Usuario.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Usuario"}));
        comboBox_Usuario.setToolTipText("");
        comboBox_Usuario.setBounds(97, 153, 182, 40);
        contentPane.add(comboBox_Usuario);
        rellenarComboBox(comboBox_Usuario);
        
        JButton btnUsuario = new JButton("Actualizar Usuario");
        btnUsuario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String usuarioSeleccionado = (String) comboBox_Usuario.getSelectedItem();
        		if(!usuarioSeleccionado.equals("Seleccionar Usuario")) {
        			ConectorMongo nuevoConectorMongo = new ConectorMongo();
        			nuevoConectorMongo.obtenerInfoUsuario(usuarioSeleccionado, lblCantidadMonedas);
        			resetearBotones(btnComprarPokemon1, btnComprarPokemon2, btnComprarPokemon3, btnVenderPokemon1, btnVenderPokemon2, btnVenderPokemon3);
        			resetearCheckBox(chckbx_Pokemon1, chckbx_Pokemon2, chckbx_Pokemon3);
        			btnComprarPokemon1.setEnabled(true);
        			btnComprarPokemon2.setEnabled(true);
        			btnComprarPokemon3.setEnabled(true);
        			lblMensajeAlUsuario.setText("");
        			lblMensajeAlUsuario.setBackground(new Color(255, 255, 255));
        		}else {
        			lblMensajeAlUsuario.setText("No has seleccionado ningun usuario valido");
        			lblMensajeAlUsuario.setBackground(new Color(255, 204, 133));
        	        lblMensajeAlUsuario.setOpaque(true);
        	        lblCantidadMonedas.setText("0");
        	        btnComprarPokemon1.setEnabled(false);
        			btnComprarPokemon2.setEnabled(false);
        			btnComprarPokemon3.setEnabled(false);
        		}
        	}
        });
        btnUsuario.setForeground(new Color(0, 0, 255));
        btnUsuario.setFont(new Font("Verdana", Font.BOLD, 20));
        btnUsuario.setBounds(308, 151, 250, 41);
        contentPane.add(btnUsuario);

        lblIMG_Pokemon.setBounds(795, 24, 588, 215);
        contentPane.add(lblIMG_Pokemon);
        lblIMG_Pokemon.setIcon(new ImageIcon(getClass().getClassLoader().getResource(("img/Pokemon-Logo.jpg"))));
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setBackground(new Color(0, 0, 0));
        separator_1.setForeground(new Color(0, 0, 0));
        separator_1.setBounds(658, 330, 2, 459);
        contentPane.add(separator_1);
    }//FIN INTERFAZ

    private void updateLabels(Document infoPokemon) {
    	lblMostrarNombre.setText(infoPokemon.getString("nombre"));
    	lblMostrarNumero.setText(infoPokemon.getString("numero"));
    	ImageIcon imagen = ajustarTamañoImagen("img/" + infoPokemon.getString("nombre")+".png", lblImagenPokemon.getWidth(), lblImagenPokemon.getHeight());
    	lblImagenPokemon.setIcon(imagen);
    	lblTipo1.setText(infoPokemon.getString("primerTipo"));
    	if(infoPokemon != null) {
    		lblTipo2.setText(infoPokemon.getString("segundoTipo"));
    	}
    	textAreaDescripcion.setText(infoPokemon.getString("descripcion"));
    	lblMostrarPS.setText(infoPokemon.getString("ps"));
    	lblMostrarAtaque.setText(infoPokemon.getString("ataque"));
    	lblMostrarDefensa.setText(infoPokemon.getString("defensa"));
    	lblMostrarAtaqueEspecial.setText(infoPokemon.getString("ataqueEspecial"));
    	lblMostrarDefensaEspecial.setText(infoPokemon.getString("defensaEspecial"));
    	lblMostrarVelocidad.setText(infoPokemon.getString("velocidad"));
    	lblMostrarAltura.setText(infoPokemon.getString("altura"));
    	lblMostrarPeso.setText(infoPokemon.getString("peso"));
    }//FIN UPDATE LABELS

    private void comprarPokemon(String nombrePokemon, JButton btnVender, JButton btnComprar, JCheckBox checkBox) {
        ConectorMongo nuevoConector = new ConectorMongo();
        Document infoPokemon = nuevoConector.mostrarInfo(nombrePokemon);
        int precio = Integer.parseInt(infoPokemon.getString("precio"));
        int monedas = Integer.parseInt(lblCantidadMonedas.getText());
        
        if (monedas>=precio) {
            monedas = monedas - precio;
            lblCantidadMonedas.setText(String.valueOf(monedas));
            lblMensajeAlUsuario.setText("¡¡¡¡Acabas de comprar a " + nombrePokemon + "!!!!!");
            lblMensajeAlUsuario.setBackground(new Color(46, 204, 113));
            lblMensajeAlUsuario.setOpaque(true);
            btnVender.setEnabled(true);
            btnComprar.setEnabled(false);
            
            boolean comprarPokemon = nuevoConector.actualizarCheckBox(nombrePokemon);
            if(comprarPokemon) {
            	checkBox.setSelected(true);
            }
        }else{
        	lblMensajeAlUsuario.setText("No tienes monedas para comprar a " + nombrePokemon);
        	lblMensajeAlUsuario.setBackground(new Color(189, 195, 199));
        	lblMensajeAlUsuario.setOpaque(true);
        }
    }//FIN COMPRAR POKEMON

    private void venderPokemon(String nombrePokemon, JButton btnVender, JButton btnComprar, JCheckBox checkBox) {
        ConectorMongo nuevoConector = new ConectorMongo();
        Document infoPokemon = nuevoConector.mostrarInfo(nombrePokemon);
        int precio = Integer.parseInt(infoPokemon.getString("precio"));
        int monedas = Integer.parseInt(lblCantidadMonedas.getText());

        monedas = monedas + precio;
        lblCantidadMonedas.setText(String.valueOf(monedas));
        lblMensajeAlUsuario.setText("Has vendido a " + nombrePokemon);
        lblMensajeAlUsuario.setBackground(new Color(155, 89, 182));
        lblMensajeAlUsuario.setOpaque(true);
        btnVender.setEnabled(false);
        btnComprar.setEnabled(true);
        
        boolean comprarPokemon = nuevoConector.actualizarCheckBox(nombrePokemon);
        if(comprarPokemon) {
        	checkBox.setSelected(false);
        }
    }//FIN VENDER POKEMON
    
    private ImageIcon ajustarTamañoImagen(String rutaImagen, int ancho, int alto) {
        ImageIcon imagen = new ImageIcon(getClass().getClassLoader().getResource(rutaImagen));
        Image imagenOriginal = imagen.getImage();
        Image imagenAjustada = imagenOriginal.getScaledInstance(alto, ancho, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenAjustada);
    }//FIN AJUSTAR TAMAÑO IMAGEN
    
    private void rellenarComboBox(JComboBox comboBox_Usuario) {
    	ConectorMongo nuevoConector = new ConectorMongo();
    	ArrayList<String> nombres = nuevoConector.obtenerNombresUsuarios();
    	
    	for(int i=0; i<nombres.size(); i++) {
    		comboBox_Usuario.addItem(nombres.get(i));
    	}
    }//FIN RELLENAR COMBOBOX
    
    private void resetearBotones(JButton btnComprarPokemon1, JButton btnComprarPokemon2, JButton btnComprarPokemon3, JButton btnVenderPokemon1, JButton btnVenderPokemon2, JButton btnVenderPokemon3) {
    	btnComprarPokemon1.setEnabled(false);
    	btnComprarPokemon2.setEnabled(false);
    	btnComprarPokemon3.setEnabled(false);
    	btnVenderPokemon1.setEnabled(false);
    	btnVenderPokemon2.setEnabled(false);
    	btnVenderPokemon3.setEnabled(false);
    }//FIN RESETEAR BOTONES
    
    private void resetearCheckBox(JCheckBox chckbx_Pokemon1, JCheckBox chckbx_Pokemon2, JCheckBox chckbx_Pokemon3) {
    	chckbx_Pokemon1.setSelected(false);
    	chckbx_Pokemon2.setSelected(false);
    	chckbx_Pokemon3.setSelected(false);
    }//FIN RESETEAR CHECK BOX
    
}//FIN CLASS