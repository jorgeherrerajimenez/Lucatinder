package lucatic.grupo1.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import lucatic.grupo1.model.Perfil;

@Component
public class FakerFactory_Impl implements FakeFactory_I {
	
	private List<String> descripcionesHombre = new ArrayList<String>();
	private List<String> descripcionesMujer = new ArrayList<String>();
	private Faker faker = new Faker();
	private String provincia;
	
	
	public FakerFactory_Impl() {
		super();
		this.descripcionesHombre.add("Me mola la programación y los memes. "+ 
				"Soy un chico normal, con virtudes y defectos." + 
				"Friki de las historietas de Mickey y Spiderman." + 
				"Me encanta el olor a gasolina, libros nuevos y el sonido de la lluvia");
		
		this.descripcionesHombre.add("Me he divorciado 5 veces, pero el problema son ellas, no yo. " + 
				"Soy fan de Phyton y la economía China comunista o capitalista?. " + 
				"Mis amigos me han obligado a abrirme este perfil.");
		
		this.descripcionesHombre.add("No sé cómo llegue aquí." + 
				"Fui una noche de cañas con mis compis y aparecí en esta app." + 
				"Pero ya que estamos, a ver qué pillamos aquí." + 
				"No espero nada nuevo de la vida.");
		
		this.descripcionesHombre.add("Un programador fuera del estereotipo. " + 
				"Cultivador de barba." + 
				"Comienzafiestas." + 
				"Seré el mejor amigo de tu gato." + 
				"Cocinillas especializado en tortilla de patatas.");
		
		this.descripcionesHombre.add("Hombre de metabolismo acelerado con esperanza de quitarse unos kilos." + 
				"Muy hijo de mis padres y amigo de mis amigos. " + 
				"Me gustan solo conversaciones buenas, las malas no ." + 
				"Me gustaría ser filósofo de la programación");
		
		this.descripcionesMujer.add("¿Te gustan las chicas malas? " + 
				"Pues yo soy mala en casi todo. " + 
				"estoy en Lucatinder para hacer amigos. " + 
				"así como voy al cine a ver pelis.");
		
		this.descripcionesMujer.add("Soy una chica que le apasionan los viajes y conocer nuevos lugares. " + 
				"También me gusta ir por una cerveza mientras hablamos de pruebas unitarias. " + 
				"Puedo revisar tu código pero no te diré donde está el problema. " + 
				"O podemos ver Netflix mientras aprendemos de hacking con Mister Robot");
		
		this.descripcionesMujer.add("Busco un chico que quiera conquistar mi corazón como buscan conquistar Gibraltar,\r\n" + 
				"No me pidas que te envíe fotos, mejor envíame un Glovo,\r\n" + 
				"Si buscas una chica con personalidad estás de suerte,\r\n" + 
				"yo tengo muchas");
		
		this.descripcionesMujer.add("\"Una chica verdaderamente increíble. " + 
				"The Ny Times. " + 
				"Una de las mentes más brillantes de esta generación. " + 
				"De lejos, la nieta favorita (soy la única). " + 
				"La chica que mejor debuggea los insectos del barrio.");
		
		this.descripcionesMujer.add("No busco pareja aquí ni allá, " + 
				"tampoco me gusta ser el entretenimiento de la modernidad actual. " + 
				"Prefiero quedar y hablar, o al menos ir por unas cañas." + 
				"O mejor encontrarnos por Git a ver si hacemos merge");
	}

	private String seleccionarDescripcion(char genero) {
		int number = this.faker.number().numberBetween(0, this.descripcionesHombre.size());
		if (genero == 'H')
			return this.descripcionesHombre.get(number);
		else
			return this.descripcionesMujer.get(number);
	}
	
	private String seleccionarImagen(char genero) {
		String image = null;
		int img=(int)(Math.random()*6)+1;
		if(genero == 'H') {
			switch (img) {
			  case 1:
					  image="genero_masculino/uno.jpg";
			    break;
			  case 2:
					  image="genero_masculino/dos.jpg";
			    break;
			  case 3:
					  image="genero_masculino/tres.jpg";
			    break;
			  case 4:
					  image="genero_masculino/cuatro.jpg";
			    break;
			  case 5:
					  image="genero_masculino/cinco.jpg";
			    break;
			  case 6:
					  image="genero_masculino/seis.jpg";
			    break;
			}
		}else if(genero == 'M') {	
			switch (img) {
			  case 1:
					  image="genero_femenino/uno.jpg";
			    break;
			  case 2:
					  image="genero_femenino/dos.jpg";
			    break;
			  case 3:
					  image="genero_femenino/tres.jpg";
			    break;
			  case 4:
					  image="genero_femenino/cuatro.jpg";
			    break;
			  case 5:
					  image="genero_femenino/cinco.jpg";
			    break;
			  case 6:
					  image="genero_femenino/seis.jpg";
			    break;
			}
		} else {
			
			image = "genero_otro/"+ (img%3) + ".jpg";
		}
		return image;
	}
	
	@Override
	public Perfil generarPerfil() {
		// TODO Auto-generated method stub
		String nombre = faker.funnyName().name();
		short edad = (short) faker.number().numberBetween(18, 60);
		String username = nombre.replaceAll("\\s","").toLowerCase() + edad + "@gmail.com";
		char genero;
		if((faker.number().randomDigit() % 2) == 0)
			genero = 'M';
		else
			genero = 'H';
		String descripcion = this.seleccionarDescripcion(genero);
		String imagen = this.seleccionarImagen(genero);
		Random rand = new Random();
		List<String> listaProvincias = Arrays.asList("A Coruña", "Álava","Albacete","Alicante","Almería", "Asturias", "Ávila", 
	"Badajoz", "Baleares", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Cantabria", 
	"Castellón", "Ciudad Real", "Córdoba", "Cuenca", "Girona", "Granada", "Guadalajara", "Gipuzkoa", 
	"Huelva", "Huesca","Jaén", "La Rioja","Las Palmas", "León","Lérida", "Lugo", "Madrid","Málaga", 
"Murcia", "Navarra", "Ourense", "Palencia", "Pontevedra", "Salamanca", "Segovia", "Sevilla", "Soria", 
"Tarragona", "Santa Cruz de Tenerife", "Teruel", "Toledo", "Valencia", "Valladolid", "Bilbao","Zamora", "Zaragoza");
		
		int control = 2;
		
		for (int i = 0; i<control; i++) {
			int randIndex = rand.nextInt(listaProvincias.size());
			this.provincia = listaProvincias.get(randIndex);
			}
		
		return new Perfil(nombre,username,genero,edad,descripcion,imagen, provincia);
	}

	@Override
	public List<Perfil> generarNPerfiles(int number) {
		// TODO Auto-generated method stub
		List<Perfil> perfiles = new ArrayList<Perfil>();
		for(int i=0; i<number; i++) {
			perfiles.add(this.generarPerfil());
		}
		return perfiles;
	}
	
	

}
