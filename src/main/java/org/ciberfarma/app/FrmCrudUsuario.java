package org.ciberfarma.app;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ciberfarma.model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmCrudUsuario extends JFrame {
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtClave;
	private JTextField txtFecha;
	private JTextField txtTipo;
	private JTextField txtEstado;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudUsuario frame = new FrmCrudUsuario();
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
	public FrmCrudUsuario() {
		getContentPane().setLayout(null);
		
		JLabel lblCodigo = new JLabel("Código :");
		lblCodigo.setBounds(10, 10, 45, 13);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(77, 10, 96, 19);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(9, 36, 45, 13);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(76, 36, 183, 19);
		getContentPane().add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellido :");
		lblApellido.setBounds(10, 67, 45, 13);
		getContentPane().add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(77, 67, 182, 19);
		getContentPane().add(txtApellido);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setBounds(10, 100, 45, 13);
		getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(76, 96, 96, 19);
		getContentPane().add(txtUsuario);
		
		JLabel lblClave = new JLabel("Clave :");
		lblClave.setBounds(182, 100, 45, 13);
		getContentPane().add(lblClave);
		
		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(233, 96, 79, 19);
		getContentPane().add(txtClave);
		
		JLabel lblFecha = new JLabel("Fch Nac :");
		lblFecha.setBounds(10, 125, 65, 13);
		getContentPane().add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(77, 124, 96, 19);
		getContentPane().add(txtFecha);
		
		JLabel lblTipo = new JLabel("Tipo :");
		lblTipo.setBounds(10, 154, 45, 13);
		getContentPane().add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(77, 152, 96, 19);
		getContentPane().add(txtTipo);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(182, 154, 45, 13);
		getContentPane().add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(233, 151, 79, 19);
		getContentPane().add(txtEstado);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro(); 					// 	para que el método se cree como método global -- Frm  --
			}
		});
		btnRegistrar.setBounds(338, 10, 85, 21);
		getContentPane().add(btnRegistrar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();					// 	para que el método se cree como método global -- Frm  --
			}
		});
		btnConsultar.setBounds(338, 41, 85, 21);
		getContentPane().add(btnConsultar);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();						// 	para que el método se cree como método global -- Frm  --
			}
		});
		btnListado.setBounds(338, 74, 85, 21);
		getContentPane().add(btnListado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 204, 413, 108);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}

	void listado() {
		//	obtener un listado de los usuarios
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ventas") ;
		EntityManager em = fabrica.createEntityManager();
				//	JPA te permite crear métodos. ahora no encontré un FIND que me sirva pero si puedo usar un Name Query
				//	para crear esos métodos tengo que hacer un agregado en la class Usuario
				
		//TypedQuery<Usuario> consulta = em.createNamedQuery("Usuario.findAll", Usuario.class);
		//List<Usuario> lstUsuarios = consulta.getResultList();
				//	estas dos lineas equivalen a esta siguiente
		
		List<Usuario> lstUsuarios; 
		if (txtTipo.getText().isEmpty()) {
			lstUsuarios = em.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
		}else {
			int tipo = Integer.parseInt(txtTipo.getText());
			lstUsuarios = em.createNamedQuery("Usuario.findAllxTipo", Usuario.class).
					setParameter("xtipo", tipo).getResultList();	//le voy a pasar el parametro llamado "xtipo" del tipo : tipo
																	//y ya con eso me das el resultados
		}
		
		
		
		//	creame un query llamado "Usuario.findAll" 
		//	que sea de tipo: Usuario.class y devuelveme el resultado.
	
		//	muestro el listado en el txt/pdf
		txtS.setText("Listado de Usuario\n");
				for (Usuario u : lstUsuarios) {
					txtS.append(u.getCodigo() + "\t" + u.getNombre() + "\t" + u.getApellido() + "\n");
				}
	}

	void consultar() {							//	borré el termino protected porque no es necesario aqui
		//	obtener el código a buscar
		int codigo = Integer.parseInt(txtCodigo.getText());
		//	buscar el código en la Entidad (Usuarios en este caso), si existe muestra los datos, sino avisa.
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ventas") ;
		EntityManager em = fabrica.createEntityManager();
		
		 Usuario u = em.find(Usuario.class, codigo);	// 	esta linea reemplaza a nuestra sentencia select where codigo while mientras que leemos el resulset
		 												// 	el método find nos ahorra código
		 												//	la parte del jpa y el navegador es esta linea nomás
		 // Si el código no existe
		 if (u == null) {
			 JOptionPane.showMessageDialog(this, "Usuario no registrado"); 
		 } else {
			 txtNombre.setText(u.getNombre());
			 txtApellido.setText(u.getApellido());
			 txtUsuario.setText(u.getUsuario());
			 txtClave.setText(u.getClave());
			 txtFecha.setText(u.getFnacim());
			 txtTipo.setText(u.getTipo()+"");
			 txtEstado.setText(u.getEstado()+"");
			 
		 }
	}

	void registro() {							//	borré el termino protected porque no es necesario aqui
		// TODO Auto-generated method stub
		//	Entradas
		//	mis variables
		 String nombre = txtNombre.getText();
		 String apellido = txtApellido.getText();
		 String usuario = txtUsuario.getText();
		 String clave = txtClave.getText();
		 String fecha = txtFecha.getText();
		 int tipo = Integer.parseInt(txtTipo.getText());
		 int estado = Integer.parseInt(txtEstado.getText());
		 
		 //	con mis variables genero mi objeto de tipo usuario
		 Usuario u = new Usuario();
		 u.setNombre(nombre);
		 u.setApellido(apellido);
		 u.setUsuario(usuario);
		 u.setClave(clave);
		 u.setFnacim(fecha);
		 u.setTipo(tipo);
		 u.setEstado(estado);
		 
		 //	Proceso
		 //	aqui tenemos la entidad, la fábrica y el manejador
		 EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ventas") ;
		 EntityManager em = fabrica.createEntityManager();
		 
		 try {
			em.getTransaction().begin();
			 em.persist(u);						//	en esta sola línea ya hiciste los setprepareStament, setString, etc
			 em.getTransaction().commit();
			 JOptionPane.showMessageDialog(this, "Usuario registrado");
		} catch (HeadlessException e) {
			 JOptionPane.showMessageDialog(this, "Error al registrar : " + e.getMessage());
		}finally {
			em.close();
		}	 	 	 
	}
}
