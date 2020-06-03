package lucatic.grupo1.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lucatic.grupo1.model.Perfil;

@Component
public class FakerFactory_Impl implements FakeFactory_I {

	@Override
	public Perfil generarPerfil() {
		// TODO Auto-generated method stub
		Perfil perfil = new Perfil();
		perfil.generarFake();
		return perfil;
	}

	@Override
	public List<Perfil> generarNPerfiles(int number) {
		// TODO Auto-generated method stub
		List<Perfil> perfiles = new ArrayList<Perfil>();
		Perfil p;
		for(int i=0; i<number; i++) {
			perfiles.add(this.generarPerfil());
		}
		return perfiles;
	}
	
	

}
