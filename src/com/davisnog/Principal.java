package com.davisnog;

import java.io.IOException;

import com.davisnog.geocode.Geocode;
import com.davisnog.geocode.ResultList;

public class Principal {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		String endereco = "rua são josé, blumenau, santa catarina";
		
		Geocode geo = new Geocode(endereco);
		
		ResultList result = geo.result();
		
		System.out.println(result.getResults().get(0).getGeometry().getLocation().getLng());
		
	}
	
}
