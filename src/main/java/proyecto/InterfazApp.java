package proyecto;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
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
    static JLabel LblMonedas = new JLabel("MONEDAS");
    static JLabel lblCantidadMonedas = new JLabel("100");
    static JLabel lblText_InformacionGeneral = new JLabel("Información General");
    static JLabel lblMostrarNombre = new JLabel();
    static JLabel lblMostrarNumero = new JLabel();
    static JLabel lblImagenPokemon = new JLabel();
    static JLabel lblTipos = new JLabel("Tipo");
    static JLabel lblTipo1 = new JLabel();
    static JLabel lblTipo2 = new JLabel();
    static JTextArea textAreaDescripcion = new JTextArea();
    static JLabel lblText_Estadisticas = new JLabel("Estadísiticas");
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
    static int monedas = 100;
    private final JCheckBox chckbxNewCheckBox_Pokemon2 = new JCheckBox("");
    private final JCheckBox chckbxNewCheckBox_Pokemon3 = new JCheckBox("");
    

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
        lblCantidadMonedas.setBounds(583, 59, 70, 40);
        contentPane.add(lblCantidadMonedas);
        
        JPanel panelSeleccionPokemons = new JPanel();
        panelSeleccionPokemons.setBackground(Color.WHITE);
        panelSeleccionPokemons.setBounds(53, 330, 551, 459);
        contentPane.add(panelSeleccionPokemons);
        panelSeleccionPokemons.setLayout(null);
        
        JButton btnPokemon1 = new JButton();
        btnPokemon1.setBackground(new Color(128, 128, 255));
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
        btnPokemon2.setBackground(new Color(0, 128, 255));
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
      
        JButton btnPokemon3 = new JButton("New button");
        btnPokemon3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ConectorMongo nuevoConector = new ConectorMongo();
        		Document infoPokemon = nuevoConector.mostrarInfo("Metapod");
        		updateLabels(infoPokemon);
        	}
        });
        btnPokemon3.setBackground(new Color(128, 255, 0));
        btnPokemon3.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnPokemon3.setBounds(57, 380, 213, 38);
        panelSeleccionPokemons.add(btnPokemon3);
        
        //MOSTRAR NOMBRE Y PRECIO EN BOTON
        ConectorMongo nuevoConector = new ConectorMongo();
        Document infoPokemon1 = nuevoConector.mostrarInfo("Gyarados");
        btnPokemon1.setText(infoPokemon1.getString("nombre") + " - " + infoPokemon1.getString("precio") + "€");
        
        Document infoPokemon2 = nuevoConector.mostrarInfo("Squirtle");
        btnPokemon2.setText(infoPokemon2.getString("nombre") + " - " + infoPokemon2.getString("precio") + "€");
        
        Document infoPokemon3 = nuevoConector.mostrarInfo("Metapod");
        btnPokemon3.setText(infoPokemon3.getString("nombre") + " - " + infoPokemon3.getString("precio") + "€");
        
        //BOTONES COMPRAR Y VENDER PRIMER POKEMON
        JButton btnComprarPokemon1 = new JButton("Comprar");
        btnComprarPokemon1.setBounds(340, 20, 138, 38);
        panelSeleccionPokemons.add(btnComprarPokemon1);
        btnComprarPokemon1.setBackground(new Color(0, 255, 128));
        btnComprarPokemon1.setForeground(new Color(0, 0, 0));
        btnComprarPokemon1.setFont(new Font("Tahoma", Font.BOLD, 22));
        
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
                comprarPokemon(infoPokemon1.getString("nombre"), btnVenderPokemon1, btnComprarPokemon1);
            }
        });

        btnVenderPokemon1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                venderPokemon(infoPokemon1.getString("nombre"), btnVenderPokemon1, btnComprarPokemon1);
            }
        });
        
        //BOTONES COMPRAR Y VENDER SEGUNDO POKEMON
        JButton btnComprarPokemon2 = new JButton("Comprar");
        btnComprarPokemon2.setForeground(Color.BLACK);
        btnComprarPokemon2.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnComprarPokemon2.setBackground(new Color(0, 255, 128));
        btnComprarPokemon2.setBounds(340, 179, 138, 38);
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
                comprarPokemon(infoPokemon2.getString("nombre"), btnVenderPokemon2, btnComprarPokemon2);
            }
        });

        btnVenderPokemon2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                venderPokemon(infoPokemon2.getString("nombre"), btnVenderPokemon2, btnComprarPokemon2);
            }
        });
        
        //BOTONES COMPRAR Y VENDER TERCER POKEMON
        JButton btnComprarPokemon3 = new JButton("Comprar");
        btnComprarPokemon3.setForeground(Color.BLACK);
        btnComprarPokemon3.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnComprarPokemon3.setBackground(new Color(0, 255, 128));
        btnComprarPokemon3.setBounds(340, 340, 138, 38);
        panelSeleccionPokemons.add(btnComprarPokemon3);
        
        JButton btnVenderPokemon3 = new JButton("Vender");
        btnVenderPokemon3.setForeground(Color.BLACK);
        btnVenderPokemon3.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnVenderPokemon3.setBackground(Color.RED);
        btnVenderPokemon3.setBounds(340, 411, 138, 38);
        panelSeleccionPokemons.add(btnVenderPokemon3);
        btnVenderPokemon3.setEnabled(false); 
        
        JCheckBox chckbxNewCheckBox_Pokemon1 = new JCheckBox("");
        chckbxNewCheckBox_Pokemon1.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxNewCheckBox_Pokemon1.setBackground(new Color(255, 255, 255));
        chckbxNewCheckBox_Pokemon1.setBounds(6, 57, 45, 38);
        panelSeleccionPokemons.add(chckbxNewCheckBox_Pokemon1);
        chckbxNewCheckBox_Pokemon2.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxNewCheckBox_Pokemon2.setBackground(Color.WHITE);
        chckbxNewCheckBox_Pokemon2.setBounds(6, 213, 45, 38);
        
        panelSeleccionPokemons.add(chckbxNewCheckBox_Pokemon2);
        chckbxNewCheckBox_Pokemon3.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxNewCheckBox_Pokemon3.setBackground(Color.WHITE);
        chckbxNewCheckBox_Pokemon3.setBounds(6, 380, 45, 38);
        
        panelSeleccionPokemons.add(chckbxNewCheckBox_Pokemon3);
        
        //ACCIONES PARA BOTONES DEL POKEMON 3
        btnComprarPokemon3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprarPokemon(infoPokemon3.getString("nombre"), btnVenderPokemon3, btnComprarPokemon3);
            }
        });

        btnVenderPokemon3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                venderPokemon(infoPokemon3.getString("nombre"), btnVenderPokemon3, btnComprarPokemon3);
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
        panel.setBounds(711, 330, 643, 443);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBackground(new Color(255, 255, 255));
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNombre.setBounds(10, 10, 73, 22);
        panel.add(lblNombre);
        
        lblMostrarNombre.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarNombre.setBounds(104, 10, 112, 22);
        panel.add(lblMostrarNombre);
        
        JLabel lblNumeroPokedex = new JLabel("Nº");
        lblNumeroPokedex.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNumeroPokedex.setBounds(242, 10, 29, 22);
        panel.add(lblNumeroPokedex);
        
        lblMostrarNumero.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblMostrarNumero.setBounds(281, 0, 52, 32);
        panel.add(lblMostrarNumero);
        
        lblImagenPokemon.setFont(new Font("Arial", Font.BOLD, 13));
        lblImagenPokemon.setBounds(10, 47, 195, 134);
        panel.add(lblImagenPokemon);
        
        lblTipos.setFont(new Font("Arial", Font.BOLD, 18));
        lblTipos.setBounds(396, 12, 73, 22);
        panel.add(lblTipos);

        lblTipo1.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblTipo1.setBounds(493, 47, 83, 22);
        panel.add(lblTipo1);
        
        lblTipo2.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblTipo2.setBounds(503, 79, 83, 22);
        panel.add(lblTipo2);
        textAreaDescripcion.setBackground(Color.WHITE);
        
        textAreaDescripcion.setFont(new Font("Verdana", Font.PLAIN, 14));
        textAreaDescripcion.setEditable(false); 
        textAreaDescripcion.setLineWrap(true); 
        textAreaDescripcion.setWrapStyleWord(true);
        textAreaDescripcion.setBounds(227, 64, 216, 117);
        panel.add(textAreaDescripcion);
        
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(0, 0, 0));
        separator.setBackground(new Color(0, 0, 0));
        separator.setBounds(0, 191, 593, 2);
        panel.add(separator);
        
        lbPS.setHorizontalAlignment(SwingConstants.LEFT);
        lbPS.setFont(new Font("Arial", Font.BOLD, 20));
        lbPS.setBounds(32, 277, 83, 16);
        panel.add(lbPS);
        
        lblMostrarPS.setHorizontalAlignment(SwingConstants.CENTER);
        lblMostrarPS.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarPS.setBounds(104, 261, 44, 32);
        panel.add(lblMostrarPS);
        
        lblAtaque.setHorizontalAlignment(SwingConstants.CENTER);
        lblAtaque.setFont(new Font("Arial", Font.BOLD, 20));
        lblAtaque.setBounds(22, 322, 83, 31);
        panel.add(lblAtaque);
        
        lblMostrarAtaque.setHorizontalAlignment(SwingConstants.CENTER);
        lblMostrarAtaque.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarAtaque.setBounds(122, 369, 52, 44);
        panel.add(lblMostrarAtaque);
        
        lblDefensa.setHorizontalAlignment(SwingConstants.CENTER);
        lblDefensa.setFont(new Font("Arial", Font.BOLD, 20));
        lblDefensa.setBounds(22, 377, 83, 22);
        panel.add(lblDefensa);
        
        lblMostrarDefensa.setHorizontalAlignment(SwingConstants.CENTER);
        lblMostrarDefensa.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarDefensa.setBounds(122, 322, 64, 44);
        panel.add(lblMostrarDefensa);
        
        lblATEsp.setHorizontalAlignment(SwingConstants.CENTER);
        lblATEsp.setFont(new Font("Arial", Font.BOLD, 20));
        lblATEsp.setBounds(415, 228, 91, 22);
        panel.add(lblATEsp);
        
        lblMostrarAtaqueEspecial.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarAtaqueEspecial.setBounds(516, 204, 46, 46);
        panel.add(lblMostrarAtaqueEspecial);
        
        lblDefEsp.setHorizontalAlignment(SwingConstants.CENTER);
        lblDefEsp.setFont(new Font("Arial", Font.BOLD, 20));
        lblDefEsp.setBounds(415, 276, 105, 18);
        panel.add(lblDefEsp);
        
        lblMostrarDefensaEspecial.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarDefensaEspecial.setBounds(517, 249, 52, 44);
        panel.add(lblMostrarDefensaEspecial);
     
        lblVelocidad.setHorizontalAlignment(SwingConstants.CENTER);
        lblVelocidad.setFont(new Font("Arial", Font.BOLD, 20));
        lblVelocidad.setBounds(415, 330, 105, 14);
        panel.add(lblVelocidad);
        
        lblMostrarVelocidad.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarVelocidad.setBounds(530, 304, 46, 49);
        panel.add(lblMostrarVelocidad);
        
        lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
        lblAltura.setFont(new Font("Arial", Font.BOLD, 20));
        lblAltura.setBounds(22, 236, 83, 22);
        panel.add(lblAltura);
        
        lblMostrarAltura.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarAltura.setBounds(104, 212, 52, 46);
        panel.add(lblMostrarAltura);
        
        lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
        lblPeso.setFont(new Font("Arial", Font.BOLD, 20));
        lblPeso.setBounds(415, 379, 73, 18);
        panel.add(lblPeso);
        
        lblMostrarPeso.setFont(new Font("Arial", Font.BOLD, 20));
        lblMostrarPeso.setBounds(504, 355, 52, 44);
        panel.add(lblMostrarPeso);
        
        lblText_Estadisticas.setHorizontalAlignment(SwingConstants.CENTER);
        lblText_Estadisticas.setBounds(227, 201, 141, 22);
        panel.add(lblText_Estadisticas);
        lblText_Estadisticas.setFont(new Font("Verdana", Font.BOLD, 20));
        
        lblIMG_Personaje.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
        lblIMG_Personaje.setHorizontalAlignment(SwingConstants.LEFT);
        lblIMG_Personaje.setIcon((new ImageIcon(getClass().getClassLoader().getResource(("img/personaje.png")))));
        lblIMG_Personaje.setBounds(10, 10, 861, 150);
        contentPane.add(lblIMG_Personaje);
        
        lblImgMonedas.setIcon(new ImageIcon(getClass().getClassLoader().getResource(("img/monedas.jpg"))));
        lblImgMonedas.setBounds(113, 264, 79, 56);
        contentPane.add(lblImgMonedas);
        lblText_InformacionGeneral.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblText_InformacionGeneral.setForeground(new Color(128, 0, 128));
        lblText_InformacionGeneral.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblText_InformacionGeneral.setBounds(850, 280, 327, 40);
        contentPane.add(lblText_InformacionGeneral);
        
        lblMensajeAlUsuario.setBackground(new Color(255, 255, 128));
        lblMensajeAlUsuario.setForeground(new Color(255, 255, 255));
        lblMensajeAlUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        lblMensajeAlUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        lblMensajeAlUsuario.setBounds(449, 233, 528, 56);
        contentPane.add(lblMensajeAlUsuario);
        
        JComboBox comboBox_Usuario = new JComboBox();
        comboBox_Usuario.setFont(new Font("Arial", Font.BOLD, 14));
        comboBox_Usuario.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Usuario"}));
        comboBox_Usuario.setToolTipText("");
        comboBox_Usuario.setBounds(80, 167, 177, 40);
        contentPane.add(comboBox_Usuario);
        
        JButton btnUsuario = new JButton("Actualizar Usuario");
        btnUsuario.setForeground(new Color(0, 0, 255));
        btnUsuario.setFont(new Font("Verdana", Font.BOLD, 20));
        btnUsuario.setBounds(308, 168, 250, 41);
        contentPane.add(btnUsuario);
        lblIMG_Pokemon.setBounds(762, 54, 588, 215);
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
    	lblImagenPokemon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/" + infoPokemon.getString("nombre") + ".png")));
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

    private void comprarPokemon(String nombrePokemon, JButton btnVender, JButton btnComprar) {
        ConectorMongo nuevoConector = new ConectorMongo();
        Document infoPokemon = nuevoConector.mostrarInfo(nombrePokemon);
        int precio = Integer.parseInt(infoPokemon.getString("precio"));
        int monedas = Integer.parseInt(lblCantidadMonedas.getText());
        
        if (monedas>=precio) {
            monedas = monedas - precio;
            lblCantidadMonedas.setText(String.valueOf(monedas));
            lblMensajeAlUsuario.setText("Acabas de comprar a " + nombrePokemon + "!!!!!");
            lblMensajeAlUsuario.setBackground(new Color(46, 204, 113));
            lblMensajeAlUsuario.setOpaque(true);
            btnVender.setEnabled(true);
            btnComprar.setEnabled(false);
        }else{
        	lblMensajeAlUsuario.setText("No tienes las monedas suficientes para comprar a " + nombrePokemon);
        	lblMensajeAlUsuario.setBackground(new Color(189, 195, 199));
        	lblMensajeAlUsuario.setOpaque(true);
        }
    }//FIN COMPRAR POKEMON

    private void venderPokemon(String nombrePokemon, JButton btnVender, JButton btnComprar) {
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
    }//FIN VENDER POKEMON
}//FIN CLASS