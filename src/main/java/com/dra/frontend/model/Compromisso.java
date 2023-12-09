package com.dra.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compromisso {
	
	private String status;
	 
	public void aceitar() {
	    
	this.status = "ACEITO";
	    
	 }
	
	public void delete() {
    
    }

    public static void setStatus(String string) {
		

	}
	
}

    
