import { Component, OnInit } from '@angular/core';
import { GestionContratosService } from 'src/app/servicios/gestion-contratos.service';
import { Clientes } from 'src/app/data/clientes';

class contratos_x_cliente{
  nombre:string;
  monto:number;
}

@Component({
  selector: 'app-gestion-contratos',
  templateUrl: './gestion-contratos.component.html',
  styleUrls: ['./gestion-contratos.component.css']
})
export class GestionContratosComponent implements OnInit {

  clientes_contratos:contratos_x_cliente[]

  constructor(private servicio_cliente : GestionContratosService) { }

  ngOnInit(): void {
    this.contador_contratos()
  }

  contador_contratos(){
    this.servicio_cliente.get_clientes()
      .subscribe(data => {

        var lista_cli_contrado = new Array<contratos_x_cliente>();
        
        data.forEach(function(value){
          var unConCli = new contratos_x_cliente();
          unConCli.nombre = value.nombre;
          unConCli.monto = 0;
          value.contratos.forEach(function(convalue){
            unConCli.monto+=convalue.monto
          })
          
          lista_cli_contrado.push(unConCli);

        })
        
        this.clientes_contratos = lista_cli_contrado;

      });

    
  }

}
