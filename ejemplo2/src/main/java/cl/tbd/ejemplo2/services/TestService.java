/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.tbd.ejemplo2.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class TestService {
	
    @GetMapping(value = "/hello")
    public String welcome()
    {
    	return "HOLA PORFA FUNCIONA";
    }
}
