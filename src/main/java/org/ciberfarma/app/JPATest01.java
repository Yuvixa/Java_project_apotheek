package org.ciberfarma.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.ciberfarma.model.Usuario;



public class JPATest01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			//		1.	Fabricar el acceso a los datos donde lo guardo? quien me pasa esa informacion?
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ventas") ;
													//		recuerda el nombre de la unidad de persistencia ( persistence-unit name="jpa_sesion01" )		
			//		2.	Crear "em" ( el manejador de entidades )
		EntityManager em = fabrica.createEntityManager();	
		
													//		JPA dice: "ya no requiero que hagas las coneccion a BBDD, crear tu conection ni tanto bla bla bla
													//		tu solo dame tus datos quieres (grabar, actualizar, listar...) y yo me las veo con MySQL 
													// 		y para poder hacer eso requiero un manejador"
													//		entonces yo lo que hago : construyo ese navegador que necesita el JPA
		
		//	 I. 	Crear un objeto de usuario a grabar
		
		Usuario u = new Usuario();
		// u.setCodigo(8);							//		int auto_increment	este campo es para autoincrementar
		u.setNombre("Yuvixa");
		u.setApellido("Camiña");
		u.setUsuario("usuario4@ciber.com");			//		NOT NULL unique		este valor es unique es decir único
		u.setClave("123");
		u.setFnacim("1997/12/31");
		u.setTipo(1);
		u.setEstado(1);		
		
		
			//		3.	empieza la transaccion		//		transaccion es toda operaci�n de registro, eliminaci�n, actualizaci�n.
		em.getTransaction().begin(); 				//		capturamos la transacci�n y empieza mi transacci�n
			//		 realizo proceso (persistencia)	//		yo quiero grabar , que persista este objeto
		em.persist(u);								//		con el comando persistence le digo: guardalo, almacenalo. 
													//		en este caso como hemos comentado el Codigo por que tiene autoincrement
		//em.merge(u);								//		permite actualizar los datos si ya existe esa fila
			//		4	Confirmar la transaccion
		em.getTransaction().commit();				//		capturo la transaccion y commit

		//	cerrar
		em.close();
	}

}
