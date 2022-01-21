import { Component, OnInit } from '@angular/core';
import { Formulario } from 'src/app/models/formulario';
import { Genero } from 'src/app/models/genero';
import { FormularioService } from 'src/app/services/formulario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  public opciones: Genero[] = [];
  public formulario: Formulario = new Formulario();
  public title: string = 'Encuesta Musical'; 
  public errors: string[];

  constructor(private serviceFormulario: FormularioService) { }

  ngOnInit(): void {
    this.serviceFormulario.listOpciones().subscribe(resp => {
      this.opciones = resp;      
    })
  }

  public create(): void {    
    this.serviceFormulario.create(this.formulario).subscribe(resp => {        
      Swal.fire('Formulario:', 'Formulario Enviado con Exito', 'success');  
      this.errors = [];    
    }, err => {
      this.errors = err.error.Errors as string[];   
      if (err.status === 500) {
        Swal.fire('Alerta!!', 'El email ya fue registrado', 'warning');  
      }      
    });
  }

  compareOpciones(g1: Genero, g2: Genero): boolean {
    if (g1 === undefined && g2 === undefined) {
      return true;
    }
    return g1 === null || g2 === null || g1 === undefined || g2 === undefined ? false : g1.id === g2.id;
  }

}
